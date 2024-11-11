package com.maan.eway.master.req;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductMasterSaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

	@JsonProperty("ProductId")
	private String productId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;

	@JsonProperty("ProductName")
	private String productName;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("MotorYn")
	private String motorYn;

	@JsonProperty("PackageYn")
	private String packageYn;

	@JsonProperty("CurrencyIds")
	private List<String> currencyIds;
	
	
	@JsonProperty("ProductDesc")
	private String productDesc;

	@JsonProperty("RegulatoryCode")
	private String regulatoryCode;
	
	@JsonProperty("Remarks")
	private String remarks;
	
	@JsonProperty("ProductIconId")
	private String productIconId;
	
	@JsonProperty("CreatedBy")
	private String createdBy;
	
	@JsonProperty("SectionEndtYn")
	private String sectionEndtYn;
	
	
}
