/*
 * Java domain class for entity "LoginProductMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import java.math.BigDecimal;
import java.util.List;

import com.maan.eway.bean.LoginProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.LoginProductMasterId;
/**
 * <h2>LoginProductMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:27
 * <p>
 * Description: "LoginProductMaster" Repository
 */
 
 
 
public interface LoginProductMasterRepository  extends JpaRepository<LoginProductMaster,LoginProductMasterId > , JpaSpecificationExecutor<LoginProductMaster> {

	List<LoginProductMaster> findByLoginId(String loginId);

	List<LoginProductMaster> findByLoginIdAndCompanyIdOrderByProductNameAsc(String loginId, String insuranceId);

}