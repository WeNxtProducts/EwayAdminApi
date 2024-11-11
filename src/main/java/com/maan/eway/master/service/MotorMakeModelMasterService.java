package com.maan.eway.master.service;

import java.util.List;

import com.maan.eway.error.Error;
import com.maan.eway.master.req.MotorMakeModelGetAllReq;
import com.maan.eway.master.req.MotorMakeModelGetReq;
import com.maan.eway.master.req.MotorMakeModelSaveReq;
import com.maan.eway.master.res.MotorColorGetRes;
import com.maan.eway.master.res.MotorMakeModelGetRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;

public interface MotorMakeModelMasterService {

	List<Error> validateMotorMakeModel(MotorMakeModelSaveReq req);

	SuccessRes saveMotorMakeModel(MotorMakeModelSaveReq req);

	MotorMakeModelGetRes getMotorMakeModel(MotorMakeModelGetReq req);

	List<MotorMakeModelGetRes> getallMotorMakeModel(MotorMakeModelGetAllReq req);

	List<MotorColorGetRes> getactiveMakeModel(MotorMakeModelGetAllReq req);

	//List<DropDownRes> getMotorMakeModelDropdown( String makeId );

}