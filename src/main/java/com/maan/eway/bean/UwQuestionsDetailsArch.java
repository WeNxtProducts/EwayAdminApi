/* 
*  Copyright (c) 2019. All right reserved
 * Created on 2022-11-21 ( Date ISO 2022-11-21 - Time 15:20:33 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */

/*
 * Created on 2022-11-21 ( 15:20:33 )
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
* Domain class for entity "UwQuestionsDetailsArch"
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
@IdClass(UwQuestionsDetailsArchId.class)
@Table(name="uw_questions_details_arch")


public class UwQuestionsDetailsArch implements Serializable {

	private static final long serialVersionUID = 1L;
	 
    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="ARCH_ID", nullable=false, length=10)
    private Integer     archId ;
    @Id
    @Column(name="COMPANY_ID", nullable=false, length=20)
    private String     companyId ;
    @Id
    @Column(name="PRODUCT_ID", nullable=false)
    private Integer    productId ;
    @Id
    @Column(name="REQUEST_REFERENCE_NO", nullable=false, length=20)
    private String     requestReferenceNo ;
    @Id
    @Column(name="VEHICLE_ID", nullable=false)
    private Integer    vehicleId ;
    @Id
    @Column(name="UW_QUESTION_ID", nullable=false)
    private Integer    uwQuestionId ;
    
	@Id
	@Column(name = "QUESTION_CATEGORY", nullable = false)
	private String questionCategory;
	//

	@Column(name = "QUESTION_CATEGORY_DESC")
	private String questionCategoryDesc;
	
    @Column(name="POLICY_HOLDER_TYPE", length=2)
    private String     policyHolderType ;
    
    @Column(name="POLICY_HOLDER_TYPE_DESC", length=100)
    private String     policyHolderTypeDesc ;
    
    @Column(name="ID_TYPE", length=100)
    private String     idType ;

    @Column(name="ID_TYPE_DESC", length=100)
    private String     idTypeDesc ;

    @Column(name="ID_NUMBER", length=100)
    private String     idNumber ;
    
    
    //--- ENTITY DATA FIELDS 
    @Column(name="UW_QUESTION_DESC", length=700)
    private String     uwQuestionDesc ;
    @Column(name="QUESTION_TYPE", length=100)
    private String     questionType ;
    @Column(name="VALUE", length=100)
    private String     value ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date       entryDate ;
    @Column(name="STATUS", length=2)
    private String     status ;
    @Column(name="REMARKS", length=100)
    private String     remarks ;
    @Column(name="CREATED_BY", length=100)
    private String     createdBy ;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATED_DATE")
    private Date       updatedDate ;
    @Column(name="UPDATED_BY", length=100)
    private String     updatedBy ;
    @Column(name="IS_REFERRAL", length=20)
    private String     isReferral;
    @Column(name="TEXT_VALUE", length=100)
    private String    textValue;
    //--- ENTITY LINKS ( RELATIONSHIP )


}



