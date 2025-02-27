package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.TradeInOfferDetails;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("tradeInOfferDetailsRepository")
public interface TradeInOfferDetailsRepository extends JpaRepository<TradeInOfferDetails, Long> {
	
	TradeInOfferDetails findByTradeInSerialNumber(String serialNumber);
}
