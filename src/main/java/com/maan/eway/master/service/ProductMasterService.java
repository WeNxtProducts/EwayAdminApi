/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;


import java.util.List;

import com.maan.eway.master.req.ProductChangeStatusReq;
import com.maan.eway.master.req.ProductMasterGetAllReq;
import com.maan.eway.master.req.ProductMasterGetReq;
import com.maan.eway.master.req.ProductMasterSaveReq;
import com.maan.eway.master.res.ProductGetAllRes;
import com.maan.eway.master.res.ProductMasterRes;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>BankMasterServiceimpl</h2>
*/
public interface ProductMasterService  {

	List<String> validateProductDetails(ProductMasterSaveReq req);

	SuccessRes insertProduct(ProductMasterSaveReq req);

	List<ProductGetAllRes> getallProductDetails(ProductMasterGetAllReq req);

	List<ProductGetAllRes> getActiveProductDetails(ProductMasterGetAllReq req);

	ProductMasterRes getByProductCode(ProductMasterGetReq req);

	List<DropDownRes> getProductMasterDropdown();

	SuccessRes changeStatusOfProduct(ProductChangeStatusReq req);


}
