/*
 * Java domain class for entity "TransactionControlDetails" 
 * Created on 2023-05-11 ( Date ISO 2023-05-11 - Time 16:45:59 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2023-05-11 ( 16:45:59 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.batch.repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maan.eway.springbatch.TransactionControlDetails;
import com.maan.eway.springbatch.TransactionControlDetailsId;


/**
 * <h2>TransactionControlDetailsRepository</h2>
 *
 * createdAt : 2023-05-11 - Time 16:45:59
 * <p>
 * Description: "TransactionControlDetails" Repository
 */
 
 
@Repository 
public interface TransactionControlDetailsRepository  extends JpaRepository<TransactionControlDetails,TransactionControlDetailsId > , JpaSpecificationExecutor<TransactionControlDetails> {

	TransactionControlDetails findByCompanyIdAndProductIdAndRequestReferenceNo(Integer companyId, Integer productId,
			String requestRefNo);
		

	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw set STATUS ='D',error_desc=?1 WHERE REQUEST_REFERENCE_NO=?5 AND QUOTE_NO=?6 AND COMPANY_ID=?2 AND PRODUCT_ID=?3 AND RISK_ID=?4",nativeQuery=true)
	Integer updateOldRecords(String errorDesc,String companyId, String productId, String riskId, String requestReferenceNo, String quoteNo);

	@Modifying
	@Transactional
	@Query(value="UPDATE eway_employee_details_raw set STATUS ='D',error_desc=?1 WHERE REQUEST_REFERENCE_NO=?2 AND COMPANY_ID=?3 AND PRODUCT_ID=?4",nativeQuery=true)
	Integer updateOldMotorRecords(String errorDesc,String requestReferenceNo, String companyId, String productId);

	@Query(value="SELECT COALESCE(MAX(RISK_ID),0) FROM eservice_motor_details WHERE request_reference_no=?1 AND PRODUCT_ID=?2",nativeQuery=true)
	Long getVehicleId(String refNo,String productId);
	
	
	TransactionControlDetails findByRequestReferenceNo(
			String requestRefNo);


	
}
