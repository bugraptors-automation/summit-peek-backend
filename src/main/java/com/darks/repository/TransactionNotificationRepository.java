package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.TransactionNotification;
/**
 * @author Er. Arundeep Randev
 * @since Mar 2025
 *
 */

@Repository("transNotificationRepository")
public interface TransactionNotificationRepository extends JpaRepository<TransactionNotification, Long> {
	
	TransactionNotification findByTransNotificationKey(Long transNotificationKey);

}