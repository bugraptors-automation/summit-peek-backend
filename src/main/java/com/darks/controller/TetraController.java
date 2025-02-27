package com.darks.controller;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.util.List;

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

import com.darks.dto.TetraConfigDto;
import com.darks.dto.TetraFileHistoryDto;
import com.darks.dto.TradeInDTO;
import com.darks.model.TetraConfig;
import com.darks.model.TetraFileHistory;
import com.darks.service.TetraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/tetra")
@CrossOrigin(origins = "*") 
public record TetraController(TetraService tetraService) {

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return ResponseEntity
	 */
	 	@GetMapping("/getAllTetraData")
	    @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", description = "Successful operation")
	    })
	    public ResponseEntity<List<TetraConfig>> getAllTetraConfigs() {
	        try {
	            List<TetraConfig> tetraConfigs = tetraService.findAll();
	            return ResponseEntity.ok(tetraConfigs);
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
	 	@GetMapping("/{sno}")
	    @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", description = "Successful operation"),
	            @ApiResponse(responseCode = "404", description = "Data not found")
	    })
	 	public ResponseEntity<TetraConfig> getTetraConfigBySno(@PathVariable String sno) {
	        
	 		TetraConfig tetraConfigOpt = tetraService.findById(sno);
	        if (tetraConfigOpt!=null) {
	            return ResponseEntity.ok(tetraConfigOpt);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

		/**
		 * @createdBy Er. Arundeep Randev
		 * @since Jan 2025
		 * @param TetraConfigDto
		 * @return ResponseEntity
		 */
	 	@PostMapping("/getTetraDataOld")
	    @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", description = "Successful operation"),
	            @ApiResponse(responseCode = "404", description = "Data not found")
	    })
	    public ResponseEntity<TetraConfig> getTetraConfigById(@RequestBody TetraConfigDto tetraConfigDto) {
		 	if (tetraConfigDto == null) {
		        return ResponseEntity.badRequest().build();
		    }
		 	
		 	TetraConfig tetraConfig =  tetraService.findById(tetraConfigDto.getSerialNumber());

		 	 if (tetraConfig != null) {
		         return ResponseEntity.ok(tetraConfig);
		     } else {
		         return ResponseEntity.notFound().build();
		     }
	    }


	 	@PostMapping("/getTetraData")
	    @ApiResponses(value = { 
	            @ApiResponse(responseCode = "200", description = "Successful operation"),
	            @ApiResponse(responseCode = "404", description = "Data not found")
	    })
	    public ResponseEntity<TradeInDTO> getTetraResponseBySerialNumber(@RequestBody TradeInDTO tradeInDTO) {
		 	if (tradeInDTO == null) {
		        return ResponseEntity.badRequest().build();
		    }
		 	
		 	tradeInDTO =  tetraService.getTetraResponse(tradeInDTO);

		 	 if (tradeInDTO != null) {
		         return ResponseEntity.ok(tradeInDTO);
		     } else {
		         return ResponseEntity.notFound().build();
		     }
	    }

}
