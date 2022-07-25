package com.lab.wordfrequency.mapper;

import org.springframework.stereotype.Component;

import com.lab.wordfrequency.DTO.EntryResult;
import com.lab.wordfrequency.DTO.LabNotebookDTO;
import com.lab.wordfrequency.entity.LabEntry;

@Component
public class LabNotebookMapper {

	    public LabEntry fromDTOToEntity(EntryResult resulting, LabNotebookDTO entry){
	    	var entity = new LabEntry();
	    	entity.setResearcherName(entry.getResearcherName());
	    	entity.setTopic(entry.getTopic());
	    	entity.setEntry(entry.getEntry());
	    	entity.setSolicitedWord(entry.getSolicitedWord());	
	    	entity.setSimilarWords(resulting.getSimilarWords());
	    	entity.setWordFrequency(resulting.getWordFrequency());
	        return entity;
	    }
}
