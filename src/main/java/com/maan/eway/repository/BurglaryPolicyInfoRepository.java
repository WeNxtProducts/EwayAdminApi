/*
 * Java domain class for entity "BankMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:26 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.BurglaryPolicyInfo;
import com.maan.eway.bean.BurglaryPolicyInfoId;
 
 
public interface BurglaryPolicyInfoRepository  extends JpaRepository<BurglaryPolicyInfo,BurglaryPolicyInfoId> , JpaSpecificationExecutor<BurglaryPolicyInfo> {


}
