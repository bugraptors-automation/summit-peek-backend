package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.InventoryType;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("inventoryTypeRepository")
public interface InventoryTypeRepository extends JpaRepository<InventoryType, Long> {
	

	
}
