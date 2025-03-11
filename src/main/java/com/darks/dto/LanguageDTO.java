package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.util.List;

public class LanguageDTO {

    private String languageCode;
    private String languageName;
    private List<OfferQuestionnaireResponseDTO> questionnaireResponses;

    public LanguageDTO() {}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public List<OfferQuestionnaireResponseDTO> getQuestionnaireResponses() {
		return questionnaireResponses;
	}

	public void setQuestionnaireResponses(List<OfferQuestionnaireResponseDTO> questionnaireResponses) {
		this.questionnaireResponses = questionnaireResponses;
	}
    
}
