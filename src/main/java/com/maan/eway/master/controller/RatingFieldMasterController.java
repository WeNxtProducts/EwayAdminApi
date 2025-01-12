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
import com.maan.eway.master.req.RatingDropDownReq;
import com.maan.eway.master.req.RatingFieldMasterGetAllReq;
import com.maan.eway.master.req.RatingFieldsMasterChangeStatusReq;
import com.maan.eway.master.req.RatingFieldsMasterGetReq;
import com.maan.eway.master.req.RatingFieldsMasterSaveReq;
import com.maan.eway.master.res.RatingFieldsMasterGetRes;
import com.maan.eway.master.service.RatingFieldMasterService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.RatingFieldDropDownRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>CityMasterController</h2>
*/
@RestController
@RequestMapping("/master")
@Api(tags = "MASTER : Factor Type Master ", description = "API's")
public class RatingFieldMasterController {

	@Autowired
	private  RatingFieldMasterService entityService;
	
	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;
	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/insertratingfield")
		@ApiOperation(value = "This method is to Insert Rating Field ")
		public ResponseEntity<CommonRes> insertfactortype(@RequestBody RatingFieldsMasterSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = entityService.validateFactorType(req);
		List<Error> validation = null;
		if(validationCodes!=null && validationCodes.size() > 0 ) {
			CommonErrorModuleReq comErrDescReq = new CommonErrorModuleReq();
			comErrDescReq.setBranchCode("99999");
			comErrDescReq.setInsuranceId("99999");
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
				SuccessRes res = entityService.insertfactortype(req);
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
		
		//  Get All Factor Type
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getallratingfields")
		@ApiOperation("This method is getall Rating Field")
		public ResponseEntity<CommonRes> getallFactorType(@RequestBody RatingFieldMasterGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<RatingFieldsMasterGetRes> res = entityService.getallFactorType(req);
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
		
	//  Get Active Factor Type
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
			@PostMapping("/getactiveratingfields")
			@ApiOperation("This method is get Active Rating Field")
			public ResponseEntity<CommonRes> getActiveFactorType(@RequestBody RatingFieldMasterGetAllReq req)
			{
				CommonRes data = new CommonRes();
				reqPrinter.reqPrint(req);
				
				List<RatingFieldsMasterGetRes> res = entityService.getActiveFactorType(req);
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
		
		// Get By Factor Id
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getbyratingfieldid")
		@ApiOperation("This Method is to get by Rating Field Id")
		public ResponseEntity<CommonRes> getByFactorId(@RequestBody RatingFieldsMasterGetReq req)
		{
		CommonRes data = new CommonRes();
		RatingFieldsMasterGetRes res = entityService.getByFactorId(req);
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
		@PostMapping("/ratingfield/changestatus")
		@ApiOperation(value = "This method is to Rating Field Change Status")
		public ResponseEntity<CommonRes> changeStatusOfFactorType(@RequestBody RatingFieldsMasterChangeStatusReq req) {

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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping(value="/dropdown/ratingfields",produces = "application/json")
		@ApiOperation(value = "This method is get Rating Fields Drop Down")

		public ResponseEntity<CommonRes> getRatingFieldsDropdown(@RequestBody RatingDropDownReq  req  ) {

			CommonRes data = new CommonRes();

			// Save
			List<RatingFieldDropDownRes> res = entityService.getRatingFieldsDropdown(req);
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
