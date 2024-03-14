package com.codesession.demo.demo.feature_todo.extensions

import com.codesession.demo.demo.feature_todo.model.TodoTask
import com.codesession.demo.demo.feature_todo.repository.TodoTaskRepository
import org.springframework.data.domain.Sort
import javax.persistence.EntityManager
import javax.persistence.criteria.Predicate

fun TodoTaskRepository.findAllWithSorting(sort: Sort): List<TodoTask> {
    return this.findAll(sort)
}

fun EntityManager.findAllWithPredicate(predicate: Predicate): List<TodoTask> {
    val criteriaQuery = criteriaBuilder.createQuery(TodoTask::class.java)
    val root = criteriaQuery.from(TodoTask::class.java)
    criteriaQuery.select(root).where(predicate)
    return createQuery(criteriaQuery).resultList
}

fun EntityManager.countWithPredicate(predicate: Predicate): Long {
    val criteriaQuery = criteriaBuilder.createQuery(Long::class.java)
    val root = criteriaQuery.from(TodoTask::class.java)
    criteriaQuery.select(criteriaBuilder.count(root)).where(predicate)
    return createQuery(criteriaQuery).singleResult
}
