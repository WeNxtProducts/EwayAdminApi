package com.maan.eway.master.res;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CompanyProductGetAllRes {

	@JsonProperty("ProductId")
	private String productId;
	
	@JsonProperty("InsuranceId")
	private String companyId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;
	
	@JsonProperty("ProductName")
	private String productName;
	
	@JsonProperty("OldProductName")
	private String oldProductName;

	@JsonProperty("PaymentYn")
	private String paymentYn;

	@JsonProperty("MotorYn")
	private String motorYn;
	
	@JsonProperty("PaymentRedirUrl")
	private String paymentRedirUrl;

	@JsonProperty("AppLoginUrl")
	private String appLoginUrl;

	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("PackageYn")
	private String packageYn;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EntryDate")
	private Date entryDate;

	@JsonProperty("ProductDesc")
	private String productDesc;

	@JsonProperty("CoreAppCode")
	private String coreAppCode;

	@JsonProperty("AmendId")
	private String amendId;

	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("ProductIconId")
	private String productIconId;
	
	@JsonProperty("ProductIconName")
	private String productIconName;
	
	@JsonProperty("SumInsuredStart")
	private String sumInsuredStart;
	
	@JsonProperty("SumInsuredEnd")
	private String sumInsuredEnd;
	
	@JsonProperty("CommissionVatYn")
	private String commissionVatYn;
	
	@JsonProperty("CheckerYn")
	private String checkerYn;
	
	@JsonProperty("MakerYn")
	private String makerYn;
	
	@JsonProperty("CustConfirmYn")
	private String custConfirmYn;
	
	@JsonProperty("CreatedBy")
	private String createdBy;
	
	@JsonProperty("RegulatoryCode")
	private String regulatoryCode;
	
	@JsonProperty("DisplayOrder")
	private String displayOrder;
}