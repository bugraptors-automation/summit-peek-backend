package com.darks.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darks.dto.AnswerDTO;
import com.darks.dto.OfferQuestionnaireResponseDTO;
import com.darks.dto.SerialNumberListDTO;
import com.darks.dto.TradeInDTO;
import com.darks.dto.TradeInOfferDetailsDTO;
import com.darks.model.Answer;
import com.darks.model.InventoryType;
import com.darks.model.Language;
import com.darks.model.QuestionnaireResponse;
import com.darks.model.SerialNumberList;
import com.darks.model.TetraConfig;
import com.darks.model.TradeIn;
import com.darks.model.TradeInOfferDetails;
import com.darks.repository.AnswerRepository;
import com.darks.repository.LanguageRepository;
import com.darks.repository.QuestionnaireResponseRepository;
import com.darks.repository.SerialNumberListRepository;
import com.darks.repository.TetraConfigRepository;
import com.darks.repository.TetraFileHistoryRepository;
import com.darks.repository.TradeInOfferDetailsRepository;
import com.darks.repository.TradeInRepository;
import com.darks.service.TetraService;
import com.darks.utils.CommonUtils;
import com.darks.utils.DateUtils;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Service
@Transactional
public class TetraServiceImpl implements TetraService{
	
	private static final String extJson = ".json";
	private static final String extXml = ".xml";
	private static final String catJson = "json";
	private static final String catXml = "xml";

	private static final String fName = "TetraResponse";
	private static final String folName = "device_details/tetra_response";

	@Autowired
	TetraConfigRepository tetraConfigRepository;
	
	@Autowired
	TradeInRepository tradeInRepository;
	
	@Autowired
	SerialNumberListRepository serialNumberListRepository;
	
	@Autowired
	TradeInOfferDetailsRepository tradeInOfferDetailsRepository;
	
	@Autowired
	QuestionnaireResponseRepository questionnaireResponseRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	TetraFileHistoryRepository tetraFileHistoryRepository;
	
	@Value("${deviceDir}")
	private String deviceDir;
	
	@Value("${tetraDirUrl}")
	private String tetraDirUrl;


	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return List<TetraConfig>
	 */
    @Transactional(readOnly = true)
    public List<TetraConfig> findAll() {
        // DONE! loads by "tetra" descending.
        return this.tetraConfigRepository.findAll(Sort.by(Sort.Direction.DESC, "tetraConfigKey"));
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param Long
	 * @return TetraConfig
	 */
    @Transactional(readOnly = true)
    public TetraConfig findById(String id) {
        return this.tetraConfigRepository.findBySerialNumber(id);
    }

	@Override
	public TetraConfig findById(Long sno) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	@Transactional
	public void addTradeIn(TradeInDTO tradeInDto) {
		
		TradeIn tradeIn = tradeInRepository.findBySerialNumber(tradeInDto.getSerialNumber());
		
		if(tradeIn!=null) {
			
		}else {
			tradeIn = new TradeIn();
			tradeIn.setSerialNumber(tradeInDto.getSerialNumber());
			tradeIn.setScenario("TMRASTR");
			tradeIn.setDispositionCode("12");
			tradeInDto.setDispositionCode("12");
			
			
			if(tradeInDto.getDispositionCode().equalsIgnoreCase("12")) {
				tradeInDto.setDispositionReason("Trade In device");
				
			}
			
			tradeIn.setSkuId(tradeInDto.getSkuID());
			tradeIn.setMake(tradeInDto.getMake());
			tradeIn.setModel(tradeInDto.getModel());
			tradeIn.setActualModel(tradeInDto.getActualModel());
			tradeIn.setColor(tradeInDto.getColor());
			tradeIn.setMemory(tradeInDto.getMemory());
			tradeIn.setMaterialStandardName(tradeInDto.getMaterialStandardName());
			tradeIn.setDeliveryNumber("50");
			tradeIn.setDeliveryItemNum("50");
			tradeIn.setSupplyingLocation("DC90");
			tradeIn.setReturnAuthNumber(tradeInDto.getRepairOrderNumber());
			tradeIn.setReturnDistributionChannel(tradeInDto.getDispositionCode());
			tradeIn.setReturnProgramCode("TIC");
			tradeIn.setReturnShipmentTrackingNumber(tradeInDto.getReturnShipmentTrackingNumber());
			tradeIn.setReturnedById(tradeInDto.getSupplierName());
			tradeIn.setReturnByLocation(!tradeInDto.getReturnShipmentTrackingNumber().isEmpty()?tradeInDto.getReturnShipmentTrackingNumber():"null");
			tradeIn.setReturnedByType("Customer");
			tradeIn.setOriginalSku(tradeInDto.getOriginalSKU());
			tradeIn.setRmaNumber(!tradeInDto.getRmaNumber().isEmpty()?tradeInDto.getRmaNumber():"");
			tradeIn.setRepairOrderNumber(null);
			tradeIn.setLastRepairVendor(null);
			tradeIn.setRepairDate(null);
			tradeIn.setReplacementSerialNumber(null);
			tradeIn.setFirstUsedDate(tradeInDto.getFirstUsedDate());
			tradeIn.setLastUsedDate(tradeInDto.getLastUsedDate());
			tradeIn.setTotalUsageDays(tradeInDto.getTotalUsageDays()!=0?tradeInDto.getTotalUsageDays():0);
			InventoryType inventType = new InventoryType(1L);
			tradeIn.setInventoryType(inventType);
			tradeIn.setOemWarrantyEndDate(null);
			tradeIn.setCustomerWarrantyEndDate(null);
			tradeIn.setRepairWarrantyEndDate(null);
			tradeIn.setRepairCount(0);
			tradeIn.setReturnCount(0);
			tradeIn.setCarrier("T-MOBILE");
			tradeIn.setEquipId(tradeInDto.getEquipId());
			tradeIn.setAStockReferenceSku(tradeInDto.getaStockReferenceSKU());
			tradeIn.setExternalRmaNumber(tradeInDto.getaStockReferenceSKU());
			tradeIn.setPrimarySerialIdentifier("");
			tradeIn.setMisShipIndicator(false);
			tradeIn.setSkuDescription("");
			tradeIn.setForwardChannel("");
			tradeIn.setForwardTrackingNumber("");
			tradeIn.setForwardDocumentDate(null);
			tradeIn.setForwardCarrierNumber("");
			tradeIn.setForwardSalesDocType("");
			tradeIn.setForwardProgramCode("");
			tradeIn.setForwardProgramDate(null);
			tradeIn.setForwardSalesOrderNumber("");
			tradeIn.setForwardSalesOrderitemNumber("");
			tradeIn.setForwardShippedDate(null);
			tradeIn.setForwardShippedTo("");
			tradeIn.setForwardShippedToCity("");
			tradeIn.setForwardShippedToName1("");
			tradeIn.setForwardShippedToName2("");
			tradeIn.setForwardShippedToName3("");
			tradeIn.setForwardShippedToState("");
			tradeIn.setForwardShippedToStreet1("");
			tradeIn.setForwardShippedToZipcode("");
			tradeIn.setForwardShippedToPoNumber("");
			tradeIn.setForwardTransactionType("");
			tradeIn.setForwardSoldTo("");
			tradeIn.setOemOriginalContract(tradeInDto.getOemOriginalContract());
			tradeIn.setLastBiller(tradeInDto.getLastBiller());
			tradeIn.setLiquidationFlag(false);
			tradeIn.setAuctionName(null);
		    
		}
		tradeIn=tradeInRepository.save(tradeIn);
		
		if(tradeIn.getTradeInKey() > 0) {
			
			this.addSerialNumberList(tradeInDto,tradeIn);
			
		}
		
	}
	
	
	private void addSerialNumberList(TradeInDTO tradeInDto, TradeIn tradeIn) {
		
		SerialNumberList serialNumberList = serialNumberListRepository.findByTradeInSerialNumber(tradeInDto.getSerialNumber());
		
		if(serialNumberList!=null) {
			
		}else {
			
			serialNumberList = new SerialNumberList();
			serialNumberList.setTradeIn(tradeIn);
			serialNumberList.setImeiDec("");
			serialNumberList.setMeidHex("");
			serialNumberList.setMeidDec("");
			serialNumberList.setEsnDec("");
			serialNumberList.setMacId("");
		}
		
		serialNumberList = serialNumberListRepository.save(serialNumberList);
		
		if(serialNumberList.getSerialNumberListKey() > 0) {
			
			this.addTradeInOfferDetails(tradeInDto,tradeIn);
		}
		
		
	}
	
	private void addTradeInOfferDetails(TradeInDTO tradeInDto, TradeIn tradeIn) {
		
		TradeInOfferDetails tradeInOfferDetails = tradeInOfferDetailsRepository.findByTradeInSerialNumber(tradeInDto.getSerialNumber());
		
		if(tradeInOfferDetails!=null) {
			
		}else {
			
			tradeInOfferDetails = new TradeInOfferDetails();
			tradeInOfferDetails.setTradeIn(tradeIn);
			tradeInOfferDetails.setOfferBan("");
			tradeInOfferDetails.setOfferMsisdn("");
			tradeInOfferDetails.setOfferQuotePrice(null);
			tradeInOfferDetails.setOfferStartDate(null);
			tradeInOfferDetails.setOfferExpirationDate(null);
			tradeInOfferDetails.setOfferRmaExpirationDate(null);
			tradeInOfferDetails.setOfferUpdatedDate(null);
			tradeInOfferDetails.setOfferOrderId("");
			tradeInOfferDetails.setOfferLineOrderId("");
			tradeInOfferDetails.setOfferPartnerRmaNumber("");
			tradeInOfferDetails.setOfferDeviceStatus("");
			tradeInOfferDetails.setOfferStatus("");
			tradeInOfferDetails.setOfferMarketingName("");
			
		}
		tradeInOfferDetails = tradeInOfferDetailsRepository.save(tradeInOfferDetails);
		
		if(tradeInOfferDetails.getOfferQuoteKey() > 0) {
			
			this.addQuestionnaireResponse(tradeInDto,tradeInOfferDetails);
		}
		
	}
	
	private void addQuestionnaireResponse(TradeInDTO tradeInDto, TradeInOfferDetails tradeInOfferDetails) {
		
		QuestionnaireResponse questionnaireResponse = questionnaireResponseRepository.findByTradeInOfferDetailsOfferQuoteKey(tradeInOfferDetails.getOfferQuoteKey());
		
		if(questionnaireResponse!=null) {
			
		}else {
			
			questionnaireResponse = new QuestionnaireResponse();
			questionnaireResponse.setTradeInOfferDetails(tradeInOfferDetails);
			Language language = languageRepository.findByLanguageCode("en");
			questionnaireResponse.setLanguage(language.getLanguageCode());
			questionnaireResponse.setQuestionName("");
			questionnaireResponse.setQuestionPriority("");
			questionnaireResponse.setQuestionDescription("");
		}
		
		questionnaireResponseRepository.save(questionnaireResponse);
		
		if(questionnaireResponse.getResponseKey() > 0) {
			
			this.addAnswer(tradeInDto, questionnaireResponse);
		}
		
	}
	
	
	private void addAnswer(TradeInDTO tradeInDto, QuestionnaireResponse questionnaireResponse) {
		
		Answer answer = answerRepository.findByQuestionnaireResponseResponseKey(questionnaireResponse.getResponseKey());
		
		if(answer!=null) {
			
		}else {
			answer = new Answer();
			answer.setQuestionnaireResponse(questionnaireResponse);
			answer.setAnswerDescription("");
			answer.setAnswerName("");
		}
		answer = answerRepository.save(answer);
		
		if(answer.getAnswerKey() > 0) {
			tradeInDto.setTetraFileUrl(this.genTetraResponseFile(tradeInDto));
			
		}
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String genTetraResponseFile(TradeInDTO dto) {

		String returnPath = "";
		String dateTimeStamp = DateUtils.getdateTimeStampByDate(new Date());
		String fileName = fName + dateTimeStamp + extJson;
		if(dto.getFileCat().equalsIgnoreCase(catJson)) {
			 fileName = fName + dateTimeStamp + extJson;
		}else if(dto.getFileCat().equalsIgnoreCase(catXml)) {
			 fileName = fName + dateTimeStamp + extXml;
		}

		String path = deviceDir + "/" + folName;
		StringBuilder sb = new StringBuilder(path);
		File maindir = new File(sb.toString());
		if (!maindir.exists() || !maindir.isDirectory()) {
			maindir.mkdirs();
		}

		File file = null;
		if (maindir.exists()) {
			sb.append("/").append(fileName);
			file = new File(sb.toString());
			if (file.exists()) {
				file.delete();
			}
		}

		
		List<Object[]> reportList = tradeInRepository.findTetraResponseBySerialNumber(dto.getSerialNumber());
		
		switch (dto.getFileCat().toLowerCase()) {
	    case catJson:
	        this.genTetraResponseJson(reportList, file);
	        break;
	    case catXml:
	        //this.genTetraResponseXml(reportList, file);
	        break;
	    default:
	        throw new IllegalArgumentException("Unknown file category: " + dto.getFileCat());
		}

		File fileSize = new File(sb.toString());
		if (!fileSize.exists() || !fileSize.isFile()) {
		} else {
			returnPath = sb.toString();
			
			CommonUtils.saveTetraFileDetails(tetraFileHistoryRepository,
					fileName, tetraDirUrl+"/"+fileName,dto);

		}
		
		
		return tetraDirUrl;
	}
	
    public void genTetraResponseJson(List<Object[]> reportList, File file) {
    	
    	if (reportList != null && !reportList.isEmpty()) {
    	        Map<String, Object> jsonMap = new LinkedHashMap<>();
                Object[] report = reportList.get(0);  

    	        // Adding the top-level fields
    	        jsonMap.put("serialNumber", report[1]);
    	        jsonMap.put("scenario", report[2]);
                jsonMap.put("dispositionCode", report[3]);  // Manually
    	        jsonMap.put("dispositionReason", report[4]);
    	        jsonMap.put("skuID", report[5]);
    	        jsonMap.put("make", report[6]);
    	        jsonMap.put("model", report[7]);
    	        jsonMap.put("actualModel", report[8]);
    	        jsonMap.put("color", report[9]);
    	        jsonMap.put("memory", report[10]);
    	        jsonMap.put("materialStandardName", report[11]);
    	        jsonMap.put("deliveryNumber", report[12]);
    	        jsonMap.put("deliveryItemNum", report[13]);
    	        jsonMap.put("supplyingLocation", report[14]);
    	        jsonMap.put("returnAuthNumber", report[15]);
    	        jsonMap.put("returnDistributionChannel", report[16]);
    	        jsonMap.put("returnProgramCode", report[17]);
    	        jsonMap.put("returnShipmentTrackingNumber", report[18]);
    	        jsonMap.put("returnedById", report[19]);
    	        jsonMap.put("returnByLocation", report[20]);
    	        jsonMap.put("returnedByType", report[21]);
    	        jsonMap.put("originalSKU", report[22]);
    	        jsonMap.put("rmaNumber", report[23]);
    	        jsonMap.put("repairOrderNumber", report[24]);
    	        jsonMap.put("lastRepairVendor", report[25]);
    	        jsonMap.put("repairDate", report[26]);
    	        jsonMap.put("replacementSerialNumber", report[27]);
    	        jsonMap.put("firstUsedDate", report[28]);
    	        jsonMap.put("lastUsedDate", report[29]);
    	        jsonMap.put("totalUsageDays", report[30]);
    	        jsonMap.put("inventoryType", report[31]);
    	        jsonMap.put("oemWarrantyEndDate", report[32]);
    	        jsonMap.put("customerWarrantyEndDate", report[33]);
    	        jsonMap.put("repairWarrantyEndDate", report[34]);
    	        jsonMap.put("repairCount", report[35]);
    	        jsonMap.put("returnCount", report[36]);
    	        jsonMap.put("carrier", report[37]);
    	        jsonMap.put("equipId", report[38]);
    	        jsonMap.put("aStockReferenceSKU", report[39]);
    	        jsonMap.put("externalRmaNumber", report[40]);
    	        jsonMap.put("primarySerialIdentifier", report[41]);
    	        jsonMap.put("misShipIndicator", report[42]);
    	        jsonMap.put("skuDescription", report[43]);

    	        
    	        Map<String, Object> serialNumberList = new LinkedHashMap<>();
    	        serialNumberList.put("imeiDec", report[69]);
    	        serialNumberList.put("meidHex", report[70]);
    	        serialNumberList.put("meidDec", report[71]);
    	        serialNumberList.put("esnDec", report[72]);
    	        serialNumberList.put("macId", report[73]);
    	        jsonMap.put("serialNumberList", serialNumberList);

    	        jsonMap.put("forwardChannel", report[44]);
    	        jsonMap.put("forwardTrackingNumber",report[45]);
    	        jsonMap.put("forwardDocumentDate", report[46]);
    	        jsonMap.put("forwardCarrierNumber",report[47]);
    	        jsonMap.put("forwardSalesDocType", report[48]);
    	        jsonMap.put("forwardProgramCode",report[49]);
    	        jsonMap.put("forwardProgramDate",report[50]);
    	        jsonMap.put("forwardSalesOrderNumber", report[51]);
    	        jsonMap.put("forwardSalesOrderitemNumber", report[52]);
    	        jsonMap.put("forwardShippedDate",report[53]);
    	        jsonMap.put("forwardShippedto",report[54]);
    	        jsonMap.put("forwardShippedtoCity",report[55]);
    	        jsonMap.put("forwardShippedtoName1",report[56]);
    	        jsonMap.put("forwardShippedtoName2",report[57]);
    	        jsonMap.put("forwardShippedtoName3",report[58]);
    	        jsonMap.put("forwardShippedtoState",report[59]);
    	        jsonMap.put("forwardShippedtoStreet1",report[60]);
    	        jsonMap.put("forwardShippedtoZipcode",report[61]);
    	        jsonMap.put("forwardShippedtoPONumber",report[62]);
    	        jsonMap.put("forwardTransactionType",report[63]);
    	        jsonMap.put("forwardSoldTo", report[64]);
    	        jsonMap.put("oemOriginalContract", report[65]);
    	        jsonMap.put("lastBiller", report[66]);
    	        jsonMap.put("liquidationFlag", report[67]);  
    	        
    	        
    	        
    	        Map<String, Object> tradeInOfferDetails = new LinkedHashMap<>();
                tradeInOfferDetails.put("offerQuoteNumber", report[74]);
                tradeInOfferDetails.put("offerBAN", report[75]);
                tradeInOfferDetails.put("offerMSISDN", report[76]);
                tradeInOfferDetails.put("offerQuotePrice", report[77]);
                tradeInOfferDetails.put("offerStartDate", report[78]);
                tradeInOfferDetails.put("offerExpirationDate", report[79]);
                tradeInOfferDetails.put("offerRMAExpirationDate", report[80]);
                tradeInOfferDetails.put("offerCancelReasonCode", report[83]);
                tradeInOfferDetails.put("offerUpdatedDate", report[81]);

               


    	        
    	        Map<String, Object> questionResponse1  = new LinkedHashMap<>();
    	        questionResponse1.put("language", String.valueOf(report[86]));
    	        questionResponse1.put("questionName", String.valueOf(report[87]));
    	        Map<String, Object> answerMap = new LinkedHashMap<>();
    	        answerMap.put("answerName", "PO_YES");//91
    	        questionResponse1.put("answers", new Object[]{answerMap});
    	        
    	        
    	        Map<String, Object> questionResponse2 = new LinkedHashMap<>();
    	        questionResponse2.put("language", String.valueOf(report[86]));
    	        questionResponse2.put("questionName", String.valueOf(report[87]));
    	        Map<String, Object> answerMap2 = new LinkedHashMap<>();
    	        answerMap2.put("answerName", "LCD_NO");//91
    	        questionResponse2.put("answers", new Object[]{answerMap2});

    	        
    	        Map<String, Object> questionResponse3 = new LinkedHashMap<>();
    	        questionResponse3.put("language", String.valueOf(report[86]));
    	        questionResponse3.put("questionName", String.valueOf(report[87]));
                Map<String, Object> answerMap3 = new LinkedHashMap<>();
    	        answerMap3.put("answerName", "LD_NO");//91
    	        questionResponse3.put("answers", new Object[]{answerMap3});

    	        
                tradeInOfferDetails.put("offerQuestionnaireResponse", new Object[]{questionResponse1, questionResponse2, questionResponse3});
                
               
                jsonMap.put("tradeInOfferDetails", tradeInOfferDetails);
                jsonMap.put("auctionName", report[68]);
                
    	        
    	        ObjectMapper objectMapper = new ObjectMapper();
    	        objectMapper.registerModule(new JavaTimeModule());
    	        try {
					objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(file.toString()), jsonMap);
				} catch (StreamWriteException e) {
					throw new RuntimeException("Unable to create file", e);
				} catch (DatabindException e) {
					throw new RuntimeException("Unable to create file", e);
				} catch (IOException e) {
					throw new RuntimeException("Unable to create file", e);
				}

    	}
    }

    
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param Long
	 * @return TetraConfig
	 */
    @Transactional(readOnly = true)
    public TradeInDTO getTetraResponse(TradeInDTO tradeInDTO) {
        
    	tradeInDTO = this.getTradeIn(tradeInDTO);
    	
    	return tradeInDTO;
    }
	
    
	public TradeInDTO getTradeIn(TradeInDTO tradeInDto) {
		
		TradeIn tradeIn = tradeInRepository.findBySerialNumber(tradeInDto.getSerialNumber());
		
		if(tradeIn!=null) {
			
			tradeInDto.setSerialNumber(tradeIn.getSerialNumber());
			tradeInDto.setScenario(tradeIn.getScenario());
			tradeInDto.setDispositionCode(tradeIn.getDispositionCode());
			tradeInDto.setDispositionReason(tradeIn.getDispositionReason());
			tradeInDto.setSkuID(tradeIn.getSkuId());
			tradeInDto.setMake(tradeIn.getMake());
			tradeInDto.setModel(tradeIn.getModel());
			tradeInDto.setActualModel(tradeIn.getActualModel());
			tradeInDto.setColor(tradeIn.getColor());
			tradeInDto.setMemory(tradeIn.getMemory());
			tradeInDto.setMaterialStandardName(tradeIn.getMaterialStandardName());
			tradeInDto.setDeliveryNumber(tradeIn.getDeliveryNumber());
			

			tradeInDto.setDeliveryItemNum(tradeIn.getDeliveryItemNum());
			tradeInDto.setSupplyingLocation(tradeIn.getSupplyingLocation());
			tradeInDto.setReturnAuthNumber(tradeIn.getRepairOrderNumber());
			tradeInDto.setReturnDistributionChannel(tradeIn.getDispositionCode());
			tradeInDto.setReturnProgramCode(tradeIn.getReturnProgramCode());
			tradeInDto.setReturnShipmentTrackingNumber(tradeIn.getReturnShipmentTrackingNumber());
			tradeInDto.setReturnedById(tradeIn.getReturnedById());
			tradeInDto.setReturnByLocation(tradeIn.getReturnByLocation());
			tradeInDto.setReturnedByType(tradeIn.getReturnedByType());
			tradeInDto.setOriginalSKU(tradeIn.getOriginalSku());
			tradeInDto.setRmaNumber(tradeIn.getRmaNumber());
			tradeInDto.setRepairOrderNumber(tradeIn.getRepairOrderNumber());
			tradeInDto.setLastRepairVendor(tradeIn.getLastRepairVendor());
			tradeInDto.setRepairDate(tradeIn.getRepairDate()!=null?tradeIn.getRepairDate().toString():"");
			tradeInDto.setReplacementSerialNumber(tradeIn.getReplacementSerialNumber());
			tradeInDto.setFirstUsedDate(tradeIn.getFirstUsedDate());
			tradeInDto.setLastUsedDate(tradeIn.getLastUsedDate());
			tradeInDto.setTotalUsageDays(tradeIn.getTotalUsageDays());
			//InventoryType inventType = new InventoryType(1L);
			//tradeInDto.setInventoryType(inventType);
			tradeInDto.setOemWarrantyEndDate(tradeIn.getOemWarrantyEndDate()!=null?tradeIn.getOemWarrantyEndDate().toString():"");
			tradeInDto.setCustomerWarrantyEndDate(tradeIn.getCustomerWarrantyEndDate()!=null?tradeIn.getCustomerWarrantyEndDate().toString():"");
			tradeInDto.setRepairWarrantyEndDate(tradeIn.getRepairWarrantyEndDate()!=null?tradeIn.getRepairWarrantyEndDate().toString():"");
			tradeInDto.setRepairCount(tradeIn.getRepairCount());
			tradeInDto.setReturnCount(tradeIn.getReturnCount());
			tradeInDto.setCarrier(tradeIn.getCarrier());
			tradeInDto.setEquipId(tradeIn.getEquipId());
			tradeInDto.setaStockReferenceSKU(tradeIn.getAStockReferenceSku());
			tradeInDto.setExternalRmaNumber(tradeIn.getExternalRmaNumber());
			tradeInDto.setPrimarySerialIdentifier(tradeIn.getPrimarySerialIdentifier());
			tradeInDto.setMisShipIndicator(tradeIn.getMisShipIndicator());
			tradeInDto.setSkuDescription(tradeIn.getSkuDescription());
			tradeInDto.setForwardChannel(tradeIn.getForwardChannel());
			tradeInDto.setForwardTrackingNumber(tradeIn.getForwardTrackingNumber());
			tradeInDto.setForwardDocumentDate(tradeIn.getForwardDocumentDate()!=null?tradeIn.getForwardDocumentDate().toString():"");
			tradeInDto.setForwardCarrierNumber(tradeIn.getForwardCarrierNumber());
			tradeInDto.setForwardSalesDocType(tradeIn.getForwardSalesDocType());
			tradeInDto.setForwardProgramCode(tradeIn.getForwardProgramCode());
			tradeInDto.setForwardProgramDate(tradeIn.getForwardProgramDate()!=null?tradeIn.getForwardProgramDate().toString():"");
			tradeInDto.setForwardSalesOrderNumber(tradeIn.getForwardSalesOrderNumber());
			tradeInDto.setForwardSalesOrderitemNumber(tradeIn.getForwardSalesOrderitemNumber());
			tradeInDto.setForwardShippedDate(tradeIn.getForwardShippedDate()!=null?tradeIn.getForwardShippedDate().toString():"");
			tradeInDto.setForwardShippedto(tradeIn.getForwardShippedTo());
			tradeInDto.setForwardShippedtoCity(tradeIn.getForwardShippedToCity());
			tradeInDto.setForwardShippedtoName1(tradeIn.getForwardShippedToName1());
			tradeInDto.setForwardShippedtoName2(tradeIn.getForwardShippedToName2());
			tradeInDto.setForwardShippedtoName3(tradeIn.getForwardShippedToName3());
			tradeInDto.setForwardShippedtoState(tradeIn.getForwardShippedToState());
			tradeInDto.setForwardShippedtoStreet1(tradeIn.getForwardShippedToStreet1());
			tradeInDto.setForwardShippedtoZipcode(tradeIn.getForwardShippedToZipcode());
			tradeInDto.setForwardShippedtoPONumber(tradeIn.getForwardShippedToPoNumber());
			tradeInDto.setForwardTransactionType(tradeIn.getForwardTransactionType());
			tradeInDto.setForwardSoldTo(tradeIn.getForwardSoldTo());
			tradeInDto.setOemOriginalContract(tradeIn.getOemOriginalContract());
			tradeInDto.setLastBiller(tradeIn.getLastBiller());
			tradeInDto.setLiquidationFlag(tradeIn.getLiquidationFlag());
			tradeInDto.setAuctionName(tradeIn.getAuctionName());
			this.getSerialNumberList(tradeInDto);
		}
		return tradeInDto;	
		
	}
	

	private void getSerialNumberList(TradeInDTO tradeInDto) {
		
		SerialNumberList serialNumberList = serialNumberListRepository.findByTradeInSerialNumber(tradeInDto.getSerialNumber());
		List<SerialNumberListDTO> serialNumberListDto = new ArrayList<SerialNumberListDTO>();
		SerialNumberListDTO serialNumberDTO = new SerialNumberListDTO();
		
		serialNumberDTO.setImeiDec(serialNumberList.getImeiDec());
		serialNumberDTO.setMeidHex(serialNumberList.getMeidHex());
		serialNumberDTO.setMeidDec(serialNumberList.getMeidDec());
		serialNumberDTO.setEsnDec(serialNumberList.getEsnDec());
		serialNumberDTO.setMacId(serialNumberList.getMacId());
			
		serialNumberListDto.add(serialNumberDTO);
		
		tradeInDto.setSerialNumberList(serialNumberListDto);
		
		this.getTradeInOfferDetails(tradeInDto);
		
	}
	
	private void getTradeInOfferDetails(TradeInDTO tradeInDto) {
		
		TradeInOfferDetails tradeInOfferDetails = tradeInOfferDetailsRepository.findByTradeInSerialNumber(tradeInDto.getSerialNumber());
		
		List<TradeInOfferDetailsDTO> tradeInOfferDetailsListDTO = new ArrayList<TradeInOfferDetailsDTO>();
		TradeInOfferDetailsDTO tradeInOfferDetailsDTO = new TradeInOfferDetailsDTO();
		
		tradeInOfferDetailsDTO.setOfferBAN(tradeInOfferDetails.getOfferBan());
		tradeInOfferDetailsDTO.setOfferMSISDN(tradeInOfferDetails.getOfferMsisdn());
		tradeInOfferDetailsDTO.setOfferQuotePrice(tradeInOfferDetails.getOfferQuotePrice()!=null?tradeInOfferDetails.getOfferQuotePrice().toString():"");
		tradeInOfferDetailsDTO.setOfferStartDate(tradeInOfferDetails.getOfferStartDate()!=null?tradeInOfferDetails.getOfferStartDate().toString():"");
		tradeInOfferDetailsDTO.setOfferExpirationDate(tradeInOfferDetails.getOfferExpirationDate()!=null?tradeInOfferDetails.getOfferExpirationDate().toString():"");
		tradeInOfferDetailsDTO.setOfferRMAExpirationDate(tradeInOfferDetails.getOfferRmaExpirationDate()!=null?tradeInOfferDetails.getOfferRmaExpirationDate().toString():"");
		tradeInOfferDetailsDTO.setOfferUpdatedDate(tradeInOfferDetails.getOfferUpdatedDate()!=null?tradeInOfferDetails.getOfferUpdatedDate().toString():"");
		tradeInOfferDetailsDTO.setOfferOrderId(tradeInOfferDetails.getOfferOrderId());
		tradeInOfferDetailsDTO.setOfferLineOrderId(tradeInOfferDetails.getOfferLineOrderId());
		tradeInOfferDetailsDTO.setOfferPartnerRMANumber(tradeInOfferDetails.getOfferPartnerRmaNumber());
		tradeInOfferDetailsDTO.setOfferDeviceStatus(tradeInOfferDetails.getOfferDeviceStatus());
		tradeInOfferDetailsDTO.setOfferStatus(tradeInOfferDetails.getOfferStatus());
		tradeInOfferDetailsDTO.setOfferMarketingName(tradeInOfferDetails.getOfferMarketingName());
		
		tradeInOfferDetailsDTO = this.getQuestionnaireResponse(tradeInDto, tradeInOfferDetailsDTO, tradeInOfferDetails );
		
		tradeInOfferDetailsListDTO.add(tradeInOfferDetailsDTO);
		
		tradeInDto.setTradeInOfferDetails(tradeInOfferDetailsDTO);
		
			
		
	}
	
	private TradeInOfferDetailsDTO getQuestionnaireResponse(TradeInDTO tradeInDto, TradeInOfferDetailsDTO tradeInOfferDetailsDTO, TradeInOfferDetails tradeInOfferDetails ) {
		
		QuestionnaireResponse questionnaireResponse = questionnaireResponseRepository.findByTradeInOfferDetailsOfferQuoteKey(tradeInOfferDetails.getOfferQuoteKey());
		List<OfferQuestionnaireResponseDTO> offerQuestionnaireResponse = new ArrayList<OfferQuestionnaireResponseDTO>();
		
		OfferQuestionnaireResponseDTO offerQuestionnaireResponseDTO = new OfferQuestionnaireResponseDTO();
		
	    offerQuestionnaireResponseDTO.setLanguage("en");
		offerQuestionnaireResponseDTO.setQuestionName(questionnaireResponse.getQuestionName());
		offerQuestionnaireResponseDTO.setQuestionPriority(questionnaireResponse.getQuestionPriority());
		offerQuestionnaireResponseDTO.setQuestionDescription(questionnaireResponse.getQuestionDescription());
		offerQuestionnaireResponseDTO = this.getAnswer(offerQuestionnaireResponseDTO, questionnaireResponse);
		
		offerQuestionnaireResponse.add(offerQuestionnaireResponseDTO);
		tradeInOfferDetailsDTO.setOfferQuestionnaireResponse(offerQuestionnaireResponse);
		
		return tradeInOfferDetailsDTO;
		
		
	}
	
	
	private OfferQuestionnaireResponseDTO getAnswer(OfferQuestionnaireResponseDTO offerQuestionnaireResponseDTO, QuestionnaireResponse questionnaireResponse) {
		
		Answer answer = answerRepository.findByQuestionnaireResponseResponseKey(questionnaireResponse.getResponseKey());
		List<AnswerDTO> answers = new ArrayList<AnswerDTO>();
		AnswerDTO answerDTO = new AnswerDTO();
		
		answerDTO.setAnswerDescription(answer.getAnswerDescription());
		answerDTO.setAnswerName(answer.getAnswerName());
		answerDTO.setPriority(null);
		answers.add(answerDTO);
		
		offerQuestionnaireResponseDTO.setAnswers(answers);
		
		return offerQuestionnaireResponseDTO;
		
		
	}

}
