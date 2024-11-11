/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:29 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:29 )
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
* Domain class for entity "SectionCoverMaster"
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
@IdClass(CompanyPromocodeMasterId.class)
@Table(name="company_promocode_master")


public class CompanyPromocodeMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="PROMOCODE_ID", nullable=false)
    private Integer    promocodeId ;

    @Id
    @Column(name="SECTION_ID", nullable=false)
    private Integer    sectionId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="AGENCY_CODE", nullable=false,length=20)
    private String    agencyCode ;

    @Id
    @Column(name="AMEND_ID", nullable=false)
    private Integer    amendId ;
    
    @Id
    @Column(name="BRANCH_CODE", nullable=false,length=20)
    private String    branchCode;

    //--- ENTITY DATA FIELDS 
    @Column(name="PROMOCODE", length=100)
    private String     promocode ;
    
    @Column(name="PROMOCODE_DESC", length=500)
    private String     promocodeDesc ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    @Column(name="CORE_APP_CODE",  length=20)
    private String     coreAppCode ;

    @Column(name="PROMOCODE_TYPE", length=1)
    private String     promocodeType ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="PROMOCODE_TYPE_DESC", length=100)
    private String     promocodeTypeDesc ;

    @Column(name="TOOL_TIP", length=500)
    private String     toolTip ;

    @Column(name="CALC_TYPE", length=1)
    private String     calcType ;

    @Column(name="CALC_TYPE_DESC", length=100)
    private String     calcTypeDesc ;

    @Column(name="PROMO_RATE_OR_AMT")
    private Double     promoRateOrAmt ;

    @Column(name="MIN_PREMIUM")
    private Double     minPremium ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="FACTOR_TYPE_ID")
    private Integer    factorTypeId ;

    @Column(name="IS_TAX_EXCEMPTED", length=1)
    private String     isTaxExcempted ;

    @Column(name="REGULATORY_CODE", nullable=false, length=20)
    private String     regulatoryCode ;

    @Column(name="TAX_EXCEMPTION_REFERENCE", length=100)
    private String     taxExcemptionReference ;

    @Column(name="TAX_EXCEMPTION_TYPE", length=1)
    private String     taxExcemptionType ;

    @Column(name="TAX_EXCEMPTION_TYPE_DESC", length=100)
    private String     taxExcemptionTypeDesc ;

    @Column(name="DEPENDENT_COVER_YN", length=2)
    private String     dependentCoverYn ;

    @Column(name="DEPENDENT_COVER_ID", length=20)
    private String    dependentCoverId ;

    @Column(name="IS_SELECTED_YN", length=20)
    private String     isSelectedYn ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="COVER_BASED_ON")
    private String       coverBasedOn;
    
    @Column(name="MULTI_SELECT_YN")
    private String       multiSelectYn;
    
    @Column(name="DISCOUNT_COVER_ID")
    private Integer    discountCoverId ;
    
    @Column(name="COVER_ID")
    private Integer    coverId ;

}
