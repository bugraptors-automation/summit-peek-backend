package com.darks.dto;

import java.util.List;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
public class FileNodesDto {
	private Long fileNodeKey;
    private String serialNumber;
    private String sourceSystemId;
    private Long rtAuthNo;
    private Long program;
    private String carrier;
    private int length;
    private String fileCat;
    private String stoFile;
    private String message;
    private int processedCount;
    private int errorCount;
    
    private List<MockTransferDto> nodes;
    
    
	public FileNodesDto(String message) {
		this.message = message;
	}
	public FileNodesDto() {
		
	}
	public Long getFileNodeKey() {
		return fileNodeKey;
	}
	public void setFileNodeKey(Long fileNodeKey) {
		this.fileNodeKey = fileNodeKey;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	public Long getRtAuthNo() {
		return rtAuthNo;
	}
	public void setRtAuthNo(Long rtAuthNo) {
		this.rtAuthNo = rtAuthNo;
	}
	public Long getProgram() {
		return program;
	}
	public void setProgram(Long program) {
		this.program = program;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getFileCat() {
		return fileCat;
	}
	public void setFileCat(String fileCat) {
		this.fileCat = fileCat;
	}
	public String getStoFile() {
		return stoFile;
	}
	public void setStoFile(String stoFile) {
		this.stoFile = stoFile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<MockTransferDto> getNodes() {
		return nodes;
	}
	public void setNodes(List<MockTransferDto> nodes) {
		this.nodes = nodes;
	}
	public int getProcessedCount() {
		return processedCount;
	}
	public void setProcessedCount(int processedCount) {
		this.processedCount = processedCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	
}
