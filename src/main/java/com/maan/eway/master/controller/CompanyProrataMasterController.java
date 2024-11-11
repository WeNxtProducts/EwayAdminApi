/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:51 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.common.service.impl.FetchErrorDescServiceImpl;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.CompanyProrataChangeStatusReq;
import com.maan.eway.master.req.CompanyProrataGetAllReq;
import com.maan.eway.master.req.CompanyProrataGetReq;
import com.maan.eway.master.req.CompanyProrataSaveReq;
import com.maan.eway.master.res.CompanyProrataGetAllRes;
import com.maan.eway.master.res.CompanyProrataGetRes;
import com.maan.eway.master.service.CompanyProrataService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>CoverMasterController</h2>
*/
@RestController
@RequestMapping("/master")
@Api(tags = "2. COMPANY CONFIG : ProRata Master ", description = "API's")
public class CompanyProrataMasterController {

	@Autowired
	private  CompanyProrataService prorataService;
	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;
	
	// save
	@PostMapping("/insertcompanyprorata")
	@ApiOperation(value = "This method is Insert Company Prorata Details")
	public ResponseEntity<CommonRes> insertCompanyProrata(@RequestBody CompanyProrataSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = prorataService.validateCompanyProrata(req);
		List<Error> validation = null;
		if(validationCodes!=null && validationCodes.size() > 0 ) {
			CommonErrorModuleReq comErrDescReq = new CommonErrorModuleReq();
			comErrDescReq.setBranchCode("99999");
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
			SuccessRes res = prorataService.insertCompanyProrata(req);
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

	// Get All Branch Master

	@PostMapping("/getallcompanyprorata")
	@ApiOperation("This method is getall Company Prorataes")
	public ResponseEntity<CommonRes> getallComapnyProrata(@RequestBody CompanyProrataGetAllReq req) {
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);

		List<CompanyProrataGetAllRes> res = prorataService.getallComapnyProrata(req);
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

	// Get Active Branch Master

	@PostMapping("/getactivecompanyprorata")
	@ApiOperation("This method is get Active Branch Details")
	public ResponseEntity<CommonRes> getActiveCompanyProrataes(@RequestBody CompanyProrataGetAllReq req) {
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);

		List<CompanyProrataGetAllRes> res = prorataService.getActiveCompanyProrata(req);
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

	// Get By Branch Id

	@PostMapping("/getbycompanyprorataid")
	@ApiOperation("This Method is to get by Branch id")
	public ResponseEntity<CommonRes> getByCompanyProrata(@RequestBody CompanyProrataGetReq req) {
		CommonRes data = new CommonRes();
		CompanyProrataGetRes res = prorataService.getByCompanyProrata(req);
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

	@PostMapping("/companyporata/changestatus")
	@ApiOperation(value = "This method is Branch Change Status")
	public ResponseEntity<CommonRes> changeStatusOfProrata(@RequestBody CompanyProrataChangeStatusReq req) {

		CommonRes data = new CommonRes();
		// Change Status
		SuccessRes res = prorataService.changeStatusOfProrata(req);
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
