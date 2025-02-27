package com.darks.dto;

import java.time.ZonedDateTime;
import java.util.Date;

public class TransferApiDto {

    private Long transferRequest;
    private String apiName;
    private String eventName;
    private ZonedDateTime eventDate;
    private String transactionRefNo;
    private String transOperation;
    private String transactionTypeId;
    private String sourceSystemId;
    private String customerId;

    private Long headerSegment;
    private String orderNumber;
    private String hostOrderNumber;
    private String trackingNumber;
    private String supplierNumber;
    private Date expiryDate;
    private String scenario;
    private String orderType;
    private String action;

    private Long address;
    private String addressLine1;
    private String addressLine2;
    private String addressType;
    private String addressName;
    private String postalCode;
    private String city;
    private String country;
    private String state;
    private String email;

    private Long lineSegment;
    private String lineNumber;
    private String actionCode;
    private Integer qty;
    private String sku;

    private Long serialInfo;
    private String serialNumber;
    private String rmaNumber;
    
    public TransferApiDto() {}

	public Long getTransferRequest() {
		return transferRequest;
	}

	public void setTransferRequest(Long transferRequest) {
		this.transferRequest = transferRequest;
	}

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

	public String getTransactionRefNo() {
		return transactionRefNo;
	}

	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
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

	public Long getHeaderSegment() {
		return headerSegment;
	}

	public void setHeaderSegment(Long headerSegment) {
		this.headerSegment = headerSegment;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getHostOrderNumber() {
		return hostOrderNumber;
	}

	public void setHostOrderNumber(String hostOrderNumber) {
		this.hostOrderNumber = hostOrderNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLineSegment() {
		return lineSegment;
	}

	public void setLineSegment(Long lineSegment) {
		this.lineSegment = lineSegment;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Long getSerialInfo() {
		return serialInfo;
	}

	public void setSerialInfo(Long serialInfo) {
		this.serialInfo = serialInfo;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRmaNumber() {
		return rmaNumber;
	}

	public void setRmaNumber(String rmaNumber) {
		this.rmaNumber = rmaNumber;
	}

    public ZonedDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(ZonedDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public TransferApiDto(Long transferRequest, String apiName, String eventName, ZonedDateTime eventDate, String transactionRefNo, 
            String transOperation, String transactionTypeId, String sourceSystemId, String customerId, 
            Long headerSegment, String orderNumber, String hostOrderNumber, String trackingNumber, 
            String supplierNumber, Date expiryDate, String scenario, String orderType, String action, 
            Long address, String addressLine1, String addressLine2, String addressType, String addressName, 
            String postalCode, String city, String country, String state, String email, 
            Long lineSegment, String lineNumber, String actionCode, Integer qty, String sku, 
            Long serialInfo, String serialNumber, String rmaNumber) {
    	
    	this.transferRequest=transferRequest;
    	this.apiName=apiName;
    	this.eventName=eventName;
    	this.eventDate=eventDate;
    	this.transactionRefNo=transactionRefNo;
        this.transOperation=transOperation;
        this.transactionTypeId=transactionTypeId;
        this.sourceSystemId=sourceSystemId;
        this.customerId=customerId;

        this.headerSegment=headerSegment;
        this.orderNumber=orderNumber;
        this.hostOrderNumber=hostOrderNumber;
        this.trackingNumber=trackingNumber;
        this.supplierNumber=supplierNumber;
        this.expiryDate=expiryDate;
        this.scenario=scenario;
        this.orderType=orderType;
        this.action=action;
    	
        this.address=address;
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.addressType=addressType;
        this.addressName=addressName;
        this.postalCode=postalCode;
        this.city=city;
        this.country=country;
        this.state=state;
        this.email=email;

        this.lineSegment=lineSegment;
        this.lineNumber=lineNumber;
        this.actionCode=actionCode;
        this.qty=qty;
        this.sku=sku;

        this.serialInfo=serialInfo;
        this.serialNumber=serialNumber;
        this.rmaNumber=rmaNumber;
}

    
    
}

