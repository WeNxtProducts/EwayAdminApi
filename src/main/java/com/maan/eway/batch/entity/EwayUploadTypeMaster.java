/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-05-11 ( Date ISO 2023-05-11 - Time 16:44:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-05-11 ( 16:44:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.batch.entity;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




/**
* Domain class for entity "EwayUploadTypeMaster"
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
@IdClass(EwayUploadTypeMasterId.class)
@Table(name="eway_upload_type_master")


public class EwayUploadTypeMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;

    @Id
    @Column(name="TYPEID", nullable=false)
    private Integer    typeid ;
    
    @Id
    @Column(name="COMPANY_ID")
    private Integer    companyId ;

    @Id
    @Column(name="SECTION_ID")
    private Integer    sectionId ;
    
    //--- ENTITY DATA FIELDS 
  

    @Column(name="TYPENAME", length=200)
    private String     typename ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="RAW_TABLE_NAME", length=200)
    private String     rawTableName ;

    @Column(name="API_NAME", length=200)
    private String     apiName ;

    @Column(name="PRODUCT_DESC", length=200)
    private String     productDesc ;

    @Column(name="FILE_PATH", length=100)
    private String     filePath ;

    @Column(name="API_METHOD", length=100)
    private String     apiMethod ;
    
    @Column(name="RAW_TABLE_ID", length=100)
    private String     rawTableId ;
    
    @Column(name="ENTRY_DATE", length=100)
    private Date     entryDate ;
    
    @Column(name="FILE_PATHYN", length=100)
    private String   filePathYn;

    //--- ENTITY LINKS ( RELATIONSHIP )

    
}



