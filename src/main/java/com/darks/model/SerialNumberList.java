package com.darks.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serial_number_list")
public class SerialNumberList implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number_list_key")
    private Long serialNumberListKey;

    @ManyToOne
    @JoinColumn(name = "serial_number", referencedColumnName = "serial_number", nullable = false, 
                foreignKey = @ForeignKey(name = "fk_serial_number_trade_in"))
    private TradeIn tradeIn; // Assuming TradeIn is another entity representing the trade_in table

    @Column(name = "imei_dec")
    private String imeiDec;

    @Column(name = "meid_hex")
    private String meidHex;

    @Column(name = "meid_dec")
    private String meidDec;

    @Column(name = "esn_dec")
    private String esnDec;

    @Column(name = "mac_id")
    private String macId;

    
    public SerialNumberList() {}

    
    public Long getSerialNumberListKey() {
        return serialNumberListKey;
    }

    public void setSerialNumberListKey(Long serialNumberListKey) {
        this.serialNumberListKey = serialNumberListKey;
    }

    public TradeIn getTradeIn() {
        return tradeIn;
    }

    public void setTradeIn(TradeIn tradeIn) {
        this.tradeIn = tradeIn;
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

