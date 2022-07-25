package com.lab.wordfrequency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lab.wordfrequency.DTO.EntryResult;
import com.lab.wordfrequency.DTO.LabNotebookDTO;
import com.lab.wordfrequency.entity.LabEntry;

@Service
public interface LabNotebookService {
    public EntryResult processEntry(LabNotebookDTO entryData);
    public Optional<LabEntry> getEntryById(Integer id);
    public List<LabEntry> getAllEntries();
}
