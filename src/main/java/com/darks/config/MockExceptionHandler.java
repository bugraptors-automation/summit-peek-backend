package com.darks.config;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @createdBy Er. Arundeep Randev
 * @since Feb-Mar 2025
 * @return ResponseEntity
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MockExceptionHandler {
	
    private static final Logger logger = LoggerFactory.getLogger(MockExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MockWrapper<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                                 .getAllErrors()
                                 .stream()
                                 .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                 .collect(Collectors.toList());
        logger.error("Validation error occurred: {}", errors);
        return new ResponseEntity<>(new MockWrapper<>("Validation failed", errors, HttpStatus.BAD_REQUEST.value(), "ERROR"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MockWrapper<Object>> handleGlobalExceptions(Exception ex) {
        logger.error("Unexpected error occurred: ", ex);
    	return new ResponseEntity<>(new MockWrapper<>("Internal server error", null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionCreationException.class)
    public ResponseEntity<MockWrapper<Object>> handleTransactionCreationException(TransactionCreationException ex) {
        logger.error("Transaction creation error occurred: ", ex);
        return new ResponseEntity<>(new MockWrapper<>(ex.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}

