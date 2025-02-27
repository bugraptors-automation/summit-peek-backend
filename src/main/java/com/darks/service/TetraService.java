package com.darks.service;

import com.darks.dto.TradeInDTO;
import com.darks.model.TetraConfig;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
public interface TetraService extends CrudService<Long, TetraConfig>{

	TetraConfig findById(String sno);

	void addTradeIn(TradeInDTO returnMockTransfer);

	public TradeInDTO getTetraResponse(TradeInDTO tradeInDTO);


}
