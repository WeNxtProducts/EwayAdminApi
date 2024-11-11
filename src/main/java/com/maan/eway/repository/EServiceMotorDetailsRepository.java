/*
 * Java domain class for entity "CustomerDetails" 
 * Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:52 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-09-02 ( 18:14:52 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.maan.eway.bean.CustomerDetails;
import com.maan.eway.bean.CustomerDetailsId;
import com.maan.eway.bean.EserviceCustomerDetails;
import com.maan.eway.bean.EserviceMotorDetails;
import com.maan.eway.bean.EserviceMotorDetailsId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * <h2>CustomerDetailsRepository</h2>
 *
 * createdAt : 2022-09-02 - Time 18:14:52
 * <p>
 * Description: "CustomerDetails" Repository
 */
 
 
 
public interface EServiceMotorDetailsRepository  extends JpaRepository<EserviceMotorDetails,EserviceMotorDetailsId > , JpaSpecificationExecutor<EserviceMotorDetails> {
  


}