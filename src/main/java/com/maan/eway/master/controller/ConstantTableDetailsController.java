package com.maan.eway.master.controller;
/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.common.service.impl.FetchErrorDescServiceImpl;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.ConstantTableChangeStatusReq;
import com.maan.eway.master.req.ConstantTableDetailsGetAllReq;
import com.maan.eway.master.req.ConstantTableDetailsGetReq;
import com.maan.eway.master.req.ConstantTableDetailsSaveReq;
import com.maan.eway.master.req.LovDropDownReq;
import com.maan.eway.master.res.ConstantTableDetailsCommonRes;
import com.maan.eway.master.res.ConstantTableDetailsRes;
import com.maan.eway.master.service.ConstantTableDetailsService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>ConstantTableDetailsController</h2>
*/
@RestController
@Api(tags = "MASTER : ConstantTableDetails Master ", description = "API's")
@RequestMapping("/api")
public class ConstantTableDetailsController {

	@Autowired
	private  ConstantTableDetailsService service;
	
	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;
	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/insertconstanttabledetails")
		@ApiOperation(value = "This method is ConstantTableDetails Master")
		public ResponseEntity<CommonRes> insertConstantTableDetails(@RequestBody ConstantTableDetailsSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = service.validateConstantTableDetails(req);
		List<Error> validation = null;
		if(validationCodes!=null && validationCodes.size() > 0 ) {
			CommonErrorModuleReq comErrDescReq = new CommonErrorModuleReq();
			comErrDescReq.setBranchCode("99999");
			comErrDescReq.setInsuranceId(req.getInsuranceId());
			comErrDescReq.setProductId("99999");
			comErrDescReq.setModuleId("31");
			comErrDescReq.setModuleName("MASTERS");
			
			validation = errorDescService.getErrorDesc(validationCodes ,comErrDescReq);
		}

		
			// validation
			if (validation != null && validation.size() != 0) {
				data.setCommonResponse(null);
				data.setIsError(true);
				data.setErrorMessage(validation);
				data.setMessage("Failed");
				return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

			} else {

				// Save
				SuccessRes res = service.insertConstantTableDetails(req);
				data.setCommonResponse(res);
				data.setIsError(false);
				data.setErrorMessage(Collections.emptyList());
				data.setMessage("Success");

				if (res != null) {
					return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}

		}
		
		//  Get All ConstantTableDetails Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getallconstanttabledetails")
		@ApiOperation("This method is getall ConstantTableDetails")
		public ResponseEntity<CommonRes> getallConstantTableDetails(@RequestBody ConstantTableDetailsGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<ConstantTableDetailsRes> res =service.getallConstantTableDetails(req);
			data.setCommonResponse(res);
			data.setErrorMessage(Collections.emptyList());
			data.setIsError(false);
			data.setMessage("Success");
			
			if(res!= null) {
				return new ResponseEntity<CommonRes> (data, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
			}
		}
		
	//  Get Active ConstantTableDetails Master
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
			@PostMapping("/getactiveconstanttabledetails")
			@ApiOperation("This method is get Active ConstantTableDetails")
			public ResponseEntity<CommonRes> getActiveConstantTableDetails(@RequestBody ConstantTableDetailsGetAllReq req)
			{
				CommonRes data = new CommonRes();
				reqPrinter.reqPrint(req);
				
				List<ConstantTableDetailsRes> res = service.getActiveConstantTableDetails(req);
				data.setCommonResponse(res);
				data.setErrorMessage(Collections.emptyList());
				data.setIsError(false);
				data.setMessage("Success");
				
				if(res!= null) {
					return new ResponseEntity<CommonRes> (data, HttpStatus.CREATED);
				}
				else {
					return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
				}
			}
		
		// Get By ConstantTableDetails Id
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getbyconstanttabledetailsid")
		@ApiOperation("This Method is to get by ConstantTableDetails id")
		public ResponseEntity<CommonRes> getByConstantTableDetailsId(@RequestBody ConstantTableDetailsGetReq req)
		{
		CommonRes data = new CommonRes();
		ConstantTableDetailsCommonRes res = service.getByConstantTableDetailsId(req);
		data.setCommonResponse(res);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");

		if (res != null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

		// ConstantTableDetails Master Drop Down Type
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")	
	@PostMapping("/dropdown/tabletype")
		@ApiOperation(value = "This method is to Table Type Drop Down")
		public ResponseEntity<CommonRes> tableType(@RequestBody LovDropDownReq req) {
			CommonRes data = new CommonRes();

			List<DropDownRes> res = service.tableType(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");

			if (res != null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		}		

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/constanttabledetails/changestatus")
		@ApiOperation(value = "This method is get ConstantTableDetails Change Status")
		public ResponseEntity<CommonRes> changeStatusOfConstantTableDetails(@RequestBody ConstantTableChangeStatusReq req) {

			CommonRes data = new CommonRes();
			// Change Status
			SuccessRes res = service.changeStatusOfConstantTableDetails(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");

			if (res != null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		}
	


}
