package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.SerialNumberList;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("serialNumberListRepository")
public interface SerialNumberListRepository extends JpaRepository<SerialNumberList, Long> {
	
	SerialNumberList findByTradeInSerialNumber(String serialNumber);
	
}
