/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:27 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;
import java.util.List;

import com.maan.eway.master.req.CompanyChangeStatusReq;
import com.maan.eway.master.req.CompanyDropDownReq;
import com.maan.eway.master.req.InsuranceCompanyMasterGetAllReq;
import com.maan.eway.master.req.InsuranceCompanyMasterGetReq;
import com.maan.eway.master.req.InsuranceCompanyMasterSaveReq;
import com.maan.eway.master.req.SubCoverChangeStatusReq;
import com.maan.eway.master.req.SuperAdminDropDownReq;
import com.maan.eway.master.res.BrokerCompanyRes;
import com.maan.eway.master.res.InsuranceCompanyMasterRes;
import com.maan.eway.bean.InsuranceCompanyMaster;
import com.maan.eway.error.Error;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>InsuranceCompanyMasterServiceimpl</h2>
*/
public interface InsuranceCompanyMasterService  {

InsuranceCompanyMaster create(InsuranceCompanyMaster d);
InsuranceCompanyMaster update(InsuranceCompanyMaster d);
//InsuranceCompanyMaster getOne(long id) ;
 List<InsuranceCompanyMaster> getAll();
long getTotal();
//boolean delete(long id);
List<String> validateCompanySaveReq(InsuranceCompanyMasterSaveReq req);
SuccessRes saveCompanyDetails(InsuranceCompanyMasterSaveReq req);
List<InsuranceCompanyMasterRes> getallInsCompanyDetails(InsuranceCompanyMasterGetAllReq req);
List<InsuranceCompanyMasterRes> getActiveInsCompanyDetails(InsuranceCompanyMasterGetAllReq req);
InsuranceCompanyMasterRes getByCompanyId(InsuranceCompanyMasterGetReq req);
List<DropDownRes> getInscompanyMasterDropdown(CompanyDropDownReq req);
SuccessRes changeStatusOfCompany(CompanyChangeStatusReq req);
List<DropDownRes> getSuperAdminCompanies(SuperAdminDropDownReq req);

}
