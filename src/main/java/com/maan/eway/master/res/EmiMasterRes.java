package com.maan.eway.master.res;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmiMasterRes implements Serializable {

    private static final long serialVersionUID = 1L;


	@JsonProperty("EmiId")
	private String emiId;

	@JsonProperty("ProductId")
	private String productId;

	@JsonProperty("CompanyId")
	private String companyId;

	@JsonProperty("PremiumStart")
	private String premiumStart;

	@JsonProperty("PremiumEnd")
	private String premiumEnd;

	@JsonProperty("InstallmentPeriod")
	private String installmentPeriod;

	@JsonProperty("PolicyType")
	private String policyType;
	
	@JsonProperty("PolicyTypeDesc")
	private String policyDesc;
	

	@JsonProperty("InterestPercent")
    private String     interestPercent ;
    
    @JsonProperty("AdvancePercent")
    private String     advancePercent ;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;
	
	@JsonProperty("Status")
	private String status;

	@JsonProperty("Remarks")
	private String remarks;

	@JsonProperty("CreatedBy")
	private String createdBy;

	@JsonProperty("UpdatedBy")
	private String updatedBy;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("UpdatedDate")
	private Date updatedDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EntryDate")
	private Date entryDate;

	@JsonProperty("AmendId")
	private String amendId;



}