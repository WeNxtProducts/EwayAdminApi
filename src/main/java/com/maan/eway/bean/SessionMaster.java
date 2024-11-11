/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:31 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:31 )
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
* Domain class for entity "SessionMaster"
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
@IdClass(SessionMasterId.class)
@Table(name="eway_session_master")


public class SessionMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="LOGIN_ID", nullable=false, length=100)
    private String     loginId ;

    @Id
    @Column(name="TEMP_TOKENID", nullable=false, length=200)
    private String     tempTokenid ;

    //--- ENTITY DATA FIELDS 
    @Column(name="USER_TYPE", length=50)
    private String     userType ;

    @Column(name="SUB_USER_TYPE", length=50)
    private String     subUserType ;

    @Column(name="AGENCY_CODE", length=50)
    private String     agencyCode ;

    @Column(name="TOKEN_ID", length=500)
    private String     tokenId ;

    @Column(name="USER_NAME", length=50)
    private String     userName ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LOGOUT_DATE")
    private Date       logoutDate ;

    @Column(name="STATUS", length=10)
    private String     status ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_TIME")
    private Date       startTime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_TIME")
    private Date       endTime ;

    @Column(name="CORE_APP_CODE", length=20)
    private String     coreAppCode ;

    @Column(name="AMEND_ID")
    private Integer    amendId ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}



