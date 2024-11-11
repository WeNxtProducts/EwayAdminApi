package com.maan.eway.master.req;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LmProductTypeDropDownReq implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("PtType")
	private String PT_TYPE;
}
