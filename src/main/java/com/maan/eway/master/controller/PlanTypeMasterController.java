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

import com.maan.eway.error.Error;
import com.maan.eway.master.req.PlanTypeDropDownReq;
import com.maan.eway.master.req.PlanTypeMasterChangeStatusReq;
import com.maan.eway.master.req.PlanTypeMasterGetAllReq;
import com.maan.eway.master.req.PlanTypeMasterGetReq;
import com.maan.eway.master.req.PlanTypeMasterSaveReq;
import com.maan.eway.master.res.PlanTypeMasterRes;
import com.maan.eway.master.service.PlanTypeMasterService;

import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.DropdownCommonRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>PlanTypeMasterController</h2>
*/
@RestController
@Api(tags = "MASTER : Plan Type Master ", description = "API's")
@RequestMapping("/master")
public class PlanTypeMasterController {

	@Autowired
	private  PlanTypeMasterService service;
	
	@Autowired
	private  PrintReqService reqPrinter;
	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/insertplantype")
		@ApiOperation(value = "This method is Plan Type Master")
		public ResponseEntity<CommonRes> insertPlanType(@RequestBody PlanTypeMasterSaveReq req) {

			reqPrinter.reqPrint(req);
			CommonRes data = new CommonRes();

			List<Error> validation = service.validatePlanType(req);
			// validation
			if (validation != null && validation.size() != 0) {
				data.setCommonResponse(null);
				data.setIsError(true);
				data.setErrorMessage(validation);
				data.setMessage("Failed");
				return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

			} else {

				// Get All
				SuccessRes res = service.insertPlanType(req);
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
		
		//  Get All PlanType Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getallplantype")
		@ApiOperation("This method is getall PlanType")
		public ResponseEntity<CommonRes> getallPlanType(@RequestBody PlanTypeMasterGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<PlanTypeMasterRes> res =service.getallPlanType(req);
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
		
	//  Get Active PlanType Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
			@PostMapping("/getactiveplantype")
			@ApiOperation("This method is get Active PlanType")
			public ResponseEntity<CommonRes> getActivePlanType(@RequestBody PlanTypeMasterGetAllReq req)
			{
				CommonRes data = new CommonRes();
				reqPrinter.reqPrint(req);
				
				List<PlanTypeMasterRes> res = service.getActivePlanType(req);
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
		
		// Get By PlanType Id
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/getbyplantypeid")
		@ApiOperation("This Method is to get by PlanType id")
		public ResponseEntity<CommonRes> getByPlanTypeId(@RequestBody PlanTypeMasterGetReq req)
		{
		CommonRes data = new CommonRes();
		PlanTypeMasterRes res = service.getByPlanTypeId(req);
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
		
		// PlanType Master Drop Down Type
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
		@PostMapping(value="/dropdown/plantype",produces = "application/json")
		@ApiOperation(value = "This method is get PlanType Master Drop Down")

		public ResponseEntity<DropdownCommonRes> getPlanTypeMasterDropdown(@RequestBody PlanTypeDropDownReq req) {

			DropdownCommonRes data = new DropdownCommonRes();

			// Save
			List<DropDownRes> res = service.getPlanTypeMasterDropdown(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");

			if (res != null) {
				return new ResponseEntity<DropdownCommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

		}	
	

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/plantype/changestatus")
		@ApiOperation(value = "This method is get PlanType Change Status")
		public ResponseEntity<CommonRes> changeStatusOfPlanType(@RequestBody PlanTypeMasterChangeStatusReq req) {

			CommonRes data = new CommonRes();
			// Change Status
			SuccessRes res = service.changeStatusOfPlanTypeMaster(req);
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
