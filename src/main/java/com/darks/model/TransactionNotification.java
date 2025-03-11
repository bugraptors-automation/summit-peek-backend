package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Feb-Mar 2025
 *
 */

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_notification")
public class TransactionNotification implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_notification_key")
    private Long transNotificationKey;

	@Column(name = "session_id")
    private String sessionId;

    @Column(name = "interaction_id")
    private String interactionId;

    @Column(name = "activity_id", nullable = false)
    private String activityId;

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "application_user_id")
    private String applicationUserId;

    @Column(name = "channel_id")
    private String channelId;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_origin", nullable = false)
    private String eventOrigin;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "api_name", nullable = false)
    private String apiName;

    @Column(name = "invocation_type", nullable = false)
    private String invocationType;

    @Column(name = "transaction_ref_no", nullable = false)
    private String transactionRefNo;

    @Column(name = "api_transaction_ref_no")
    private String apiTransactionRefNo;

    @Column(name = "api_trans_confirm_number")
    private String apiTransConfirmNumber;

    @Column(name = "trans_confirm_number")
    private String transConfirmNumber;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "error_description")
    private String errorDescription;

    @Column(name = "error_source")
    private String errorSource;

    @Column(name = "event_action", nullable = false)
    private String eventAction;

    @Column(name = "event_attribute_list")
    private String eventAttributeList;  // This can be mapped as String or a JSON type if supported by JPA

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    
    public TransactionNotification() {}
    
    public Long getTransNotificationKey() {
        return transNotificationKey;
    }

    public void setTransNotificationKey(Long transNotificationKey) {
        this.transNotificationKey = transNotificationKey;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(String applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventOrigin() {
        return eventOrigin;
    }

    public void setEventOrigin(String eventOrigin) {
        this.eventOrigin = eventOrigin;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getInvocationType() {
        return invocationType;
    }

    public void setInvocationType(String invocationType) {
        this.invocationType = invocationType;
    }

    public String getTransactionRefNo() {
        return transactionRefNo;
    }

    public void setTransactionRefNo(String transactionRefNo) {
        this.transactionRefNo = transactionRefNo;
    }

    public String getApiTransactionRefNo() {
        return apiTransactionRefNo;
    }

    public void setApiTransactionRefNo(String apiTransactionRefNo) {
        this.apiTransactionRefNo = apiTransactionRefNo;
    }

    public String getApiTransConfirmNumber() {
        return apiTransConfirmNumber;
    }

    public void setApiTransConfirmNumber(String apiTransConfirmNumber) {
        this.apiTransConfirmNumber = apiTransConfirmNumber;
    }

    public String getTransConfirmNumber() {
        return transConfirmNumber;
    }

    public void setTransConfirmNumber(String transConfirmNumber) {
        this.transConfirmNumber = transConfirmNumber;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public void setErrorSource(String errorSource) {
        this.errorSource = errorSource;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getEventAttributeList() {
        return eventAttributeList;
    }

    public void setEventAttributeList(String eventAttributeList) {
        this.eventAttributeList = eventAttributeList;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TransactionNotification{" +
                "transNotificationKey=" + transNotificationKey +
                ", sessionId='" + sessionId + '\'' +
                ", interactionId='" + interactionId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", applicationUserId='" + applicationUserId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", eventDate=" + eventDate +
                ", eventOrigin='" + eventOrigin + '\'' +
                ", eventName='" + eventName + '\'' +
                ", apiName='" + apiName + '\'' +
                ", invocationType='" + invocationType + '\'' +
                ", transactionRefNo='" + transactionRefNo + '\'' +
                ", apiTransactionRefNo='" + apiTransactionRefNo + '\'' +
                ", apiTransConfirmNumber='" + apiTransConfirmNumber + '\'' +
                ", transConfirmNumber='" + transConfirmNumber + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorSource='" + errorSource + '\'' +
                ", eventAction='" + eventAction + '\'' +
                ", eventAttributeList='" + eventAttributeList + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
