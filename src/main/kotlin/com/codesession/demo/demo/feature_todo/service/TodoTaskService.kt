package com.codesession.demo.demo.feature_todo.service

import com.codesession.demo.demo.feature_todo.model.TodoTask

interface TodoTaskService {
    fun getAllTasks(sortBy: String?, filterBy: String?): List<TodoTask>
    fun countTasks(filterBy: String?): Long
    fun save(task: TodoTask): TodoTask
    fun deleteById(id: Long)
    fun getTaskById(id: Long): TodoTask?
}