/*
 * Java domain class for entity "CoverDetails" 
 * Created on 2022-11-09 ( Date ISO 2022-11-09 - Time 18:32:05 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-11-09 ( 18:32:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.PolicyCoverData;
import com.maan.eway.bean.PolicyCoverDataId;
/**
 * <h2>CoverDetailsRepository</h2>
 *
 * createdAt : 2022-11-09 - Time 18:32:05
 * <p>
 * Description: "CoverDetails" Repository
 */
 
 
 
public interface CoverDetailsRepository  extends JpaRepository<PolicyCoverData,PolicyCoverDataId > , JpaSpecificationExecutor<PolicyCoverData> {

	List<PolicyCoverData> findByQuoteNoOrderByVehicleIdAsc(String quoteNo);

}