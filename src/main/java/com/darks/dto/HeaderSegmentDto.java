package com.darks.dto;

import java.sql.Date;

public class HeaderSegmentDto {

    private String orderNumber;
    private String hostOrderNumber;
    private String trackingNumber;
    private String supplierNumber;
    private Date expiryDate;
    private String scenario;
    private String orderType;
    private String action;
    
    
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
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
    

}
