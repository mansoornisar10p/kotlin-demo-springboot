package com.codesession.demo.demo.feature_checklist.service;

import com.codesession.demo.demo.feature_checklist.extensions.ChecklistRepositoryExtensionsKt;
import com.codesession.demo.demo.feature_checklist.model.Checklist;
import com.codesession.demo.demo.feature_checklist.repository.ChecklistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {
    private final ChecklistRepository repository;

    public ChecklistService(ChecklistRepository repository) {
        this.repository = repository;
    }

    public List<Checklist> getAllChecklists() {
        return repository.findAll();
    }

    public Checklist createChecklist(Checklist checklist) {
        return repository.save(checklist);
    }

    public Checklist updateChecklist(Long id, Checklist checklist) {
        Checklist updatedChecklist = checklist.withId(id);
        return ChecklistRepositoryExtensionsKt.updateChecklistById(repository,id,updatedChecklist);
    }

    public void deleteChecklist(Long id) {
        ChecklistRepositoryExtensionsKt.deleteChecklistById(repository, id);
    }
}

