package com.maan.eway.common.res;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TiraPusehDetailsREs2 {

	@JsonProperty("RequestId")
    private String     requestId ;
	@JsonProperty("QuoteNo")
    private String     quoteNo  ;
	@JsonProperty("TiraTrackingId")
    private String     tiraTrackingId  ;
	@JsonProperty("ResponseId")
    private String     responseId ;
	@JsonProperty("MethodName")
    private String     methodName ;
	@JsonProperty("HitCount")
    private String     hitCount  ;
	@JsonProperty("Status")
    private String     status  ;
	@JsonProperty("AcknowledgementId")
    private String     acknowledgementId  ; //Successfull/Failed
	@JsonProperty("StatusCode")
    private String     statusCode  ;
	
	@JsonProperty("StatusDesc")
	private String statusDesc;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@JsonProperty("EntryDate")
    private Date     entryDate  ;
	

	@JsonProperty("ChassisNumber")
	private String chassisNumber;
	
	@JsonProperty("RequestFilePath")
	private String requestFilePath;
	
	@JsonProperty("ResponseFilePath")
	private String responseFilePath;
	
	
}
