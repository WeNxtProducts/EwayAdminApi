/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.ProductSequenceMaster;
import com.maan.eway.master.req.ProductSequenceDropDownReq;
import com.maan.eway.master.req.ProductSequenceMasterChangeStatusReq;
import com.maan.eway.master.req.ProductSequenceMasterGetAllReq;
import com.maan.eway.master.req.ProductSequenceMasterGetReq;
import com.maan.eway.master.req.ProductSequenceMasterSaveReq;
import com.maan.eway.master.res.ProductSequenceMasterRes;
import com.maan.eway.master.service.ProductSequenceMasterService;
import com.maan.eway.repository.ProductSequenceMasterRepository;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.impl.BasicValidationService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

@Service
@Transactional
public class ProductSequenceMasterServiceImpl implements ProductSequenceMasterService {

@PersistenceContext
private EntityManager em;

@Autowired
private ProductSequenceMasterRepository repo;

@Autowired
private BasicValidationService basicvalidateService;

Gson json = new Gson();

private Logger log=LogManager.getLogger(ProductSequenceMasterServiceImpl.class);


	
@Override
public List<String> validateProductSequence(ProductSequenceMasterSaveReq req) {
	List<String> errorList = new ArrayList<String>();

	try {
		if(StringUtils.isBlank(req.getBranchCode()) ) {
		//	errorList.add(new Error("01", "BranchCode", "Please Select BranchCode"));
			errorList.add("1256");
			
		} 
		if(StringUtils.isBlank(req.getInsuranceId()) ) {
		//	errorList.add(new Error("01", "InsuranceId", "Please Select company"));
			errorList.add("1255");
		} 
		if(StringUtils.isBlank(req.getProductId()) ) {
		//	errorList.add(new Error("01", "ProductId", "Please Select ProductId"));
			errorList.add("1313");
		}
		
		if (StringUtils.isBlank(req.getType())) {
		//	errorList.add(new Error("02", "Type ", "Please select Type"));
			errorList.add("1851");
			
		} else if (StringUtils.isBlank(req.getSequenceId()) &&  StringUtils.isNotBlank(req.getInsuranceId()) && StringUtils.isNotBlank(req.getBranchCode())
					&& StringUtils.isNotBlank(req.getProductId()) ) {
			
			List<ProductSequenceMaster> oldList = getSeqTypeNameExistDetails(req.getType() , req.getProductId() , req.getInsuranceId() ,req.getBranchCode() );
			if (oldList.size()>0 ) {
		//		errorList.add(new Error("01", "SequenceType", "This Sequence Type Already Exist "));
				errorList.add("1852");
			}
		}else if (StringUtils.isNotBlank(req.getSequenceId()) &&  StringUtils.isNotBlank(req.getInsuranceId()) && StringUtils.isNotBlank(req.getBranchCode())
				&& StringUtils.isNotBlank(req.getProductId()) ) {
			List<ProductSequenceMaster> oldList = getSeqTypeNameExistDetails(req.getType() , req.getProductId() , req.getInsuranceId() ,req.getBranchCode() );
			
			if (oldList.size()>0 &&  (! req.getSequenceId().equalsIgnoreCase(oldList.get(0).getSequenceId().toString())) ) {
			//	errorList.add(new Error("01", "SequenceType", "This Sequence Type  Already Exist "));
				errorList.add("1852");
			}
			
		}
		
		if(StringUtils.isBlank(req.getProductId()) ) {
		//	errorList.add(new Error("01", "ProductId", "Please Select ProductId"));
			errorList.add("1313");
		}
	
		if(StringUtils.isBlank(req.getSequenceCharacter()) ) {
		//	errorList.add(new Error("01", "SequenceCharacter", "Please Enter Sequence Character"));
			errorList.add("1853");
		}
		
		if(StringUtils.isBlank(req.getCurrentSequenceNo()) ) {
		//	errorList.add(new Error("01", "CurrentSequenceNo", "Please Enter Current Sequence No"));
			errorList.add("1854");
			
		} else if(! req.getCurrentSequenceNo().matches("[0-9]+") ) {
	//		errorList.add(new Error("01", "CurrentSequenceNo", "Please Enter Valid Number in Current Sequence No"));
			errorList.add("1855");
			

		}  else if( req.getCurrentSequenceNo().length() > 20 ) {
			//errorList.add(new Error("01", "CurrentSequenceNo", " Current Sequence No Max 20 digits only allowed"));
			errorList.add("1952");

		}  else if( req.getCurrentSequenceNo().length() > 8 ) {
		//	errorList.add(new Error("01", "CurrentSequenceNo", " Current Sequence No Max 8 digits only allowed"));
			errorList.add("1856");

		}
		
		if(StringUtils.isBlank(req.getQueryYn()) ) {
		//	errorList.add(new Error("01", "QueryYn", "Please Select Query Condition"));
			errorList.add("1857");
		}
			
		// Date Validation 
		Calendar cal = new GregorianCalendar();
		Date today = new Date();
		cal.setTime(today);cal.add(Calendar.DAY_OF_MONTH, -1);;
		today = cal.getTime();
		if (req.getEffectiveDateStart() == null || StringUtils.isBlank(req.getEffectiveDateStart().toString())) {
		//	errorList.add(new Error("05", "EffectiveDateStart", "Please Enter Effective Date Start"));
			errorList.add("1261");

		} else if (req.getEffectiveDateStart().before(today)) {
		//	errorList.add(new Error("05", "EffectiveDateStart", "Please Enter Effective Date Start as Future Date"));
			errorList.add("1262");
		}
		//Status Validation
		if (StringUtils.isBlank(req.getStatus())) {
	//		errorList.add(new Error("05", "Status", "Please Select Status  "));
			errorList.add("1263");
		} else if (req.getStatus().length() > 1) {
		//	errorList.add(new Error("05", "Status", "Please Select Valid Status - One Character Only Allwed"));
			errorList.add("1264");
		}else if(!("Y".equalsIgnoreCase(req.getStatus())||"N".equalsIgnoreCase(req.getStatus())||"R".equalsIgnoreCase(req.getStatus())|| "P".equalsIgnoreCase(req.getStatus()))) {
		//	errorList.add(new Error("05", "Status", "Please Select Valid Status - Active or Deactive or Pending or Referral "));
			errorList.add("1265");
		}

		
		if (StringUtils.isBlank(req.getCreatedBy())) {
		//	errorList.add(new Error("09", "CreatedBy", "Please Select CreatedBy"));
			errorList.add("1270");
		}else if (req.getCreatedBy().length() > 100){
		//	errorList.add(new Error("09","CreatedBy", "Please Enter CreatedBy within 100 Characters")); 
			errorList.add("1271");
		}		
	} catch (Exception e) {
		log.error(e);
		e.printStackTrace();
	}
	return errorList;
}

	
	@Override
	public SuccessRes insertProductSequence(ProductSequenceMasterSaveReq req) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SuccessRes res = new SuccessRes();
		ProductSequenceMaster saveData = new ProductSequenceMaster();
		List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			Integer amendId=0;
			Date startDate = req.getEffectiveDateStart() ;
			String end = "31/12/2050";
			Date endDate = sdf.parse(end);
			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
			Date entryDate = null ;
			String createdBy = "" ;
			String currentGeneratedSequence = "" ;
			Integer sequenceId =Integer.valueOf(req.getType());
//			if(StringUtils.isBlank(req.getSequenceId())) {
//				// Save
//				Integer totalCount = getMasterTableCount( req.getInsuranceId() ,req.getProductId() , req.getBranchCode());
//				sequenceId =  totalCount+1 ;
//				entryDate = new Date();
//				createdBy = req.getCreatedBy();
//				res.setResponse("Saved Successfully");
//				res.setSuccessId(sequenceId.toString());
//			}
//			else {
				// Update
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);
				//Find all
				Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);
				//Select 
				query.select(b);
//					
				// Order By
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(cb.desc(b.get("amendId")));
				
				// Where
				Predicate n1 = cb.equal(b.get("sequenceId"), sequenceId);
				Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
				Predicate n3 = cb.equal(b.get("branchCode"), req.getBranchCode());
				Predicate n4 = cb.equal(b.get("productId"),  req.getProductId());
				
				query.where(n1,n2,n3,n4).orderBy(orderList);
				
				// Get Result 
				TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
				int limit = 0 , offset = 2 ;
				result.setFirstResult(limit * offset);
				result.setMaxResults(offset);
				list = result.getResultList();
				
				if(list.size()>0) {
					Date beforeOneDay = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
				
					if ( list.get(0).getEffectiveDateStart().before(beforeOneDay)  ) {
						amendId = list.get(0).getAmendId() + 1 ;
						entryDate = new Date() ;
						createdBy = req.getCreatedBy();
						currentGeneratedSequence = "" ;
						ProductSequenceMaster lastRecord = list.get(0);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						
					} else {
						amendId = list.get(0).getAmendId() ;
						entryDate = list.get(0).getEntryDate() ;
						createdBy = list.get(0).getCreatedBy();
						saveData = list.get(0) ;
						currentGeneratedSequence = list.get(0).getCurrentGeneratedSequence() ;
						if (list.size()>1 ) {
							ProductSequenceMaster lastRecord = list.get(1);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						}
					
				    }
				}
				res.setResponse("Updated Successfully");
				res.setSuccessId(sequenceId.toString());
			
			dozerMapper.map(req, saveData);
			saveData.setSequenceId(sequenceId);
			saveData.setEffectiveDateStart(startDate);
			saveData.setEffectiveDateEnd(endDate);
			saveData.setCreatedBy(createdBy);
			saveData.setStatus(req.getStatus());
			saveData.setCompanyId(req.getInsuranceId());
			saveData.setEntryDate(entryDate);
			saveData.setUpdatedDate(new Date());
			saveData.setUpdatedBy(req.getCreatedBy());
			saveData.setAmendId(amendId);
			saveData.setCurrentGeneratedSequence(currentGeneratedSequence);
			saveData.setSequenceNoApplyYn(StringUtils.isBlank(req.getSequenceNoApplyYn())?"Y" :req.getSequenceNoApplyYn() ) ;
			// Type Desc
			String seqTypeDesc = getListItem (req.getInsuranceId() , req.getBranchCode() ,"SEQUENCE_TYPE",req.getType() ); 
			saveData.setTypeDesc(seqTypeDesc);
			repo.saveAndFlush(saveData);
			log.info("Saved Details is --> " + json.toJson(saveData));
			
			}
		catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --> "+ e.getMessage());
			return null;
		}
		return res;
		}
	
	public synchronized String getListItem(String insuranceId , String branchCode, String itemType, String itemCode) {
		String itemDesc = "" ;
		List<ListItemValue> list = new ArrayList<ListItemValue>();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			today = cal.getTime();
			Date todayEnd = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ListItemValue> query=  cb.createQuery(ListItemValue.class);
			// Find All
			Root<ListItemValue> c = query.from(ListItemValue.class);
			
			//Select
			query.select(c);
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("branchCode")));
			
			
			// Effective Date Start Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<ListItemValue> ocpm1 = effectiveDate.from(ListItemValue.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("itemId"),ocpm1.get("itemId"));
			Predicate b3 = cb.equal(c.get("branchCode"),ocpm1.get("branchCode"));
			Predicate b4 = cb.equal(c.get("companyId"),ocpm1.get("companyId"));
			Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			effectiveDate.where(a1,a2,b3,b4);
			// Effective Date End Max Filter
			Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
			Root<ListItemValue> ocpm2 = effectiveDate2.from(ListItemValue.class);
			effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
			Predicate a3 = cb.equal(c.get("itemId"),ocpm2.get("itemId"));
			Predicate b1 = cb.equal(c.get("branchCode"),ocpm2.get("branchCode"));
			Predicate b2 = cb.equal(c.get("companyId"),ocpm2.get("companyId"));
			Predicate a4 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			effectiveDate2.where(a3,a4,b1,b2);
						
			// Where
			Predicate n1 = cb.equal(c.get("status"),"Y");
			Predicate n12 = cb.equal(c.get("status"),"R");
			Predicate n13 = cb.or(n1,n12);
			Predicate n2 = cb.equal(c.get("effectiveDateStart"),effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"),effectiveDate2);	
			//Predicate n4 = cb.equal(c.get("companyId"), insuranceId);
			Predicate n5 = cb.equal(c.get("companyId"), "99999");
		//	Predicate n6 = cb.equal(c.get("branchCode"), branchCode);
			Predicate n7 = cb.equal(c.get("branchCode"), "99999");
			//Predicate n8 = cb.or(n4,n5);
			//Predicate n9 = cb.or(n6,n7);
			Predicate n10 = cb.equal(c.get("itemType"),itemType );
			Predicate n11 = cb.equal(c.get("itemCode"), itemCode);
			
			query.where(n13,n2,n3,n5,n7,n10,n11).orderBy(orderList);
			
		
			// Get Result
			TypedQuery<ListItemValue> result = em.createQuery(query);
			list = result.getResultList();
			
			itemDesc = list.size() > 0 ? list.get(0).getItemValue() : "" ; 
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return itemDesc ;
	}
	
	@Override
	public List<ProductSequenceMasterRes> getallProductSequence(ProductSequenceMasterGetAllReq req) {
		List<ProductSequenceMasterRes> resList = new ArrayList<ProductSequenceMasterRes>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		try {
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
		
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);

			// Find All
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);

			// Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"),b.get("branchCode"));
			Predicate a5 = cb.equal(  ocpm1.get("productId"),b.get("productId"));
			amendId.where(a1, a2,a3,a5);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("amendId")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
			Predicate n3 = cb.equal(b.get("productId"),  req.getProductId());
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			query.where(n1,n2,n3,n4).orderBy(orderList);
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();
			// Map
			for (ProductSequenceMaster data : list) {
				ProductSequenceMasterRes res = new ProductSequenceMasterRes();

				res = mapper.map(data, ProductSequenceMasterRes.class);
				resList.add(res);
			}
			resList.sort( Comparator.comparing(ProductSequenceMasterRes :: getType  ));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return resList;
	}
	
	@Override
	public List<ProductSequenceMasterRes> getActiveProductSequence(ProductSequenceMasterGetAllReq req) {
		List<ProductSequenceMasterRes> resList = new ArrayList<ProductSequenceMasterRes>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		try {
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
		
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);

			// Find All
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);

			// Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"),b.get("branchCode"));
			Predicate a5 = cb.equal(  ocpm1.get("productId"),b.get("productId"));
			amendId.where(a1, a2,a3,a5);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("amendId")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
			Predicate n3 = cb.equal(b.get("productId"),  req.getProductId());
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			query.where(n1,n2,n3,n4).orderBy(orderList);
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();
			// Map
			for (ProductSequenceMaster data : list) {
				ProductSequenceMasterRes res = new ProductSequenceMasterRes();

				res = mapper.map(data, ProductSequenceMasterRes.class);
				resList.add(res);
			}
			resList.sort( Comparator.comparing(ProductSequenceMasterRes :: getType  ));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return resList;
	}
	
	@Override
	public ProductSequenceMasterRes getByProductSequenceId(ProductSequenceMasterGetReq req) {
		ProductSequenceMasterRes res = new ProductSequenceMasterRes();
		DozerBeanMapper mapper = new DozerBeanMapper();
		try {
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
		
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);

			// Find All
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);

			// Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"),b.get("branchCode"));
			Predicate a5 = cb.equal(  ocpm1.get("productId"),b.get("productId"));
			amendId.where(a1, a2,a3,a5);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("amendId")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
			Predicate n3 = cb.equal(b.get("productId"),  req.getProductId());
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			Predicate n5 = cb.equal(b.get("sequenceId"), req.getSequenceId());
			query.where(n1,n2,n3,n4,n5).orderBy(orderList);
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();
			res = mapper.map(list.get(0), ProductSequenceMasterRes.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}
	
	@Override
	public List<DropDownRes> getProductSequenceMasterDropdown(ProductSequenceDropDownReq req) {
		List<DropDownRes> resList = new ArrayList<DropDownRes>();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			;
			cal.set(Calendar.MINUTE, 1);
			today = cal.getTime();
			cal.set(Calendar.HOUR_OF_DAY, 1);
			cal.set(Calendar.MINUTE, 1);
			Date todayEnd = cal.getTime();

			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
			// Find All
			Root<ProductSequenceMaster> c = query.from(ProductSequenceMaster.class);
			// Select
			query.select(c);
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("branchCode")));

			// Effective Date Start Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<ProductSequenceMaster> ocpm1 = effectiveDate.from(ProductSequenceMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("sequenceId"), ocpm1.get("sequenceId"));
			Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			Predicate a3 = cb.equal(c.get("companyId"), ocpm1.get("companyId"));
			Predicate a4 = cb.equal(c.get("branchCode"), ocpm1.get("branchCode"));
			Predicate a6 = cb.equal(c.get("productId"), ocpm1.get("productId"));
			effectiveDate.where(a1, a2,a3,a4,a6);
			
			// Effective Date End Max Filter
			Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
			Root<ProductSequenceMaster> ocpm2 = effectiveDate2.from(ProductSequenceMaster.class);
			effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
			Predicate a7 = cb.equal(c.get("sequenceId"), ocpm2.get("sequenceId"));
			Predicate a8 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			Predicate a9 = cb.equal(c.get("companyId"), ocpm2.get("companyId"));
			Predicate a10 = cb.equal(c.get("branchCode"), ocpm2.get("branchCode"));
			Predicate a12 = cb.equal(c.get("productId"),  ocpm2.get("productId"));
			effectiveDate2.where(a7,a8,a9,a10,a12);
			
			// Where
			Predicate n1 = cb.equal(c.get("status"),"Y");
			Predicate n11 = cb.equal(c.get("status"),"R");
			Predicate n12 = cb.or(n1,n11);
			Predicate n2 = cb.equal(c.get("effectiveDateStart"), effectiveDate);
			Predicate n3 = cb.equal(c.get("effectiveDateEnd"), effectiveDate2);
			Predicate n4 = cb.equal(c.get("productId"), req.getProductId());
			Predicate n5 = cb.equal(c.get("companyId"), req.getInsuranceId());
			Predicate n6 = cb.equal(c.get("branchCode"), req.getBranchCode());
			
			query.where(n12,n2,n3,n4,n5,n6).orderBy(orderList);
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();
			
			for (ProductSequenceMaster data : list) {
				// Response 
				DropDownRes res = new DropDownRes();
				res.setCode(data.getSequenceId().toString());
				res.setCodeDesc(data.getTypeDesc());
				res.setStatus(data.getStatus());
				resList.add(res);
			}
		} catch(Exception e) {
				e.printStackTrace();
				log.info("Exception is --->"+e.getMessage());
				return null;
				}
			return resList;
		}
	
	@Override
	public SuccessRes changeStatusOfProductSequenceMaster(ProductSequenceMasterChangeStatusReq req) {
		SuccessRes res = new SuccessRes();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
			
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);
			// Find all
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);
			//Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"),b.get("branchCode"));
			Predicate a4 = cb.equal(  ocpm1.get("productId"),b.get("productId"));
			amendId.where(a1, a2,a3,a4);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("amendId")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
			Predicate n3 = cb.equal(b.get("productId"),  req.getProductId());
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			Predicate n5 = cb.equal(b.get("sequenceId"), req.getSequenceId());
			
			query.where(n1,n2,n3,n4,n5).orderBy(orderList);
			
			// Get Result 
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();
			ProductSequenceMaster updateRecord = list.get(0);
			updateRecord.setStatus(req.getStatus());
			repo.save(updateRecord);
			
			// Perform Update
			res.setResponse("Status Changed");
			res.setSuccessId(req.getSequenceId());
		}
		catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --> " + e.getMessage());
			return null;
			}
		return res;
	}

	public List<ProductSequenceMaster> getSeqTypeNameExistDetails(String type , String productId ,String insuranceId , String branchCode) {
		List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
		try {
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);

			// Find All
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);

			// Select
			query.select(b);

			// Effective Date Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
			Predicate a4 = cb.equal(ocpm1.get("productId"), b.get("productId"));
			amendId.where(a1,a2,a3,a4);

			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal( b.get("type"), type);
			Predicate n3 = cb.equal(b.get("companyId"),insuranceId);
			Predicate n4 = cb.equal(b.get("branchCode"), branchCode);
			Predicate n5 = cb.equal(b.get("productId"), productId);
			query.where(n1,n2,n3,n4,n5);
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			list = result.getResultList();		
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());

		}
		return list;
	}
	
	public Integer getMasterTableCount(String companyId ,String productId , String branchCode) {
		Integer data =0;
		try {
			List<ProductSequenceMaster> list = new ArrayList<ProductSequenceMaster>();
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSequenceMaster> query = cb.createQuery(ProductSequenceMaster.class);
		// Find all
			Root<ProductSequenceMaster> b = query.from(ProductSequenceMaster.class);
			//Select 
			query.select(b);

			//Effective Date Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<ProductSequenceMaster> ocpm1 = amendId.from(ProductSequenceMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sequenceId"), b.get("sequenceId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
			Predicate a4 = cb.equal(ocpm1.get("productId"), b.get("productId"));
			amendId.where(a1,a2,a3,a4);
			
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("sequenceId")));
			
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), companyId);
			Predicate n3 = cb.equal(b.get("branchCode"), branchCode);
			Predicate n4 = cb.equal(b.get("productId"), productId);
			query.where(n1,n2,n3,n4).orderBy(orderList);
			
			
			
			// Get Result
			TypedQuery<ProductSequenceMaster> result = em.createQuery(query);
			int limit = 0 , offset = 1 ;
			result.setFirstResult(limit * offset);
			result.setMaxResults(offset);
			list = result.getResultList();
			data = list.size() > 0 ? list.get(0).getSequenceId() : 0 ;
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return data;
	}

}