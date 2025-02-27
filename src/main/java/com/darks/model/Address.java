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
@Table(name = "Address")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_key")
	private Long addressKey;
	 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transferRequestKey", referencedColumnName = "transfer_request_key", nullable = false)
    private TransferRequest transferRequest;
    
    @Column(name = "addressLine1", length = 255)
    private String addressLine1;
    
    @Column(name = "addressLine2", length = 255)
    private String addressLine2;
    
    @Column(name = "address_type", length = 50)
    private String addressType;
    
    @Column(name = "address_name", length = 255)
    private String addressName;
    
    @Column(name = "postal_code", length = 20)
    private String postalCode;
    
    @Column(name = "city", length = 100)
    private String city;
    
    @Column(name = "country", length = 50)
    private String country;
    
    @Column(name = "state", length = 50)
    private String state;
    
    @Column(name = "email", length = 100)
    private String email;
    
    public Address() {
    }

	public Long getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(Long addressKey) {
		this.addressKey = addressKey;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TransferRequest getTransferRequest() {
		return transferRequest;
	}

	public void setTransferRequest(TransferRequest transferRequest) {
		this.transferRequest = transferRequest;
	}

}
