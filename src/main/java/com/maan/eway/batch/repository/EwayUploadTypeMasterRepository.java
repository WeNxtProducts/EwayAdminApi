/*
 * Java domain class for entity "EwayUploadTypeMaster" 
 * Created on 2023-05-11 ( Date ISO 2023-05-11 - Time 16:44:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2023-05-11 ( 16:44:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.batch.repository;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.maan.eway.batch.entity.EwayUploadTypeMaster;
import com.maan.eway.batch.entity.EwayUploadTypeMasterId;
/**
 * <h2>EwayUploadTypeMasterRepository</h2>
 *
 * createdAt : 2023-05-11 - Time 16:44:27
 * <p>
 * Description: "EwayUploadTypeMaster" Repository
 */
 
 
 
public interface EwayUploadTypeMasterRepository  extends JpaRepository<EwayUploadTypeMaster,EwayUploadTypeMasterId > , JpaSpecificationExecutor<EwayUploadTypeMaster> {


	EwayUploadTypeMaster findByCompanyIdAndProductIdAndTypeidAndStatus(Integer companyId, Integer productId, Integer typeId, String status);

	EwayUploadTypeMaster findByCompanyIdAndProductIdAndStatus(Integer companyId, Integer productId, 
			 String status);
	
	EwayUploadTypeMaster findByCompanyIdAndProductIdAndSectionIdAndStatus(Integer companyId, Integer productId, 
			 Integer sectionid,String status);


	List<EwayUploadTypeMaster> findByCompanyIdAndStatus(Integer valueOf, String string);

	@Transactional
	void deleteByCompanyIdAndProductIdAndTypeid(Integer companyId, Integer productId,Integer typeId);

	List<EwayUploadTypeMaster> findByCompanyIdAndProductId(Integer companyId, Integer productId);
	
	
	@Query(nativeQuery = true,value="select max(typeid) from eway_upload_type_master where company_id=?1 group by company_id")
	public Integer getLastNo(String companyId);

	@Query(nativeQuery = true, value="select * from eway_upload_type_master where company_id=?1 and product_id=?2 and typeid=?3 and section_id=?4")
	public EwayUploadTypeMaster findBy(String companyId, String productId, String typeId, String sectionId);
	
	@Query(nativeQuery = true, value="select * from eway_upload_type_master where company_id=?1")
	public List<EwayUploadTypeMaster> findByCompanyId(String companyId);
	
	EwayUploadTypeMaster findByCompanyIdAndProductIdAndSectionIdAndTypeidAndStatus(Integer companyId,Integer productId,Integer sectionId,
			Integer typeId,String status);

	
}
