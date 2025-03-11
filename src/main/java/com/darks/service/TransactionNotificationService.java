package com.darks.service;

import org.springframework.http.ResponseEntity;

import com.darks.config.MockWrapper;
import com.darks.dto.TransactionNotificationDto;

/**
 * @author Er. Arundeep Randev
 * @since Mar 2025
 *
 */
public interface TransactionNotificationService{

	ResponseEntity<MockWrapper<TransactionNotificationDto>> createTransaction(TransactionNotificationDto transactionNotificationDto);



}
