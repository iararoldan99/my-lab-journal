package com.lab.wordfrequency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.wordfrequency.entity.LabEntry;

@Repository
public interface LabNotebookRepository extends JpaRepository<LabEntry, Integer> {

}
