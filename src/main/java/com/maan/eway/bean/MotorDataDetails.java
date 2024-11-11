/* 
\*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:15 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:15 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "MotorDataDetails"
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
@IdClass(MotorDataDetailsId.class)
@Table(name="motor_data_details")


public class MotorDataDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="QUOTE_NO", nullable=false, length=20)
    private String     quoteNo ;

    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;

    @Id
    @Column(name="VEHICLE_ID", nullable=false, length=20)
    private String     vehicleId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Column(name="POLICY_NO", length=100)
    private String     policyNo;

    
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Column(name="BRANCH_CODE", nullable=false, length=20)
    private String     branchCode ;

    @Column(name="CUSTOMER_ID", nullable=false, length=20)
    private String     customerId ;

    @Column(name="VD_REFNO", nullable=false, length=20)
    private String     vdRefno ;

    @Column(name="CD_REFNO", nullable=false, length=20)
    private String     cdRefno ;

    @Column(name="MS_REFNO", nullable=false, length=20)
    private String     msRefno ;

    @Column(name="ID_NUMBER", nullable=false, length=20)
    private String     idNumber ;

    @Column(name="ACCIDENT", length=1)
    private String     accident ;

    @Column(name="GPS_TRACKING_INSTALLED", length=1)
    private String     gpsTrackingInstalled ;

    @Column(name="WIND_SCREEN_COVER_REQUIRED", nullable=false, length=1)
    private String     windScreenCoverRequired ;

    @Column(name="INSURANCE_TYPE", nullable=false, length=10)
    private String     insuranceType ;

    @Column(name="INSURANCE_TYPE_DESC", length=100)
    private String     insuranceTypeDesc ;

    @Column(name="MOTOR_CATEGORY", length=1)
    private String     motorCategory ;

    @Column(name="MOTOR_CATEGORY_DESC", length=100)
    private String     motorCategoryDesc ;

    @Column(name="MOTOR_USAGE", length=100)
    private String     motorUsage ;

    @Column(name="REGISTRATION_NUMBER", length=20)
    private String     registrationNumber ;

    @Column(name="CHASSIS_NUMBER", length=20)
    private String     chassisNumber ;

    @Column(name="VEHICLE_MAKE", length=20)
    private String     vehicleMake ;

    @Column(name="VEHICLE_MAKE_DESC", length=100)
    private String     vehicleMakeDesc ;

    @Column(name="VEHCILE_MODEL", length=20)
    private String     vehcileModel ;

    @Column(name="VEHCILE_MODEL_DESC", length=100)
    private String     vehcileModelDesc ;

    @Column(name="VEHICLE_TYPE", length=100)
    private String     vehicleType ;

    @Column(name="VEHICLE_TYPE_DESC", length=100)
    private String     vehicleTypeDesc ;

    @Column(name="MODEL_NUMBER", length=20)
    private String     modelNumber ;

    @Column(name="ENGINE_NUMBER", length=20)
    private String     engineNumber ;

    @Column(name="FUEL_TYPE", length=20)
    private String     fuelType ;

    @Column(name="FUEL_TYPE_DESC", length=100)
    private String     fuelTypeDesc ;

    @Column(name="SEATING_CAPACITY")
    private Integer    seatingCapacity ;

    @Column(name="CUBIC_CAPACITY")
    private Double     cubicCapacity ;

    @Column(name="COLOR", length=100)
    private String     color ;

    @Column(name="COLOR_DESC", length=100)
    private String     colorDesc ;

    @Column(name="GROSS_WEIGHT")
    private Double     grossWeight ;

    @Column(name="TARE_WEIGHT")
    private Double     tareWeight ;

    @Column(name="ACTUAL_PREMIUM_FC")
    private Double     actualPremiumFc ;

    @Column(name="ACTUAL_PREMIUM_LC")
    private Double     actualPremiumLc ;
//
//    @Column(name="COVERNOTE_NO", length=20)
//    private String     covernoteNo ;
//
//    @Column(name="STICKER_NO", length=20)
//    private String     stickerNo ;

    @Column(name="OVERALL_PREMIUM_LC")
    private Double     overallPremiumLc ;

    @Column(name="OVERALL_PREMIUM_FC")
    private Double     overallPremiumFc ;

    @Column(name="PERIOD_OF_INSURANCE", length=20)
    private String     periodOfInsurance ;

    @Column(name="WIND_SCREEN_SUM_INSURED")
    private Double     windScreenSumInsured ;

    @Column(name="ACCCESSORIES_SUM_INSURED")
    private Double     acccessoriesSumInsured ;

//    @Column(name="ACCESSORIES_INFORMATION", length=200)
//    private String     accessoriesInformation ;

    @Column(name="NUMBER_OF_AXELS")
    private Integer    numberOfAxels ;

    @Column(name="AXEL_DISTANCE")
    private Double     axelDistance ;

    @Column(name="SUM_INSURED")
    private Double     sumInsured ;

//    @Column(name="OVERRIDE_PERCENTAGE")
//    private Double     overridePercentage ;

    @Column(name="TPPD_FREE_LIMIT")
    private Double     tppdFreeLimit ;

    @Column(name="TPPD_INCREAE_LIMIT")
    private Double     tppdIncreaeLimit ;
//
//    @Column(name="INSURER_SETTLEMENT")
//    private Double     insurerSettlement ;

    @Column(name="POLICY_TYPE", length=5)
    private String     policyType ;

    @Column(name="POLICY_TYPE_DESC", length=100)
    private String     policyTypeDesc ;
//
//    @Column(name="RADIOORCASSETEPLAYER")
//    private Double     radioorcasseteplayer ;

    @Column(name="ROOF_RACK")
    private Double     roofRack ;

    @Column(name="SPOT_FOG_LAMP")
    private Double     spotFogLamp ;

    @Column(name="TRAILER_DETAILS", length=200)
    private String     trailerDetails ;

    @Column(name="DRIVEN_BY", length=5)
    private String     drivenBy ;

    @Column(name="DRIVEN_BY_DESC", length=100)
    private String     drivenByDesc ;

    @Column(name="VEHICLE_INTERESTED_COMPANY", length=5)
    private String     vehicleInterestedCompany ;

    @Column(name="INTERESTED_COMPANY_DETAILS", length=200)
    private String     interestedCompanyDetails ;

    @Column(name="OTHER_VEHICLE", length=5)
    private String     otherVehicle ;

    @Column(name="OTHER_VEHICLE_DETAILS", length=200)
    private String     otherVehicleDetails ;

    @Column(name="OTHER_INSURANCE", length=5)
    private String     otherInsurance ;

    @Column(name="OTHER_INSURANCE_DETAILS", length=200)
    private String     otherInsuranceDetails ;

    @Column(name="HOLD_INSURANCE_POLICY", length=5)
    private String     holdInsurancePolicy ;

    @Column(name="NO_OF_CLAIMS")
    private Integer    noOfClaims ;

    @Column(name="ADDITIONAL_CIRCUMSTANCES", length=200)
    private String     additionalCircumstances ;

    @Column(name="ENDORSEMENT_TYPE")
    private Integer    endorsementType ;

    @Column(name="ENDORSEMENT_TYPE_DESC", length=100)
    private String     endorsementTypeDesc ;

    @Column(name="DRIVEN_BY_UNDER_AGE", length=5)
    private String     drivenByUnderAge ;

    @Column(name="DEFECTIVE_VISION_OR_HEARING", length=5)
    private String     defectiveVisionOrHearing ;

    @Column(name="MOTORING_OFFENCE", length=5)
    private String     motoringOffence ;

    @Column(name="SUSPENSION_OF_LICENSE", length=5)
    private String     suspensionOfLicense ;

    @Column(name="SPECIAL_TERMS_OF_PREMIUM", length=5)
    private String     specialTermsOfPremium ;

    @Column(name="IRRESPECTIVE_OF_BLAME", length=5)
    private String     irrespectiveOfBlame ;

    @Column(name="AGENCY_CODE", nullable=false, length=20)
    private String     agencyCode ;

    @Column(name="INSURANCE_CLASS", nullable=false, length=20)
    private String     insuranceClass ;

    @Column(name="INSURANCE_CLASS_DESC", length=100)
    private String     insuranceClassDesc ;

    @Column(name="OWNER_CATEGORY", length=20)
    private String     ownerCategory ;

    @Column(name="MANUFACTURE_AGE")
    private Integer    manufactureAge ;

    @Column(name="REGISTRATION_AGE")
    private Integer    registrationAge ;

    @Column(name="NCD_YEARS")
    private Integer    ncdYears ;

    @Column(name="NCD_YN", length=1)
    private String     ncdYn ;

    @Temporal(TemporalType.DATE)
    @Column(name="REGISTRATION_YEAR")
    private Date       registrationYear ;

    @Column(name="MANUFACTURE_YEAR")
    private Integer    manufactureYear ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="UPDATED_BY", length=100)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="POLICY_START_DATE")
    private Date       policyStartDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="POLICY_END_DATE")
    private Date       policyEndDate ;

    @Column(name="CURRENCY", length=100)
    private String     currency ;

    @Column(name="EXCHANGE_RATE")
    private Double     exchangeRate ;

    @Column(name="FLEET_OWNER_YN", length=1)
    private String     fleetOwnerYn ;

    @Column(name="NO_OF_VEHICLES")
    private Integer    noOfVehicles ;

    @Column(name="NO_OF_COMPEHENSIVES")
    private Integer    noOfCompehensives ;

    @Column(name="CLAIM_RATIO")
    private Double     claimRatio ;

    @Column(name="COLLATERAL_YN", length=1)
    private String     collateralYn ;

    @Column(name="BORROWER_TYPE", length=1)
    private String     borrowerType ;

    @Column(name="BORROWER_TYPE_DESC", length=100)
    private String     borrowerTypeDesc ;

    @Column(name="COLLATERAL_NAME", length=100)
    private String     collateralName ;

    @Column(name="FIRST_LOSS_PAYEE", length=100)
    private String     firstLossPayee ;

    @Column(name="CITY_LIMIT", length=20)
    private String     cityLimit ;

    @Column(name="AC_EXECUTIVE_ID")
    private Integer    acExecutiveId ;

    @Column(name="APPLICATION_ID", length=100)
    private String     applicationId ;

    @Column(name="BROKER_CODE", length=20)
    private String     brokerCode ;

    @Column(name="SUB_USER_TYPE", length=20)
    private String     subUserType ;

    @Column(name="LOGIN_ID", length=100)
    private String     loginId ;

    @Column(name="SAVED_FROM", length=100)
    private String     savedFrom ;


    @Column(name="BROKER_BRANCH_CODE", length=20)
    private String     brokerBranchCode ;

    @Column(name="HAVEPROMOCODE", length=10)
    private String     havepromocode ;

    @Column(name="PROMOCODE", length=100)
    private String     promocode ;


    @Column(name="BANK_CODE", length=100)
    private String   bankCode;
    
    @Column(name="ENDORSEMENT_YN", length=10)
    private String     endorsementYn ;
    
    @Column(name="TIRA_COVER_NOTE_NO")
    private String tiraCoverNoteNo;
    
    @Column(name="COMMISSION_PERCENTAGE")
    private BigDecimal commissionPercentage;
    
    @Column(name="VAT_COMMISSION")
    private BigDecimal vatCommission;
    
    @Column(name="WIND_SCREEN_SUM_INSURED_LC")
    private BigDecimal     windScreenSumInsuredLc ;

    @Column(name="SUM_INSURED_LC")
    private BigDecimal     sumInsuredLc ;
    
    @Column(name="TPPD_FREE_LIMIT_LC")
    private BigDecimal     tppdFreeLimitLc ;

    @Column(name="TPPD_INCREAE_LIMIT_LC")
    private BigDecimal     tppdIncreaeLimitLc ;
    
    @Column(name="ACCCESSORIES_SUM_INSURED_LC")
    private BigDecimal     acccessoriesSumInsuredLc ;

    @Column(name="CUSTOMER_CODE")
    private String     customerCode ;
    
    @Column(name="SOURCE_TYPE")
    private String     sourceType ;

    @Column(name="BDM_CODE")
    private String     bdmCode ;
    
    @Column(name="CUSTOMER_NAME")
    private String     customerName ;
    
    @Column(name="BRANCH_NAME")
    private String     branchName ;
    
    @Column(name="MOTOR_USAGE_DESC")
    private String     motorUsageDesc ;
    
    
    @Column(name="TIRA_BODY_TYPE")
    private String     tiraBodyType ;
    
    @Column(name="TIRA_MOTOR_USAGE")
    private String     tiraMotorUsage ;
    
    @Column(name="SALE_POINT_CODE", length=200)
    private String    salePointCode;
    
    @Column(name="BROKER_TIRA_CODE")
    private String brokerTiraCode;
    
    @Column(name="SOURCE_TYPE_ID")
    private String sourceTypeId;
    
    @Column(name="VAT_PREMIUM")
    private BigDecimal vatPremium;
    
    
    @Column(name="ENDT_VAT_PREMIUM")
    private BigDecimal endtVatPremium;

    @Column(name="VEHICLE_MAKE_ID")
    private String vehicleMakeId;
    
    @Column(name="VEHICLE_MODEL_ID")
    private String vehicleModelId ;
    
    @Column(name="FUEL_TYPE_ID")
    private String fuelTypeId;   
    
    @Column(name="OWNER_CATEGORY_ID", length=20)
    private String     ownerCategoryId ;
    
    @Column(name="OWNER_NAME", length=20)
    private String     ownerName ;
    

    @Column(name="OWN_DAMAGE", length=20)
    private String     ownDamage ;
    
    @Column(name="THEFT", length=20)
    private String     theft ;
    
    @Column(name="WINDSCREEN", length=20)
    private String     windscreen ;
    
    @Column(name="FIRE", length=20)
    private String     fire ;
    
    @Column(name="THIRD_PARTY", length=20)
    private String     thirdParty ;
    
    @Column(name="VEHICLE_CLASS", length=20)
    private String     vehicleClass ;
    
    @Column(name="CLAIM_NUM_12M_0M", length=20)
    private Integer     claimNum12m0m ;
    
    @Column(name="CLAIM_NUM_24M_12M", length=20)
    private Integer     claimNum24m12m ;
    
    @Column(name="CLAIM_NUM_36M_24M", length=20)
    private Integer     claimNum36m24m ;
    
    @Column(name="POWER_KILO_WATTS", length=20)
    private BigDecimal     powerKiloWatts ;
    
    @Column(name="POWER_WATTS", length=20)
    private BigDecimal     powerWatts ;
    

    @Column(name="VEHICLE_GROUP", length=20)
    private String     vehicleGroup ;
    
    @Column(name="CAR_ALARM_YN", length=20)
    private String     carAlarmYn ;

    @Column(name="PAYMENT_FREQUENCY", length=20)
    private Integer     paymentFrequency ;
    
    @Column(name="SERIES", length=50)
    private String     series ;
    
    @Column(name="NO_OF_CYCLINDERS", length=20)
    private Integer     nocyclinders ;
    
    @Column(name="NO_OF_CYCLINDERS_DESC", length=50)
    private String   nocyclindersdesc ; 
    
    @Column(name="PLATE_TYPE_ID", length=5)
    private String   platetypeid ; 
    
    @Column(name="PLATE_TYPE_DESC", length=50)
    private String   platetypedesc ;
    
    @Column(name="PLATE_COLOR", length=50)
    private String   platecolor ;
    
    @Column(name="NO_OF_DOORS", length=10)
    private Integer     noofdoors ;
    
    @Column(name="NO_OF_DOORS_DESC", length=10)
    private String   noofdoorsdesc ;
    
    @Column(name="ENGINE_TYPE", length=100)
    private String   enginetype ; 
    
}


