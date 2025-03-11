package com.darks.controller;
/**
 * @author Er. Arundeep Randev
 * @since Feb-Mar 2025
 *
 */
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.darks.config.MockWrapper;
import com.darks.dto.FileNodesDto;
import com.darks.dto.TransferRequestDto;
import com.darks.model.TransferRequest;
import com.darks.service.TransferRequestService;
import com.darks.utils.CommonUtils;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/transfer")
@CrossOrigin(origins = "*") 
public record TransferRequestController(TransferRequestService transferRequestService) {


	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return ResponseEntity
	 */
    @GetMapping("/getAllReference")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<TransferRequest>> getAllFileReferences() {
        
        try {
            List<TransferRequest> transferRequests = transferRequestService.findAll();
            return ResponseEntity.ok(transferRequests);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param Long
	 * @return ResponseEntity
	 */
    @GetMapping("/oldFile/{id}")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "FileReference not found")
    })
    public ResponseEntity<TransferRequest> getAllOldFileReferenceById(@PathVariable Long id) {
        
    	TransferRequest fileReferenceOpt = transferRequestService.findById(id);
        if (fileReferenceOpt!=null) {
            return ResponseEntity.ok(fileReferenceOpt);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/{id}")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "FileReference not found")
    })
    public ResponseEntity<List<Object[]>> getAllFileReferenceById(@PathVariable String id) {
        
    	List<Object[]> fileReferenceOpt = transferRequestService.getTransferApiSto(id);
        if (fileReferenceOpt!=null) {
            return ResponseEntity.ok(fileReferenceOpt);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param fileReferenceDto
	 * @return ResponseEntity
	 */
    @PostMapping("/create")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "FileReference created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid load data provided")
    })
    public ResponseEntity<TransferRequestDto> create(@RequestBody TransferRequestDto transferRequestDto) {
        
    	transferRequestService.create(transferRequestDto);
        
        return ResponseEntity.ok(transferRequestDto);
    }


	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param FileNodeDto
	 * @return ResponseEntity
	 */
    @PostMapping("/load_data")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "File generated successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid load data provided"),
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
	public ResponseEntity<String> generateDeviceFile(@RequestBody FileNodesDto fileNodesDto) {

    	if (fileNodesDto == null || fileNodesDto.getLength() == 0) {
    	    return new ResponseEntity<>("Invalid file data", HttpStatus.BAD_REQUEST);
    	}
    	
   			
			transferRequestService.genNodeFile(fileNodesDto);
			
   		return new ResponseEntity<>("Ok", HttpStatus.CREATED);
    
	}
    
    
    @PostMapping("/mockTransfer")
    @ApiResponses(value = {
    		 @ApiResponse(responseCode = "201", description = "File generated successfully"),
             @ApiResponse(responseCode = "422", description = "Invalid load data provided"),
             @ApiResponse(responseCode = "400", description = "File is empty"),
             @ApiResponse(responseCode = "415", description = "Unsupported file type"),
             @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<MockWrapper<FileNodesDto>> mockTransferUpload(HttpServletRequest request, @RequestParam(value="mockTransferFile", required=true) MultipartFile mockTransferFile) {
		
    	try {
    		
    	    if (!CommonUtils.validateCSVContent(mockTransferFile)) {
    	            
       	       return new ResponseEntity<>(new MockWrapper<FileNodesDto>("Invalid file content", null,HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    	    }
    		return transferRequestService.mockTransferUpload(mockTransferFile);
    	
        } catch (IllegalArgumentException  e) {
            return new ResponseEntity<>(new MockWrapper<FileNodesDto>("Invalid data provided", null,HttpStatus.UNPROCESSABLE_ENTITY.value()), HttpStatus.UNPROCESSABLE_ENTITY);
            
        } catch (Exception e) {
            return new ResponseEntity<>(new MockWrapper<FileNodesDto>("Internal server error", null,HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
    }
    

}
