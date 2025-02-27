package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
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
@Table(name = "tetra_file_history")
public class TetraFileHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tetra_file_hist_key")
    private Long tetraFileHistKey;
    
    @Column(name="tetra_file_name")
    private String tetraFileName;
    
    @Column(name="tetra_file_path")
    private String tetraFilePath;
    
	@Column(name="serial_number")
    private String serialNumber;

	public Long getTetraFileHistKey() {
		return tetraFileHistKey;
	}

	public void setTetraFileHistKey(Long tetraFileHistKey) {
		this.tetraFileHistKey = tetraFileHistKey;
	}

	public String getTetraFileName() {
		return tetraFileName;
	}

	public void setTetraFileName(String tetraFileName) {
		this.tetraFileName = tetraFileName;
	}

	public String getTetraFilePath() {
		return tetraFilePath;
	}

	public void setTetraFilePath(String tetraFilePath) {
		this.tetraFilePath = tetraFilePath;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	
}
