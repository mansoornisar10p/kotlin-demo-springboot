package com.codesession.demo.demo.feature_todo.service

import com.codesession.demo.demo.feature_todo.extensions.countWithPredicate
import com.codesession.demo.demo.feature_todo.extensions.findAllWithPredicate
import com.codesession.demo.demo.feature_todo.extensions.findAllWithSorting
import com.codesession.demo.demo.feature_todo.model.TodoTask
import com.codesession.demo.demo.feature_todo.repository.TodoTaskRepository
import com.codesession.demo.demo.utils.createCompletedPredicate
import com.codesession.demo.demo.utils.nonNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Service
class TodoTaskService @Autowired constructor(
    private val repository: TodoTaskRepository,
    private val entityManager: EntityManager
) {

    fun getAllTasks(sortBy: String?, filterBy: String?): List<TodoTask> {
        val sort = sortBy?.let { Sort.by(it) } ?: Sort.by("id")
        val predicate = filterBy?.let { parseFilter(it) }

        predicate.nonNull {
            return entityManager.findAllWithPredicate(this)
        }
        return repository.findAllWithSorting(sort)
    }

    fun countTasks(filterBy: String?): Long {
        val predicate = filterBy?.let { parseFilter(it) }
        predicate.nonNull {
            return entityManager.countWithPredicate(this)
        }
        return repository.count()
    }

    fun getTaskById(id: Long): TodoTask? = repository.findById(id).orElse(null)

    fun save(task: TodoTask) = repository.save(task)

    fun deleteById(id: Long) = repository.deleteById(id)


    private fun parseFilter(filter: String): Predicate? {
        val criteria = filter.split(",").map { it.split("=") }.associate { it[0] to it[1] }
        var predicate: Predicate? = null

        val cb: CriteriaBuilder = entityManager.criteriaBuilder
        val query: CriteriaQuery<TodoTask> = cb.createQuery(TodoTask::class.java)
        val root: Root<TodoTask> = query.from(TodoTask::class.java)

        for ((key, value) in criteria) {
            val newPredicate: Predicate = when (key) {
                "completed" -> cb.createCompletedPredicate(root, value)
                else -> throw IllegalArgumentException("Invalid filter key: $key")
            }

            predicate = predicate?.let { cb.and(it, newPredicate) } ?: newPredicate
        }

        return predicate
    }

}