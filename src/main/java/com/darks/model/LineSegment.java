package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Line_segment")
public class LineSegment implements Serializable {
	
	private static final long serialVersionUID = 1L;	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Line_segment_key")
    private Long lineSegmentKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transferRequestKey", referencedColumnName = "transfer_request_key", nullable = false)
    private TransferRequest transferRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "headerSegmentKey", referencedColumnName = "header_segment_key", nullable = false)
    private HeaderSegment headerSegment;

    @Column(name = "line_number", length = 50)
    private String lineNumber;

    @Column(name = "action_code", length = 50)
    private String actionCode;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "sku", length = 255)
    private String sku;

    public LineSegment() {
    }

	public Long getLineSegmentKey() {
		return lineSegmentKey;
	}

	public void setLineSegmentKey(Long lineSegmentKey) {
		this.lineSegmentKey = lineSegmentKey;
	}


	public TransferRequest getTransferRequest() {
		return transferRequest;
	}

	public void setTransferRequest(TransferRequest transferRequest) {
		this.transferRequest = transferRequest;
	}

	public HeaderSegment getHeaderSegment() {
		return headerSegment;
	}

	public void setHeaderSegment(HeaderSegment headerSegment) {
		this.headerSegment = headerSegment;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
    
}
