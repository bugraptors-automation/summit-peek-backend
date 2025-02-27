package com.darks.dto;

import java.util.List;

public class LineSegmentDto {

    private String lineNumber;
    private String actionCode;
    private Integer qty;
    private String sku;
    private List<SerialInfoDto> serialInfo;
    
    
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
	public List<SerialInfoDto> getSerialInfo() {
		return serialInfo;
	}
	public void setSerialInfo(List<SerialInfoDto> serialInfo) {
		this.serialInfo = serialInfo;
	}
    
}
