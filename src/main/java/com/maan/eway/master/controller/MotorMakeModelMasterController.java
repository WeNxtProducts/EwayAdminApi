package com.maan.eway.master.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.error.Error;
import com.maan.eway.master.req.MotorColorGetAllReq;
import com.maan.eway.master.req.MotorColorGetReq;
import com.maan.eway.master.req.MotorColorSaveReq;
import com.maan.eway.master.req.MotorMakeModelGetAllReq;
import com.maan.eway.master.req.MotorMakeModelGetReq;
import com.maan.eway.master.req.MotorMakeModelSaveReq;
import com.maan.eway.master.res.MotorColorGetRes;
import com.maan.eway.master.res.MotorMakeModelGetRes;
import com.maan.eway.master.service.MotorMakeModelMasterService;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "MASTER : Motor MakeModel Master ", description = "API's")
@RequestMapping("/master")
public class MotorMakeModelMasterController {

	@Autowired
	private MotorMakeModelMasterService service;
	@Autowired
	private PrintReqService reqPrinter;
	// Insert
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/savemakemodel")
	@ApiOperation(value = "This method is Save Motor Make Model")

	public ResponseEntity<CommonRes> saveMotorMakeModel(@RequestBody MotorMakeModelSaveReq req) {
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<Error> validation = service.validateMotorMakeModel(req);
		//// validation
		if (validation != null && validation.size() != 0) {
			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);

		} else {
			/////// save

			SuccessRes res = service.saveMotorMakeModel(req);
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

	// Get By Make Id

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getmotormakemodel")
	@ApiOperation(value = "This method is get by Motor Model")

	public ResponseEntity<CommonRes> getMotorMakeModel(@RequestBody MotorMakeModelGetReq req) {
		CommonRes data = new CommonRes();

		MotorMakeModelGetRes res = service.getMotorMakeModel(req);
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

	// Get All
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_APPROVER')")
	@PostMapping("/getallmotormakemodel")
	@ApiOperation(value = "This method is Get all Motor Make Model ")

	public ResponseEntity<CommonRes> getallMotorMakeModel(@RequestBody MotorMakeModelGetAllReq req) {
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();

		// Get All
		List<MotorMakeModelGetRes> res = service.getallMotorMakeModel(req);
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

	// Get All
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_APPROVER')")
	@PostMapping("/getactivemotormakemodel")
	@ApiOperation(value = "This method is Get Active Motor Make MOdel ")

	public ResponseEntity<CommonRes> getactiveMakeModel(@RequestBody MotorMakeModelGetAllReq req) {
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();

		// Get All
		List<MotorColorGetRes> res = service.getactiveMakeModel(req);
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
	/*
	@GetMapping("/dropdown/motormakemodel/{makeid}")
	@ApiOperation(value = "This method is get Motor Make Master Drop Down")

	public ResponseEntity<CommonRes> getMotorMakeModelDropdown(@PathVariable ("makeid") String makeId ) {

		CommonRes data = new CommonRes();

		// Save
		List<DropDownRes> res = service.getMotorMakeModelDropdown(makeId);
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
*/
}