package com.maan.eway.master.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SectionListReq {

	@JsonProperty("SectionId")
	private String sectionId ;
	
	@JsonProperty("SectionName")
	private String sectionName ;
	
}