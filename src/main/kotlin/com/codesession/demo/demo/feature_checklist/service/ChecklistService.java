package com.codesession.demo.demo.feature_checklist.service;

import com.codesession.demo.demo.commons.Result;
import com.codesession.demo.demo.feature_checklist.extensions.ChecklistRepositoryExtensionsKt;
import com.codesession.demo.demo.feature_checklist.model.Checklist;
import com.codesession.demo.demo.feature_checklist.repository.ChecklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChecklistService {
    private final ChecklistRepository repository;

    public ChecklistService(ChecklistRepository repository) {
        this.repository = repository;
    }

    public List<Checklist> getAllChecklists() {
        return repository.findAll();
    }
    public Result<Checklist> createChecklist(Checklist checklist) {
        try {
            Checklist createdChecklist = repository.save(checklist);
            return Result.success(createdChecklist);
        } catch (Exception e) {
            return Result.error("Failed to create checklist: " + e.getMessage());
        }
    }


    public Result<Checklist> updateChecklist(Long id, Checklist checklist) {
        try {
            Checklist updatedChecklist = checklist.withId(id);
            Checklist updatedCheckList = ChecklistRepositoryExtensionsKt.updateChecklistById(repository, id, updatedChecklist);
            return Result.success(updatedCheckList);
        } catch (NoSuchElementException e) {
            return Result.error("Checklist not found with id: " + id);
        } catch (Exception e) {
            return Result.error("Failed to update checklist: " + e.getMessage());
        }
    }

    public Result<Void> deleteChecklist(Long id) {
        try {
            ChecklistRepositoryExtensionsKt.deleteChecklistById(repository, id);
            return Result.success(null); // Return null data for successful deletion
        } catch (NoSuchElementException e) {
            return Result.error("Checklist not found with id: " + id);
        } catch (Exception e) {
            return Result.error("Failed to delete checklist: " + e.getMessage());
        }
    }
}

