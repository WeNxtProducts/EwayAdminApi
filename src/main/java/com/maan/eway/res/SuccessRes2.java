package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SuccessRes2 {

	@JsonProperty("Response")
	private String response;

	@JsonProperty("SuccessId")
	private String successId;
}
