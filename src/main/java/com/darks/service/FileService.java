package com.darks.service;

import org.springframework.data.domain.Page;

import com.darks.dto.StoFileHistoryDto;
import com.darks.dto.TetraFileHistoryDto;
import com.darks.model.StoFileHistory;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

public interface FileService extends CrudService<Long, StoFileHistory> {

	Page<StoFileHistoryDto> getAllStoFile(int page, int size);
	
	Page<TetraFileHistoryDto> getAllTetraFile(TetraFileHistoryDto tetraFileHistoryDto);


}
