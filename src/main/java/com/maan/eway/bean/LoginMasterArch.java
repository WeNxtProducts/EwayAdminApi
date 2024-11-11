/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:11 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:11 )
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
* Domain class for entity "LoginMasterArch"
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
@IdClass(LoginMasterArchId.class)
@Table(name="eway_login_master_arch")


public class LoginMasterArch implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ARCH_ID", nullable=false, length=20)
    private String     archId ;

    @Id
    @Column(name="LOGIN_ID", nullable=false, length=50)
    private String     loginId ;

    @Id
    @Column(name="USER_TYPE", nullable=false, length=20)
    private String     userType ;

    @Id
    @Column(name="SUB_USER_TYPE", nullable=false, length=20)
    private String     subUserType ;

    //--- ENTITY DATA FIELDS 
    @Column(name="ATTACHED_BRANCHES", nullable=false, length=300)
    private String     attachedBranches ;

    @Column(name="ATTACHED_REGIONS", length=300)
    private String     attachedRegions ;

    @Column(name="ATTACHED_COMPANIES", length=300)
    private String     attachedCompanies ;

    @Column(name="BANK_CODE", length=20)
    private String     bankCode ;

    @Column(name="AGENCY_CODE")
    private Integer    agencyCode ;

    @Column(name="OA_CODE")
    private Integer    oaCode ;

    @Column(name="PASSWORD", length=100)
    private String     password ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LPASS_DATE")
    private Date       lpassDate ;

    @Column(name="LPASS1", length=100)
    private String     lpass1 ;

    @Column(name="LPASS2", length=100)
    private String     lpass2 ;

    @Column(name="LPASS3", length=100)
    private String     lpass3 ;

    @Column(name="LPASS4", length=100)
    private String     lpass4 ;

    @Column(name="LPASS5", length=100)
    private String     lpass5 ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="STATUS", length=1)
    private String     status ;

    @Column(name="CREATED_BY", length=20)
    private String     createdBy ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="PWD_COUNT")
    private Integer    pwdCount ;


    //--- ENTITY LINKS ( RELATIONSHIP )


}


