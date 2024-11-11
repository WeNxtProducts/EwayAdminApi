/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:54 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;
import java.util.List;

import com.maan.eway.error.Error;
import com.maan.eway.master.req.CompanyRegionChangeStatusReq;
import com.maan.eway.master.req.CompanyRegionDropDownReq;
import com.maan.eway.master.req.CompanyRegionGetAllReq;
import com.maan.eway.master.req.CompanyRegionGetReq;
import com.maan.eway.master.req.CompanyRegionMultiInsertSaveReq;
import com.maan.eway.master.req.CompanyRegionNonSelectedReq;
import com.maan.eway.master.req.CompanyRegionSaveReq;
import com.maan.eway.master.res.CompanyRegionGetRes;
import com.maan.eway.master.res.RegionMasterRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>SessionMasterServiceimpl</h2>
*/
public interface CompanyRegionMasterService  {



	List<CompanyRegionGetRes> getallCompanyRegion(CompanyRegionGetAllReq req);

	List<CompanyRegionGetRes> getActiveCompanyRegion(CompanyRegionGetAllReq req);

	CompanyRegionGetRes getByCompanyRegionId(CompanyRegionGetReq req);

	List<RegionMasterRes> getallNonSelectedCompanyRegion(CompanyRegionNonSelectedReq req);

	List<DropDownRes> getCompanyRegionDropdown(CompanyRegionDropDownReq req);

	SuccessRes changeStatusofCompanyRegion(CompanyRegionChangeStatusReq req);

	List<Error> validateCompanyRegion(List<CompanyRegionMultiInsertSaveReq> req);

	SuccessRes insertCompanyRegion(List<CompanyRegionMultiInsertSaveReq> req);

	List<Error> validateUpdateCompanyRegion(CompanyRegionSaveReq req);

	SuccessRes updateCompanyRegion(CompanyRegionSaveReq req);


}
