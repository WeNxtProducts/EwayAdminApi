/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-30 ( Date ISO 2022-09-30 - Time 18:45:34 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;
import java.util.List;

import com.maan.eway.master.req.FactorTypeDetailsSaveReq;
import com.maan.eway.master.req.FactorTypeDropDownReq;
import com.maan.eway.master.req.FactorTypeGetAllReq;
import com.maan.eway.master.req.FactorTypeGetReq;
import com.maan.eway.master.req.FactorUpdateStatusReq;
import com.maan.eway.master.res.FactorTypeDetailsGetRes;
import com.maan.eway.master.res.FactorTypeGetAllRes;
import com.maan.eway.res.RatingFieldDropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>FactorTypeDetailsServiceimpl</h2>
*/
public interface FactorTypeDetailsService  {

	List<String> validateFactorTypeDetails(FactorTypeDetailsSaveReq req);

	SuccessRes insertFactorTypeDetails(FactorTypeDetailsSaveReq req);

	List<FactorTypeGetAllRes> getallFactorTypes(FactorTypeGetAllReq req);

	List<FactorTypeGetAllRes> getActiveFactocTypes(FactorTypeGetAllReq req);

	FactorTypeDetailsGetRes getByFactorTypeId(FactorTypeGetReq req);

	SuccessRes changeStatusOfFactorType(FactorUpdateStatusReq req);

	FactorTypeDetailsGetRes getByFactorTypeForRating(FactorTypeGetReq req);

	List<RatingFieldDropDownRes> factorTypeDropDown(FactorTypeDropDownReq req);





}