/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2023-01-11 ( Date ISO 2023-01-11 - Time 13:27:45 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2023-01-11 ( 13:27:45 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.bean;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;




/**
* Domain class for entity "NotifTemplateMaster"
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
@IdClass(NotifTemplateMasterId.class)
@Table(name="eway_notif_template_master")


public class NotifTemplateMaster implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
  //  @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="NOTIF_TEMPLATE_CODE", length=20,nullable=false)
    private String       notifTemplateCode ;

    @Id
    @Column(name="COMPANY_ID", nullable=false, length=10)
    private String     companyId ;

    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Long       productId ;
    
    @Id
    @Column(name="AMEND_ID", nullable=false)
    private Integer       amendId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="TO_MESSENGERNO", length=100)
    private String toMessengerno ;

    @Column(name="TO_SMSNO", length=100)
    private String toSmsno ;

    @Column(name="TO_EMAIL", length=100)
    private String     toEmail ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_START", nullable=false)
    private Date       effectiveDateStart ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EFFECTIVE_DATE_END", nullable=false)
    private Date       effectiveDateEnd ;

    @Column(name="MAIL_REQUIRED", length=10)
    private String     mailRequired ;

    @Column(name="MAIL_SUBJECT", length=500)
    private String     mailSubject ;

    @Column(name="MAIL_BODY", length=2000)
    private String     mailBody ;

    @Column(name="MAIL_REGARDS", length=500)
    private String     mailRegards ;

    @Column(name="SMS_REQUIRED", length=10)
    private String     smsRequired ;

    @Column(name="SMS_SUBJECT", length=500)
    private String     smsSubject ;

    @Column(name="SMS_BODY_EN", length=2000)
    private String     smsBodyEn ;

    @Column(name="WHATSAPP_REQUIRED", length=10)
    private String     whatsappRequired ;

    @Column(name="WHATSAPP_SUBJECT", length=500)
    private String     whatsappSubject ;

    @Column(name="WHATSAPP_BODY_EN", length=2000)
    private String     whatsappBodyEn ;

    @Column(name="WHATSAPP_REGARDS", length=500)
    private String     whatsappRegards ;

    @Temporal(TemporalType.DATE)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;

    @Column(name="NOTIF_TEMPLATENAME", length=60)
    private String     notifTemplatename ;

    @Column(name="REMARKS", length=100)
    private String     remarks ;

    @Column(name="STATUS", length=10)
    private String     status ;

    @Column(name="CREATED_BY", nullable=false, length=100)
    private String     createdBy ;

    @Column(name="CORE_APP_CODE", nullable=false, length=20)
    private String     coreAppCode ;

    @Column(name="REGULATORY_CODE", nullable=false, length=20)
    private String     regulatoryCode ;

    @Column(name="UPDATED_BY", length=20)
    private String     updatedBy ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;

    @Column(name="SMS_REGARDS", length=500)
    private String    smsRegards ;

    //--- ENTITY LINKS ( RELATIONSHIP )


}


