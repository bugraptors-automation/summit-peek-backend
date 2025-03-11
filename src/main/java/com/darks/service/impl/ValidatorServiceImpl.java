package com.darks.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darks.service.ValidatorService;

/**
 * @author Er. Arundeep Randev
 * @since Feb-Mar 2025
 *
 */

@Service
@Transactional
public class ValidatorServiceImpl implements ValidatorService {

	@Override
    public boolean isExcelValid(InputStream excelInputStream) throws Exception {
        Workbook workbook = new XSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Set<String> serialNumbers = new HashSet<>(); // Set to check duplicates

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell serialCell = row.getCell(4); 

            if (serialCell != null) {
                String serialNumber = serialCell.getStringCellValue().trim();

                if (serialNumbers.contains(serialNumber)) {
                    workbook.close();
                    return false; // Duplicate found
                }
                serialNumbers.add(serialNumber);
            }
        }

        workbook.close();
        return true; 
    }
   
	@Override
    public boolean isExcelValid(InputStream excelInputStream, Workbook workbook) throws Exception {
        Sheet sheet = workbook.getSheetAt(0);
        Set<String> serialNumbers = new HashSet<>();
        Set<Integer> duplicateRows = new HashSet<>(); // To store rows that have duplicates

        // Create red style for highlighting duplicate cells
        XSSFCellStyle redStyle = (XSSFCellStyle) workbook.createCellStyle();
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        int rowIndex = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell serialCell = row.getCell(0); // Assuming email is in the first column

            if (serialCell != null) {
                String serialNumber = serialCell.getStringCellValue().trim();

                if (serialNumbers.contains(serialNumber)) {
                    // Highlight the entire row in red
                    duplicateRows.add(rowIndex);
                    row.getCell(0).setCellStyle(redStyle); // Highlight the email cell
                }
                serialNumbers.add(serialNumber);
            }
            rowIndex++;
        }
        
        return duplicateRows.isEmpty(); // Return true if no duplicates, false otherwise
    }

	@Override
    public byte[] getModifiedExcelFile(InputStream excelInputStream) throws IOException {
        Workbook workbook = new XSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Set<String> serialNumbers = new HashSet<>();
        Set<Integer> duplicateRows = new HashSet<>();

        // Create red style for highlighting duplicate cells
        XSSFCellStyle redStyle = (XSSFCellStyle) workbook.createCellStyle();
        redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        int rowIndex = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell serialCell = row.getCell(0); // Assuming email is in the first column

            if (serialCell != null) {
                String serialNumber = serialCell.getStringCellValue().trim();

                if (serialNumbers.contains(serialNumber)) {
                    // Highlight the entire row in red
                    duplicateRows.add(rowIndex);
                    row.getCell(0).setCellStyle(redStyle); // Highlight the email cell
                }
                serialNumbers.add(serialNumber);
            }
            rowIndex++;
        }

        // Write the modified file to a byte array output stream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        workbook.close();
        
        return byteArrayOutputStream.toByteArray();
    }

}