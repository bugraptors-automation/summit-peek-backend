package com.darks.model;

import java.io.Serializable;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

//import javax.persistence.*;
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
@Table(name = "answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_key")
    private Long answerKey;

    @ManyToOne
    @JoinColumn(name = "response_question_id", referencedColumnName = "response_key", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_response_question_id"))
    private QuestionnaireResponse questionnaireResponse; // Assuming QuestionnaireResponse is the entity representing the questionnaire_response table

    @Column(name = "answer_description")
    private String answerDescription;

    @Column(name = "answer_name")
    private String answerName;

    @Column(name = "priority")
    private Integer priority;

    
    public Answer() {}

    
    public Long getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(Long answerKey) {
        this.answerKey = answerKey;
    }

    public QuestionnaireResponse getQuestionnaireResponse() {
        return questionnaireResponse;
    }

    public void setQuestionnaireResponse(QuestionnaireResponse questionnaireResponse) {
        this.questionnaireResponse = questionnaireResponse;
    }

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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

