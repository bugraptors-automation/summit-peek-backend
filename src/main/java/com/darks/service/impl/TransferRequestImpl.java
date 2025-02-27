package com.darks.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.darks.dto.FileNodesDto;
import com.darks.dto.LineSegmentDto;
import com.darks.dto.MockTransferDto;
import com.darks.dto.TradeInDTO;
import com.darks.dto.TransferRequestDto;
import com.darks.exception.NotFoundException;
import com.darks.model.Address;
import com.darks.model.HeaderSegment;
import com.darks.model.LineSegment;
import com.darks.model.SerialInfo;
import com.darks.model.TetraConfig;
import com.darks.model.TransferRequest;
import com.darks.repository.AddressRepository;
import com.darks.repository.StoFileRepository;
import com.darks.repository.HeaderSegmentRepository;
import com.darks.repository.LineSegmentRepository;
import com.darks.repository.SerialInfoRepository;
import com.darks.repository.TetraConfigRepository;
import com.darks.repository.TransferRequestRepository;
import com.darks.service.TetraService;
import com.darks.service.TransferRequestService;
import com.darks.utils.CommonUtils;
import com.darks.utils.DateUtils;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

@Service
@Transactional
public class TransferRequestImpl implements TransferRequestService {

    private static final String extJson = ".json";
    private static final String extXml = ".xml";
    private static final String catJson = "json";
    private static final String catXml = "xml";
    
    private static final String fName = "DeviceDetails_";
    private static final String folName = "device_details";
    
    @Autowired
    private TransferRequestRepository transferReqRepository;
    
    @Autowired
    private StoFileRepository stoFileRepository;
	
	@Autowired
	TetraConfigRepository tetraConfigRepository;
	
	@Autowired
	SerialInfoRepository serialInfoRepository;
	
	@Autowired
	LineSegmentRepository lineSegmentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	HeaderSegmentRepository headerSegmentRepository;
	
	@Autowired 
	TetraService tetraService;
	
	@Value("${deviceDir}")
	private String deviceDir;
	
	@Value("${deviceDirUrl}")
    private String deviceDirUrl;
	
	
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return List<FileReference>
	 */
    @Transactional(readOnly = true)
    public List<TransferRequest> findAll() {
        // DONE! loads by "Node" descending.
        return this.transferReqRepository.findAll(Sort.by(Sort.Direction.DESC, "fileNodeKey"));
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @return FileReference
	 */
    @Transactional(readOnly = true)
    public TransferRequest findById(Long id) {
        return this.transferReqRepository.findById(id).orElseThrow(NotFoundException::new);
    }

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param FileNodesDto
	 * @return FileReference
	 */
    @Transactional
    public TransferRequest create(TransferRequestDto transferRequestDto) {
    	SerialInfo savedSerialInfo= null;
    	TransferRequest savedTransferRequest = null;
    	try {	
    	String serialNumber = null;
    	 if (transferRequestDto.getLineSegment() != null && !transferRequestDto.getLineSegment().isEmpty()) {
             LineSegmentDto firstLineSegment = transferRequestDto.getLineSegment().get(0); 
             if (firstLineSegment.getSerialInfo() != null && !firstLineSegment.getSerialInfo().isEmpty()) {
                 serialNumber = firstLineSegment.getSerialInfo().get(0).getSerialNumber(); 
             }
         }

    	if (serialNumber != null) {
    	//TransferRequest transferRequest = transferReqRepository.findBySerialNumberOrderBySerialNumberDesc(serialNumber);
    	
    	//SerialInfo serialInfo = serialInfoRepository.findBySerialNumberOrderBySerialNumberDesc(serialNumber);
    		//List<TransferApiDto> transferApiDto = transferReqRepository.findTransferRequests(serialNumber);
    		List<Object[]> results = transferReqRepository.findTransferApiDtoBySerialNumber(serialNumber);

/*    		List<TransferApiDto> dtos = new ArrayList<>();
    		for (Object[] result : results) {
    		    TransferApiDto dto = new TransferApiDto(
    		        (Long) result[0],  // transferRequest
    		        (String) result[1],  // apiName
    		        (String) result[2]  // eventName
    		    );
    		    dtos.add(dto);
    		}*/
    		TransferRequest transferRequest = null;
    		if (results.size()>0) {
    			for (Object[] result : results) {
    				transferRequest = transferReqRepository.findByTransferRequestKey((Long) result[0]);
    				this.populateTransferReqFields(transferRequestDto, transferRequest);
    			}
            } else {
            	transferRequest= new TransferRequest();
            	this.populateTransferReqFields(transferRequestDto, transferRequest);
            }
    		
    		savedSerialInfo = serialInfoRepository.findBySerialNumberOrderBySerialNumberDesc(serialNumber);	
         
         if(savedSerialInfo.getSerialNumber() != null && savedSerialInfo.getSerialInfoKey() > 0) {
         	TetraConfig tetraConfig = tetraConfigRepository.findBySerialNumber(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getSerialNumber());
            this.updateTetraConfig(tetraConfig,transferRequestDto,savedSerialInfo);
         }
    	}
    	}catch (Exception e) {
    		throw new RuntimeException("Unable to create", e);
    	}
    	
    	return savedTransferRequest;
    	
    }

    
    
    private void populateTransferReqFields(TransferRequestDto transferRequestDto, TransferRequest transferRequest) {
    	
    	if(transferRequest!=null) {
    	transferRequest.setApiName(transferRequestDto.getApiName());
    	transferRequest.setEventName(transferRequestDto.getEventName());
    	transferRequest.setEventDate(transferRequestDto.getEventDate());
    	transferRequest.setTransOperation(transferRequestDto.getTransOperation());
    	transferRequest.setTransactionTypeId(transferRequestDto.getTransactionTypeId());
    	transferRequest.setTransactionRefNo(transferRequestDto.getTransactionRefNo());
    	transferRequest.setSourceSystemId(transferRequestDto.getSourceSystemId());
    	transferRequest.setCustomerId(transferRequestDto.getCustomerId());
    	}else {
    		transferRequest = new TransferRequest();
    		transferRequest.setApiName(transferRequestDto.getApiName());
        	transferRequest.setEventName(transferRequestDto.getEventName());
        	transferRequest.setEventDate(transferRequestDto.getEventDate());
        	transferRequest.setTransOperation(transferRequestDto.getTransOperation());
        	transferRequest.setTransactionTypeId(transferRequestDto.getTransactionTypeId());
        	transferRequest.setTransactionRefNo(transferRequestDto.getTransactionRefNo());
        	transferRequest.setSourceSystemId(transferRequestDto.getSourceSystemId());
        	transferRequest.setCustomerId(transferRequestDto.getCustomerId());
    	}
    	
    	transferRequest = this.transferReqRepository.save(transferRequest);
    	if(transferRequest.getTransferRequestKey() > 0) {
    		
    		HeaderSegment headerSegment = headerSegmentRepository.findByTransferRequestTransferRequestKey(transferRequest.getTransferRequestKey());
    		
    		this.populateHeaderSegFields(transferRequestDto, headerSegment,transferRequest);
    		
    		
    	}
    	
    }

    private void populateHeaderSegFields(TransferRequestDto transferRequestDto, HeaderSegment headerSegment, TransferRequest transferRequest) {
    	
    	if(headerSegment!=null) {
    	headerSegment.setOrderNumber(transferRequestDto.getHeaderSegment().getOrderNumber());
    	headerSegment.setHostOrderNumber(transferRequestDto.getHeaderSegment().getHostOrderNumber());
    	headerSegment.setTrackingNumber(transferRequestDto.getHeaderSegment().getTrackingNumber());
    	headerSegment.setSupplierNumber(transferRequestDto.getHeaderSegment().getSupplierNumber());
    	headerSegment.setExpiryDate(transferRequestDto.getHeaderSegment().getExpiryDate());
    	headerSegment.setScenario(transferRequestDto.getHeaderSegment().getScenario());
    	headerSegment.setOrderType(transferRequestDto.getHeaderSegment().getOrderType());
		headerSegment.setAction(transferRequestDto.getHeaderSegment().getAction());
    	}else {
    		headerSegment = new HeaderSegment();
    		headerSegment.setOrderNumber(transferRequestDto.getHeaderSegment().getOrderNumber());
        	headerSegment.setHostOrderNumber(transferRequestDto.getHeaderSegment().getHostOrderNumber());
        	headerSegment.setTrackingNumber(transferRequestDto.getHeaderSegment().getTrackingNumber());
        	headerSegment.setSupplierNumber(transferRequestDto.getHeaderSegment().getSupplierNumber());
        	headerSegment.setTransferRequest(transferRequest);
        	headerSegment.setExpiryDate(transferRequestDto.getHeaderSegment().getExpiryDate());
        	headerSegment.setScenario(transferRequestDto.getHeaderSegment().getScenario());
        	headerSegment.setOrderType(transferRequestDto.getHeaderSegment().getOrderType());
    		headerSegment.setAction(transferRequestDto.getHeaderSegment().getAction());
    	}
		
		headerSegment = headerSegmentRepository.save(headerSegment);
		
		if(headerSegment.getHeaderSegmentKey() > 0) {
			
			Address address = addressRepository.findByTransferRequestTransferRequestKey(transferRequest.getTransferRequestKey());
			
			this.populateAddressFields(transferRequestDto, address, headerSegment,transferRequest);
		}
    }
    
    private void populateAddressFields(TransferRequestDto transferRequestDto, Address address, HeaderSegment headerSegment, TransferRequest transferRequest) {
    	
    	if(address!=null) {
    		address.setAddressLine1(transferRequestDto.getAddress().getAddressLine1());
        	address.setAddressLine2(transferRequestDto.getAddress().getAddressLine2());
        	address.setAddressType(transferRequestDto.getAddress().getAddressType());
        	address.setAddressName(transferRequestDto.getAddress().getAddressName());
        	address.setPostalCode(transferRequestDto.getAddress().getPostalCode());
        	address.setCity(transferRequestDto.getAddress().getCity());
        	address.setCountry(transferRequestDto.getAddress().getCountry());
        	address.setState(transferRequestDto.getAddress().getState());
        	address.setEmail(transferRequestDto.getAddress().getEmail());
    	}else {
    		address = new Address();
	    	address.setAddressLine1(transferRequestDto.getAddress().getAddressLine1());
	    	address.setAddressLine2(transferRequestDto.getAddress().getAddressLine2());
	    	address.setAddressType(transferRequestDto.getAddress().getAddressType());
	    	address.setAddressName(transferRequestDto.getAddress().getAddressName());
	    	address.setPostalCode(transferRequestDto.getAddress().getPostalCode());
	    	address.setCity(transferRequestDto.getAddress().getCity());
	     	address.setCountry(transferRequestDto.getAddress().getCountry());
	    	address.setState(transferRequestDto.getAddress().getState());
	    	address.setTransferRequest(transferRequest);
	    	address.setEmail(transferRequestDto.getAddress().getEmail());
       }
		
    	address = addressRepository.save(address);
    	if(address.getAddressKey()>0) {
    		LineSegment lineSegment = lineSegmentRepository.findByTransferRequestTransferRequestKey(
    				address.getTransferRequest().getTransferRequestKey());
    		
    		  this.populateLineSegFields(transferRequestDto, lineSegment,headerSegment,transferRequest);
    	}
    }
    
    private void populateLineSegFields(TransferRequestDto transferRequestDto, LineSegment lineSegment, HeaderSegment headerSegment, TransferRequest transferRequest) {
    	
    	LineSegment lineSegmentDetails = null;
    	if(lineSegment!=null) {
        	lineSegmentDetails = lineSegmentRepository.findByTransferRequestTransferRequestKeyAndHeaderSegmentHeaderSegmentKey(
        			headerSegment.getHeaderSegmentKey(), lineSegment.getTransferRequest().getTransferRequestKey());
        	if(lineSegmentDetails!=null) {
        		lineSegmentDetails.setLineNumber(transferRequestDto.getLineSegment().get(0).getLineNumber());
        		lineSegmentDetails.setActionCode(transferRequestDto.getLineSegment().get(0).getActionCode());
        		lineSegmentDetails.setQty(transferRequestDto.getLineSegment().get(0).getQty());
        		lineSegmentDetails.setSku(transferRequestDto.getLineSegment().get(0).getSku());
        	}
    	}    	
    	else {
    		lineSegmentDetails = new LineSegment();
    		lineSegmentDetails.setLineNumber(transferRequestDto.getLineSegment().get(0).getLineNumber());
    		lineSegmentDetails.setActionCode(transferRequestDto.getLineSegment().get(0).getActionCode());
    		lineSegmentDetails.setTransferRequest(transferRequest);
    		lineSegmentDetails.setHeaderSegment(headerSegment);
    		lineSegmentDetails.setQty(transferRequestDto.getLineSegment().get(0).getQty());
    		lineSegmentDetails.setSku(transferRequestDto.getLineSegment().get(0).getSku());
    	}
		
    	lineSegment = this.lineSegmentRepository.save(lineSegmentDetails);
    	
    	if(lineSegmentDetails.getLineSegmentKey()>0) {
    		
    		this.populateSerialInfoFields(transferRequestDto, lineSegment);
    	}
    }
 
    private void populateSerialInfoFields(TransferRequestDto transferRequestDto, LineSegment lineSegment) {
		/*SerialInfo serialInfo = serialInfoRepository.findByLineSegmentLineSegmentKeyAndSerialNumberOrderBySerialNumberDesc
				(lineSegment.getLineSegmentKey(), transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getSerialNumber());*/
		SerialInfo serialInfo = serialInfoRepository.findBySerialNumberOrderBySerialNumberDesc
				(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getSerialNumber());
    	if(serialInfo!=null) {
        	serialInfo.setRmaNumber(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getRmaNumber());
        	serialInfo.setSerialNumber(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getSerialNumber());
    	}else {
    		serialInfo = new SerialInfo();
	    	serialInfo.setLineSegment(lineSegment);
	    	serialInfo.setRmaNumber(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getRmaNumber());
	    	serialInfo.setSerialNumber(transferRequestDto.getLineSegment().get(0).getSerialInfo().get(0).getSerialNumber());
    	}
		 this.serialInfoRepository.save(serialInfo);
    }
    		
    		
    private TetraConfig updateTetraConfig(TetraConfig tetraConfig, TransferRequestDto transferRequestDto, SerialInfo serialInfo) {
        if (tetraConfig != null) {
        	populateTetraFields(transferRequestDto, tetraConfig, serialInfo);
            tetraConfig.setEquipId(190198459183L);
        } else {
            tetraConfig = new TetraConfig();
            populateTetraFields(transferRequestDto, tetraConfig, serialInfo);
            tetraConfig.setEquipId(190198459183L);
        }
        return this.tetraConfigRepository.save(tetraConfig);
    }

    
    private void populateTetraFields(TransferRequestDto fileNodesDto, TetraConfig tetraConfig, SerialInfo serialInfo) {
        tetraConfig.setSerialNumber(serialInfo.getSerialNumber());
        tetraConfig.setSourceSystemId(fileNodesDto.getSourceSystemId());
    }
    
    


	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param FileNodesDto
	 * @return String
	 */   
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String genNodeFile(FileNodesDto dto) {

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

		
		List<Object[]> reportList = transferReqRepository.findTransferApiDtoBySerialNumber(dto.getSerialNumber());
		
		switch (dto.getFileCat().toLowerCase()) {
	    case catJson:
	        this.genDeviceJson(reportList, file);
	        break;
	    case catXml:
	        //this.genDeviceXml(reportList, file);
	        break;
	    default:
	        throw new IllegalArgumentException("Unknown file category: " + dto.getFileCat());
		}

		File fileSize = new File(sb.toString());
		if (!fileSize.exists() || !fileSize.isFile()) {
		} else {
			returnPath = sb.toString();
			
			CommonUtils.saveFileDetails(stoFileRepository,
					fileName, deviceDirUrl+"/"+fileName,dto);

		}
		
		
		return deviceDirUrl;
	}

	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param List<FileReference>
	 * @param File
	 * @return void
	 */
/*	public void genDeviceXml(List<TransferRequest> reportList, File file) {
		// Prepare XML document
		try {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        
        // Root element
        Element root = document.createElement("Devices");
        document.appendChild(root);
        
        
		String sourceSystemId;
		Long rtAuthNumber;
		Long prog;
		String carrier;
		
		if (!reportList.isEmpty()) {
			Integer sno = 1;
			for (TransferRequest report : reportList) {
				sno++;
				if((report.getSerialNumber()>0)) {
				
				sourceSystemId = report.getSourceSystemId().toString();
				rtAuthNumber = report.getRtAuthNo();
				prog = report.getProgram();
				carrier = report.getCarrier().toString();
					Element deviceElement = document.createElement("Device");	
					
	                Element serialNumElement = document.createElement("serialNumber");
	                serialNumElement.appendChild(document.createTextNode(String.valueOf(report.getSerialNumber())));
	                deviceElement.appendChild(serialNumElement);

	                Element srcSysIdElement = document.createElement("sourceSystemId");
	                srcSysIdElement.appendChild(document.createTextNode(sourceSystemId));
	                deviceElement.appendChild(srcSysIdElement);

	                Element rtAuthNoElement = document.createElement("rtAuthNo");
	                rtAuthNoElement.appendChild(document.createTextNode(String.valueOf(rtAuthNumber)));
	                deviceElement.appendChild(rtAuthNoElement);
	                
	                Element progElement = document.createElement("program");
	                progElement.appendChild(document.createTextNode(String.valueOf(prog)));
	                deviceElement.appendChild(progElement);
	                
	                
	                Element carrierElement = document.createElement("carrier");
	                carrierElement.appendChild(document.createTextNode(carrier));
	                deviceElement.appendChild(carrierElement);


	                root.appendChild(deviceElement);
	                
	            }
				
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer;
				try {
					transformer = transformerFactory.newTransformer();
					 DOMSource source = new DOMSource(document);
			            StreamResult result = new StreamResult(new File(file.toString()));
			            transformer.transform(source, result);
				} catch (TransformerException e) {
				}
	           
			}
		}
		} catch (ParserConfigurationException e1) {
			throw new RuntimeException("Unable to create file", e1); 
		}
	}*/
	
	/**
	 * @createdBy Er. Arundeep Randev
	 * @since Jan 2025
	 * @param List<FileReference>
	 * @param File
	 * @return void
	 */
	public void genDeviceJson1(List<Object[]> reportList, File file) {
		
		if (reportList != null && !reportList.isEmpty()) {
			
			 JSONArray jsonArray = new JSONArray();   // Create a JSONArray to hold all JSON objects
			for (Object[] report : reportList) {
		            // Create the outer JSONObject with a LinkedHashMap to preserve order
		            //JSONObject jsonRequest = new JSONObject(new LinkedHashMap<>());

		            LinkedHashMap<String, Object> jsonRequest = new LinkedHashMap<>();
		            
			        jsonRequest.put("apiName", report[1]);
			        jsonRequest.put("eventName",report[2]);
			        jsonRequest.put("eventDate", report[3]);
			        //String eventDate = formatEventDate(report[3]);
	                //jsonRequest.put("eventDate", eventDate);  // Ensure correct date formatting here
			        jsonRequest.put("transactionRefNo", report[4]);

			        //JSONObject headerSegment = new JSONObject(new LinkedHashMap<>());
			        LinkedHashMap<String, Object> headerSegment = new LinkedHashMap<>();
			        headerSegment.put("orderNumber",  report[10]);
			        headerSegment.put("hostOrderNumber",  report[11]);
			        headerSegment.put("trackingNumber",  report[12]);
			        headerSegment.put("supplierNumber",  report[13]);
			        headerSegment.put("expiryDate",  report[14]);
			        headerSegment.put("scenario",  report[15]);
			        headerSegment.put("orderType",  report[16]);
			        headerSegment.put("action",  report[17]);

			        //jsonRequest.put("headerSegment", headerSegment);
			        jsonRequest.put("headerSegment", new JSONObject(headerSegment));

			        //JSONObject address = new JSONObject(new LinkedHashMap<>());
			        LinkedHashMap<String, Object> address = new LinkedHashMap<>();
			        
			        address.put("addressLine1",  report[19]);
			        address.put("addressLine2",  report[20]);
			        address.put("addressType",  report[21]);
			        address.put("addressName",  report[22]);
			        address.put("postalCode",  report[23]);
			        address.put("city",  report[24]);
			        address.put("country", report[25]);
			        address.put("state", report[26]);
			        address.put("email", report[27]);

			        //jsonRequest.put("address", address);
			        jsonRequest.put("address", new JSONObject(address));

			        JSONArray lineSegment = new JSONArray();
			        //JSONObject lineItem = new JSONObject(new LinkedHashMap<>());
			        
			        LinkedHashMap<String, Object> lineItem = new LinkedHashMap<>();
			        lineItem.put("lineNumber", String.valueOf(report[29]));
			        lineItem.put("actionCode", String.valueOf(report[30]));
			        lineItem.put("qty", String.valueOf(report[31]));
			        lineItem.put("sku", String.valueOf(report[32]));

			        JSONArray serialInfo = new JSONArray();
			        //JSONObject serial = new JSONObject(new LinkedHashMap<>());
			        LinkedHashMap<String, Object> serial = new LinkedHashMap<>();
			        serial.put("serialNumber", report[34]);
			        serial.put("rmaNumber", report[35]);

			        //serialInfo.put(serial);
			        //lineItem.put("serialInfo", serialInfo);
			        
			        serialInfo.put(new JSONObject(serial));
	                lineItem.put("serialInfo", serialInfo);

			        //lineSegment.put(lineItem);
			        //jsonRequest.put("lineSegment", lineSegment);
	                
	                lineSegment.put(new JSONObject(lineItem));
	                jsonRequest.put("lineSegment", lineSegment);

			        jsonRequest.put("transOperation", report[5]);
			        jsonRequest.put("transactionTypeId", report[6]);
			        jsonRequest.put("sourceSystemId", report[7]);
			        jsonRequest.put("customerId", report[8]);
			        
			     // Now create the final jsonRequest and add it to the jsonArray
	               // JSONObject jsonRequestObj = new JSONObject(jsonRequest);
	                
	                //String jsonString = new JSONObject(jsonRequest).toString(); // Serialize to JSON string
	               // JSONObject jsonRequestObj = new JSONObject(jsonString);  // Parse back into JSONObject


			     // Debugging: Check the structure of each jsonRequest before adding it to jsonArray
		            //System.out.println("Generated jsonRequest with in for loop: " + jsonRequestObj.toString(4));

			        //the current jsonRequest to the jsonArray
		            //jsonArray.put(jsonRequest);
		            
		            jsonArray.put(new JSONObject(jsonRequest)); // 
	                //jsonArray.put(jsonRequestObj);
		            
		            System.out.println("Generated jsonRequest (debugging): " + new JSONObject(jsonRequest).toString(4));


			}
	           /* try (FileWriter writer = new FileWriter(file)) {
	                
	            	// writer.write(jsonRequest.toString(4));  // Pretty print with an indent factor of 4
	                System.out.println("Final jsonArray to write: " + jsonArray.toString(4));
	            	writer.write(jsonArray.toString(4));  // Pretty print with an indent factor of 4

	            } catch (IOException e) {
	            	throw new RuntimeException("Unable to create file", e); 
	            }*/
			   // Writing the jsonArray to the file after the loop
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		            // Debugging: Check the final jsonArray before writing
		            System.out.println("Final jsonArray to write after for loop: " + jsonArray.toString(4));
	
		            // Write the entire jsonArray to the file
		            writer.write(jsonArray.toString(4));  // Pretty print with an indent factor of 4
		            writer.flush(); // Ensure everything is written out
	
		        } catch (IOException e) {
		            throw new RuntimeException("Unable to create file", e);
		        }
			//}
		}
	}
	

    // Helper method to format the eventDate (with exact precision)
    private String formatEventDate(Object date) {
        if (date != null) {
            try {
                // Check if the date is a valid Date object
                if (date instanceof Date) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'");
                    return sdf.format((Date) date);
                }
                // If it's a String, try formatting it directly
                if (date instanceof String) {
                    String strDate = (String) date;
                    // If it's already in the required format, return it as is
                    if (strDate.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{9}Z")) {
                        return strDate;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "unknown_date_format";  // Return default if the date is null or invalid
    }
    

    public void genDeviceJson2(List<Object[]> reportList, File file) {
        if (reportList != null && !reportList.isEmpty()) {
            // Jackson ObjectMapper instance that handles the serialization
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS); // Ensure keys are ordered

            // Create an array node for the final JSON array
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Iterate over the reportList to generate the desired JSON structure
            for (Object[] report : reportList) {
                // Create a LinkedHashMap to maintain field order
                LinkedHashMap<String, Object> jsonRequest = new LinkedHashMap<>();

                // Add fields to the JSON request, maintaining the order
                jsonRequest.put("apiName", report[1]);
                jsonRequest.put("eventName", report[2]);
               // jsonRequest.put("eventDate", report[3]);
                jsonRequest.put("transactionRefNo", report[4]);

                // Header Segment
                LinkedHashMap<String, Object> headerSegment = new LinkedHashMap<>();
                headerSegment.put("orderNumber", report[10]);
                headerSegment.put("hostOrderNumber", report[11]);
                headerSegment.put("trackingNumber", report[12]);
                headerSegment.put("supplierNumber", report[13]);
                headerSegment.put("expiryDate", report[14]);
                headerSegment.put("scenario", report[15]);
                headerSegment.put("orderType", report[16]);
                headerSegment.put("action", report[17]);

                // Add header segment to the main JSON object
                jsonRequest.put("headerSegment", headerSegment);

                // Address Segment
                LinkedHashMap<String, Object> address = new LinkedHashMap<>();
                address.put("addressLine1", report[19]);
                address.put("addressLine2", report[20]);
                address.put("addressType", report[21]);
                address.put("addressName", report[22]);
                address.put("postalCode", report[23]);
                address.put("city", report[24]);
                address.put("country", report[25]);
                address.put("state", report[26]);
                address.put("email", report[27]);

                // Add address to the main JSON object
                jsonRequest.put("address", address);

                // Line Segment (Array of Line Items)
                ArrayNode lineSegmentArray = objectMapper.createArrayNode();
                LinkedHashMap<String, Object> lineItem = new LinkedHashMap<>();
                lineItem.put("lineNumber", String.valueOf(report[29]));
                lineItem.put("actionCode", String.valueOf(report[30]));
                lineItem.put("qty", String.valueOf(report[31]));
                lineItem.put("sku", String.valueOf(report[32]));

                // Serial Info for each line item
                ArrayNode serialInfoArray = objectMapper.createArrayNode();
                LinkedHashMap<String, Object> serialInfo = new LinkedHashMap<>();
                serialInfo.put("serialNumber", report[34]);
                serialInfo.put("rmaNumber", report[35]);
                serialInfoArray.add(objectMapper.valueToTree(serialInfo)); // Add serialInfo

                lineItem.put("serialInfo", serialInfoArray); // Add serial info to line item
                lineSegmentArray.add(objectMapper.valueToTree(lineItem)); // Add line item to line segment array

                // Add line segment to the main JSON object
                jsonRequest.put("lineSegment", lineSegmentArray);

                // Other fields (non-nested)
                jsonRequest.put("transOperation", report[5]);
                jsonRequest.put("transactionTypeId", report[6]);
                jsonRequest.put("sourceSystemId", report[7]);
                jsonRequest.put("customerId", report[8]);

                // Convert the LinkedHashMap to ObjectNode for serialization
                ObjectNode jsonNode = objectMapper.valueToTree(jsonRequest);

                // Add the node to the final JSON array
                jsonArray.add(jsonNode);
            }

            // Writing the jsonArray to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Serialize the jsonArray and write to the file with pretty print
                writer.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void genDeviceJson(List<Object[]> reportList, File file) {
    	
    	if (reportList != null && !reportList.isEmpty()) {
    	        LinkedHashMap<String, Object> jsonMap = new LinkedHashMap<>();
                Object[] report = reportList.get(0);  // Using the first (and only) report

    	        // Adding the top-level fields
    	        jsonMap.put("apiName", report[1]);
    	        jsonMap.put("eventName", report[2]);
    	        Instant eventDate = (Instant) report[3];
                String formattedEventDate = DateTimeFormatter.ISO_INSTANT.format(eventDate);
                jsonMap.put("eventDate", formattedEventDate);  // Manually
    	        jsonMap.put("transactionRefNo", report[4]);

    	        // Creating the "headerSegment" object
    	        LinkedHashMap<String, Object> headerSegment = new LinkedHashMap<>();
                headerSegment.put("orderNumber", report[10]);
                headerSegment.put("hostOrderNumber", report[11]);
                headerSegment.put("trackingNumber", report[12]);
                headerSegment.put("supplierNumber", report[13]);
                headerSegment.put("expiryDate", report[14]);
                headerSegment.put("scenario", report[15]);
                headerSegment.put("orderType", report[16]);
                headerSegment.put("action", report[17]);
    	        jsonMap.put("headerSegment", headerSegment);

    	        // Creating the "address" object
    	        LinkedHashMap<String, Object> address = new LinkedHashMap<>();
                address.put("addressLine1", report[19]);
                address.put("addressLine2", report[20]);
                address.put("addressType", report[21]);
                address.put("addressName", report[22]);
                address.put("postalCode", report[23]);
                address.put("city", report[24]);
                address.put("country", report[25]);
                address.put("state", report[26]);
                address.put("email", report[27]);

                // Add address 
                jsonMap.put("address", address);


    	        // Creating the "lineSegment" 
    	        LinkedHashMap<String, Object> lineSegment = new LinkedHashMap<>();
    	        lineSegment.put("lineNumber", String.valueOf(report[29]));
    	        lineSegment.put("actionCode", String.valueOf(report[30]));
    	        lineSegment.put("qty", String.valueOf(report[31]));
    	        lineSegment.put("sku", String.valueOf(report[32]));

    	        // Creating the "serialInfo" 
    	        LinkedHashMap<String, Object> serialInfo = new LinkedHashMap<>();
    	        serialInfo.put("serialNumber", report[34]);
                serialInfo.put("rmaNumber", report[35]);
                
    	        lineSegment.put("serialInfo", new Object[] { serialInfo });

    	        // Putting "lineSegment" 
    	        jsonMap.put("lineSegment", new Object[] { lineSegment });

    	        // Adding other fields
    	        jsonMap.put("transOperation", report[5]);
    	        jsonMap.put("transactionTypeId", report[6]);
    	        jsonMap.put("sourceSystemId", report[7]);
    	        jsonMap.put("customerId", report[8]);
    	        
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
   
    
	public void genDeviceJsonOld(List<Object[]> reportList, File file) {
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    if (reportList != null && !reportList.isEmpty()) {
	        for (Object[] report : reportList) {
	            JsonObject jsonRequest = new JsonObject();

	            jsonRequest.addProperty("apiName", (String) report[1]);
	            jsonRequest.addProperty("eventName", (String) report[2]);
	            jsonRequest.addProperty("eventDate", (String) report[3]);
	            jsonRequest.addProperty("transactionRefNo", (String) report[4]);

	            JsonObject headerSegment = new JsonObject();
	            headerSegment.addProperty("orderNumber", (String) report[10]);
	            headerSegment.addProperty("hostOrderNumber", (String) report[11]);
	            headerSegment.addProperty("trackingNumber", (String) report[12]);
	            headerSegment.addProperty("supplierNumber", (String) report[13]);
	            headerSegment.addProperty("expiryDate", (String) report[14]);
	            headerSegment.addProperty("scenario", (String) report[15]);
	            headerSegment.addProperty("orderType", (String) report[16]);
	            headerSegment.addProperty("action", (String) report[17]);

	            jsonRequest.add("headerSegment", headerSegment);

	            JsonObject address = new JsonObject();
	            address.addProperty("addressLine1", (String) report[19]);
	            address.addProperty("addressLine2", (String) report[20]);
	            address.addProperty("addressType", (String) report[21]);
	            address.addProperty("addressName", (String) report[22]);
	            address.addProperty("postalCode", (String) report[23]);
	            address.addProperty("city", (String) report[24]);
	            address.addProperty("country", (String) report[25]);
	            address.addProperty("state", (String) report[26]);
	            address.addProperty("email", (String) report[27]);

	            jsonRequest.add("address", address);

	            JsonArray lineSegment = new JsonArray();
	            JsonObject lineItem = new JsonObject();
	            lineItem.addProperty("lineNumber", (String) report[29]);
	            lineItem.addProperty("actionCode", (String) report[30]);
	            lineItem.addProperty("qty", (String) report[31]);
	            lineItem.addProperty("sku", (String) report[32]);

	            JsonArray serialInfo = new JsonArray();
	            JsonObject serial = new JsonObject();
	            serial.addProperty("serialNumber", (String) report[34]);
	            serial.addProperty("rmaNumber", (String) report[35]);

	            serialInfo.add(serial);
	            lineItem.add("serialInfo", serialInfo);

	            lineSegment.add(lineItem);
	            jsonRequest.add("lineSegment", lineSegment);

	            jsonRequest.addProperty("transOperation", (String) report[5]);
	            jsonRequest.addProperty("transactionTypeId", (String) report[6]);
	            jsonRequest.addProperty("sourceSystemId", (String) report[7]);
	            jsonRequest.addProperty("customerId", (String) report[8]);

	            try (FileWriter writer = new FileWriter(file)) {
	                gson.toJson(jsonRequest, writer);
	            } catch (IOException e) {
	                throw new RuntimeException("Unable to create file", e);
	            }
	        }
	    }
	}


	public List<Object[]> getTransferApiSto(String serialNumber) {
        return transferReqRepository.findTransferApiDtoBySerialNumber(serialNumber);
    }

	@Override
	public FileNodesDto mockTransferUpload(MultipartFile mockTransferFile) {
		FileNodesDto fileNodesDto = new FileNodesDto();
        try {
        	if (mockTransferFile != null && mockTransferFile.getBytes().length > 0) {
        		String docName = mockTransferFile.getOriginalFilename();
        	}
            
        	InputStream file = mockTransferFile.getInputStream();
        	Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); 
            
            Iterator<Row> rowIterator = sheet.iterator();
            
            
            rowIterator.next();
            
            List<MockTransferDto> processedNodes = new ArrayList<>();
            
            //New code 
            int processedCount = 0;
            int errorCount = 0;
           // new end
            
            // Initialize rowIndex to track the current row
            int rowIndex = 1;  // Start at 1 (because 0 is the header row)
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (!rowIterator.hasNext()) {
                    break; 
                }
               
                boolean isRowEmpty = true;
                
                for (Cell cell : row) {
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        isRowEmpty = false;
                        break;
                    }
                }

                if (isRowEmpty) {
                    break;  
                }
                
                MockTransferDto returnMockTransfer = (new MockTransferDto(row));
                //MockTransferDto returnMockTransfer = (new MockTransferDto(row, workbook, sheet,rowIndex));
                
        		List<Object[]> results = transferReqRepository.findTransferApiDtoBySerialNumber(returnMockTransfer.getSerialNumber());

        		TransferRequest transferRequest = null;
                boolean hasError = false;//New Code 25022025
                String errorMessage = null;  // New Code 25022025
                
        		if (results.size()>0) {
        			for (Object[] result : results) {
        				transferRequest = transferReqRepository.findByTransferRequestKey((Long) result[0]);
        				this.transferTransferReqFields(returnMockTransfer, transferRequest);
        			}
                } else {
                	transferRequest= null;
                	this.transferTransferReqFields(returnMockTransfer, transferRequest);
                }                       
                
                // Here you check if there are any errors in the row.
                // For example, check if the transferRequest is null, which would be an error.
                if (transferRequest == null) {
                    hasError = true;
                    errorCount++;

                    // Set the error message for the row
                    errorMessage = "Error: Failed to insert record into the database";

                    // Color the row red to indicate an error
                    for (Cell cell : row) {
                        if (cell != null) {
                            CellStyle style = workbook.createCellStyle();
                            style.setFillForegroundColor(IndexedColors.RED.getIndex());
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            cell.setCellStyle(style);
                        }
                    }
                }
                
                // Check for data type errors (string, number, date, etc.)
                for (Cell cell : row) {
                    // For example, if column 1 expects a string and the cell type is not string
                    if (cell.getColumnIndex() == 0 && cell.getCellType() != CellType.STRING) { // Assume column 0 should be a string
                        hasError = true;
                        errorCount++;
                        errorMessage = "Error: Expected string value but got " + cell.getCellType().name();
                        break;
                    }
                    // Check if column 2 expects a number (e.g., column 1)
                    if (cell.getColumnIndex() == 1 && cell.getCellType() != CellType.NUMERIC) { // Assume column 1 should be numeric
                        hasError = true;
                        errorCount++;
                        errorMessage = "Error: Expected numeric value but got " + cell.getCellType().name();
                        break;
                    }
                    // Check if column 3 expects a date (e.g., column 2)
                    if (cell.getColumnIndex() == 2 && cell.getCellType() != CellType.NUMERIC) { // Assume column 2 should be a date
                        hasError = true;
                        errorCount++;
                        errorMessage = "Error: Expected date value but got " + cell.getCellType().name();
                        break;
                    }
                    
                    // Check if column 3 expects a date (e.g., column 2)
                    if (cell.getColumnIndex() == 3 && cell.getCellType() != CellType.STRING) { // Assume column 2 should be a date
                        hasError = true;
                        errorCount++;
                        errorMessage = "Error: Expected date value but got " + cell.getCellType().name();
                        break;
                    }
                    
                    // Check if column 3 expects a date (e.g., column 2)
                    if (cell.getColumnIndex() == 4 && cell.getCellType() != CellType.NUMERIC) { // Assume column 2 should be a date
                        hasError = true;
                        errorCount++;
                        errorMessage = "Error: Expected date value but got " + cell.getCellType().name();
                        break;
                    }
                }

        		// processedNodes.add(returnMockTransfer);
             // If there was an error, add the error message to the row in the "Error Message" column (last column)
                // If there was an error, add the error message to the row in the "Error Message" column (last column)
                if (hasError) {
                    // Create a new cell for the error message if it doesn't exist
                    Cell errorCell = row.createCell(row.getLastCellNum() != -1 ? row.getLastCellNum() : row.getPhysicalNumberOfCells());
                    errorCell.setCellValue(errorMessage);  // Set the error message

                    // Mark the row red
                    for (Cell cell : row) {
                        if (cell != null) {
                            CellStyle style = workbook.createCellStyle();
                            style.setFillForegroundColor(IndexedColors.RED.getIndex());
                            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            cell.setCellStyle(style);
                        }
                    }
                }
                
                
                // If no error, process the row
                if (!hasError) {
                    processedNodes.add(returnMockTransfer);
                    processedCount++;
                }
                
                rowIndex++;
            }
            
            fileNodesDto.setNodes(processedNodes);
            fileNodesDto.setMessage("Data inserted successfully!");
            fileNodesDto.setProcessedCount(processedCount); // Set the count of processed records
            fileNodesDto.setErrorCount(errorCount); // Set the count of records with errors
            
            // After processing, write the changes to the output file
            File outputFile = new File("processed_" + mockTransferFile.getOriginalFilename());
            FileOutputStream fileOut = new FileOutputStream(outputFile);
            workbook.write(fileOut);
            
            String path = deviceDir + "/" + folName;
    		StringBuilder sb = new StringBuilder(path);
    		File maindir = new File(sb.toString());
    		if (!maindir.exists() || !maindir.isDirectory()) {
    			maindir.mkdirs();
    		}

    		File file1 = null;
    		if (maindir.exists()) {
    			sb.append("/").append(fileOut);
    			file1 = new File(sb.toString());
    			if (file1.exists()) {
    				file1.delete();
    			}
    		}
            fileOut.close();
            
            workbook.close();
            
        } 
        catch (IOException e) {
        	fileNodesDto.setMessage("Error occurred during file processing!");
        }
        return fileNodesDto;
	}
	
	
	
    private void transferTransferReqFields(MockTransferDto mockTransferDto, TransferRequest transferRequest) {
    	
    	if(transferRequest!=null) {
    		transferRequest.setEventDate(ZonedDateTime.now(ZoneId.of("UTC")));
    		transferRequest.setTransOperation(mockTransferDto.getAction());

    	}else {
    		transferRequest = new TransferRequest();
    		transferRequest.setApiName("transfer");
        	transferRequest.setEventName("RMA");
        	transferRequest.setEventDate(ZonedDateTime.now(ZoneId.of("UTC")));
        	transferRequest.setTransOperation(mockTransferDto.getAction());
        	transferRequest.setTransactionTypeId("RMA");
        	transferRequest.setTransactionRefNo(mockTransferDto.getTransactionRefNo());
        	transferRequest.setSourceSystemId("TMO");
        	transferRequest.setCustomerId("1100099");
    	}
    	
    	transferRequest = this.transferReqRepository.save(transferRequest);
    	if(transferRequest.getTransferRequestKey() > 0) {
    		
    		this.transferHeaderSegFields(mockTransferDto, transferRequest);
    		
    		
    	}
    	
    }
    
    private void transferHeaderSegFields(MockTransferDto mockTransferDto, TransferRequest transferRequest) {
		HeaderSegment headerSegment = headerSegmentRepository.findByTransferRequestTransferRequestKey(transferRequest.getTransferRequestKey());
    	if(headerSegment!=null) {
    	headerSegment.setExpiryDate(mockTransferDto.getExpiryDate());
    	headerSegment.setOrderType(mockTransferDto.getOrderType());
		headerSegment.setAction(mockTransferDto.getAction());
    	}else {
    		headerSegment = new HeaderSegment();
    		headerSegment.setOrderNumber(mockTransferDto.getOrderNumber());
        	headerSegment.setHostOrderNumber(mockTransferDto.getOrderNumber());
        	headerSegment.setTrackingNumber(mockTransferDto.getTrackingNumber());
        	headerSegment.setSupplierNumber("9925");
        	headerSegment.setTransferRequest(transferRequest);
        	headerSegment.setExpiryDate(mockTransferDto.getExpiryDate());
        	headerSegment.setScenario(mockTransferDto.getScenario());
        	headerSegment.setOrderType(mockTransferDto.getOrderType());
    		headerSegment.setAction(mockTransferDto.getAction());
    	}
		
		headerSegment = headerSegmentRepository.save(headerSegment);
		
		if(headerSegment.getHeaderSegmentKey() > 0) {
			
			this.transferAddressFields(mockTransferDto, headerSegment, transferRequest);
		}
    }
    
    private void transferAddressFields(MockTransferDto mockTransferDto, HeaderSegment headerSegment, TransferRequest transferRequest) {
    	
		Address address = addressRepository.findByTransferRequestTransferRequestKey(transferRequest.getTransferRequestKey());

    	if(address!=null) {
        	address.setAddressLine2("");
    	}else {
    		address = new Address();
	    	address.setAddressLine1("5135 W ALABAMA ST STE 6010");
	    	address.setAddressLine2("");
	    	address.setAddressType("MALL IN-LINE");
	    	address.setAddressName("TM -  Houston Galleria");
	    	address.setPostalCode("77056-5827");
	    	address.setCity("HOUSTON");
	     	address.setCountry("US");
	    	address.setState("TX");
	    	address.setTransferRequest(transferRequest);
	    	address.setEmail("RetailStore9925@T-Mobile.com");
       }
		
    	address = addressRepository.save(address);
    	if(address.getAddressKey()>0) {
    		
    		  this.transferLineSegFields(mockTransferDto,headerSegment,transferRequest);
    	}
    }
    
    private void transferLineSegFields(MockTransferDto mockTransferDto, HeaderSegment headerSegment, TransferRequest transferRequest) {
    	
    	LineSegment lineSegmentDetails = lineSegmentRepository.findByTransferRequestTransferRequestKeyAndHeaderSegmentHeaderSegmentKey(
    			headerSegment.getHeaderSegmentKey(), transferRequest.getTransferRequestKey());
    	
    	if(lineSegmentDetails!=null) {
        	lineSegmentDetails.setLineNumber("");
        	lineSegmentDetails.setActionCode(mockTransferDto.getAction());
    	}    	
    	else {
    		lineSegmentDetails = new LineSegment();
    		lineSegmentDetails.setLineNumber("");
    		lineSegmentDetails.setActionCode(mockTransferDto.getAction());
    		lineSegmentDetails.setTransferRequest(transferRequest);
    		lineSegmentDetails.setHeaderSegment(headerSegment);
    		lineSegmentDetails.setQty(1);
    		lineSegmentDetails.setSku(mockTransferDto.getTmoSku());
    	}
		
    	lineSegmentDetails = this.lineSegmentRepository.save(lineSegmentDetails);
    	
    	if(lineSegmentDetails.getLineSegmentKey()>0) {
    		
    		this.transferSerialInfoFields(mockTransferDto, lineSegmentDetails);
    	}
    }
 
    private void transferSerialInfoFields(MockTransferDto mockTransferDto, LineSegment lineSegment) {
		SerialInfo serialInfo = serialInfoRepository.findBySerialNumberOrderBySerialNumberDesc
				(mockTransferDto.getSerialNumber());
    	if(serialInfo!=null) {
        	serialInfo.setRmaNumber(mockTransferDto.getRmaNumber());
    	}else {
    		serialInfo = new SerialInfo();
	    	serialInfo.setLineSegment(lineSegment);
	    	serialInfo.setRmaNumber(mockTransferDto.getRmaNumber());
	    	serialInfo.setSerialNumber(mockTransferDto.getSerialNumber());
    	}
		 this.serialInfoRepository.save(serialInfo);
		 
		 if(serialInfo.getSerialInfoKey() >0) {
			 FileNodesDto dto = new FileNodesDto();
			 dto.setFileCat("json");
			 dto.setSerialNumber(serialInfo.getSerialNumber());
			 
			 mockTransferDto.setStoFileUrl(genNodeFile(dto));
			 dto.setStoFile(mockTransferDto.getStoFileUrl());
			 dto.setSerialNumber(serialInfo.getSerialNumber());
			 
			 mockTransferDto.setFileCat("json");
			 
			 this.generateTetraResponse(mockTransferDto,serialInfo);
		 }
    }
    
    
    private void generateTetraResponse(MockTransferDto mockTransferDto, SerialInfo serialInfo) {

    	TradeInDTO returnMockTransfer = (new TradeInDTO(mockTransferDto));
    	tetraService.addTradeIn(returnMockTransfer);
    }
    
	
}