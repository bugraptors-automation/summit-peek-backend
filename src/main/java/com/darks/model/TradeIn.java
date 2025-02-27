package com.darks.model;

/**
 * @author Er. Arundeep Randev
 * @since Feb 2025
 *
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "trade_in")
public class TradeIn implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_in_key")
    private Long tradeInKey;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @Column(name = "scenario")
    private String scenario;

    @Column(name = "disposition_code")
    private String dispositionCode;

    @Column(name = "disposition_reason")
    private String dispositionReason;

    @Column(name = "sku_id")
    private String skuId;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "actual_model")
    private String actualModel;

    @Column(name = "color")
    private String color;

    @Column(name = "memory")
    private String memory;

    @Column(name = "material_standard_name")
    private String materialStandardName;

    @Column(name = "delivery_number")
    private String deliveryNumber;

    @Column(name = "delivery_item_num")
    private String deliveryItemNum;

    @Column(name = "supplying_location")
    private String supplyingLocation;

    @Column(name = "return_auth_number")
    private String returnAuthNumber;

    @Column(name = "return_distribution_channel")
    private String returnDistributionChannel;

    @Column(name = "return_program_code")
    private String returnProgramCode;

    @Column(name = "return_shipment_tracking_number")
    private String returnShipmentTrackingNumber;

    @Column(name = "returned_by_id")
    private String returnedById;

    @Column(name = "return_by_location")
    private String returnByLocation;

    @Column(name = "returned_by_type")
    private String returnedByType;

    @Column(name = "original_sku")
    private String originalSku;

    @Column(name = "rma_number")
    private String rmaNumber;

    @Column(name = "repair_order_number")
    private String repairOrderNumber;

    @Column(name = "last_repair_vendor")
    private String lastRepairVendor;

    @Column(name = "repair_date")
    @Temporal(TemporalType.DATE)
    private Date repairDate;

    @Column(name = "replacement_serial_number")
    private String replacementSerialNumber;

    @Column(name = "first_used_date")
    @Temporal(TemporalType.DATE)
    private Date firstUsedDate;

    @Column(name = "last_used_date")
    @Temporal(TemporalType.DATE)
    private Date lastUsedDate;

    @Column(name = "total_usage_days")
    private Integer totalUsageDays;

    @ManyToOne
    @JoinColumn(name = "inventory_type")
    private InventoryType inventoryType;

    @Column(name = "oem_warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date oemWarrantyEndDate;

    @Column(name = "customer_warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date customerWarrantyEndDate;

    @Column(name = "repair_warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date repairWarrantyEndDate;

    @Column(name = "repair_count")
    private Integer repairCount;

    @Column(name = "return_count")
    private Integer returnCount;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "equip_id")
    private String equipId;

    @Column(name = "a_stock_reference_sku")
    private String aStockReferenceSku;

    @Column(name = "external_rma_number")
    private String externalRmaNumber;

    @Column(name = "primary_serial_identifier")
    private String primarySerialIdentifier;

    @Column(name = "mis_ship_indicator")
    private Boolean misShipIndicator;

    @Column(name = "sku_description")
    private String skuDescription;

    @Column(name = "forward_channel")
    private String forwardChannel;

    @Column(name = "forward_tracking_number")
    private String forwardTrackingNumber;

    @Column(name = "forward_document_date")
    @Temporal(TemporalType.DATE)
    private Date forwardDocumentDate;

    @Column(name = "forward_carrier_number")
    private String forwardCarrierNumber;

    @Column(name = "forward_sales_doc_type")
    private String forwardSalesDocType;

    @Column(name = "forward_program_code")
    private String forwardProgramCode;

    @Column(name = "forward_program_date")
    @Temporal(TemporalType.DATE)
    private Date forwardProgramDate;

    @Column(name = "forward_sales_order_number")
    private String forwardSalesOrderNumber;

    @Column(name = "forward_sales_orderitem_number")
    private String forwardSalesOrderitemNumber;

    @Column(name = "forward_shipped_date")
    @Temporal(TemporalType.DATE)
    private Date forwardShippedDate;

    @Column(name = "forward_shipped_to")
    private String forwardShippedTo;

    @Column(name = "forward_shipped_to_city")
    private String forwardShippedToCity;

    @Column(name = "forward_shipped_to_name1")
    private String forwardShippedToName1;

    @Column(name = "forward_shipped_to_name2")
    private String forwardShippedToName2;

    @Column(name = "forward_shipped_to_name3")
    private String forwardShippedToName3;

    @Column(name = "forward_shipped_to_state")
    private String forwardShippedToState;

    @Column(name = "forward_shipped_to_street1")
    private String forwardShippedToStreet1;

    @Column(name = "forward_shipped_to_zipcode")
    private String forwardShippedToZipcode;

    @Column(name = "forward_shipped_to_po_number")
    private String forwardShippedToPoNumber;

    @Column(name = "forward_transaction_type")
    private String forwardTransactionType;

    @Column(name = "forward_sold_to")
    private String forwardSoldTo;

    @Column(name = "oem_original_contract")
    private String oemOriginalContract;

    @Column(name = "last_biller")
    private String lastBiller;

    @Column(name = "liquidation_flag")
    private Boolean liquidationFlag;

    @Column(name = "auction_name")
    private String auctionName;

    // Getters and Setters
    public Long getTradeInKey() {
        return tradeInKey;
    }

    public void setTradeInKey(Long tradeInKey) {
        this.tradeInKey = tradeInKey;
    }

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

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
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

    public String getOriginalSku() {
        return originalSku;
    }

    public void setOriginalSku(String originalSku) {
        this.originalSku = originalSku;
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

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
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

    public Integer getTotalUsageDays() {
        return totalUsageDays;
    }

    public void setTotalUsageDays(Integer totalUsageDays) {
        this.totalUsageDays = totalUsageDays;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Date getOemWarrantyEndDate() {
        return oemWarrantyEndDate;
    }

    public void setOemWarrantyEndDate(Date oemWarrantyEndDate) {
        this.oemWarrantyEndDate = oemWarrantyEndDate;
    }

    public Date getCustomerWarrantyEndDate() {
        return customerWarrantyEndDate;
    }

    public void setCustomerWarrantyEndDate(Date customerWarrantyEndDate) {
        this.customerWarrantyEndDate = customerWarrantyEndDate;
    }

    public Date getRepairWarrantyEndDate() {
        return repairWarrantyEndDate;
    }

    public void setRepairWarrantyEndDate(Date repairWarrantyEndDate) {
        this.repairWarrantyEndDate = repairWarrantyEndDate;
    }

    public Integer getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(Integer repairCount) {
        this.repairCount = repairCount;
    }

    public Integer getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(Integer returnCount) {
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

    public String getAStockReferenceSku() {
        return aStockReferenceSku;
    }

    public void setAStockReferenceSku(String aStockReferenceSku) {
        this.aStockReferenceSku = aStockReferenceSku;
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

    public Boolean getMisShipIndicator() {
        return misShipIndicator;
    }

    public void setMisShipIndicator(Boolean misShipIndicator) {
        this.misShipIndicator = misShipIndicator;
    }

	public String getaStockReferenceSku() {
		return aStockReferenceSku;
	}

	public void setaStockReferenceSku(String aStockReferenceSku) {
		this.aStockReferenceSku = aStockReferenceSku;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
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

	public Date getForwardDocumentDate() {
		return forwardDocumentDate;
	}

	public void setForwardDocumentDate(Date forwardDocumentDate) {
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

	public Date getForwardProgramDate() {
		return forwardProgramDate;
	}

	public void setForwardProgramDate(Date forwardProgramDate) {
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

	public Date getForwardShippedDate() {
		return forwardShippedDate;
	}

	public void setForwardShippedDate(Date forwardShippedDate) {
		this.forwardShippedDate = forwardShippedDate;
	}

	public String getForwardShippedTo() {
		return forwardShippedTo;
	}

	public void setForwardShippedTo(String forwardShippedTo) {
		this.forwardShippedTo = forwardShippedTo;
	}

	public String getForwardShippedToCity() {
		return forwardShippedToCity;
	}

	public void setForwardShippedToCity(String forwardShippedToCity) {
		this.forwardShippedToCity = forwardShippedToCity;
	}

	public String getForwardShippedToName1() {
		return forwardShippedToName1;
	}

	public void setForwardShippedToName1(String forwardShippedToName1) {
		this.forwardShippedToName1 = forwardShippedToName1;
	}

	public String getForwardShippedToName2() {
		return forwardShippedToName2;
	}

	public void setForwardShippedToName2(String forwardShippedToName2) {
		this.forwardShippedToName2 = forwardShippedToName2;
	}

	public String getForwardShippedToName3() {
		return forwardShippedToName3;
	}

	public void setForwardShippedToName3(String forwardShippedToName3) {
		this.forwardShippedToName3 = forwardShippedToName3;
	}

	public String getForwardShippedToState() {
		return forwardShippedToState;
	}

	public void setForwardShippedToState(String forwardShippedToState) {
		this.forwardShippedToState = forwardShippedToState;
	}

	public String getForwardShippedToStreet1() {
		return forwardShippedToStreet1;
	}

	public void setForwardShippedToStreet1(String forwardShippedToStreet1) {
		this.forwardShippedToStreet1 = forwardShippedToStreet1;
	}

	public String getForwardShippedToZipcode() {
		return forwardShippedToZipcode;
	}

	public void setForwardShippedToZipcode(String forwardShippedToZipcode) {
		this.forwardShippedToZipcode = forwardShippedToZipcode;
	}

	public String getForwardShippedToPoNumber() {
		return forwardShippedToPoNumber;
	}

	public void setForwardShippedToPoNumber(String forwardShippedToPoNumber) {
		this.forwardShippedToPoNumber = forwardShippedToPoNumber;
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

	public Boolean getLiquidationFlag() {
		return liquidationFlag;
	}

	public void setLiquidationFlag(Boolean liquidationFlag) {
		this.liquidationFlag = liquidationFlag;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

 
}
