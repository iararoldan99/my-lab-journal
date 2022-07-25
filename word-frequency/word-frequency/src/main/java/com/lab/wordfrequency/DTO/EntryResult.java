package com.lab.wordfrequency.DTO;

import java.util.List;

public class EntryResult {
	private String topic;
	private String solicitedWord;
	private Integer wordFrequency;
	private List<String> similarWords;
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSolicitedWord() {
		return solicitedWord;
	}
	public void setSolicitedWord(String solicitedWord) {
		this.solicitedWord = solicitedWord;
	}
	public Integer getWordFrequency() {
		return wordFrequency;
	}
	public void setWordFrequency(Integer wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
	public List<String> getSimilarWords() {
		return similarWords;
	}
	public void setSimilarWords(List<String> similarWords) {
		this.similarWords = similarWords;
	}
	
	
}
