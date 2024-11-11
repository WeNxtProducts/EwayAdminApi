/*
 * Java domain class for entity "InsuranceCompanyMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
package com.maan.eway.master.req;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.maan.eway.bean.BranchMaster;
import com.maan.eway.bean.DocumentMaster;
import com.maan.eway.bean.MailMaster;
import com.maan.eway.bean.ProductMaster;
import com.maan.eway.bean.RegionMaster;
import com.maan.eway.bean.SmsConfigMaster;

import lombok.Data;



/**
 * Domain class for entity "InsuranceCompanyMaster"
 *
 * @author Telosys Tools Generator
 *
 */
 
 
@Data
public class InsuranceCompanyMasterSaveReq {

	@JsonProperty("InsuranceId")
	private String insuranceId;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;

	
	@JsonProperty("CompanyName")
	private String companyName;

	@JsonProperty("CompanyAddress")
	private String companyAddress;

	@JsonProperty("CompanyEmail")
	private String companyEmail;

	@JsonProperty("CompanyPhone")
	private String companyPhone;

	@JsonProperty("CompanyLogo")
	private String companyLogo;

	@JsonProperty("Regards")
	private String regards;

	@JsonProperty("BrokerYn")
	private String brokerYn;
	
	@JsonProperty("Status")
	private String status;

	@JsonProperty("CoreAppCode")
	private String coreAppCode;
	
	@JsonProperty("RegulatoryCode")
	private String regulatoryCode;


	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("CreatedBy")
	private String createdBy;
	
	@JsonProperty("CurrencyId")
	private String currencyId;

	@JsonProperty("CountryId")
	private String countryId;
	
	@JsonProperty("VrnNumber")
	private String vrnNumber;
	
	@JsonProperty("TinNumber")
	private String tinNumber;
	
	@JsonProperty("PoBox")
	private String poBox;
	
	@JsonProperty("Character")
	private String character;
	
	@JsonProperty("NumericDigitsStart")
	private String numericdigitsStart;
	
	@JsonProperty("NumericDigitsEnd")
	private String numericdigitsEnd;
	
	@JsonProperty("Symbols")
	private String symbols;
	
	@JsonProperty("TotalLengthMin")
	private String totallengthmin;
	
	@JsonProperty("TotalLengthMax")
	private String TotalLengthMax;
	
	
	@JsonProperty("PatternStatus")
	private String patternstatus;
	

}
