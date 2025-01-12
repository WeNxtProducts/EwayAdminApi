/*
 * Java domain class for entity "RawPersonalAccident" 
 * Created on 2022-09-06 ( Date ISO 2022-09-06 - Time 11:31:30 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
package com.maan.eway.req;

import java.io.Serializable;

import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Date;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Domain class for entity "RawPersonalAccident"
 *
 * @author Telosys Tools Generator
 *
 */
 
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EservicePersonalAccidentSaveReq {

	@JsonProperty("CustomerRequestReferenceNo")
    private String     requestReferenceNo ;
	@JsonProperty("SectionId")
    private Integer    sectionId    ;
	@JsonProperty("LocationId")
    private Integer    locationId       ;
	@JsonProperty("CustomerId")
    private Integer    customerId   ;
	@JsonProperty("InsuranceId")
    private String     companyId    ;
	@JsonProperty("BranchCode")
    private String     branchCode   ;
	@JsonProperty("AccidentDetails")
	private List<AccidentDetailsReq> accidentDetails;

      
	  
	  
}
