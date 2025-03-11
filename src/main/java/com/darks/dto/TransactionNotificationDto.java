package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionNotificationDto {
	
	private Long transNotificationKey;
    private String sessionId;              
    private String interactionId;  
    @NotBlank(message = "Activity ID is mandatory")
    private String activityId;             
    private String applicationId;          
    private String applicationUserId;      
    private String channelId; 
    @NotNull(message = "Event Date is mandatory")
    private String eventDate;   
    @NotBlank(message = "Event Origin is mandatory")
    private String eventOrigin;            
    @NotBlank(message = "Event Name is mandatory")
    private String eventName; 
    @NotBlank(message = "API Name is mandatory")
    private String apiName;                
    @NotBlank(message = "Invocation Type is mandatory")
    private String invocationType;         
    @NotBlank(message = "Transaction Reference Number is mandatory")
    private String transactionRefNo;      
    private String apiTransactionRefNo;   
    private String apiTransConfirmNumber; 
    private String transConfirmNumber;    
    private String errorCode;             
    private String errorDescription;      
    private String errorSource;           
    private String eventAction;           
    private List<EventAttribute> eventAttributeList; 
    private Timestamp createdAt;
    private String statusText;
    private String interfaceName;

  
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

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
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

	public List<EventAttribute> getEventAttributeList() {
		return eventAttributeList;
	}

	public void setEventAttributeList(List<EventAttribute> eventAttributeList) {
		this.eventAttributeList = eventAttributeList;
	}


	public Long getTransNotificationKey() {
		return transNotificationKey;
	}

	public void setTransNotificationKey(Long transNotificationKey) {
		this.transNotificationKey = transNotificationKey;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}


	
	public static class EventAttribute {
        private String key;
        private String value;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
        
        

    }
    
    @Override
    public String toString() {
        return "TransactionNotificationDTO{" +
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
                ", statusText=" + statusText +
                '}';
    }

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
    
}
