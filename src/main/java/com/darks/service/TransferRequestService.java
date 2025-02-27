package com.darks.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.darks.dto.FileNodesDto;
import com.darks.dto.TransferRequestDto;
import com.darks.model.TransferRequest;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

public interface TransferRequestService extends CrudService<Long, TransferRequest> {

	TransferRequest create(TransferRequestDto transferRequestDto);

	String genNodeFile(FileNodesDto fileNodesDto);
	
	List<Object[]> getTransferApiSto(String id);

	FileNodesDto mockTransferUpload(MultipartFile mockTransferFile);
}
