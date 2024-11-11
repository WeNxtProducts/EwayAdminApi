/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:27 )
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

import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "RawReferenceTableDetails"
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
@Table(name="raw_reference_table_details")


public class RawReferenceTableDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="PARENT_ID", nullable=false)
    private Integer    parentId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="TABLE_ID")
    private Integer    tableId ;

    @Column(name="TABLE_NAME", length=100)
    private String     tableName ;

    @Column(name="COLUMN_ID")
    private Integer    columnId ;

    @Column(name="COLUMN_NAME", length=100)
    private String     columnName ;

    @Column(name="KEY_NAME", length=100)
    private String     keyName ;

    @Column(name="DISPLAY_NAME", length=100)
    private String     displayName ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}


