package com.lab.wordfrequency.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.wordfrequency.DTO.EntryResult;
import com.lab.wordfrequency.DTO.LabNotebookDTO;
import com.lab.wordfrequency.entity.LabEntry;
import com.lab.wordfrequency.service.LabNotebookService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notebook")
public class LabNotebookController {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private LabNotebookService service;

	@PostMapping("/add")
	public ResponseEntity<EntryResult> add(@Valid @RequestBody LabNotebookDTO entry) {
		return ResponseEntity.ok(service.processEntry(entry));

	}

	@GetMapping("/entries")
	public ResponseEntity<List<LabEntry>> getAll() {
		try {
			LOGGER.info("Retrieving all entries!");
			return ResponseEntity.ok(service.getAllEntries());
		} catch (Exception e) {
			LOGGER.error("ERROR GETTING ALL LAB NOTEBOOK ENTRIES!", e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
