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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.common.service.impl.FetchErrorDescServiceImpl;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.DocumentChangeStatusReq;
import com.maan.eway.master.req.DocumentMasterGetReq;
import com.maan.eway.master.req.DocumentMasterSaveReq;
import com.maan.eway.master.req.LovDropDownReq;
import com.maan.eway.master.res.DocumentMasterGetRes;
import com.maan.eway.master.service.DocumentMasterService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.DropdownCommonRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;
import com.maan.eway.service.impl.BasicValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>SectionMasterController</h2>
*/
@RestController
@RequestMapping("/master")
@Api(tags = "1. GLOBAL CONFIG : Document Master ", description = "API's")
public class DocumentMasterController {

	@Autowired
	private  DocumentMasterService documentservice;

	@Autowired
	private  PrintReqService reqPrinter;
	
	@Autowired
	private BasicValidationService basicvalidateService;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;

	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/insertdocument")
		@ApiOperation(value = "This method is Insert Document Master")
		public ResponseEntity<CommonRes> insertDocument(@RequestBody DocumentMasterSaveReq req) {

		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = documentservice.validateDocument(req);
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
				SuccessRes res = documentservice.insertDocument(req);
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
		@GetMapping("/getalldocuments")
		@ApiOperation("This method is getall Documents")
		public ResponseEntity<CommonRes> getallDocuments()
		{
			CommonRes data = new CommonRes();
			
			List<DocumentMasterGetRes> res =documentservice.getallDocuments();
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
		@PostMapping("/getbydocument")
		@ApiOperation("This Method is to get by Document Id")
		public ResponseEntity<CommonRes> getByDocumentId(@RequestBody DocumentMasterGetReq req)
		{
		CommonRes data = new CommonRes();
		DocumentMasterGetRes res = documentservice.getByDocumentId(req);
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
		@GetMapping("/getactivedocument")
		@ApiOperation("This Method is to Get Active Documents")
		public ResponseEntity<CommonRes> getActiveDocument()
		{
			CommonRes data = new CommonRes();
			List<DocumentMasterGetRes> res = documentservice.getActiveDocument();
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
		@PostMapping(value="/dropdown/document",produces = "application/json")
		@ApiOperation(value="This Method is to Drop Down Document")
		public ResponseEntity<DropdownCommonRes> getDocumentDropdown(@RequestBody LovDropDownReq req)
		{
			DropdownCommonRes data = new DropdownCommonRes();
			List<DropDownRes> res = documentservice.getDocumentDropDown(req);
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
		@PostMapping("/document/changestatus")
		@ApiOperation(value = "This method is  Change Status of Documents")
		public ResponseEntity<CommonRes> changeStatusOfDocument(@RequestBody DocumentChangeStatusReq req) {

			CommonRes data = new CommonRes();
			// Change Status
			SuccessRes res = documentservice.changeStatusOfDocument(req);
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
