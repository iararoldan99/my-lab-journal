package com.lab.wordfrequency.DTO;

import javax.validation.constraints.NotEmpty;

public class LabNotebookDTO {
	@NotEmpty
	private String researcherName;
	@NotEmpty
	private String topic;
	@NotEmpty
	private String entry;
	@NotEmpty
	private String solicitedWord;
	
	public String getResearcherName() {
		return researcherName;
	}
	public void setResearcherName(String researcherName) {
		this.researcherName = researcherName;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getSolicitedWord() {
		return solicitedWord;
	}
	public void setSolicitedWord(String solicitedWord) {
		this.solicitedWord = solicitedWord;
	}
	
	
}
