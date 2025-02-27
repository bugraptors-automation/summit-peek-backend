package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.Answer;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("answerRepository")
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	Answer findByQuestionnaireResponseResponseKey(Long responseKey);

	
}
