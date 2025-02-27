package com.darks.dto;

import com.darks.model.TetraFileHistory;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */
public class TetraFileHistoryDto {
	 
	 private Long fileKey;
	 private String fileName;
	 private String filePath;
	 private int page;
	 private int size;
	 private String serialNumber;
	

	public Long getFileKey() {
		return fileKey;
	}

	public void setFileKey(Long fileKey) {
		this.fileKey = fileKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public TetraFileHistoryDto() {}
	public TetraFileHistoryDto(TetraFileHistory tetraFileHistory) {
		this.fileKey = tetraFileHistory.getTetraFileHistKey();
		this.fileName = tetraFileHistory.getTetraFileName();
		this.filePath = tetraFileHistory.getTetraFilePath();
	}
	
}
