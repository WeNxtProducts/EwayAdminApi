/*
 * Java domain class for entity "EserviceBuildingsDetails" 
 * Created on 2022-09-06 ( Date ISO 2022-09-06 - Time 11:31:29 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
package com.maan.eway.res;

import java.io.Serializable;

import lombok.*;
import java.util.Date;


import java.util.Date;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Domain class for entity "EserviceBuildingsDetails"
 *
 * @author Telosys Tools Generator
 *
 */
 
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EserviceBuildingsDetailsRes implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY 
    //----------------------------------------------------------------------
	@JsonProperty("CustomerRequestReferenceNo")
    private String     requestReferenceNo ;
	@JsonProperty("CustomerId")
    private String    customerId   ;
	@JsonProperty("SectionId")
    private String    sectionId    ;
	@JsonProperty("LocationId")
    private String    locationId       ;
	@JsonProperty("InsuranceId")
    private String     companyId    ;
	@JsonProperty("BranchCode")
    private String     branchCode   ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
	@JsonProperty("BuildingAddress")
    private String     buildingAddress ;
	@JsonProperty("ConstMaterialId")
    private String    constMaterialId ;
	@JsonProperty("ConstMaterialDesc")
    private String     constMaterialDesc ;
	@JsonProperty("StoreysHeight")
    private String    storeysHeight ;
	@JsonProperty("OutbuildingConstId")
    private String    outbuildingConstId ;
	@JsonProperty("OutbuildingConstDesc")
    private String     outbuildingConstDesc ;
	@JsonProperty("BusinessPortionDetails")
    private String     businessPortionDetails ;
	@JsonProperty("AboutBuildingId")
    private String    aboutBuildingId ;
	@JsonProperty("AboutBuildingDesc")
    private String     aboutBuildingDesc ;
	@JsonProperty("YouOccupyTheBuilding")
    private String     youOccupyTheBuilding ;
	@JsonProperty("StateExtentId")
    private String    stateExtentId ;
	@JsonProperty("StateExtentDesc")
    private String     stateExtentDesc ;
	@JsonProperty("MaintanenceDesc")
    private String     maintanenceDesc ;
	@JsonProperty("StartDate")
    private Date       startDate    ;
	@JsonProperty("EndDate")
    private Date       endDate      ;
	@JsonProperty("Status")
    private String     status       ;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EntryDate")
	private Date entryDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("UpdatedDate")
	private Date updatedDate;

	@JsonProperty("CreatedBy")
	private String createdBy;

	@JsonProperty("UpdatedBy")
	private String updatedBy;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

      
	  
	  
}