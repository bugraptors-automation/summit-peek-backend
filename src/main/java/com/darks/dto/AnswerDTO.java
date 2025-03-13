package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

public class AnswerDTO {

    private String answerDescription;
    private String answerName;
    private String priority;

    
    public AnswerDTO() {}


	public String getAnswerDescription() {
		return answerDescription;
	}


	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}


	public String getAnswerName() {
		return answerName;
	}


	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}
    
}
