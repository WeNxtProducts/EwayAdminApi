/*
 * Java domain class for entity "ProductMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:28 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:28 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.ProductSequenceMaster;
import com.maan.eway.bean.ProductSequenceMasterId;

 
 
public interface ProductSequenceMasterRepository  extends JpaRepository<ProductSequenceMaster,ProductSequenceMasterId > , JpaSpecificationExecutor<ProductSequenceMaster> {

}
