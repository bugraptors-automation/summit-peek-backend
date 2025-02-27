package com.darks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darks.model.TradeIn;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("tradeInRepository")
public interface TradeInRepository extends JpaRepository<TradeIn, Long> {
	

	TradeIn findBySerialNumber(String serialNumber);
	
	
	@Query(value = "SELECT " +
		    "t.trade_in_key, " +
		    "t.serial_number, " +
		    "t.scenario, " +
		    "t.disposition_code, " +
		    "t.disposition_reason, " +
		    "t.sku_id, " +
		    "t.make, " +
		    "t.model, " +
		    "t.actual_model, " +
		    "t.color, " +
		    "t.memory, " +
		    "t.material_standard_name, " +
		    "t.delivery_number, " +
		    "t.delivery_item_num, " +
		    "t.supplying_location, " +
		    "t.return_auth_number, " +
		    "t.return_distribution_channel, " +
		    "t.return_program_code, " +
		    "t.return_shipment_tracking_number, " +
		    "t.returned_by_id, " +
		    "t.return_by_location, " +
		    "t.returned_by_type, " +
		    "t.original_sku, " +
		    "t.rma_number, " +
		    "t.repair_order_number, " +
		    "t.last_repair_vendor, " +
		    "t.repair_date, " +
		    "t.replacement_serial_number, " +
		    "t.first_used_date, " +
		    "t.last_used_date, " +
		    "t.total_usage_days, " +
		    "t.inventory_type, " +
		    "t.oem_warranty_end_date, " +
		    "t.customer_warranty_end_date, " +
		    "t.repair_warranty_end_date, " +
		    "t.repair_count, " +
		    "t.return_count, " +
		    "t.carrier, " +
		    "t.equip_id, " +
		    "t.a_stock_reference_sku, " +
		    "t.external_rma_number, " +
		    "t.primary_serial_identifier, " +
		    "t.mis_ship_indicator, " +
		    "t.sku_description, " +
		    "t.forward_channel, " +
		    "t.forward_tracking_number, " +
		    "t.forward_document_date, " +
		    "t.forward_carrier_number, " +
		    "t.forward_sales_doc_type, " +
		    "t.forward_program_code, " +
		    "t.forward_program_date, " +
		    "t.forward_sales_order_number, " +
		    "t.forward_sales_orderitem_number, " +
		    "t.forward_shipped_date, " +
		    "t.forward_shipped_to, " +
		    "t.forward_shipped_to_city, " +
		    "t.forward_shipped_to_name1, " +
		    "t.forward_shipped_to_name2, " +
		    "t.forward_shipped_to_name3, " +
		    "t.forward_shipped_to_state, " +
		    "t.forward_shipped_to_street1, " +
		    "t.forward_shipped_to_zipcode, " +
		    "t.forward_shipped_to_po_number, " +
		    "t.forward_transaction_type, " +
		    "t.forward_sold_to, " +
		    "t.oem_original_contract, " +
		    "t.last_biller, " +
		    "t.liquidation_flag, " +
		    "t.auction_name, " +
		    
		    "snl.imei_dec, " +
		    "snl.meid_hex, " +
		    "snl.meid_dec, " +
		    "snl.esn_dec, " +
		    "snl.mac_id, " +

		    "tio.offer_quote_key, " +
		    "tio.offer_ban, " +
		    "tio.offer_msisdn, " +
		    "tio.offer_quote_price, " +
		    "tio.offer_start_date, " +
		    "tio.offer_expiration_date, " +
		    "tio.offer_rma_expiration_date, " +
		    "tio.offer_updated_date, " +
		    "tio.offer_order_id, " +
		    "tio.offer_device_status, " +
		    "tio.offer_status, " +
		    "tio.offer_marketing_name, " +

		    "qr.language, " +
		    "qr.question_name, " +
		    "qr.question_priority, " +
		    "qr.question_description, " +

		    "a.answer_description, " +
		    "a.answer_name, " +
		    "a.priority " +

		"FROM " +
		    "trade_in t " +
		"LEFT JOIN serial_number_list snl ON snl.serial_number = t.serial_number " +
		"LEFT JOIN trade_in_offer_details tio ON tio.trade_in_serial_number = t.serial_number " +
		"LEFT JOIN questionnaire_response qr ON qr.offer_quote_key = tio.offer_quote_key " +
		"LEFT JOIN answer a ON a.response_question_id = qr.response_key " +
		"WHERE t.serial_number = :serialNumber ",
		    nativeQuery = true)
	List<Object[]> findTetraResponseBySerialNumber(@Param("serialNumber") String serialNumber);
	
}
