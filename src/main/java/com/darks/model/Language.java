package com.darks.model;

import java.io.Serializable;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import javax.persistence.*;


@Entity
@Table(name = "language")
public class Language implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_key")
    private Long languageKey;

    @Column(name = "language_code", unique = true, nullable = false)
    private String languageCode;

    @Column(name = "language_name")
    private String languageName;

   
    public Language() {}

    
    public Long getLanguageKey() {
        return languageKey;
    }

    public void setLanguageKey(Long languageKey) {
        this.languageKey = languageKey;
    }

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
}

