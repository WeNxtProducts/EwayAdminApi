/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;


import java.util.List;

import com.maan.eway.master.req.ConstantTableChangeStatusReq;
import com.maan.eway.master.req.ConstantTableDetailsGetAllReq;
import com.maan.eway.master.req.ConstantTableDetailsGetReq;
import com.maan.eway.master.req.ConstantTableDetailsSaveReq;
import com.maan.eway.master.req.LovDropDownReq;
import com.maan.eway.master.res.ConstantTableDetailsCommonRes;
import com.maan.eway.master.res.ConstantTableDetailsRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>BankMasterServiceimpl</h2>
*/
public interface ConstantTableDetailsService  {

	List<String> validateConstantTableDetails(ConstantTableDetailsSaveReq req);

	SuccessRes insertConstantTableDetails(ConstantTableDetailsSaveReq req);

	List<ConstantTableDetailsRes> getallConstantTableDetails(ConstantTableDetailsGetAllReq req);

	List<ConstantTableDetailsRes> getActiveConstantTableDetails(ConstantTableDetailsGetAllReq req);

	ConstantTableDetailsCommonRes getByConstantTableDetailsId(ConstantTableDetailsGetReq req);

	SuccessRes changeStatusOfConstantTableDetails(ConstantTableChangeStatusReq req);

	List<DropDownRes> tableType(LovDropDownReq req);

	}
