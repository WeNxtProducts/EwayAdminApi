package com.maan.eway.common.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TiraPushedListDetailsRes {

	  @JsonProperty("TotalCount")
	   private Long     totalCount ;
	   
	   @JsonProperty("TiraHistory")
	   private List<TiraPusehDetailsREs2>     tiraHistory ;
}