package com.darks.controller;
/**
 * @author Er. Arundeep Randev
 * @since Feb-Mar 2025
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darks.config.MockWrapper;
import com.darks.dto.TransactionNotificationDto;
import com.darks.service.TransactionNotificationService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ack")
@CrossOrigin(origins = "*") 
public record TransactionNotificationController(TransactionNotificationService transactionNotificationService) {

	private static final Logger logger = LoggerFactory.getLogger(TransactionNotificationController.class);

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Mar 2025
	 * @param fileReferenceDto
	 * @return ResponseEntity
	 */
    @PostMapping("/getTransactionAck")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "Transaction created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid load data provided")
    })
    public ResponseEntity<MockWrapper<TransactionNotificationDto>> getAck(@RequestBody @Valid TransactionNotificationDto transactionNotificationDto) {
    	ResponseEntity<MockWrapper<TransactionNotificationDto>> response;
    	try {
    		response = transactionNotificationService.createTransaction(transactionNotificationDto);
    		if (response.getStatusCode() == HttpStatus.OK) {
                response = new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);
            }
    	} catch (Exception e) {
    		logger.error("Error occurred while creating transaction: ", e);
            response = new ResponseEntity<>(new MockWrapper<TransactionNotificationDto>("Internal server error", null,HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	return response;
    }
}
