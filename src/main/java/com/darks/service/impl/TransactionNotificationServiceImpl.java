package com.darks.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darks.config.MockWrapper;
import com.darks.dto.TransactionNotificationDto;
import com.darks.model.TransactionNotification;
import com.darks.repository.TransactionNotificationRepository;
import com.darks.service.TransactionNotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Er. Arundeep Randev
 * @since Mar 2025
 *
 */

@Service
@Transactional
public class TransactionNotificationServiceImpl implements TransactionNotificationService{

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static final String SUCCESS_MESSAGE = "Transaction Notification Received Successfully.";
	private static final String FAILURE_MESSAGE = "Transaction Notification Failed.";
	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String FAILURE_STATUS = "FAILED";
	private static final String INTERFACE_NAME = "Transaction Notification API";
	private static final int SUCCESS_KEY = 0;


	
	@Autowired
	TransactionNotificationRepository transactionNotificationRepository;

	@Override
	public ResponseEntity<MockWrapper<TransactionNotificationDto>> createTransaction(TransactionNotificationDto transactionNotificationDto) {

		try {
		    TransactionNotification transactionNotification = mapToTransactionNotification(transactionNotificationDto);
		    transactionNotification = transactionNotificationRepository.save(transactionNotification);
		    TransactionNotificationDto responseDto = response(transactionNotification);
		    boolean isSuccess = transactionNotification.getTransNotificationKey() > SUCCESS_KEY;
		    return createResponse(responseDto, isSuccess);
		}
		catch (Exception e) {
		    return new ResponseEntity<>(new MockWrapper<>("Error saving transaction notification", null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "FAILED"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ResponseEntity<MockWrapper<TransactionNotificationDto>> createResponse(TransactionNotificationDto responseDto, boolean isSuccess) {
	    String message = isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE;
	    HttpStatus status = isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	    String statusCode = isSuccess ? SUCCESS_STATUS : FAILURE_STATUS;
	    return new ResponseEntity<>(new MockWrapper<>(message, responseDto, status.value(), statusCode), status);
	}
	
	private TransactionNotification mapToTransactionNotification(TransactionNotificationDto dto) {
	    TransactionNotification transactionNotification = new TransactionNotification();
	    transactionNotification.setActivityId(dto.getActivityId());
	    transactionNotification.setEventDate(dateFmt(dto.getEventDate()));
	    transactionNotification.setEventOrigin(dto.getEventOrigin());
	    transactionNotification.setEventName(dto.getEventName());
	    transactionNotification.setApiName(dto.getApiName());
	    transactionNotification.setInvocationType(dto.getInvocationType());
	    transactionNotification.setTransactionRefNo(dto.getTransactionRefNo());
	    transactionNotification.setApiTransactionRefNo(dto.getApiTransactionRefNo());
	    transactionNotification.setApiTransConfirmNumber(dto.getApiTransConfirmNumber());
	    transactionNotification.setTransConfirmNumber(dto.getTransConfirmNumber());
	    transactionNotification.setErrorCode(dto.getErrorCode());
	    transactionNotification.setErrorDescription(dto.getErrorDescription());
	    transactionNotification.setErrorSource(dto.getErrorSource());
	    transactionNotification.setEventAction(dto.getEventAction());
	    if (dto.getEventAttributeList() != null) {
	        try {
	            transactionNotification.setEventAttributeList(new ObjectMapper().writeValueAsString(dto.getEventAttributeList()));
	        } catch (JsonProcessingException e) {
	            //log.error("Error serializing eventAttributeList: ", e);
	        }
	    }
	    transactionNotification.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	    return transactionNotification;
	}

	private TransactionNotificationDto response(TransactionNotification transactionNotification) {
	    TransactionNotificationDto responseDto = new TransactionNotificationDto();
	    responseDto.setTransConfirmNumber(transactionNotification.getTransConfirmNumber());
	    responseDto.setTransactionRefNo(transactionNotification.getTransactionRefNo());
	    responseDto.setInterfaceName(INTERFACE_NAME); 
	    responseDto.setSessionId(transactionNotification.getSessionId());
	    responseDto.setStatusText(SUCCESS_MESSAGE);
	    return responseDto;
	}
	
	private Date dateFmt(String dateStr){
		try{
			if(StringUtils.isNotEmpty(dateStr)){
				java.util.Date utilDate = formatter.parse(dateStr);
	            return new java.sql.Date(utilDate.getTime());

			 }
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format for date: " + dateStr, e);
	    }
		return null;
	}
}
