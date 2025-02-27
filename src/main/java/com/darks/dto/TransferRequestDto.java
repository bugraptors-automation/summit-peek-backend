package com.darks.dto;

import java.time.ZonedDateTime;
import java.util.List;

public class TransferRequestDto {
	
    private String apiName;
    private String eventName;
    private ZonedDateTime eventDate;
    private String transactionRefNo;
    private HeaderSegmentDto headerSegment;
    private AddressDto address;
    private List<LineSegmentDto> lineSegment;
    private String transOperation;
    private String transactionTypeId;
    private String sourceSystemId;
    private String customerId;
    
    
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public ZonedDateTime getEventDate() {
		return eventDate;
	}
	public void setEventDate(ZonedDateTime eventDate) {
		this.eventDate = eventDate;
	}
	public String getTransactionRefNo() {
		return transactionRefNo;
	}
	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}
	public HeaderSegmentDto getHeaderSegment() {
		return headerSegment;
	}
	public void setHeaderSegment(HeaderSegmentDto headerSegment) {
		this.headerSegment = headerSegment;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public List<LineSegmentDto> getLineSegment() {
		return lineSegment;
	}
	public void setLineSegment(List<LineSegmentDto> lineSegment) {
		this.lineSegment = lineSegment;
	}
	public String getTransOperation() {
		return transOperation;
	}
	public void setTransOperation(String transOperation) {
		this.transOperation = transOperation;
	}
	public String getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(String transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    
}
