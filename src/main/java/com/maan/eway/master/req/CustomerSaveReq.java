package com.maan.eway.master.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerSaveReq {

	
	@JsonProperty("CustomerId")
    private String     customerId;
	@JsonProperty("InsuranceId")
    private String     companyId;
	@JsonProperty("BranchCode")
    private String     branchCode;
	@JsonProperty("TitleId")
    private String    titleId;
	@JsonProperty("TitleDesc")
    private String     titleDesc;
	@JsonProperty("ClientName")
    private String     clientName; 
	
/*  @JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("EntryDate")
    private Date     entryDate  ;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("UpdatedDate")
    private Date  updatedDate  ;
	@JsonProperty("UpdatedBy")
	private String updatedBy;	
    @JsonProperty("Status")
    private String     status       ;
    @JsonProperty("ClientStatusId")
    private String    clientStatusId ;
	@JsonProperty("ClientStatusDesc")
    private String     clientStatusDesc ;
    @JsonProperty("Vrngst")
    private String     vrngst       ;\	@JsonProperty("RegionId")
    private String    regionId     ;
	@JsonProperty("RegionDesc")
    private String     regionDesc   ;
    */
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("DateOfBirth")
    private Date       dateOfBirth  ;
	@JsonProperty("GstNo")
    private String    gstNo  ;
	
	@JsonProperty("CreatedBy")
	private String createdBy;
	
	
	@JsonProperty("NationalityId")
    private String    nationalityId ;
	@JsonProperty("NationalityDesc")
    private String     nationalityDesc ;
	@JsonProperty("PlaceOfBirth")
    private String     placeOfBirth ;
	@JsonProperty("GenderId")
    private String    genderId     ;
	@JsonProperty("GenderDesc")
    private String     genderDesc   ;
	@JsonProperty("OccupationId")
    private String    occupationId ;
	@JsonProperty("OccupationDesc")
    private String     occupationDesc ;
	@JsonProperty("Address1")
    private String     address1     ;
	@JsonProperty("Address2")
    private String     address2     ;
	@JsonProperty("Insurer")
    private String     insurer      ;
	@JsonProperty("CurrencyId")
    private String     currencyId     ;
	@JsonProperty("CurrencyName")
    private String     currencyName     ;
	
	@JsonProperty("ExchangeRate")
    private String     exchangeRate ;
	@JsonProperty("InsurerExchangeRate")
    private String     insurerExchangeRate ;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("ExpiryDate")
    private Date       expiryDate   ;
	@JsonProperty("NoOfDaysPolicy")
    private String     noOfDaysPolicy ;
	@JsonProperty("UniquePropertyIdentification")
    private String     uniquePropertyIdentification ;
	
/*	@JsonProperty("BusinessType")
    private String     businessType ; */
	@JsonProperty("ContactPerson")
    private String     contactPerson ;
	@JsonProperty("ContactPersonMobile")
    private String     contactPersonMobile ;
	@JsonProperty("InsuredName")
    private String     insuredName  ;
	
	@JsonProperty("BusinessTypeId")
    private String    businessTypeId ;
	@JsonProperty("BusinessTypeIdDesc")
    private String     businessTypeIdDesc ;
	@JsonProperty("CountryOfRegistrationId")
    private String    countryOfRegistrationId ;
	@JsonProperty("CountryOfRegistrationDesc")
    private String     countryOfRegistrationDesc ;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("RegistrationDate")
    private Date       registrationDate ;
	
	@JsonProperty("RegistrationNumber")
    private String     registrationNumber ;

	@JsonProperty("DistrictId")
    private String    districtId   ;
	@JsonProperty("DistrictDesc")
    private String     districtDesc ;
	@JsonProperty("Street")
    private String     street       ;
	@JsonProperty("Fax")
    private String     fax          ;
	@JsonProperty("ProfileId")
    private String    profileId    ;
	@JsonProperty("ProfileCategoryId")
    private String    profileCategoryId ;
	@JsonProperty("ProfileCategoryDesc")
    private String     profileCategoryDesc ;
	@JsonProperty("ScreeningGroupId")
    private String    screeningGroupId ;
	@JsonProperty("TelephoneNo1")
    private String     telephoneNo1 ;
	@JsonProperty("TelephoneNo2")
    private String     telephoneNo2 ;
	@JsonProperty("TelephoneNo3")
    private String     telephoneNo3 ;
	@JsonProperty("MobileNo1")
    private String     mobileNo1    ;
	@JsonProperty("MobileNo2")
    private String     mobileNo2    ;
	@JsonProperty("MobileNo3")
    private String     mobileNo3    ;
	@JsonProperty("Email1")
    private String     email1       ;
	@JsonProperty("Email2")
    private String     email2       ;
	@JsonProperty("Email3")
    private String     email3       ;
	@JsonProperty("PreferredSystemNotificationId")
    private String     preferredSystemNotificationId ;
	@JsonProperty("PreferredSystemNotification")
    private String     preferredSystemNotification ;
	
	@JsonProperty("SelectLanguageId")
    private String    selectLanguageId ;
	@JsonProperty("SelectLanguageDesc")
    private String     selectLanguageDesc ;

	@JsonProperty("FrontingBusiness")
    private String     frontingBusiness ;
	
	
	@JsonProperty("NonRenewable")
    private String     nonRenewable ;
	@JsonProperty("TinNo")
    private String     tinNo        ;
	@JsonProperty("VrnNumber")
    private String     vrnNumber    ;
	@JsonProperty("Branch")
    private String     branch       ;
	@JsonProperty("BusinessBy")
    private String     businessBy   ;
	@JsonProperty("FirstLossPayee")
    private String     firstLossPayee ;
	@JsonProperty("BorrowerType")
    private String     borrowerType ;
	@JsonProperty("VatPercentage")
    private String     vatPercentage ;
	@JsonProperty("BindToCollateral")
    private String     bindToCollateral ;
	@JsonProperty("CollateralName")
    private String     collateralName ;
	@JsonProperty("CoveringDetails")
    private String     coveringDetails ;
	@JsonProperty("DescriptionOfRisk")
    private String     descriptionOfRisk ;
	@JsonProperty("AccountNumber")
    private String     accountNumber ;

	
	@JsonProperty("IdTypeId")
    private String    idTypeId;
	@JsonProperty("IdTypeDesc")
    private String     idTypeDesc   ;
	@JsonProperty("IdNumber")
    private String    idNumber     ;
	@JsonProperty("TinPan")
    private String     tinPan       ;
	@JsonProperty("TaxExempted")
    private String     taxExempted  ;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("AppointmentDate")
    private Date       appointmentDate ;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("MandateExpiry")
    private Date       mandateExpiry ;
	
	
}
