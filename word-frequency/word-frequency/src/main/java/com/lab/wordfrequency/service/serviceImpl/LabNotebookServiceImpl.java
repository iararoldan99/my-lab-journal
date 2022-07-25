package com.lab.wordfrequency.service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.wordfrequency.DTO.EntryResult;
import com.lab.wordfrequency.DTO.LabNotebookDTO;
import com.lab.wordfrequency.entity.LabEntry;
import com.lab.wordfrequency.mapper.LabNotebookMapper;
import com.lab.wordfrequency.repository.LabNotebookRepository;
import com.lab.wordfrequency.service.LabNotebookService;

import info.debatty.java.stringsimilarity.Levenshtein;

@Service
public class LabNotebookServiceImpl implements LabNotebookService {

	@Autowired
	private LabNotebookMapper mapper;

	@Autowired
	private LabNotebookRepository repository;

	@Override
	public EntryResult processEntry(LabNotebookDTO entryData) {
		var result = new EntryResult();
		String entry = entryData.getEntry();
		String solicitedWord = entryData.getSolicitedWord();
		result.setSolicitedWord(solicitedWord);
		result.setTopic(entryData.getTopic());
		result.setSimilarWords(getSpecificSimilarWords(entry, solicitedWord));
		result.setWordFrequency(getSpecificWordFrequency(entry, solicitedWord));
		saveEntry(result, entryData);
		return result;
	}

	public List<String> getSpecificSimilarWords(String entry, String word) {
		var levenshtein = new Levenshtein();
		List<String> similarWords = Arrays.asList(entry.replaceAll("\\p{Punct}", "").split("\\s+")).stream().distinct()
				.filter(w -> 1 == levenshtein.distance(w, word)).collect(Collectors.toList());
		return similarWords;
	}

	public Integer getSpecificWordFrequency(String entry, String word) {
		Long frequency = Arrays.asList(entry.replaceAll("\\p{Punct}", "").split("\\s+")).stream()
				.filter(s -> !s.isEmpty() && s.equals(word)).collect(Collectors.counting());
		return frequency.intValue();
	}

	public void saveEntry(EntryResult result, LabNotebookDTO data) {
		LabEntry entity = mapper.fromDTOToEntity(result, data);
		repository.save(entity);
	}

	public Optional<LabEntry> getEntryById(Integer id) {
		return repository.findById(id);
	}

	public List<LabEntry> getAllEntries() {
		return repository.findAll();
	}

	public void deleteAllEntries() {
		repository.deleteAll();
	}

	public void deleteEntryById(Integer id) {
		repository.deleteById(id);
	}

}
