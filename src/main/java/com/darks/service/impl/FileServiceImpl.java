package com.darks.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darks.dto.StoFileHistoryDto;
import com.darks.dto.TetraFileHistoryDto;
import com.darks.exception.NotFoundException;
import com.darks.model.StoFileHistory;
import com.darks.model.TetraFileHistory;
import com.darks.repository.StoFileRepository;
import com.darks.repository.TetraFileHistoryRepository;
import com.darks.service.FileService;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private StoFileRepository stoFileRepository;
	
	@Autowired
	TetraFileHistoryRepository tetraFileHistoryRepository;

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return List<DocConfig>
	 */
    @Transactional(readOnly = true)
    public List<StoFileHistory> findAll() {
        // DONE! Sort loads by "Doc" descending.
        return this.stoFileRepository.findAll(Sort.by(Sort.Direction.DESC, "docKey"));
    }
    

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param Long
	 * @return DocConfig
	 */
	@Override
	public StoFileHistory findById(Long id) {
		 return this.stoFileRepository.findById(id).orElseThrow(NotFoundException::new);
	}
	
	@Override
	public Page<TetraFileHistoryDto> getAllTetraFile(TetraFileHistoryDto tetraFileHistoryDto) {
		
        Pageable pageable = PageRequest.of(tetraFileHistoryDto.getPage(), tetraFileHistoryDto.getSize());
        
        List<TetraFileHistoryDto> list = new ArrayList<>();
        
        Page<TetraFileHistory> tetraFileHistoryList = tetraFileHistoryRepository.findBySerialNumber(pageable, tetraFileHistoryDto.getSerialNumber());
        
        if(tetraFileHistoryList!=null && !tetraFileHistoryList.getContent().isEmpty()) {
        	tetraFileHistoryList.forEach(tetraFileHistory->list.add(new TetraFileHistoryDto(tetraFileHistory)));
        	
        }
        return new PageImpl<>(list, pageable, tetraFileHistoryList.getTotalElements());

        
	}


	@Override
	public Page<StoFileHistoryDto> getAllStoFile(int page, int size) {
        
		Pageable pageable = PageRequest.of(page, size);
        
        List<StoFileHistoryDto> list = new ArrayList<>();
        
        Page<StoFileHistory> stoFileHistoryList = stoFileRepository.findAll(pageable);
        
        if(stoFileHistoryList!=null && !stoFileHistoryList.getContent().isEmpty()) {
        	stoFileHistoryList.forEach(tetraFileHistory->list.add(new StoFileHistoryDto(tetraFileHistory)));
        	
        }
        
        return new PageImpl<>(list, pageable, stoFileHistoryList.getTotalElements());
	}

}