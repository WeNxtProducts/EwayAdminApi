/*
 * Java domain class for entity "EserviceLifeDetails" 
 * Created on 2023-09-20 ( Date ISO 2023-09-20 - Time 16:47:06 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2023-09-20 ( 16:47:06 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;

import com.maan.eway.bean.EserviceLifeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.EserviceLifeDetailsId;
/**
 * <h2>EserviceLifeDetailsRepository</h2>
 *
 * createdAt : 2023-09-20 - Time 16:47:06
 * <p>
 * Description: "EserviceLifeDetails" Repository
 */
 
 
 
public interface EserviceLifeDetailsRepository  extends JpaRepository<EserviceLifeDetails,EserviceLifeDetailsId > , JpaSpecificationExecutor<EserviceLifeDetails> {

}
