package com.codesession.demo.demo.feature_checklist.extensions

import com.codesession.demo.demo.feature_checklist.model.Checklist
import com.codesession.demo.demo.feature_checklist.repository.ChecklistRepository

fun ChecklistRepository.updateChecklistById(id: Long, checklist: Checklist): Checklist {
    val updatedChecklist = checklist.withId(id)
    return save(updatedChecklist)
}

fun ChecklistRepository.deleteChecklistById(id: Long) {
    deleteById(id)
}
