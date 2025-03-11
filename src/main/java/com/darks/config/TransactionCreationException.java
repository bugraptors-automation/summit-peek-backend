package com.darks.config;
/**
 * @createdBy Er. Arundeep Randev
 * @since Feb-Mar 2025
 * @return ResponseEntity
 */


public class TransactionCreationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TransactionCreationException(String message) {
        super(message);
    }
}
