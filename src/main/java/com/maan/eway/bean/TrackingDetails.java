/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-03-05 ( Date ISO 2022-03-05 - Time 12:12:36 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-03-05 ( 12:12:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Table;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "TrackingDetails"
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
@IdClass(TrackingDetailsId.class)
@Table(name="EWAY_TRACKING_DETAILS")


public class TrackingDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="TRACKING_ID", nullable=false,length=100)
    private String     trackingId ;

    @Id
    @Column(name="RISK_ID", nullable=false,length=100)
    private String     riskId ;
    
    @Id
    @Column(name="COMPANY_ID", nullable=false, length=100)
    private String     companyId ;

    @Id
    @Column(name="BRANCH_CODE", length=100)
    private String     branchCode ;
    
    //--- ENTITY DATA FIELDS 
    @Column(name="REQUEST_REFERENCE_NO", length=100)
    private String     requestReferenceNo ;

    @Column(name="STATUS", length=20)
    private String     status ;

    @Column(name="STATUS_DESC", length=100)
    private String     statusDesc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="REMARKS", length=500)
    private String     remarks ;
 
    @Column(name="POLICY_NO", length=100)
    private String     policyNo ;

    @Column(name="QUOTE_NO", length=100)
    private String     quoteNo ;
    
    @Column(name="PRODUCT_ID", length=100)
    private String     productId ;
    
    @Column(name="ORIGINAL_POLICY_NO", length=100)
    private String     originalPolicyNo;


}



