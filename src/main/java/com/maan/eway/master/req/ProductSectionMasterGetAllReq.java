package com.maan.eway.master.req;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductSectionMasterGetAllReq implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("ProductId")
	private String productId;

	@JsonProperty("InsuranceId")
	private String insuranceId;



	/*
	 * @JsonProperty("Limit") private String limit;
	 * 
	 * @JsonProperty("Offset") private String offset;
	 */
	  
	  @JsonFormat(pattern ="dd/MM/yyyy")
	  @JsonProperty("EffectiveDateStart")
	  private Date effectiveDateStart;
	  
	 
}