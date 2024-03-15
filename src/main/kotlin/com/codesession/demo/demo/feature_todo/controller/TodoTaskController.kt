package com.codesession.demo.demo.feature_todo.controller

import com.codesession.demo.demo.feature_todo.service.TodoTaskServiceImpl
import com.codesession.demo.demo.feature_todo.model.TodoTask
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TodoTaskController @Autowired constructor(private val service: TodoTaskServiceImpl) {

    @GetMapping
    fun getAllTasks(
        @RequestParam(required = false) sortBy: String?,
        @RequestParam(required = false) filterBy: String?
    ): List<TodoTask> {
        return service.getAllTasks(sortBy, filterBy)
    }

    @GetMapping("/count")
    fun countTasks(
        @RequestParam(required = false) filterBy: String?
    ): Long {
        return service.countTasks(filterBy)
    }

    @GetMapping("/{id}")
    fun getTaskById(
        @PathVariable id: Long
    ): TodoTask? {
        return service.getTaskById(id)
    }

    @PostMapping
    fun createTask(@RequestBody task: TodoTask): TodoTask = service.save(task)

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: TodoTask): TodoTask {
        require(id == task.id) { "ID mismatch" }
        return service.save(task)
    }


    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        service.deleteById(id)
    }
}