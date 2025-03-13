package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.util.Date;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.darks.utils.CommonUtils;
import com.darks.utils.DateUtils;

public class MockTransferDto {
	
    private String apiName;
    private String eventName;
    private ZonedDateTime eventDate;
    private String transactionRefNo;
    private HeaderSegmentDto headerSegment;
    private AddressDto address;
    private List<LineSegmentDto> lineSegment;
    private String transOperation;
    private String transactionTypeId;
    private String sourceSystemId;
    private String customerId;
    
    private String trackingNumber;
    private String scenario = "TMRASTR";
    private Date expiryDate;
    private String action = "Create";
    private String tmoSku ;
    private String serialNumber;
    private String rmaNumber;
    
    
    private String dispositionCode;
    private String make;
    private String model;
    private String color;
    private String memory;
    private String returnProgramCode;
    private int totalUsageDays = 0;
    private String skuDescription;
    private String equipId;
    private String aStockReferenceSKU;
    
   
    private String orderNumber;
    private String orderType;
    
    private String SupplierName;
    private String stoFileUrl;
    private String tetraFileUrl;
    private String fileCat;
    
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public ZonedDateTime getEventDate() {
		return eventDate;
	}
	public void setEventDate(ZonedDateTime eventDate) {
		this.eventDate = eventDate;
	}
	public String getTransactionRefNo() {
		return transactionRefNo;
	}
	public void setTransactionRefNo(String transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}
	public HeaderSegmentDto getHeaderSegment() {
		return headerSegment;
	}
	public void setHeaderSegment(HeaderSegmentDto headerSegment) {
		this.headerSegment = headerSegment;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public List<LineSegmentDto> getLineSegment() {
		return lineSegment;
	}
	public void setLineSegment(List<LineSegmentDto> lineSegment) {
		this.lineSegment = lineSegment;
	}
	public String getTransOperation() {
		return transOperation;
	}
	public void setTransOperation(String transOperation) {
		this.transOperation = transOperation;
	}
	public String getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(String transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTmoSku() {
		return tmoSku;
	}
	public void setTmoSku(String tmoSku) {
		this.tmoSku = tmoSku;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getRmaNumber() {
		return rmaNumber;
	}
	public void setRmaNumber(String rmaNumber) {
		this.rmaNumber = rmaNumber;
	}
	public String getDispositionCode() {
		return dispositionCode;
	}
	public void setDispositionCode(String dispositionCode) {
		this.dispositionCode = dispositionCode;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getReturnProgramCode() {
		return returnProgramCode;
	}
	public void setReturnProgramCode(String returnProgramCode) {
		this.returnProgramCode = returnProgramCode;
	}
	public int getTotalUsageDays() {
		return totalUsageDays;
	}
	public void setTotalUsageDays(int totalUsageDays) {
		this.totalUsageDays = totalUsageDays;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public String getEquipId() {
		return equipId;
	}
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	public String getaStockReferenceSKU() {
		return aStockReferenceSKU;
	}
	public void setaStockReferenceSKU(String aStockReferenceSKU) {
		this.aStockReferenceSKU = aStockReferenceSKU;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	
	public String getStoFileUrl() {
		return stoFileUrl;
	}
	public void setStoFileUrl(String stoFileUrl) {
		this.stoFileUrl = stoFileUrl;
	}
	public String getTetraFileUrl() {
		return tetraFileUrl;
	}
	public void setTetraFileUrl(String tetraFileUrl) {
		this.tetraFileUrl = tetraFileUrl;
	}
	public String getFileCat() {
		return fileCat;
	}
	public void setFileCat(String fileCat) {
		this.fileCat = fileCat;
	}
	
	
	public MockTransferDto(Row row) {
		
		this.trackingNumber = CommonUtils.generateTrackingNumber();
		this.scenario = row.getCell(0).getStringCellValue().isEmpty() ?"TMRASTR":row.getCell(0).getStringCellValue();
        if (row.getCell(1).getCellType() == CellType.NUMERIC) {
            this.expiryDate = row.getCell(1).getDateCellValue();
        } else {
            this.expiryDate = DateUtils.futureDate((Date) row.getCell(1).getDateCellValue()); 
        }
		this.action = row.getCell(2).getStringCellValue().isEmpty()?"Create":row.getCell(2).getStringCellValue();
		this.tmoSku = row.getCell(3).getStringCellValue().replace("'", "");
		this.serialNumber = String.format("%.0f", row.getCell(4).getNumericCellValue());
		this.rmaNumber = row.getCell(5).getStringCellValue().isEmpty()?"": row.getCell(5).getStringCellValue();
        this.transactionRefNo = CommonUtils.generateTransRefNumber();
        
         
         this.dispositionCode = String.format("%.0f", row.getCell(6).getNumericCellValue());
         this.make = row.getCell(7).getStringCellValue();
         this.model = row.getCell(8).getStringCellValue();
         this.color = row.getCell(9).getStringCellValue();
         this.memory = row.getCell(10).getStringCellValue();
         this.returnProgramCode = row.getCell(11).getStringCellValue();
         this.totalUsageDays = (int) row.getCell(12).getNumericCellValue();
         this.skuDescription = row.getCell(13).getStringCellValue();
         this.equipId = String.format("%.0f", row.getCell(14).getNumericCellValue());
         this.aStockReferenceSKU = row.getCell(15).getStringCellValue().replace("'", "");
         
         this.orderNumber = CommonUtils.generateRandomNumber();
         this.orderType = "STOCreate";
         if(this.action.equalsIgnoreCase("Update")) {
        	 this.orderType = "STOUpdate";
         } else if(this.action.equalsIgnoreCase("Closure")) {
        	 this.orderType = "STOClosure";
         } else {
        	 this.orderType = "STOCreate";
         }
         
		
		
	}
	
	
	public MockTransferDto(Row row, Workbook workbook, Sheet sheet, int rowIndex) {
	    try {
	        this.trackingNumber = CommonUtils.generateTrackingNumber();
	        this.scenario = row.getCell(0).getStringCellValue().isEmpty() ? "TMRASTR" : row.getCell(0).getStringCellValue();
	        if (row.getCell(1).getCellType() == CellType.NUMERIC) {
	            this.expiryDate = row.getCell(1).getDateCellValue();
	        } else {
	            this.expiryDate = DateUtils.futureDate(new Date()); 
	        }
	        
	        this.action = row.getCell(2).getStringCellValue().isEmpty() ? "Create" : row.getCell(2).getStringCellValue();
	        this.tmoSku = row.getCell(3).getStringCellValue().replace("'", "");
	        
	        if (row.getCell(4).getCellType() == CellType.NUMERIC) {
	            this.serialNumber = String.format("%.0f", row.getCell(4).getNumericCellValue());
	        } else {
	            throw new IllegalArgumentException("Serial Number must be numeric");
	        }
	        
	        this.rmaNumber = row.getCell(5).getStringCellValue().isEmpty() ? "" : row.getCell(5).getStringCellValue();
	        this.transactionRefNo = CommonUtils.generateTransRefNumber();
	        this.dispositionCode = String.format("%.0f", row.getCell(6).getNumericCellValue());
	        this.make = row.getCell(7).getStringCellValue();
	        this.model = row.getCell(8).getStringCellValue();
	        this.color = row.getCell(9).getStringCellValue();
	        this.memory = row.getCell(10).getStringCellValue();
	        this.returnProgramCode = row.getCell(11).getStringCellValue();
	        this.totalUsageDays = (int) row.getCell(12).getNumericCellValue();
	        this.skuDescription = row.getCell(13).getStringCellValue();
	        this.equipId = String.format("%.0f", row.getCell(14).getNumericCellValue());
	        this.aStockReferenceSKU = row.getCell(15).getStringCellValue().replace("'", "");
	        this.orderNumber = CommonUtils.generateRandomNumber();
	        this.orderType = "STOCreate";
	        if (this.action.equalsIgnoreCase("Update")) {
	            this.orderType = "STOUpdate";
	        } else if (this.action.equalsIgnoreCase("Closure")) {
	            this.orderType = "STOClosure";
	        } else {
	            this.orderType = "STOCreate";
	        }
	        
	    } catch (Exception e) {
	        
	        handleError(row, workbook, sheet, rowIndex, e.getMessage());
	    }
	}

	
	private void handleError(Row row, Workbook workbook, Sheet sheet, int rowIndex, String errorMessage) {
	    Cell errorCell = row.createCell(row.getLastCellNum() != -1 ? row.getLastCellNum() : row.getPhysicalNumberOfCells());
	    errorCell.setCellValue("Error: " + errorMessage);
	    
	    for (Cell cell : row) {
	        if (cell != null) {
	            CellStyle style = workbook.createCellStyle();
	            style.setFillForegroundColor(IndexedColors.RED.getIndex());
	            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            cell.setCellStyle(style);
	        }
	    }
	}
}
