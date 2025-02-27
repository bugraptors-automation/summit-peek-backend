package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sto_file_history")
public class StoFileHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sto_file_hist_key")
    private Long stoFileKey;
    
    @Column(name="doc_name")
    private String stoFileName;
    
    @Column(name="doc_path")
    private String stoFilePath;
    
	@Column(name="serial_number")
    private String serialNumber;

	public Long getStoFileKey() {
		return stoFileKey;
	}

	public void setStoFileKey(Long stoFileKey) {
		this.stoFileKey = stoFileKey;
	}

	public String getStoFileName() {
		return stoFileName;
	}

	public void setStoFileName(String stoFileName) {
		this.stoFileName = stoFileName;
	}

	public String getStoFilePath() {
		return stoFilePath;
	}

	public void setStoFilePath(String stoFilePath) {
		this.stoFilePath = stoFilePath;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	
}
