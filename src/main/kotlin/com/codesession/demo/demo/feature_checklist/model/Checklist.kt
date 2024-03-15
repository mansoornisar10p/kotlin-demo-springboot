package com.codesession.demo.demo.feature_checklist.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Checklist(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val completed: Boolean = false
) {
    constructor() : this(0, "", false)
    fun withId(id: Long) = Checklist(id, name, completed)
}
