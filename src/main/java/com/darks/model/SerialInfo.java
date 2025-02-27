package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "serial_info")
public class SerialInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="serial_info_key")
    private Long serialInfoKey;
    
    @Column(name="serial_number", length = 255)
    private String serialNumber;

    @Column(name="rma_number" , length = 255)
    private String rmaNumber;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lineSegmentKey", referencedColumnName = "line_segment_key", nullable = false)
    private LineSegment lineSegment;
    
    
    public SerialInfo() {
    }

	public Long getSerialInfoKey() {
		return serialInfoKey;
	}


	public void setSerialInfoKey(Long serialInfoKey) {
		this.serialInfoKey = serialInfoKey;
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

	public LineSegment getLineSegment() {
		return lineSegment;
	}

	public void setLineSegment(LineSegment lineSegment) {
		this.lineSegment = lineSegment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
