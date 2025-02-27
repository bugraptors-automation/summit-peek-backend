package com.darks.model;

import java.io.Serializable;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "trade_in_offer_details")
public class TradeInOfferDetails implements Serializable  {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_quote_key")
    private Long offerQuoteKey;

    @ManyToOne
    @JoinColumn(name = "trade_in_serial_number", referencedColumnName = "serial_number", nullable = false,
                foreignKey = @ForeignKey(name = "fk_trade_in_serial_number"))
    private TradeIn tradeIn; // Assuming TradeIn is the entity corresponding to the trade_in table

    @Column(name = "offer_ban")
    private String offerBan;

    @Column(name = "offer_msisdn")
    private String offerMsisdn;

    @Column(name = "offer_quote_price", precision = 10, scale = 2)
    private BigDecimal offerQuotePrice;

    @Column(name = "offer_start_date")
    private LocalDateTime offerStartDate;

    @Column(name = "offer_expiration_date")
    private LocalDateTime offerExpirationDate;

    @Column(name = "offer_rma_expiration_date")
    private LocalDateTime offerRmaExpirationDate;

    @Column(name = "offer_updated_date")
    private LocalDateTime offerUpdatedDate;

    @Column(name = "offer_order_id")
    private String offerOrderId;

    @Column(name = "offer_line_order_id")
    private String offerLineOrderId;

    @Column(name = "offer_partner_rma_number")
    private String offerPartnerRmaNumber;

    @Column(name = "offer_device_status")
    private String offerDeviceStatus;

    @Column(name = "offer_status")
    private String offerStatus;

    @Column(name = "offer_marketing_name")
    private String offerMarketingName;

    
    public TradeInOfferDetails() {}

    
    public Long getOfferQuoteKey() {
        return offerQuoteKey;
    }

    public void setOfferQuoteKey(Long offerQuoteKey) {
        this.offerQuoteKey = offerQuoteKey;
    }

    public TradeIn getTradeIn() {
        return tradeIn;
    }

    public void setTradeIn(TradeIn tradeIn) {
        this.tradeIn = tradeIn;
    }

    public String getOfferBan() {
        return offerBan;
    }

    public void setOfferBan(String offerBan) {
        this.offerBan = offerBan;
    }

    public String getOfferMsisdn() {
        return offerMsisdn;
    }

    public void setOfferMsisdn(String offerMsisdn) {
        this.offerMsisdn = offerMsisdn;
    }

    public BigDecimal getOfferQuotePrice() {
        return offerQuotePrice;
    }

    public void setOfferQuotePrice(BigDecimal offerQuotePrice) {
        this.offerQuotePrice = offerQuotePrice;
    }

    public LocalDateTime getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(LocalDateTime offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public LocalDateTime getOfferExpirationDate() {
        return offerExpirationDate;
    }

    public void setOfferExpirationDate(LocalDateTime offerExpirationDate) {
        this.offerExpirationDate = offerExpirationDate;
    }

    public LocalDateTime getOfferRmaExpirationDate() {
        return offerRmaExpirationDate;
    }

    public void setOfferRmaExpirationDate(LocalDateTime offerRmaExpirationDate) {
        this.offerRmaExpirationDate = offerRmaExpirationDate;
    }

    public LocalDateTime getOfferUpdatedDate() {
        return offerUpdatedDate;
    }

    public void setOfferUpdatedDate(LocalDateTime offerUpdatedDate) {
        this.offerUpdatedDate = offerUpdatedDate;
    }

    public String getOfferOrderId() {
        return offerOrderId;
    }

    public void setOfferOrderId(String offerOrderId) {
        this.offerOrderId = offerOrderId;
    }

    public String getOfferLineOrderId() {
        return offerLineOrderId;
    }

    public void setOfferLineOrderId(String offerLineOrderId) {
        this.offerLineOrderId = offerLineOrderId;
    }

    public String getOfferPartnerRmaNumber() {
        return offerPartnerRmaNumber;
    }

    public void setOfferPartnerRmaNumber(String offerPartnerRmaNumber) {
        this.offerPartnerRmaNumber = offerPartnerRmaNumber;
    }

    public String getOfferDeviceStatus() {
        return offerDeviceStatus;
    }

    public void setOfferDeviceStatus(String offerDeviceStatus) {
        this.offerDeviceStatus = offerDeviceStatus;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getOfferMarketingName() {
        return offerMarketingName;
    }

    public void setOfferMarketingName(String offerMarketingName) {
        this.offerMarketingName = offerMarketingName;
    }
}

