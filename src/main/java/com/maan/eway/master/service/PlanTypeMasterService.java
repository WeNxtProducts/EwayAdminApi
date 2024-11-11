/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;

import java.util.List;

import com.maan.eway.error.Error;
import com.maan.eway.master.req.PlanTypeDropDownReq;
import com.maan.eway.master.req.PlanTypeMasterChangeStatusReq;
import com.maan.eway.master.req.PlanTypeMasterGetAllReq;
import com.maan.eway.master.req.PlanTypeMasterGetReq;
import com.maan.eway.master.req.PlanTypeMasterSaveReq;
import com.maan.eway.master.res.PlanTypeMasterRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;

public interface PlanTypeMasterService  {

	List<DropDownRes> getPlanTypeMasterDropdown(PlanTypeDropDownReq req);

	List<Error> validatePlanType(PlanTypeMasterSaveReq req);

	SuccessRes insertPlanType(PlanTypeMasterSaveReq req);

	List<PlanTypeMasterRes> getallPlanType(PlanTypeMasterGetAllReq req);

	List<PlanTypeMasterRes> getActivePlanType(PlanTypeMasterGetAllReq req);

	PlanTypeMasterRes getByPlanTypeId(PlanTypeMasterGetReq req);

	SuccessRes changeStatusOfPlanTypeMaster(PlanTypeMasterChangeStatusReq req);

	

}
