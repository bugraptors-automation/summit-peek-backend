package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.Language;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("languageRepository")
public interface LanguageRepository extends JpaRepository<Language, Long> {
	

	Language findByLanguageCode(String languageCode);
}
