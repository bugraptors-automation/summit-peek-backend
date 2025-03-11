package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.util.List;

public class OfferQuestionnaireResponseDTO {

    private String questionName;
    private String questionPriority;
    private String questionDescription;
    private List<AnswerDTO> answers;
    private String language;

    public OfferQuestionnaireResponseDTO() {}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionPriority() {
		return questionPriority;
	}

	public void setQuestionPriority(String questionPriority) {
		this.questionPriority = questionPriority;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	public void setLanguage(String language) {
		this.language = language;
		
	}

	public String getLanguage() {
		return language;
	}
    
	
}
