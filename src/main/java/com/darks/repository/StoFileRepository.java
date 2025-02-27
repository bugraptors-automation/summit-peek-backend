package com.darks.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.StoFileHistory;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("stoFileRepository")
public interface StoFileRepository extends JpaRepository<StoFileHistory, Long> {
	
	List<StoFileHistory> findByStoFileKey(Long stoFileKey);
	
	StoFileHistory findBySerialNumber(String serialNumber);
	
	Page<StoFileHistory> findAll(Pageable pageable);
	
}
