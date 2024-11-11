/*
 * Java domain class for entity "MailMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;

import com.maan.eway.bean.MailMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.MailMasterId;
/**
 * <h2>MailMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:28
 * <p>
 * Description: "MailMaster" Repository
 */
 
 
 
public interface MailMasterRepository  extends JpaRepository<MailMaster,MailMasterId > , JpaSpecificationExecutor<MailMaster> {

	MailMaster findByCompanyId(String insuranceId);

}