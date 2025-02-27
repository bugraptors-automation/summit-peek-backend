package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.QuestionnaireResponse;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("questionnaireResponseRepository")
public interface QuestionnaireResponseRepository extends JpaRepository<QuestionnaireResponse, Long> {
	
	
	QuestionnaireResponse findByTradeInOfferDetailsOfferQuoteKey(Long offerQuoteKey);

	
}
