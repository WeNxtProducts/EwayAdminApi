/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-05-20 ( Date ISO 2023-05-20 - Time 16:50:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-05-20 ( 16:50:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.batch.entity;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Table;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "EserviceMotorDetailsRaw"
*
* @author Telosys Tools Generator
*
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
//@IdClass(EserviceMotorDetailsRawId.class)
@Table(name="eservice_motor_details_raw")

public class EserviceMotorDetailsRaw implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ROW_NUM", nullable=false)
    private Integer    rowNum ;
    
    @Column(name="SNO", nullable=false)
    private Integer    sno ;
    
    //------------------------------------
    
    @Column(name="COMPANY_ID")
    private Integer    companyId ;

    
    @Column(name="PRODUCT_ID")
    private Integer    productId ;

    
    @Column(name="SECTION_ID")
    private Integer    sectionId ;

   
    @Column(name="TYPEID")
    private Integer    typeid ;

   
    @Column(name="REQUEST_REFERENCE_NO", nullable=true, length=200)
    private String     requestReferenceNo ;

    @Column(name="VEHICLE_ID", nullable=true)
    private Integer    vehicleId ;

    @Column(name="TIRA_SEARCH_BY_DESC", length=200)
    private String     tiraSearchByDesc ;

    @Column(name="TIRA_SEARCH_BY_ID", length=200)
    private String     tiraSearchById ;

    @Column(name="SEARCH_BY_DATA", length=200)
    private String     searchByData ;

    @Column(name="INSURANCE_TYPE_DESC", length=200)
    private String     insuranceTypeDesc ;

    @Column(name="INSURANCE_TYPE_ID", length=200)
    private String     insuranceTypeId ;

    @Column(name="INSURANCE_CLASS_DESC", length=200)
    private String     insuranceClassDesc ;

    @Column(name="INSURANCE_CLASS_ID", length=200)
    private String     insuranceClassId ;

    @Column(name="BODY_TYPE_DESC", length=200)
    private String     bodyTypeDesc ;

    @Column(name="BODY_TYPE_ID", length=200)
    private String     bodyTypeId ;

    @Column(name="MOTOR_USAGE_DESC", length=200)
    private String     motorUsageDesc ;

    @Column(name="MOTOR_USAGE_ID", length=200)
    private String     motorUsageId ;

    @Column(name="CLAIM_YN", length=20)
    private String     claimYn ;

    @Column(name="GPS_TRACKING_ENABLED", length=200)
    private String     gpsTrackingEnabled ;

    @Column(name="VEHICLE_SUMINSURED", length=200)
    private String     vehicleSuminsured ;

    @Column(name="ACCESSORIES_SUMINSURED", length=200)
    private String     accessoriesSuminsured ;

    @Column(name="WINDSHIELD_SUMINSURED", length=200)
    private String     windshieldSuminsured ;

    @Column(name="EXTENDED_SUMINSURED", length=200)
    private String     extendedSuminsured ;

    @Column(name="COLLATERAL", length=200)
    private String     collateral ;

    @Column(name="BORROWER_TYPE", length=200)
    private String     borrowerType ;

    @Column(name="FIRST_LOSS_PAYEE", length=200)
    private String     firstLossPayee ;

    @Column(name="STATUS", length=20)
    private String     status ;

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="AXEL_DISTANCE", length=200)
    private String     axelDistance ;

    @Column(name="CHASSIS_NUMBER", length=200)
    private String     chassisNumber ;

    @Column(name="COLOR", length=200)
    private String     color ;
    
    @Column(name="COLOR_ID", length=200)
    private String     colorId ;

    @Column(name="CREATED_BY", length=200)
    private String     createdBy ;

    @Column(name="ENGINE_NUMBER", length=200)
    private String     engineNumber ;

    @Column(name="FUEL_TYPE", length=200)
    private String     fuelType ;

    @Column(name="GROSS_WEIGHT", length=200)
    private String     grossWeight ;

    @Column(name="MANUFACTURE_YEAR", length=200)
    private String     manufactureYear ;

    @Column(name="MOTOR_CATEGORY", length=200)
    private String     motorCategory ;
    
    @Column(name="MOTOR_CATEGORY_ID", length=200)
    private String     motorCategoryId ;


    @Column(name="NUMBER_OF_AXELS", length=20)
    private String     numberOfAxels ;

    @Column(name="OWNER_CATEGORY", length=20)
    private String     ownerCategory ;

    @Column(name="POLICY_YN", length=20)
    private String     policyYn ;

    @Column(name="REGISTRATION_NO", length=20)
    private String     registrationNo ;

    @Column(name="REQ_CHASSIS_NO", length=200)
    private String     reqChassisNo ;

    @Column(name="REQ_COMPANY_CODE", length=200)
    private String     reqCompanyCode ;

    @Column(name="REQ_MOTOR_CATEGORY", length=200)
    private String     reqMotorCategory ;

    @Column(name="REQ_REG_NUMBER", length=200)
    private String     reqRegNumber ;

    @Column(name="RES_ENGINE_CAPACITY", length=200)
    private String     resEngineCapacity ;

    @Column(name="RES_MSG_SIGNATURE", length=500)
    private String     resMsgSignature ;

    @Column(name="RES_OWNER_NAME", length=200)
    private String     resOwnerName ;

    @Column(name="RES_STATUS_CODE", length=20)
    private String     resStatusCode ;

    @Column(name="RES_STATUS_DESC", length=200)
    private String     resStatusDesc ;

    @Column(name="SAVED_FROM", length=200)
    private String     savedFrom ;

    @Column(name="SEATING_CAPACITY", length=200)
    private String     seatingCapacity ;

    @Column(name="TARE_WEIGHT", length=200)
    private String     tareWeight ;

    @Column(name="VEHICLE_MODEL", length=200)
    private String     vehicleModel ;

    @Column(name="VEHICLE_TYPE", length=200)
    private String     vehicleType ;

    @Column(name="VEHICLE_MAKE", length=200)
    private String     vehicleMake ;

    @Column(name="DELETED_RECORDS")
    private Integer    deletedRecords ;

    @Column(name="BROKER_BRANCHCODE", length=20)
    private String     brokerBranchcode ;

    @Column(name="AC_EXECUTIVEID", length=200)
    private String     acExecutiveid ;

    @Column(name="COMMISSION_TYPE", length=200)
    private String     commissionType ;

    @Column(name="BROKER_CODE", length=200)
    private String     brokerCode ;

    @Column(name="LOGIN_ID", length=200)
    private String     loginId ;

    @Column(name="SUB_USERTYPE", length=200)
    private String     subUsertype ;

    @Column(name="APPLICATION_ID", length=200)
    private String     applicationId ;

    @Column(name="CUSTOMER_REFERENCENO", length=200)
    private String     customerReferenceno ;

    @Column(name="ENDORSEMENT_YN", length=20)
    private String     endorsementYn ;

    @Column(name="ENDORSEMENT_DATE", length=200)
    private String     endorsementDate ;

    @Column(name="ENDORSEMENT_EFFECTIVE_DATE", length=200)
    private String     endorsementEffectiveDate ;

    @Column(name="ENDORSEMENT_REMARKS", length=200)
    private String     endorsementRemarks ;

    @Column(name="ENDORSEMENT_TYPE", length=200)
    private String     endorsementType ;

    @Column(name="ENDORSEMENT_TYPE_DESC", length=200)
    private String     endorsementTypeDesc ;

    @Column(name="ENDT_CATEGORY_DESC", length=200)
    private String     endtCategoryDesc ;

    @Column(name="ENDT_COUNT", length=200)
    private String     endtCount ;

    @Column(name="ENDT_PREV_POLICYNO", length=200)
    private String     endtPrevPolicyno ;

    @Column(name="ENDT_PREV_QUOTENO", length=200)
    private String     endtPrevQuoteno ;

    @Column(name="ENDT_STATUS", length=20)
    private String     endtStatus ;

    @Column(name="IS_FINANCE_ENDT", length=20)
    private String     isFinanceEndt ;

    @Column(name="ORGINAL_POLICYNO", length=200)
    private String     orginalPolicyno ;

    @Column(name="WINDSCREEN_COVER_REQUIRED", length=200)
    private String     windscreenCoverRequired ;

    @Column(name="ACCIDENT", length=200)
    private String     accident ;

    @Column(name="PERIOD_OF_INSURANCE", length=200)
    private String     periodOfInsurance ;

    @Column(name="POLICY_START_DATE", length=200)
    private String     policyStartDate ;

    @Column(name="POLICY_END_DATE", length=200)
    private String     policyEndDate ;

    @Column(name="CURRENCY", length=200)
    private String     currency ;

    @Column(name="EXCHANGE_RATE", length=200)
    private String     exchangeRate ;

    @Column(name="HAVE_PROMOCODE", length=20)
    private String     havePromocode ;

    @Column(name="PROMOCODE", length=200)
    private String     promocode ;

    @Column(name="FLEETOWNER_YN", length=20)
    private String     fleetownerYn ;

    @Column(name="NO_OF_VEHICLES", length=200)
    private String     noOfVehicles ;

    @Column(name="NO_OF_COMPREHENSIVES", length=200)
    private String     noOfComprehensives ;

    @Column(name="CLAIM_RATIO", length=200)
    private String     claimRatio ;

    @Column(name="CITY_LIMIT", length=200)
    private String     cityLimit ;

    @Column(name="COVERNOTE_NO", length=200)
    private String     covernoteNo ;

    @Column(name="HOLD_INSURANCE_POLICY", length=200)
    private String     holdInsurancePolicy ;

    @Column(name="DRIVENBY_DESC", length=200)
    private String     drivenbyDesc ;

    @Column(name="BRANCH_CODE")
    private String       branchCode ;
    
    @Column(name="AGENCY_CODE")
    private String       agencyCode ;

    @Column(name="ID_NUMBER")
    private String       idNumber ;

    @Column(name="USER_TYPE")
    private String       userType ;

    @Column(name="ERROR_DESC")
    private String       errorDesc ;

    @Column(name="NCD_YN")
    private String       ncdYn ;
    
    @Column(name="SOURCE_TYPE")
    private String       sourceType ;

    @Column(name="CUSTOMER_CODE")
    private String       customerCode ;
    
    @Column(name="API_STATUS")
    private String       apiStatus ;

    @Column(name="TIRA_STATUS")
    private String       tiraStatus ;
    
    @Column(name="TIRA_ERROR_DESC")
    private String       tiraErrorDesc ;
    
    @Column(name="MOTOR_REQUEST")
    private String       motorRequest ;
    
    @Column(name="CALC_REQUEST")
    private String       calcRequest ;
    
    @Column(name="MOTOR_ERROR_DESC")
    private String       motorErrorDesc ;
    
    @Column(name="CALC_ERROR_DESC")
    private String       calcErrorDesc ;
    
    @Column(name="CUSTOMER_NAME")
    private String       customerName ;
    
    @Column(name="BDM_CODE")
    private String       bdmCode ;
    
    @Column(name="CAR_ALARAMYN")
    private String       carAlaramyn ;
    
    @Column(name="COLLATERAL_YN")
    private String       collateralYn ;
    
    @Column(name="COLLATERAL_BANKNAME")
    private String       collateralBankname ;
    
    @Column(name="BANK_ID")
    private String       bankId ;
    
    @Column(name="SOURCE_TYPEID")
    private String       sourceTypeId ;
    
    @Column(name="HORSE_POWER")
    private String       horsePower ;
    
    @Column(name="NO_OF_CYLINDERS")
    private String       noOfCylinders ;
    
    @Column(name="REGISTRATION_DATE")
    private String       registration_date ;
    
    @Column(name="TONNAGE")
    private String       tonnage ;
    
    @Column(name="DEDUCTIBLES_ID")
    private String       deductiblesId ;
    
    @Column(name="DEDUCTIBLES_DESC")
    private String       deductiblesDesc ;
    
    @Column(name="AGGREGATED_VALUE_ID")
    private String       aggregatedValueId ;
    
    @Column(name="AGGREGATED_VALUE_DESC")
    private String       aggregatedValueDesc ;
    
    @Column(name="NO_OF_PASSENGERS")
    private String       noOfPassengers ;
    
    @Column(name="NO_OF_CARDS")
    private String       noOfCards ;
    
    @Column(name="MUNICIPALITY_OF_TRAFFIC_DESC")
    private String       municipalityOfTrafficDesc ;
    
    @Column(name="MUNICIPALITY_OF_TRAFFIC_ID")
    private String       municipalityOfTrafficId ;
    
    @Column(name="TRANSPORTATION_OF_HYDROCARBONS")
    private String       transportationOfHydrocarbons ;
    
    @Column(name="VEHICLE_VALUE_TYPE_DESC")
    private String       vehicleValueTypeDesc ;
    
    @Column(name="VEHICLE_VALUE_TYPE_ID")
    private String       vehicleValueTypeId ;
    
    @Column(name="MARKET_VALUE")
    private String       marketValue ;
    
    @Column(name="VEHICLE_MAKEID")
    private String       vehicleMakeId ;
    
    @Column(name="VEHICLE_MODELID")
    private String       vehicleModelId ;
    
    
    
    
    
    //--- ENTITY LINKS ( RELATIONSHIP )

}



