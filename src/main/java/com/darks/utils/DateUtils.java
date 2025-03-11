package com.darks.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
public class DateUtils {

	private static String df = "dd-MM-yyyy-HH-mm-ss";

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param Data
	 * @return String
	 */
	public static String getdateTimeStampByDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(df);
		try {
			if(date!=null){
				return  formatter.format(date);
			}
			return null;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	public static String calculateFirstUsedDateStr(int totalUsageDays) {
        if (totalUsageDays == 0) {
            return "0";
        }
        LocalDate today = LocalDate.now();

        LocalDate lastUsedDate = today.minusDays(totalUsageDays);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return lastUsedDate.format(formatter);
    }
	
	
    public static Date calculateFirstUsedDate(int totalUsageDays) {
        if (totalUsageDays == 0) {
            return new Date(); // Return the current date if no usage days
        }

        LocalDate today = LocalDate.now();

        LocalDate lastUsedDate = today.minusDays(totalUsageDays);

        LocalDateTime localDateTime = lastUsedDate.atStartOfDay();
        Date lastUsed = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        return lastUsed;
    }
    
    public static Date calculateLastUsedDate(int totalUsageDays) {
        if (totalUsageDays != 0) {
            return new Date(); // Return the current date if no usage days
        }


        return new Date();
    }
    
    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
    
    public static Date futureDate(Date date) {
    	
    	if(date == null) {
    		date = new Date();
    	}
    	LocalDateTime inputDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

		
		LocalDateTime futureDateTime = inputDateTime.plusDays(21);
		
		
		Date futureDate = Date.from(futureDateTime.atZone(ZoneId.systemDefault()).toInstant());

        return futureDate;
    }
    
    
    public static Date formatEvent() {
    
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'")
                .withZone(ZoneOffset.UTC); 
    	
    	String dateStr = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'";
    	
    	Date date = new Date(); 
    	        
    	  try {
    	           
    	       Instant instant = Instant.parse(dateStr);
    	       date = Date.from(instant); 
    	   } catch (DateTimeParseException e) {
    	            
    	   }

    	 return date;
    }
    
}
