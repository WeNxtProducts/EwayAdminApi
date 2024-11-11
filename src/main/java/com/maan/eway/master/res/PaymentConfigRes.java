package com.maan.eway.master.res;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentConfigRes {

	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("Name")
	private String name;
	
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("StatusDesc")
	private String statusDesc;
	
	@JsonProperty("UserType")
	private String userType;
	
	@JsonProperty("SubUsertype")
	private String subUsertype;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;
}
