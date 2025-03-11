package com.darks.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;

public interface ValidatorService {

	byte[] getModifiedExcelFile(InputStream excelInputStream) throws IOException;

	boolean isExcelValid(InputStream excelInputStream, Workbook workbook) throws Exception;

	boolean isExcelValid(InputStream excelInputStream) throws Exception;
	

}
