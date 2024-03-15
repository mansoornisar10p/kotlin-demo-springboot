package com.codesession.demo.demo.feature_checklist.controller

import com.codesession.demo.demo.commons.Result
import com.codesession.demo.demo.feature_checklist.model.Checklist
import com.codesession.demo.demo.feature_checklist.service.ChecklistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/checklists")
class ChecklistController @Autowired constructor(private val checklistService: ChecklistService) {

    @GetMapping
    fun getAllChecklists(): List<Checklist> = checklistService.allChecklists

    @PostMapping
    fun createChecklist(@RequestBody checklist: Checklist): Result<Checklist>? = checklistService.createChecklist(checklist)

    @PutMapping("/{id}")
    fun updateChecklist(@PathVariable id: Long, @RequestBody checklist: Checklist): Result<Checklist>? {
        require(id == checklist.id) { "ID mismatch" }
        return checklistService.updateChecklist(id, checklist)
    }

    @DeleteMapping("/{id}")
    fun deleteChecklist(@PathVariable id: Long) {
        checklistService.deleteChecklist(id)
    }
}
