package com.maan.eway.common.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsageDropDownReq {

	@JsonProperty("SectionId")
	private String sectionId ;
}
