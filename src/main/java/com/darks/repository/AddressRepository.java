package com.darks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darks.model.Address;
/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

@Repository("addressRepository")
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findByTransferRequestTransferRequestKey(Long transferRequestKey);

	
}
