/*
 * Java domain class for entity "ReferalMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;



import com.maan.eway.bean.CompaniesTaxSetup;
import com.maan.eway.bean.CompaniesTaxSetupId;
import com.maan.eway.bean.CountryMaster;
import com.maan.eway.bean.CountryMasterId;
import com.maan.eway.bean.CountryTaxSetup;
import com.maan.eway.bean.CountryTaxSetupId;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <h2>ReferalMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:28
 * <p>
 * Description: "ReferalMaster" Repository
 */
 
 
 
public interface CompaniesTaxSetupRepository  extends JpaRepository<CompaniesTaxSetup,CompaniesTaxSetupId > , JpaSpecificationExecutor<CompaniesTaxSetup> {



}
