package com.darks.dto;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
public class TetraConfigDto {
	private Long tetraConfigKey;
    private String serialNumber;
    private String sourceSystemId;
    private Long rtAuthNo;
    private Long program;
    private String carrier;
    private Long equipId;
    private int length;
	
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
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
