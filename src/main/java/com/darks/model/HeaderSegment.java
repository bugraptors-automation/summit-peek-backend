package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "header_segment")
public class HeaderSegment implements Serializable{

	private static final long serialVersionUID = 1L;	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="header_segment_key")
    private Long headerSegmentKey;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transferRequestKey", referencedColumnName = "transfer_request_key", nullable = false)
    private TransferRequest transferRequest;

    @Column(name = "order_number", length = 255)
    private String orderNumber;

    @Column(name = "host_order_number", length = 255)
    private String hostOrderNumber;

    @Column(name = "tracking_number", length = 255)
    private String trackingNumber;

    @Column(name = "supplier_number", length = 50)
    private String supplierNumber;

    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @Column(name = "scenario", length = 50)
    private String scenario;

    @Column(name = "order_type", length = 50)
    private String orderType;

    @Column(name = "action", length = 50)
    private String action;

    public HeaderSegment() {
    }

	public Long getHeaderSegmentKey() {
		return headerSegmentKey;
	}

	public void setHeaderSegmentKey(Long headerSegmentKey) {
		this.headerSegmentKey = headerSegmentKey;
	}

	public TransferRequest getTransferRequest() {
		return transferRequest;
	}

	public void setTransferRequest(TransferRequest transferRequest) {
		this.transferRequest = transferRequest;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getHostOrderNumber() {
		return hostOrderNumber;
	}

	public void setHostOrderNumber(String hostOrderNumber) {
		this.hostOrderNumber = hostOrderNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
}
