package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.HeaderSegment;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("headerSegmentRepository")
public interface HeaderSegmentRepository extends JpaRepository<HeaderSegment, Long> {
	
	HeaderSegment findByTransferRequestTransferRequestKey(Long transferRequestKey);
	
}
