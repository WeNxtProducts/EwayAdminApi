/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:54 )
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
import com.maan.eway.master.req.CountryChangeStatusReq;
import com.maan.eway.master.req.CountryTaxDropDownReq;
import com.maan.eway.master.req.CountryTaxGetAllReq;
import com.maan.eway.master.req.CountryTaxGetReq;
import com.maan.eway.master.req.CountryTaxSaveReq;
import com.maan.eway.master.res.CountryTaxGetRes;
import com.maan.eway.master.service.CountryTaxSetupService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.DropdownCommonRes;
import com.maan.eway.res.SuccessRes2;
import com.maan.eway.service.PrintReqService;
import com.maan.eway.service.impl.BasicValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>SectionMasterController</h2>
*/
@RestController
@RequestMapping("/master")
@Api(tags = "1. GLOBAL CONFIG : Country Tax Setup ", description = "API's")
public class CountryTaxSetupController {

	@Autowired
	private  CountryTaxSetupService entityService;

	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private BasicValidationService basicvalidateService;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;

	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/savecountrytax")
	@ApiOperation(value = "This method is to save Country Tax")
	public ResponseEntity<CommonRes> saveCountryTax(@RequestBody CountryTaxSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = entityService.validateCountryTax(req);
		List<Error> validation = null;
		if(validationCodes!=null && validationCodes.size() > 0 ) {
			CommonErrorModuleReq comErrDescReq = new CommonErrorModuleReq();
			comErrDescReq.setBranchCode("99999");
			comErrDescReq.setInsuranceId(req.getInsuranceId());// doubt
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
			SuccessRes2 res = entityService.saveCountryTax(req);
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
		
	//  Get All Section Master
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getallcountrytax")
	@ApiOperation("This method is getall Country Tax")
	public ResponseEntity<CommonRes> getallCountryTax(@RequestBody CountryTaxGetAllReq req)
	{
		CommonRes data = new CommonRes();
		
		List<CountryTaxGetRes> res =entityService.getallCountryTax(req);
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
	// Get By Document Id
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getbycountrytaxid")
	@ApiOperation("This Method is to get by Tax Id")
	public ResponseEntity<CommonRes> getByCountryTaxId(@RequestBody CountryTaxGetReq req){
	CommonRes data = new CommonRes();
	CountryTaxGetRes res = entityService.getByCountryTaxId(req);
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

		
	// Get By Active Status
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getactivecountrytax")
	@ApiOperation("This Method is to Get Active Documents")
	public ResponseEntity<CommonRes> getActiveCountryTax(@RequestBody CountryTaxGetAllReq req)
	{
		CommonRes data = new CommonRes();
		List<CountryTaxGetRes> res = entityService.getActiveCountryTax(req);
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
	
	// Document Drop Down
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
	@PostMapping(value="/dropdown/countrytaxes",produces = "application/json")
	@ApiOperation(value="This Method is to Drop Down Document")
	public ResponseEntity<DropdownCommonRes> getCountryTaxDropdown(@RequestBody CountryTaxDropDownReq req)
	{
		DropdownCommonRes data = new DropdownCommonRes();
		List<DropDownRes> res = entityService.getCountryTaxDropdown(req);
		data.setCommonResponse(res);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		if (res != null) {
			return new ResponseEntity<DropdownCommonRes>(data, HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}			
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/countrytax/changestatus")
	@ApiOperation(value = "This method is  Change Status of Country")
	public ResponseEntity<CommonRes> changeStatusOfCountryTax(@RequestBody CountryChangeStatusReq req) {

		CommonRes data = new CommonRes();
		// Change Status
		SuccessRes2 res = entityService.changeStatusOfCountryTax(req);
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
