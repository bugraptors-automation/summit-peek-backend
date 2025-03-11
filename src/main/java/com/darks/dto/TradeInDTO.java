package com.darks.dto;
/**
 * @author Er. Arundeep Randev
 * @since Jan-Mar 2025
 *
 */

import java.util.Date;
import java.util.List;

import com.darks.utils.DateUtils;

public class TradeInDTO {

    private String serialNumber;
    private String scenario;
    private String dispositionCode;
    private String dispositionReason;
    private String skuID;
    private String make;
    private String model;
    private String actualModel;
    private String color;
    private String memory;
    private String materialStandardName;
    private String deliveryNumber;
    private String deliveryItemNum;
    private String supplyingLocation;
    private String returnAuthNumber;
    private String returnDistributionChannel;
    private String returnProgramCode;
    private String returnShipmentTrackingNumber;
    private String returnedById;
    private String returnByLocation;
    private String returnedByType;
    private String originalSKU;
    private String rmaNumber;
    private String repairOrderNumber;
    private String lastRepairVendor;
    private String repairDate;
    private String replacementSerialNumber;
    private Date firstUsedDate;
    private Date lastUsedDate;
    private int totalUsageDays;
    private String inventoryType;
    private String oemWarrantyEndDate;
    private String customerWarrantyEndDate;
    private String repairWarrantyEndDate;
    private int repairCount;
    private int returnCount;
    private String carrier;
    private String equipId;
    private String aStockReferenceSKU;
    private String externalRmaNumber;
    private String primarySerialIdentifier;
    private boolean misShipIndicator;
    private String skuDescription;
    private List<SerialNumberListDTO> serialNumberList;
    private String forwardChannel;
    private String forwardTrackingNumber;
    private String forwardDocumentDate;
    private String forwardCarrierNumber;
    private String forwardSalesDocType;
    private String forwardProgramCode;
    private String forwardProgramDate;
    private String forwardSalesOrderNumber;
    private String forwardSalesOrderitemNumber;
    private String forwardShippedDate;
    private String forwardShippedto;
    private String forwardShippedtoCity;
    private String forwardShippedtoName1;
    private String forwardShippedtoName2;
    private String forwardShippedtoName3;
    private String forwardShippedtoState;
    private String forwardShippedtoStreet1;
    private String forwardShippedtoZipcode;
    private String forwardShippedtoPONumber;
    private String forwardTransactionType;
    private String forwardSoldTo;
    private String oemOriginalContract;
    private String lastBiller;
    private boolean liquidationFlag;
    private TradeInOfferDetailsDTO tradeInOfferDetails;
    private String auctionName;
    private String SupplierName;
    private String tetraFileUrl;
    
    
    private String fileCat;
    
    public TradeInDTO() {}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getDispositionCode() {
		return dispositionCode;
	}

	public void setDispositionCode(String dispositionCode) {
		this.dispositionCode = dispositionCode;
	}

	public String getDispositionReason() {
		return dispositionReason;
	}

	public void setDispositionReason(String dispositionReason) {
		this.dispositionReason = dispositionReason;
	}

	public String getSkuID() {
		return skuID;
	}

	public void setSkuID(String skuID) {
		this.skuID = skuID;
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

	public String getActualModel() {
		return actualModel;
	}

	public void setActualModel(String actualModel) {
		this.actualModel = actualModel;
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

	public String getMaterialStandardName() {
		return materialStandardName;
	}

	public void setMaterialStandardName(String materialStandardName) {
		this.materialStandardName = materialStandardName;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getDeliveryItemNum() {
		return deliveryItemNum;
	}

	public void setDeliveryItemNum(String deliveryItemNum) {
		this.deliveryItemNum = deliveryItemNum;
	}

	public String getSupplyingLocation() {
		return supplyingLocation;
	}

	public void setSupplyingLocation(String supplyingLocation) {
		this.supplyingLocation = supplyingLocation;
	}

	public String getReturnAuthNumber() {
		return returnAuthNumber;
	}

	public void setReturnAuthNumber(String returnAuthNumber) {
		this.returnAuthNumber = returnAuthNumber;
	}

	public String getReturnDistributionChannel() {
		return returnDistributionChannel;
	}

	public void setReturnDistributionChannel(String returnDistributionChannel) {
		this.returnDistributionChannel = returnDistributionChannel;
	}

	public String getReturnProgramCode() {
		return returnProgramCode;
	}

	public void setReturnProgramCode(String returnProgramCode) {
		this.returnProgramCode = returnProgramCode;
	}

	public String getReturnShipmentTrackingNumber() {
		return returnShipmentTrackingNumber;
	}

	public void setReturnShipmentTrackingNumber(String returnShipmentTrackingNumber) {
		this.returnShipmentTrackingNumber = returnShipmentTrackingNumber;
	}

	public String getReturnedById() {
		return returnedById;
	}

	public void setReturnedById(String returnedById) {
		this.returnedById = returnedById;
	}

	public String getReturnByLocation() {
		return returnByLocation;
	}

	public void setReturnByLocation(String returnByLocation) {
		this.returnByLocation = returnByLocation;
	}

	public String getReturnedByType() {
		return returnedByType;
	}

	public void setReturnedByType(String returnedByType) {
		this.returnedByType = returnedByType;
	}

	public String getOriginalSKU() {
		return originalSKU;
	}

	public void setOriginalSKU(String originalSKU) {
		this.originalSKU = originalSKU;
	}

	public String getRmaNumber() {
		return rmaNumber;
	}

	public void setRmaNumber(String rmaNumber) {
		this.rmaNumber = rmaNumber;
	}

	public String getRepairOrderNumber() {
		return repairOrderNumber;
	}

	public void setRepairOrderNumber(String repairOrderNumber) {
		this.repairOrderNumber = repairOrderNumber;
	}

	public String getLastRepairVendor() {
		return lastRepairVendor;
	}

	public void setLastRepairVendor(String lastRepairVendor) {
		this.lastRepairVendor = lastRepairVendor;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public String getReplacementSerialNumber() {
		return replacementSerialNumber;
	}

	public void setReplacementSerialNumber(String replacementSerialNumber) {
		this.replacementSerialNumber = replacementSerialNumber;
	}

	public Date getFirstUsedDate() {
		return firstUsedDate;
	}

	public void setFirstUsedDate(Date firstUsedDate) {
		this.firstUsedDate = firstUsedDate;
	}

	public Date getLastUsedDate() {
		return lastUsedDate;
	}

	public void setLastUsedDate(Date lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	public int getTotalUsageDays() {
		return totalUsageDays;
	}

	public void setTotalUsageDays(int totalUsageDays) {
		this.totalUsageDays = totalUsageDays;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getOemWarrantyEndDate() {
		return oemWarrantyEndDate;
	}

	public void setOemWarrantyEndDate(String oemWarrantyEndDate) {
		this.oemWarrantyEndDate = oemWarrantyEndDate;
	}

	public String getCustomerWarrantyEndDate() {
		return customerWarrantyEndDate;
	}

	public void setCustomerWarrantyEndDate(String customerWarrantyEndDate) {
		this.customerWarrantyEndDate = customerWarrantyEndDate;
	}

	public String getRepairWarrantyEndDate() {
		return repairWarrantyEndDate;
	}

	public void setRepairWarrantyEndDate(String repairWarrantyEndDate) {
		this.repairWarrantyEndDate = repairWarrantyEndDate;
	}

	public int getRepairCount() {
		return repairCount;
	}

	public void setRepairCount(int repairCount) {
		this.repairCount = repairCount;
	}

	public int getReturnCount() {
		return returnCount;
	}

	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
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

	public String getExternalRmaNumber() {
		return externalRmaNumber;
	}

	public void setExternalRmaNumber(String externalRmaNumber) {
		this.externalRmaNumber = externalRmaNumber;
	}

	public String getPrimarySerialIdentifier() {
		return primarySerialIdentifier;
	}

	public void setPrimarySerialIdentifier(String primarySerialIdentifier) {
		this.primarySerialIdentifier = primarySerialIdentifier;
	}

	public boolean isMisShipIndicator() {
		return misShipIndicator;
	}

	public void setMisShipIndicator(boolean misShipIndicator) {
		this.misShipIndicator = misShipIndicator;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public List<SerialNumberListDTO> getSerialNumberList() {
		return serialNumberList;
	}

	public void setSerialNumberList(List<SerialNumberListDTO> serialNumberList) {
		this.serialNumberList = serialNumberList;
	}

	public String getForwardChannel() {
		return forwardChannel;
	}

	public void setForwardChannel(String forwardChannel) {
		this.forwardChannel = forwardChannel;
	}

	public String getForwardTrackingNumber() {
		return forwardTrackingNumber;
	}

	public void setForwardTrackingNumber(String forwardTrackingNumber) {
		this.forwardTrackingNumber = forwardTrackingNumber;
	}

	public String getForwardDocumentDate() {
		return forwardDocumentDate;
	}

	public void setForwardDocumentDate(String forwardDocumentDate) {
		this.forwardDocumentDate = forwardDocumentDate;
	}

	public String getForwardCarrierNumber() {
		return forwardCarrierNumber;
	}

	public void setForwardCarrierNumber(String forwardCarrierNumber) {
		this.forwardCarrierNumber = forwardCarrierNumber;
	}

	public String getForwardSalesDocType() {
		return forwardSalesDocType;
	}

	public void setForwardSalesDocType(String forwardSalesDocType) {
		this.forwardSalesDocType = forwardSalesDocType;
	}

	public String getForwardProgramCode() {
		return forwardProgramCode;
	}

	public void setForwardProgramCode(String forwardProgramCode) {
		this.forwardProgramCode = forwardProgramCode;
	}

	public String getForwardProgramDate() {
		return forwardProgramDate;
	}

	public void setForwardProgramDate(String forwardProgramDate) {
		this.forwardProgramDate = forwardProgramDate;
	}

	public String getForwardSalesOrderNumber() {
		return forwardSalesOrderNumber;
	}

	public void setForwardSalesOrderNumber(String forwardSalesOrderNumber) {
		this.forwardSalesOrderNumber = forwardSalesOrderNumber;
	}

	public String getForwardSalesOrderitemNumber() {
		return forwardSalesOrderitemNumber;
	}

	public void setForwardSalesOrderitemNumber(String forwardSalesOrderitemNumber) {
		this.forwardSalesOrderitemNumber = forwardSalesOrderitemNumber;
	}

	public String getForwardShippedDate() {
		return forwardShippedDate;
	}

	public void setForwardShippedDate(String forwardShippedDate) {
		this.forwardShippedDate = forwardShippedDate;
	}

	public String getForwardShippedto() {
		return forwardShippedto;
	}

	public void setForwardShippedto(String forwardShippedto) {
		this.forwardShippedto = forwardShippedto;
	}

	public String getForwardShippedtoCity() {
		return forwardShippedtoCity;
	}

	public void setForwardShippedtoCity(String forwardShippedtoCity) {
		this.forwardShippedtoCity = forwardShippedtoCity;
	}

	public String getForwardShippedtoName1() {
		return forwardShippedtoName1;
	}

	public void setForwardShippedtoName1(String forwardShippedtoName1) {
		this.forwardShippedtoName1 = forwardShippedtoName1;
	}

	public String getForwardShippedtoName2() {
		return forwardShippedtoName2;
	}

	public void setForwardShippedtoName2(String forwardShippedtoName2) {
		this.forwardShippedtoName2 = forwardShippedtoName2;
	}

	public String getForwardShippedtoName3() {
		return forwardShippedtoName3;
	}

	public void setForwardShippedtoName3(String forwardShippedtoName3) {
		this.forwardShippedtoName3 = forwardShippedtoName3;
	}

	public String getForwardShippedtoState() {
		return forwardShippedtoState;
	}

	public void setForwardShippedtoState(String forwardShippedtoState) {
		this.forwardShippedtoState = forwardShippedtoState;
	}

	public String getForwardShippedtoStreet1() {
		return forwardShippedtoStreet1;
	}

	public void setForwardShippedtoStreet1(String forwardShippedtoStreet1) {
		this.forwardShippedtoStreet1 = forwardShippedtoStreet1;
	}

	public String getForwardShippedtoZipcode() {
		return forwardShippedtoZipcode;
	}

	public void setForwardShippedtoZipcode(String forwardShippedtoZipcode) {
		this.forwardShippedtoZipcode = forwardShippedtoZipcode;
	}

	public String getForwardShippedtoPONumber() {
		return forwardShippedtoPONumber;
	}

	public void setForwardShippedtoPONumber(String forwardShippedtoPONumber) {
		this.forwardShippedtoPONumber = forwardShippedtoPONumber;
	}

	public String getForwardTransactionType() {
		return forwardTransactionType;
	}

	public void setForwardTransactionType(String forwardTransactionType) {
		this.forwardTransactionType = forwardTransactionType;
	}

	public String getForwardSoldTo() {
		return forwardSoldTo;
	}

	public void setForwardSoldTo(String forwardSoldTo) {
		this.forwardSoldTo = forwardSoldTo;
	}

	public String getOemOriginalContract() {
		return oemOriginalContract;
	}

	public void setOemOriginalContract(String oemOriginalContract) {
		this.oemOriginalContract = oemOriginalContract;
	}

	public String getLastBiller() {
		return lastBiller;
	}
	

	public void setLastBiller(String lastBiller) {
		this.lastBiller = lastBiller;
	}

	public boolean isLiquidationFlag() {
		return liquidationFlag;
	}

	public void setLiquidationFlag(boolean liquidationFlag) {
		this.liquidationFlag = liquidationFlag;
	}

	public TradeInOfferDetailsDTO getTradeInOfferDetails() {
		return tradeInOfferDetails;
	}

	public void setTradeInOfferDetails(TradeInOfferDetailsDTO tradeInOfferDetails) {
		this.tradeInOfferDetails = tradeInOfferDetails;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public String getFileCat() {
		return fileCat;
	}

	public void setFileCat(String fileCat) {
		this.fileCat = fileCat;
	}
	
	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getTetraFileUrl() {
		return tetraFileUrl;
	}

	public void setTetraFileUrl(String tetraFileUrl) {
		this.tetraFileUrl = tetraFileUrl;
	}

	public TradeInDTO(MockTransferDto mockTransferDto) {
		
		this.fileCat = mockTransferDto.getFileCat();
		this.skuID = mockTransferDto.getTmoSku();
		this.make = mockTransferDto.getMake();
		this.model = mockTransferDto.getModel();
		this.actualModel = mockTransferDto.getModel();
		this.color = mockTransferDto.getColor();
		this.memory = mockTransferDto.getMemory();
		this.materialStandardName = mockTransferDto.getModel();
		this.returnAuthNumber = "";
		this.returnShipmentTrackingNumber = mockTransferDto.getTrackingNumber();
		this.returnedById  = mockTransferDto.getSupplierName();
		this.returnByLocation = "null";
		this.originalSKU = mockTransferDto.getTmoSku();
		this.rmaNumber = !mockTransferDto.getRmaNumber().isEmpty()?mockTransferDto.getRmaNumber():"";
		this.firstUsedDate = (Date) DateUtils.calculateFirstUsedDate(mockTransferDto.getTotalUsageDays());
		this.lastUsedDate =  (Date) DateUtils.calculateLastUsedDate(mockTransferDto.getTotalUsageDays());
		this.totalUsageDays = mockTransferDto.getTotalUsageDays()!=0?mockTransferDto.getTotalUsageDays():0;
		this.equipId  = mockTransferDto.getEquipId();
		this.aStockReferenceSKU  = mockTransferDto.getaStockReferenceSKU();
		this.externalRmaNumber = mockTransferDto.getaStockReferenceSKU();
		this.oemOriginalContract = "TMOBILE";
		this.lastBiller = "TMOBILE";
		this.serialNumber = mockTransferDto.getSerialNumber();
		this.scenario = mockTransferDto.getScenario();
		this.dispositionCode = mockTransferDto.getDispositionCode().isEmpty()?"12":mockTransferDto.getDispositionCode();
		this.skuDescription = mockTransferDto.getSkuDescription();
		this.SupplierName = mockTransferDto.getSupplierName();
	}
	
}
