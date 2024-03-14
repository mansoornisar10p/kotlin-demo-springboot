package com.codesession.demo.demo.feature_todo.repository

import com.codesession.demo.demo.feature_todo.model.TodoTask
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoTaskRepository : JpaRepository<TodoTask, Long>
