package com.darks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.SerialInfo;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("serialInfoRepository")
public interface SerialInfoRepository extends JpaRepository<SerialInfo, Long> {
	
	List<SerialInfo> findBySerialNumber(String serialNumber);
	
	SerialInfo findBySerialNumberOrderBySerialNumberDesc(String serialNumber);
	
	SerialInfo findByLineSegmentLineSegmentKey(Long lineSegKey);
	
	SerialInfo findByLineSegmentLineSegmentKeyAndSerialNumberOrderBySerialNumberDesc(Long lineSegKey, String serialNumber);
}
