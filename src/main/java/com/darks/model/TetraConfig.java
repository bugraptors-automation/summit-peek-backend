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
@Table(name = "tetra_config")
public class TetraConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tetra_config_Key")
    private Long tetraConfigKey;
    
    @Column(name="serial_number")
    private String serialNumber;
    
    @Column(name="source_system_id")
    private String sourceSystemId;
    
    @Column(name="return_auth_no")
    private Long rtAuthNo;
    
    @Column(name="program")
    private Long program;
    
    @Column(name="carrier")
    private String carrier;
    
    @Column(name="equipId")
    private Long equipId;

	public Long getTetraConfigKey() {
		return tetraConfigKey;
	}

	public void setTetraConfigKey(Long tetraConfigKey) {
		this.tetraConfigKey = tetraConfigKey;
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

	public Long getEquipId() {
		return equipId;
	}

	public void setEquipId(Long equipId) {
		this.equipId = equipId;
	}

}
