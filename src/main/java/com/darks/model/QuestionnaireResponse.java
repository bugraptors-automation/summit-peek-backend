package com.darks.model;

import java.io.Serializable;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questionnaire_response")
public class QuestionnaireResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_key")
    private Long responseKey;

    @ManyToOne
    @JoinColumn(name = "offerQuoteKey", referencedColumnName = "offer_quote_key", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_offer_quote_key"))
    private TradeInOfferDetails tradeInOfferDetails; // Assuming TradeInOfferDetails is another entity representing the trade_in_offer_details table

    @Column(name = "language")
    private String language;

    @Column(name = "question_name")
    private String questionName;

    @Column(name = "question_priority")
    private String questionPriority;

    @Column(name = "question_description")
    private String questionDescription;


    public QuestionnaireResponse() {}


    public Long getResponseKey() {
        return responseKey;
    }

    public void setResponseKey(Long responseKey) {
        this.responseKey = responseKey;
    }

    public TradeInOfferDetails getTradeInOfferDetails() {
        return tradeInOfferDetails;
    }

    public void setTradeInOfferDetails(TradeInOfferDetails tradeInOfferDetails) {
        this.tradeInOfferDetails = tradeInOfferDetails;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

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
}

