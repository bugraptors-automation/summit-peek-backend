package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

public class SerialNumberListDTO {

    private String imeiDec;
    private String meidHex;
    private String meidDec;
    private String esnDec;
    private String macId;
    
    public SerialNumberListDTO(){
    	
    }
    
	public String getImeiDec() {
		return imeiDec;
	}
	public void setImeiDec(String imeiDec) {
		this.imeiDec = imeiDec;
	}
	public String getMeidHex() {
		return meidHex;
	}
	public void setMeidHex(String meidHex) {
		this.meidHex = meidHex;
	}
	public String getMeidDec() {
		return meidDec;
	}
	public void setMeidDec(String meidDec) {
		this.meidDec = meidDec;
	}
	public String getEsnDec() {
		return esnDec;
	}
	public void setEsnDec(String esnDec) {
		this.esnDec = esnDec;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
    
    
}
