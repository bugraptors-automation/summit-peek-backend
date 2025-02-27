package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.LineSegment;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("lineSegmentRepository")
public interface LineSegmentRepository extends JpaRepository<LineSegment, Long> {
	
	LineSegment findByTransferRequestTransferRequestKeyAndHeaderSegmentHeaderSegmentKey(Long transferReqKey, Long headerSegKey);
	
	LineSegment findByTransferRequestTransferRequestKey(Long transferReqKey);
	
}
