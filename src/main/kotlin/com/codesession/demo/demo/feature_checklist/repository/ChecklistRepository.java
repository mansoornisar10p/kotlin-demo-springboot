package com.codesession.demo.demo.feature_checklist.repository;

import com.codesession.demo.demo.feature_checklist.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}

