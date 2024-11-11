package com.maan.eway.master.req;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CompanyPromocodeMasterGetAllReq implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("InsuranceId")
    private String insuranceId;
    
    @JsonProperty("ProductId")
    private String productId;
    
    @JsonProperty("SectionId")
    private String sectionId;
    
	@JsonProperty("AgencyCode")
	private String agencyCode;
	
	@JsonProperty("BranchCode")
	private String branchCode;
  
    @JsonFormat(pattern ="dd/MM/yyyy")
    @JsonProperty("EffectiveDateStart")
    private Date effectiveDateStart;

}
