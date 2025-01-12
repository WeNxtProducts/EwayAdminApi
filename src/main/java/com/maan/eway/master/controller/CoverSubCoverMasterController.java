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

import com.maan.eway.error.Error;
import com.maan.eway.master.req.CompanyChangeStatusReq;
import com.maan.eway.master.req.CoverSubCoverChangeStatusReq;
import com.maan.eway.master.req.CoverSubCoverMasterGetAllReq;
import com.maan.eway.master.req.CoverSubCoverMasterGetReq;
import com.maan.eway.master.req.CoverSubCoverMasterSaveReq;
import com.maan.eway.master.req.SectionCoverUpdateReq;
import com.maan.eway.master.req.SubCoverDropDownReq;
import com.maan.eway.master.req.SubCoverGetAllReq;
import com.maan.eway.master.req.SubCoverMasterGetAllReq;
import com.maan.eway.master.req.SubCoverMasterGetReq;
import com.maan.eway.master.req.SubCoverUpdatedReq;
import com.maan.eway.master.res.CoverMasterRes;
import com.maan.eway.master.res.CoverSubCoverGetRes;
import com.maan.eway.master.res.SubCoverMasterGetAllRes;
import com.maan.eway.master.res.SubCoverMasterGetRes;
import com.maan.eway.master.res.SubCoverMasterRes;
import com.maan.eway.master.service.CoverSubCoverMasterService;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.DropdownCommonRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
* <h2>SectionMasterController</h2>
*/
@RestController
@RequestMapping("/master")
@Api(tags = "2. COMPANY CONFIG : SubCover Master ", description = "API's")
public class CoverSubCoverMasterController {

	@Autowired
	private  CoverSubCoverMasterService service;

	@Autowired
	private  PrintReqService reqPrinter;
	
	// save
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/insertcoversubcover")
		@ApiOperation(value = "This method is Insert CoverSubcover")
		public ResponseEntity<CommonRes> insertSubCover(@RequestBody List<CoverSubCoverMasterSaveReq> req) {

			reqPrinter.reqPrint(req);
			CommonRes data = new CommonRes();
			List<Error> validation = service.validateSubCover(req);
			// validation
			if (validation != null && validation.size() != 0) {
				data.setCommonResponse(null);
				data.setIsError(true);
				data.setErrorMessage(validation);
				data.setMessage("Failed");
				return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

			} else {

				// Get All
				SuccessRes res = service.insertSubCover(req);
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

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
		@PostMapping("/getallcoversubcoverdetails")
		@ApiOperation("This method is getall Section Cover Details")
		public ResponseEntity<CommonRes> getallCoverSubCoverDetails(@RequestBody CoverSubCoverMasterGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<CoverSubCoverGetRes> res = service.getallCoverSubCoverDetails(req);
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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
		@PostMapping("/getactivecoversubcoverdetails")
		@ApiOperation("This method is getall Section Cover Details")
		public ResponseEntity<CommonRes> getActiveCoverSubCoverDetails(@RequestBody CoverSubCoverMasterGetAllReq req)
		{
			CommonRes data = new CommonRes();
			reqPrinter.reqPrint(req);
			
			List<CoverSubCoverGetRes> res = service.getActiveCoverSubCoverDetails(req);
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
		
		// Get By Section Id
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/getbycoversubcover")
		@ApiOperation("This Method is to get by Sub Cover Id")
		public ResponseEntity<CommonRes> getBySubCoverId(@RequestBody CoverSubCoverMasterGetReq req)
		{
		CommonRes data = new CommonRes();
		CoverSubCoverGetRes res = service.getByCoverSubCoverId(req);
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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER','ROLE_USER')")
		@PostMapping("/getallnonselectedcoversubcover")
		@ApiOperation("This method is getall SubCover")
		public ResponseEntity<CommonRes> getallNonSelectedSubCover(@RequestBody CoverSubCoverMasterGetAllReq req)
		{
			CommonRes data = new CommonRes();
			
			List<SubCoverMasterGetRes> res =service.getallNonSelectedSubCover(req);
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
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping("/coversubcover/changestatus")
		@ApiOperation(value = "This method is get Company Change Status")
		public ResponseEntity<CommonRes> changeStatusOfCoverSubCover(@RequestBody CoverSubCoverChangeStatusReq req) {

			CommonRes data = new CommonRes();
			// Change Status
			SuccessRes res = service.changeStatusOfCoverSubCover(req);
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
		@PostMapping("/updatecoversubcover")
		@ApiOperation(value = "This method is Update Section  Cover Details")
		public ResponseEntity<CommonRes> updateSectionCover(@RequestBody SubCoverUpdatedReq req) {

			reqPrinter.reqPrint(req);
			CommonRes data = new CommonRes();

			List<Error> validation = service.validateUpdatingSubCover(req);
			// validation
			if (validation != null && validation.size() != 0) {
				data.setCommonResponse(null);
				data.setIsError(true);
				data.setErrorMessage(validation);
				data.setMessage("Failed");
				return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

			} else {

				// Save
				SuccessRes res = service.updateSubCover(req);
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
		
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
		@PostMapping(value="/dropdown/subcover",produces = "application/json")
		@ApiOperation(value="This method is to get dropdown")
		public ResponseEntity<DropdownCommonRes> subcoverDropDown(@RequestBody SubCoverDropDownReq req){
			DropdownCommonRes data = new DropdownCommonRes();
			List<DropDownRes> res = service.subcoverDropDown(req);
			reqPrinter.reqPrint(req);
			data.setCommonResponse(res);
			data.setErrorMessage(Collections.emptyList());
			data.setIsError(false);
			data.setMessage("Success");
			if(res!=null) {
				return new ResponseEntity<DropdownCommonRes>(data, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}
}
