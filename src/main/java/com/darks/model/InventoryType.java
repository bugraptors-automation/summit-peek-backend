package com.darks.model;

import java.io.Serializable;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

import jakarta.persistence.Column;

//import javax.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory_type")
public class InventoryType implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_type_key")
    private Long inventoryTypeKey;

    @Column(name = "inventory_type_name", unique = true, nullable = false)
    private String inventoryTypeName;

    @Column(name = "inventory_type_description")
    private String inventoryTypeDescription;

    public InventoryType(Long i) {
		this.inventoryTypeKey = i;
	}
    
    public InventoryType() {
		
	}

	// Getters and Setters
    public Long getInventoryTypeKey() {
        return inventoryTypeKey;
    }

    public void setInventoryTypeKey(Long inventoryTypeKey) {
        this.inventoryTypeKey = inventoryTypeKey;
    }

    public String getInventoryTypeName() {
        return inventoryTypeName;
    }

    public void setInventoryTypeName(String inventoryTypeName) {
        this.inventoryTypeName = inventoryTypeName;
    }

    public String getInventoryTypeDescription() {
        return inventoryTypeDescription;
    }

    public void setInventoryTypeDescription(String inventoryTypeDescription) {
        this.inventoryTypeDescription = inventoryTypeDescription;
    }
}

