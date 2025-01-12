/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:54 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service;
import java.util.List;

import com.maan.eway.master.req.ProductSectionsGetReq;
import com.maan.eway.master.req.SectionMasterChangeStatusReq;
import com.maan.eway.master.req.SectionMasterGetReq;
import com.maan.eway.master.req.SectionMasterSaveReq;
import com.maan.eway.master.res.ProductSectionGetRes;
import com.maan.eway.master.res.SectionMasterRes;
import com.maan.eway.res.SuccessRes;
/**
* <h2>SessionMasterServiceimpl</h2>
*/
public interface SectionMasterService  {

	List<String> validateSectionDetails(SectionMasterSaveReq req);

	SectionMasterRes getBySectionId(SectionMasterGetReq req);

	SuccessRes insertSection(SectionMasterSaveReq req);

	List<SectionMasterRes> getallSectionDetails();

	List<SectionMasterRes> getActiveSectionDetails();

	List<ProductSectionGetRes> getProductSections(ProductSectionsGetReq req);

	SuccessRes changeStatusOfSection(SectionMasterChangeStatusReq req);


}
