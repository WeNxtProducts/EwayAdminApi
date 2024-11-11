/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:52 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;
import java.util.List;

import com.maan.eway.error.Error;
import com.maan.eway.master.controller.DiscountCoverReq;
import com.maan.eway.master.req.CoverChangeStatusReq;
import com.maan.eway.master.req.CoverMasterGetAllReq;
import com.maan.eway.master.req.CoverMasterGetReq;
import com.maan.eway.master.req.CoverMasterSaveReq;
import com.maan.eway.master.req.EmiMasterChangeStatusReq;
import com.maan.eway.master.req.EmiMasterGetAllReq;
import com.maan.eway.master.req.EmiMasterGetReq;
import com.maan.eway.master.req.EmiMasterSaveReq;
import com.maan.eway.master.res.CoverMasterGetAllRes;
import com.maan.eway.master.res.CoverMasterRes;
import com.maan.eway.master.res.EmiMasterRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>CoverMasterServiceimpl</h2>
*/
public interface EmiMasterService  {

	List<String> validateEmiDetails(EmiMasterSaveReq req);

	SuccessRes insertEmi(EmiMasterSaveReq req);

	SuccessRes changeStatusOfProduct(EmiMasterChangeStatusReq req);

	List<EmiMasterRes> getallEmiDetails(EmiMasterGetAllReq req);

	List<EmiMasterRes> getActiveEmiDetails(EmiMasterGetAllReq req);

	EmiMasterRes getByEmiId(EmiMasterGetReq req);

	


}