package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.util.List;

public class TradeInOfferDetailsDTO {

    private String offerQuoteNumber;
    private String offerBAN;
    private String offerMSISDN;
    private String offerQuotePrice;
    private String offerStartDate;
    private String offerExpirationDate;
    private String offerRMAExpirationDate;
    private String offerCancelReasonCode;
    private String offerUpdatedDate;
    private List<OfferQuestionnaireResponseDTO> offerQuestionnaireResponse;
    private String offerOrderId;
    private String offerLineOrderId;
    private String offerPartnerRMANumber;
    private String offerRejectReason;
    private String offerDeviceStatus;
    private String offerTradeInIntent;
    private String offerInsuranceDeductible;
    private boolean offerClaimRequiredIndicator;
    private String offerClaimAuthorizationDate;
    private boolean offerClaimDeviceCollectionRequired;
    private boolean offerClaimAuthorizationAvailable;
    private String offerClaimAuthorizationCode;
    private String offerJumpTradeInValue;
    private String ccrAdjustedOfferAmount;
    private String ccrAdjustmentReason;
    private String offerStatus;
    private String offerMarketingName;
    
    public TradeInOfferDetailsDTO() {
    	
    }
    
	public String getOfferQuoteNumber() {
		return offerQuoteNumber;
	}
	public void setOfferQuoteNumber(String offerQuoteNumber) {
		this.offerQuoteNumber = offerQuoteNumber;
	}
	public String getOfferBAN() {
		return offerBAN;
	}
	public void setOfferBAN(String offerBAN) {
		this.offerBAN = offerBAN;
	}
	public String getOfferMSISDN() {
		return offerMSISDN;
	}
	public void setOfferMSISDN(String offerMSISDN) {
		this.offerMSISDN = offerMSISDN;
	}
	public String getOfferQuotePrice() {
		return offerQuotePrice;
	}
	public void setOfferQuotePrice(String offerQuotePrice) {
		this.offerQuotePrice = offerQuotePrice;
	}
	public String getOfferStartDate() {
		return offerStartDate;
	}
	public void setOfferStartDate(String offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
	public String getOfferExpirationDate() {
		return offerExpirationDate;
	}
	public void setOfferExpirationDate(String offerExpirationDate) {
		this.offerExpirationDate = offerExpirationDate;
	}
	public String getOfferRMAExpirationDate() {
		return offerRMAExpirationDate;
	}
	public void setOfferRMAExpirationDate(String offerRMAExpirationDate) {
		this.offerRMAExpirationDate = offerRMAExpirationDate;
	}
	public String getOfferCancelReasonCode() {
		return offerCancelReasonCode;
	}
	public void setOfferCancelReasonCode(String offerCancelReasonCode) {
		this.offerCancelReasonCode = offerCancelReasonCode;
	}
	public String getOfferUpdatedDate() {
		return offerUpdatedDate;
	}
	public void setOfferUpdatedDate(String offerUpdatedDate) {
		this.offerUpdatedDate = offerUpdatedDate;
	}
	public List<OfferQuestionnaireResponseDTO> getOfferQuestionnaireResponse() {
		return offerQuestionnaireResponse;
	}
	public void setOfferQuestionnaireResponse(List<OfferQuestionnaireResponseDTO> offerQuestionnaireResponse) {
		this.offerQuestionnaireResponse = offerQuestionnaireResponse;
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
	public String getOfferPartnerRMANumber() {
		return offerPartnerRMANumber;
	}
	public void setOfferPartnerRMANumber(String offerPartnerRMANumber) {
		this.offerPartnerRMANumber = offerPartnerRMANumber;
	}
	public String getOfferRejectReason() {
		return offerRejectReason;
	}
	public void setOfferRejectReason(String offerRejectReason) {
		this.offerRejectReason = offerRejectReason;
	}
	public String getOfferDeviceStatus() {
		return offerDeviceStatus;
	}
	public void setOfferDeviceStatus(String offerDeviceStatus) {
		this.offerDeviceStatus = offerDeviceStatus;
	}
	public String getOfferTradeInIntent() {
		return offerTradeInIntent;
	}
	public void setOfferTradeInIntent(String offerTradeInIntent) {
		this.offerTradeInIntent = offerTradeInIntent;
	}
	public String getOfferInsuranceDeductible() {
		return offerInsuranceDeductible;
	}
	public void setOfferInsuranceDeductible(String offerInsuranceDeductible) {
		this.offerInsuranceDeductible = offerInsuranceDeductible;
	}
	public boolean isOfferClaimRequiredIndicator() {
		return offerClaimRequiredIndicator;
	}
	public void setOfferClaimRequiredIndicator(boolean offerClaimRequiredIndicator) {
		this.offerClaimRequiredIndicator = offerClaimRequiredIndicator;
	}
	public String getOfferClaimAuthorizationDate() {
		return offerClaimAuthorizationDate;
	}
	public void setOfferClaimAuthorizationDate(String offerClaimAuthorizationDate) {
		this.offerClaimAuthorizationDate = offerClaimAuthorizationDate;
	}
	public boolean isOfferClaimDeviceCollectionRequired() {
		return offerClaimDeviceCollectionRequired;
	}
	public void setOfferClaimDeviceCollectionRequired(boolean offerClaimDeviceCollectionRequired) {
		this.offerClaimDeviceCollectionRequired = offerClaimDeviceCollectionRequired;
	}
	public boolean isOfferClaimAuthorizationAvailable() {
		return offerClaimAuthorizationAvailable;
	}
	public void setOfferClaimAuthorizationAvailable(boolean offerClaimAuthorizationAvailable) {
		this.offerClaimAuthorizationAvailable = offerClaimAuthorizationAvailable;
	}
	public String getOfferClaimAuthorizationCode() {
		return offerClaimAuthorizationCode;
	}
	public void setOfferClaimAuthorizationCode(String offerClaimAuthorizationCode) {
		this.offerClaimAuthorizationCode = offerClaimAuthorizationCode;
	}
	public String getOfferJumpTradeInValue() {
		return offerJumpTradeInValue;
	}
	public void setOfferJumpTradeInValue(String offerJumpTradeInValue) {
		this.offerJumpTradeInValue = offerJumpTradeInValue;
	}
	public String getCcrAdjustedOfferAmount() {
		return ccrAdjustedOfferAmount;
	}
	public void setCcrAdjustedOfferAmount(String ccrAdjustedOfferAmount) {
		this.ccrAdjustedOfferAmount = ccrAdjustedOfferAmount;
	}
	public String getCcrAdjustmentReason() {
		return ccrAdjustmentReason;
	}
	public void setCcrAdjustmentReason(String ccrAdjustmentReason) {
		this.ccrAdjustmentReason = ccrAdjustmentReason;
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
