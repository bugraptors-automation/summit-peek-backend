package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.darks.dto.TransferApiDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.*;


@Entity
@Table(name = "transfer_request")
@SqlResultSetMapping(
	    name = "TransferApiDtoMapping", 
	    classes = @ConstructorResult(
	        targetClass = TransferApiDto.class,
	        columns = {
	            @ColumnResult(name = "transferRequest", type = Long.class),
	            @ColumnResult(name = "apiName", type = String.class),
	            @ColumnResult(name = "eventName", type = String.class),
	            @ColumnResult(name = "transactionRefNo", type = String.class),
	            @ColumnResult(name = "transOperation", type = String.class),
	            @ColumnResult(name = "transactionTypeId", type = String.class),
	            @ColumnResult(name = "sourceSystemId", type = String.class),
	            @ColumnResult(name = "customerId", type = String.class),
	            @ColumnResult(name = "headerSegment", type = Long.class),
	            @ColumnResult(name = "orderNumber", type = String.class),
	            @ColumnResult(name = "hostOrderNumber", type = String.class),
	            @ColumnResult(name = "trackingNumber", type = String.class),
	            @ColumnResult(name = "supplierNumber", type = String.class),
	            @ColumnResult(name = "scenario", type = String.class),
	            @ColumnResult(name = "orderType", type = String.class),
	            @ColumnResult(name = "action", type = String.class),
	            @ColumnResult(name = "address", type = Long.class),
	            @ColumnResult(name = "addressLine1", type = String.class),
	            @ColumnResult(name = "addressLine2", type = String.class),
	            @ColumnResult(name = "addressType", type = String.class),
	            @ColumnResult(name = "addressName", type = String.class),
	            @ColumnResult(name = "postalCode", type = String.class),
	            @ColumnResult(name = "city", type = String.class),
	            @ColumnResult(name = "country", type = String.class),
	            @ColumnResult(name = "state", type = String.class),
	            @ColumnResult(name = "email", type = String.class),
	            @ColumnResult(name = "lineSegment", type = Long.class),
	            @ColumnResult(name = "lineNumber", type = String.class),
	            @ColumnResult(name = "actionCode", type = String.class),
	            @ColumnResult(name = "qty", type = Integer.class),
	            @ColumnResult(name = "sku", type = String.class),
	            @ColumnResult(name = "serialInfo", type = Long.class),
	            @ColumnResult(name = "serialNumber", type = String.class),
	            @ColumnResult(name = "rmaNumber", type = String.class)
	        }
	    )
	)
public class TransferRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transfer_request_key")
    private Long transferRequestKey;
    
    @Column(name = "api_name", length = 255)
    private String apiName;

    @Column(name = "event_name", length = 255)
    private String eventName;

    @Column(name = "event_date")
    private ZonedDateTime eventDate;

    //@Column(name = "transaction_ref_no", length = 255, unique = true)
    @Column(name = "transaction_ref_no", length = 255)
    private String transactionRefNo;

    @Column(name = "trans_operation", length = 50)
    private String transOperation;

    @Column(name = "transaction_type_id", length = 50)
    private String transactionTypeId;

    @Column(name = "source_system_id", length = 50)
    private String sourceSystemId;

    @Column(name = "customer_id", length = 50)
    private String customerId;

    public TransferRequest() {
    }

	public Long getTransferRequestKey() {
		return transferRequestKey;
	}

	public void setTransferRequestKey(Long transferRequestKey) {
		this.transferRequestKey = transferRequestKey;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public ZonedDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(ZonedDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public String getTransactionRefNo() {
		return transactionRefNo;
	}

	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}

	public String getTransOperation() {
		return transOperation;
	}

	public void setTransOperation(String transOperation) {
		this.transOperation = transOperation;
	}

	public String getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(String transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
