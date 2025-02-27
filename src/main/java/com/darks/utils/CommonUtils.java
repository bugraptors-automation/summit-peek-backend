package com.darks.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import com.darks.dto.FileNodesDto;
import com.darks.dto.TradeInDTO;
import com.darks.model.StoFileHistory;
import com.darks.model.TetraFileHistory;
import com.darks.repository.StoFileRepository;
import com.darks.repository.TetraFileHistoryRepository;

public class CommonUtils {

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param StoFileRepository
	 * @param docPath
	 * @param docName
	 * @param FileNodesDto
	 * @return void
	 */
	public static void saveFileDetails(StoFileRepository stoFileRepository, String stoFileName, String stoFilePath, FileNodesDto fileNodesDto) {

			StoFileHistory stoFileHistory = stoFileRepository.findBySerialNumber(fileNodesDto.getSerialNumber());
			
			if(stoFileHistory!=null) {
				stoFileHistory.setStoFileName(stoFileName);
	       	 	stoFileHistory.setStoFilePath(stoFilePath);
	       	    stoFileHistory.setSerialNumber(fileNodesDto.getSerialNumber());
			}else {
				stoFileHistory = new StoFileHistory();
				stoFileHistory.setStoFileName(stoFileName);
	       	 	stoFileHistory.setStoFilePath(stoFilePath);
	       	    stoFileHistory.setSerialNumber(fileNodesDto.getSerialNumber());
			}
       	 	
            stoFileRepository.saveAndFlush(stoFileHistory);
	}
	
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param StoFileRepository
	 * @param docPath
	 * @param docName
	 * @param FileNodesDto
	 * @return void
	 */
	public static void saveTetraFileDetails(TetraFileHistoryRepository tetraFileHistoryRepository, String docName, String docPath, TradeInDTO tradeInDTO) {

		    TetraFileHistory tetraFileHistory = tetraFileHistoryRepository.findBySerialNumber(tradeInDTO.getSerialNumber());
			
			if(tetraFileHistory!=null) {
				tetraFileHistory.setTetraFileName(docName);
				tetraFileHistory.setTetraFilePath(docPath);
				tetraFileHistory.setSerialNumber(tradeInDTO.getSerialNumber());
			}else {
				tetraFileHistory = new TetraFileHistory();
				tetraFileHistory.setTetraFileName(docName);
				tetraFileHistory.setTetraFilePath(docPath);
				tetraFileHistory.setSerialNumber(tradeInDTO.getSerialNumber());
			}
       	 	
			tetraFileHistoryRepository.saveAndFlush(tetraFileHistory);
	}

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Feb 2025
	 * @return String
	 */
    // Unique tracking number starting with 1Z
    public static String generateTrackingNumber() {
        String prefix = "1Z";  // Prefix for the tracking number
        StringBuilder trackingNumber = new StringBuilder(prefix);
        Random random = new Random();

       
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            trackingNumber.append(characters.charAt(index));
        }

        return trackingNumber.toString();
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Feb 2025
	 * @return String
	 */
    // Generate a random number starting with "MT"
    public static String generateTransRefNumber() {
        String prefix = "MT";  
        StringBuilder randomNumber = new StringBuilder(prefix);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomNumber.append(random.nextInt(10));  
        }

        return randomNumber.toString();
    }
    
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Feb 2025
	 * @return String
	 */
    // Generate a random number starting with "MT"
    public static String generateRandomNumber() {
        
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            
        	sb.append(random.nextInt(10)); 
        }

        return sb.toString();
    }
    
    public static boolean validateCSVContent(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                if (line.contains("<script>") || line.contains("<?php")) {
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
