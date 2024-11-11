package com.maan.eway.master.res;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StateMasterRes implements Serializable {

    private static final long serialVersionUID = 1L;


	@JsonProperty("StateId")
	private String stateId;

	@JsonProperty("StateShortCode")
	private String stateShortCode;
	
	@JsonProperty("StateName")
	private String stateName;
	
	@JsonProperty("CountryId")
	private String countryId;
	
	@JsonProperty("RegionCode")
	private String regionCode;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateStart")
	private Date effectiveDateStart;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EffectiveDateEnd")
	private Date effectiveDateEnd;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EntryDate")
	private Date entryDate;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("CreatedBy")
	private String createdBy;
	
	@JsonProperty("RegulatoryCode")
	private String regulatoryCode;

	@JsonProperty("AmendId")
	private String amendId;

	@JsonProperty("Remarks")
	private String remarks;
}