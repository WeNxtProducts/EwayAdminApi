/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;


import com.maan.eway.master.req.CityChangeStatusReq;
import com.maan.eway.master.req.CityMasterDropDownReq;
import com.maan.eway.master.req.CityMasterGetAllReq;
import com.maan.eway.master.req.CityMasterGetReq;
import com.maan.eway.master.req.CityMasterSaveReq;
import com.maan.eway.master.req.CompanyCityChangeStatusReq;
import com.maan.eway.master.req.CompanyCityMasterDropDownReq;
import com.maan.eway.master.req.CompanyCityMasterGetAllReq;
import com.maan.eway.master.req.CompanyCityMasterGetReq;
import com.maan.eway.master.req.CompanyCityMasterMultiInsertSaveReq;
import com.maan.eway.master.req.CompanyCityMasterSaveReq;
import com.maan.eway.master.req.CompanyCityNonSelectedReq;
import com.maan.eway.master.res.CityMasterRes;
import com.maan.eway.master.res.CompanyCityMasterRes;
import com.maan.eway.error.Error;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;

import java.util.List;
/**
* <h2>BankMasterServiceimpl</h2>
*/
public interface CompanyCityMasterService  {


	List<Error> validateUpdateCityDetails(CompanyCityMasterSaveReq req);

	SuccessRes updateCity(CompanyCityMasterSaveReq req);

	List<CompanyCityMasterRes> getallCityDetails(CompanyCityMasterGetAllReq req);

	List<CompanyCityMasterRes> getActiveCityDetails(CompanyCityMasterGetAllReq req);

	CompanyCityMasterRes getByCityId(CompanyCityMasterGetReq req);

	List<Error> validateDropdownGet(CompanyCityMasterDropDownReq req);

	List<DropDownRes> getCityMasterDropdown(CompanyCityMasterDropDownReq req);

	SuccessRes changeStatusOfCity(CompanyCityChangeStatusReq req);

	List<CompanyCityMasterRes> getallNonSelectedCompanyState(CompanyCityNonSelectedReq req);

	List<Error> validateCityDetails(List<CompanyCityMasterMultiInsertSaveReq> req);

	SuccessRes insertCity(List<CompanyCityMasterMultiInsertSaveReq> req);

	List<Error> validateCompanyCity(CompanyCityMasterDropDownReq req);

	List<DropDownRes> getCompanyCityDropdown(CompanyCityMasterDropDownReq req);

	
	

}
