package com.lab.wordfrequency.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lab.wordfrequency.utils.ListToStringConverter;

@Entity 
@Table(name="lab_entry")
public class LabEntry {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="researcher_name")
	private String researcherName;
	private String topic;
	@Column(columnDefinition = "LONGTEXT")
	private String entry;
	@Column(name="solicited_word")
	private String solicitedWord;
	@Column(name="word_frequency")
	private Integer wordFrequency;
	@Column(name="similar_words")
    @Convert(converter = ListToStringConverter.class)
	private List<String> similarWords;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
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
