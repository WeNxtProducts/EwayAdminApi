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

import com.maan.eway.common.res.CommonRes;
import com.maan.eway.common.service.impl.FetchErrorDescServiceImpl;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.GetPolicyTypesubcoverReq;
import com.maan.eway.master.req.PolicyTypeMasterSubCoverSingleSaveReq;
import com.maan.eway.master.req.PolicyTypeSubCoverMasterGetAllReq;
import com.maan.eway.master.res.PolicyTypeSubCoverMasterGetRes;
import com.maan.eway.master.service.PolicyTypeMasterSubCoverService;
import com.maan.eway.req.CommonErrorModuleReq;
import com.maan.eway.res.SuccessRes2;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="MASTER : Policy Type Master Sub Cover", description = "API's")
@RequestMapping("/master")
public class PolicyTypeMasterSubCoverController {
	
	@Autowired
	private PolicyTypeMasterSubCoverService service;
	
	@Autowired
	private PrintReqService reqPrinter;
	
	@Autowired
	private FetchErrorDescServiceImpl errorDescService ;
	
//	@PostMapping("/insertpolicytypesubcover")
//	@ApiOperation("This method is to save Policy Type Master Sub Cover")
//	public ResponseEntity<CommonRes> insertPolicyTypeSubCover(@RequestBody PolicyTypeMasterSubCoverSaveReq req){
//		CommonRes data = new CommonRes();
//		reqPrinter.reqPrint(req);
//		
//		List<Error> validation = service.validatePolicyTypeSubCover(req);
//		//Validation
//		if(validation!=null && validation.size()!=0) {
//		data.setCommonResponse(null);
//		data.setErrorMessage(validation);
//		data.setMessage("Failed");
//		return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
//
//		}
//		else {
//		SuccessRes2 res = service.insertPolicyTypeSubCover(req);
//		data.setCommonResponse(res);
//		data.setErrorMessage(Collections.emptyList());
//		data.setIsError(false);
//		data.setMessage("Success");
//		
//		if(res!=null) {
//			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
//		}
//		else {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		}
//		
//		}
//	}
	
	@PostMapping("/insertpolicytypesubcover") //single
	@ApiOperation("This method is to save Policy Type Master Sub Cover")
	public ResponseEntity<CommonRes> insertPolicyTypeSubCover(@RequestBody PolicyTypeMasterSubCoverSingleSaveReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<String> validationCodes = service.validatePolicyTypeSubCover(req);
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
		//Validation
		if(validation!=null && validation.size()!=0) {
		data.setCommonResponse(null);
		data.setErrorMessage(validation);
		data.setMessage("Failed");
		return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

		}
		else {
		SuccessRes2 res = service.insertPolicyTypeSubCover(req);
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
	
	
	@PostMapping("/getallpolicytypesubcover")
	@ApiOperation("This method is to get all Policy Type Sub Cover Master ")
	public ResponseEntity<CommonRes> getallPolicyTypesubcover(@RequestBody PolicyTypeSubCoverMasterGetAllReq req){
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);
		List<PolicyTypeSubCoverMasterGetRes> res = service.getallPolicyTypesubcover(req);
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
	
	
	@PostMapping("/getpolicytypesubcover")
	@ApiOperation("This method is to get One Policy Type Sub Cover")
	public ResponseEntity<CommonRes> getPolicyTypesubcover(@RequestBody GetPolicyTypesubcoverReq req){
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);
		PolicyTypeSubCoverMasterGetRes res = service.getPolicyTypesubcover(req);
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
