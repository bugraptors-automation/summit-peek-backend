package com.darks.dto;

import com.darks.model.StoFileHistory;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
public class StoFileHistoryDto {
	 private String fileSerialNumber;
	 private Long fileKey;
     private String fileName;
	 private String filePath;
	 
	
	public String getFileSerialNumber() {
		return fileSerialNumber;
	}

	public void setFileSerialNumber(String fileSerialNumber) {
		this.fileSerialNumber = fileSerialNumber;
	}

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


	public StoFileHistoryDto(StoFileHistory stoFileHistory) {

		this.fileName = stoFileHistory.getStoFileName();
		this.filePath = stoFileHistory.getStoFilePath();
		this.fileKey = stoFileHistory.getStoFileKey();
		this.fileSerialNumber = stoFileHistory.getSerialNumber();
	}
	 

	 
}
