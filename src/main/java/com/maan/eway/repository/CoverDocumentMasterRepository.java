/*
 * Java domain class for entity "DocumentMaster" 
 * Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:27 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
 
 /*
 * Created on 2022-08-24 ( 12:58:27 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */


package com.maan.eway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.maan.eway.bean.CoverDocumentMaster;
import com.maan.eway.bean.CoverDocumentMasterId;

 
public interface CoverDocumentMasterRepository  extends JpaRepository<CoverDocumentMaster,CoverDocumentMasterId > , JpaSpecificationExecutor<CoverDocumentMaster> {

}
