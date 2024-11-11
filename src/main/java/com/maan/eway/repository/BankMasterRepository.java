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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.maan.eway.bean.BankMaster;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.maan.eway.bean.BankMasterId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * <h2>BankMasterRepository</h2>
 *
 * createdAt : 2022-08-24 - Time 12:58:26
 * <p>
 * Description: "BankMaster" Repository
 */
 
 
 
public interface BankMasterRepository  extends JpaRepository<BankMaster,BankMasterId > , JpaSpecificationExecutor<BankMaster> {

	List<BankMaster> findByBankCodeAndBankShortNameOrderByBankShortName(String bankCode, String bankShortName);
			
	List<BankMaster> findByBankCodeAndEffectiveDateStartGreaterThanEqualAndEffectiveDateEndLessThanEqualOrderByEffectiveDateEndDesc(
			String bankCode, Date startDate, Date endDate);

	List<BankMaster> findByStatusOrderByEffectiveDateStartDesc(String string);

	Long countByBankShortNameOrderByEntryDateDesc(String bankShortName);


	

}
