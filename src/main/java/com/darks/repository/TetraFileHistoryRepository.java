package com.darks.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.TetraFileHistory;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("tetraFileHistoryRepository")
public interface TetraFileHistoryRepository extends JpaRepository<TetraFileHistory, Long> {
	
	List<TetraFileHistory> findByTetraFileHistKey(Long tetraFileHistKey);
	
	TetraFileHistory findBySerialNumber(String serialNumber);
	
    Page<TetraFileHistory> findBySerialNumber(Pageable pageable,String serialNumber);
}
