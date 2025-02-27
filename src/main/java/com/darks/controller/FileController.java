package com.darks.controller;
import java.util.HashMap;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
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

import com.darks.dto.StoFileHistoryDto;
import com.darks.dto.TetraFileHistoryDto;
import com.darks.model.StoFileHistory;
import com.darks.service.FileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/file")
@CrossOrigin(origins = "*") 
public record FileController(FileService fileService) {
	
	
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return ResponseEntity
	 */
    @GetMapping("/getAllDocDetails")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<List<StoFileHistory>> getAllDocConfigs() {
       
        try {
            List<StoFileHistory> stoFileHistories = fileService.findAll();
            return ResponseEntity.ok(stoFileHistories);
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
    @GetMapping("/getDocDetails/{id}")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "FileReference not found")
    })
    public ResponseEntity<StoFileHistory> getDocConfig(@PathVariable Long id) {
        
        StoFileHistory docConfigOpt = fileService.findById(id);
        if (docConfigOpt!=null) {
            return ResponseEntity.ok(docConfigOpt);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/getStoFileDetails")
    @Operation(summary = "Get all doc details", description = "Get a list of all registered Doc details")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    public ResponseEntity<Map<String, Object>> getAllStoFile(
        @RequestParam(defaultValue = "0") int page, // Default to page 0 if not provided
        @RequestParam(defaultValue = "10") int size  // Default to 10 items per page if not provided
    ) {
        // Call the service method to get paginated data
        Page<StoFileHistoryDto> stoFileHistories = fileService.getAllStoFile(page, size);
        
        Map<String, Object> response = new HashMap<>();
        if (stoFileHistories.getTotalElements() > 0) {
	        response.put("data", stoFileHistories.getContent());  // List of items for the current page
	        response.put("currentPage", stoFileHistories.getNumber());
	        response.put("totalItems", stoFileHistories.getTotalElements());
	        response.put("totalPages", stoFileHistories.getTotalPages());
	        response.put("pageSize", stoFileHistories.getSize());
	        
	       
	        return ResponseEntity.ok(response);
        }else {
        	response.put("message", "No data found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    
    
    @PostMapping("/getTetraResponseFile")
    @Operation(summary = "Get all Tetra Response details", description = "Get a list of all registered tetra File details")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        @ApiResponse(responseCode = "400", description = "No data found")
    })
    public ResponseEntity<Map<String, Object>> getTetraResponseFile(
    	@RequestBody TetraFileHistoryDto tetraFileHistoryDto
        
    ) {
        // Call the service method to get paginated data
        Page<TetraFileHistoryDto> pageResult = fileService.getAllTetraFile(tetraFileHistoryDto);
        
        Map<String, Object> response = new HashMap<>();
        
        if (pageResult.getTotalElements() > 0) {
        	
        	response.put("data", pageResult.getContent());  // List of items for the current page
            response.put("currentPage", pageResult.getNumber());
            response.put("totalItems", pageResult.getTotalElements());
            response.put("totalPages", pageResult.getTotalPages());
            response.put("pageSize", pageResult.getSize());
            
            
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
        	response.put("message", "No data found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
