/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-30 ( Date ISO 2022-09-30 - Time 18:45:34 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.controller;

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
import com.maan.eway.master.req.FactorTypeDetailsSaveReq;
import com.maan.eway.master.req.FactorTypeDropDownReq;
import com.maan.eway.master.req.FactorTypeGetAllReq;
import com.maan.eway.master.req.FactorTypeGetReq;
import com.maan.eway.master.req.FactorUpdateStatusReq;
import com.maan.eway.master.res.FactorTypeDetailsGetRes;
import com.maan.eway.master.res.FactorTypeGetAllRes;
import com.maan.eway.master.service.FactorTypeDetailsService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.RatingFieldDropDownRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.ApiOperation;


/**
* <h2>FactorTypeDetailsController</h2>
*/
@RestController
@RequestMapping("/master")
public class FactorTypeDetailsController {

	@Autowired
	private  FactorTypeDetailsService entityService;

	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;
	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/insertfactortypes")
	@ApiOperation(value = "This method is Insert Factor Type Details")
	public ResponseEntity<CommonRes> insertProduct(@RequestBody FactorTypeDetailsSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = entityService.validateFactorTypeDetails(req);
		List<Error> validation = null;
		if(validationCodes!=null && validationCodes.size() > 0 ) {
			CommonErrorModuleReq comErrDescReq = new CommonErrorModuleReq();
			comErrDescReq.setBranchCode(req.getBranchCode());
			comErrDescReq.setInsuranceId(req.getCompanyId());
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

			// Get All
			SuccessRes res = entityService.insertFactorTypeDetails(req);
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
	
	//  Get All Product Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getallfactortypes")
	@ApiOperation("This method is getall Factor Type Details")
	public ResponseEntity<CommonRes> getallFactorTypeDetails(@RequestBody FactorTypeGetAllReq req)
	{
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);
		
		List<FactorTypeGetAllRes> res = entityService.getallFactorTypes(req);
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
	
	//  Get Active Product Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getactivefactortypes")
		@ApiOperation("This method is get Active Factor Type Details")
		public ResponseEntity<CommonRes> getActiveProductDetails(@RequestBody FactorTypeGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<FactorTypeGetAllRes> res = entityService.getActiveFactocTypes(req);
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
		
		// Get By Product Id
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getbyfactortypeid")
		@ApiOperation("This Method is to get by Product id")
		public ResponseEntity<CommonRes> getByFactorTypeId(@RequestBody FactorTypeGetReq req)
		{
		CommonRes data = new CommonRes();
		FactorTypeDetailsGetRes res = entityService.getByFactorTypeId(req);
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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getfactortypeforrating")
		@ApiOperation("This Method is to get by Product id")
		public ResponseEntity<CommonRes> getByFactorTypeForRating(@RequestBody FactorTypeGetReq req)
		{
		CommonRes data = new CommonRes();
		FactorTypeDetailsGetRes res = entityService.getByFactorTypeForRating(req);
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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/factortype/changestatus")
	@ApiOperation(value = "This method is get Product Change Status ")
	public ResponseEntity<CommonRes> changeStatusOfFactorType(@RequestBody FactorUpdateStatusReq req) {

		CommonRes data = new CommonRes();
		// Change Status
		SuccessRes res = entityService.changeStatusOfFactorType(req);
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

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
	@PostMapping(value="/dropdown/factortype",produces = "application/json")
	@ApiOperation(value="This method is to get Factor Type dropdown")
	public ResponseEntity<CommonRes> factorTypeDropDown(@RequestBody FactorTypeDropDownReq req){
		CommonRes data = new CommonRes();
		List<RatingFieldDropDownRes> res = entityService.factorTypeDropDown(req);
		data.setCommonResponse(res);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		if(res!=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	

}