/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:13 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:13 )
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

import jakarta.persistence.*;




/**
* Domain class for entity "MailDetails"
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
@Table(name="mail_details")


public class MailDetails implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ID", nullable=false, length=100)
    private String     id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="MAIL_SUBJECT", length=100)
    private String     mailSubject ;

    @Column(name="MAIL_BODY", length=5000)
    private String     mailBody ;

    @Column(name="TYPE", length=100)
    private String     type ;

    @Column(name="SENDER", length=100)
    private String     sender ;

    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;

    @Column(name="INS_COMPANY_ID", length=100)
    private String     insCompanyId ;

    @Column(name="BRANCH_CODE", length=100)
    private String     branchCode ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}


