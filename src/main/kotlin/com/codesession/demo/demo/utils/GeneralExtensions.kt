package com.codesession.demo.demo.utils

import com.codesession.demo.demo.feature_todo.model.TodoTask
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

inline fun <T : Any> T?.nonNull(action: T.() -> Unit) = this?.apply { action(this) }

fun CriteriaBuilder.createCompletedPredicate(root: Root<TodoTask>, value: String): Predicate {
    return if (value.toBoolean()) {
        isTrue(root.get("completed"))
    } else {
        isFalse(root.get("completed"))
    }
}