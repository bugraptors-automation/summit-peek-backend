package com.darks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darks.model.TransferRequest;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Repository("tetraRepository")
public interface TetraRepository extends JpaRepository<TransferRequest, Long> {
	
	
	 @Query(value = "SELECT " +
             "tr.transfer_request_key AS transferRequest, " +
             "tr.api_name, " +
             "tr.event_name, " +
             "tr.event_date, " +
             "COALESCE(tr.transaction_ref_no, ''), " +
             "tr.trans_operation, " +
             "tr.transaction_type_id, " +
             "tr.source_system_id, " +
             "tr.customer_id, " +
             "hs.header_segment_key AS headerSegment, " +
             "hs.order_number, " +
             "COALESCE(hs.host_order_number, ''), " +
             "hs.tracking_number, " +
             "hs.supplier_number, " +
             "hs.expiry_date, " +
             "hs.scenario, " +
             "hs.order_type, " +
             "hs.action, " +
             "addr.address_key AS address, " +
             "addr.address_line1, " +
             "COALESCE(addr.address_line2, ''), " +
             "addr.address_type, " +
             "addr.address_name, " +
             "addr.postal_code, " +
             "addr.city, " +
             "addr.country, " +
             "addr.state, " +
             "addr.email, " +
             "ls.line_segment_key AS lineSegment, " +
             "ls.line_number, " +
             "ls.action_code, " +
             "ls.qty, " +
             "ls.sku, " +
             "si.serial_info_key AS serialInfo, " +
             "si.serial_number, " +
             "si.rma_number " +
             "FROM " +
             "Transfer_Request tr " +
             "LEFT JOIN Header_Segment hs ON tr.transfer_Request_Key = hs.transfer_Request_Key " +
             "LEFT JOIN Address addr ON tr.transfer_Request_Key = addr.transfer_Request_Key " +
             "LEFT JOIN Line_Segment ls ON tr.transfer_Request_Key = ls.transfer_Request_Key " +
             "LEFT JOIN Serial_Info si ON ls.line_Segment_Key = si.line_Segment_Key "+ 
             "WHERE si.serial_number = :serialNumber",
     nativeQuery = true)
List<Object[]> findTransferApiDtoBySerialNumber(@Param("serialNumber") String serialNumber);
	

}