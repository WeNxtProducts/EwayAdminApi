/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:19:56 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:19:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "ConstantTableDetails"
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
@IdClass(ConstantTableDetailsId.class)
@Table(name="constant_table_details")


public class ConstantTableDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ITEM_ID", nullable=false)
    private Integer    itemId ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;

    @Id
    @Column(name="BRANCH_CODE", nullable=false, length=20)
    private String     branchCode ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Column(name="AMEND_ID", nullable=false)
    private Integer    amendId ;

    //--- ENTITY DATA FIELDS 
//    @Column(name="TABLE_NAME", length=100)
//    private String     tableName ;

    @Column(name="TABLE_TYPE", length=100)
    private String     tableType ;

    @Column(name="API_URL", length=200)
    private String     apiUrl ;

    @Column(name="API_NAME", length=200)
    private String     apiName ;

    @Column(name="KEY_NAME", length=100)
    private String     keyName ;

    @Column(name="KEY_TABLE", length=200)
    private String     keyTable ;

    @Column(name="REQUEST_YN", length=2)
    private String     requestYn ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    @Column(name="STATUS", length=2)
    private String     status ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;

    //--- ENTITY LINKS ( RELATIONSHIP )


}



