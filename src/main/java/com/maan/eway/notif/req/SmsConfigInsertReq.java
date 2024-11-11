package com.maan.eway.notif.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SmsConfigInsertReq {

	@JsonProperty("SNo")
	private String sNo;
	
	@JsonProperty("InsuranceId")
	private String companyId;
	
	@JsonProperty("BranchCode")
	private String branchCode;
	
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("SenderId")
	private String senderId;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("SmsUserPass")
	private String smsUserPass;
	
	@JsonProperty("SmsUserName")
	private String smsUserName;
	
	@JsonProperty("SmsPartyUrl")
	private String smsPartyUrl;	
	
	@JsonProperty("SecureYn")
	private String secureYn;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;

	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;


	@JsonProperty("CoreAppCode")
	private String coreAppCode;
	
	@JsonProperty("RegulatoryCode")
	private String regulatoryCode;
	
	@JsonProperty("CreatedBy")
	private String createdBy;

}
