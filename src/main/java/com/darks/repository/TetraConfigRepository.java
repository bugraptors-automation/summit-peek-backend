package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.TetraConfig;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("tetraConfigRepository")
public interface TetraConfigRepository extends JpaRepository<TetraConfig, Long> {
	
	
	TetraConfig findBySerialNumber(String serialNumber);
	
}
