/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-09-02 ( Date ISO 2022-09-02 - Time 18:14:54 )
* Generated by Telosys Tools Generator ( version 3.3.0 )
*/
package com.maan.eway.master.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.maan.eway.bean.SectionMaster;
import com.maan.eway.master.req.ProductSectionsGetReq;
import com.maan.eway.master.req.SectionMasterChangeStatusReq;
import com.maan.eway.master.req.SectionMasterGetReq;
import com.maan.eway.master.req.SectionMasterSaveReq;
import com.maan.eway.master.res.ProductSectionGetRes;
import com.maan.eway.master.res.SectionMasterRes;
import com.maan.eway.master.service.SectionMasterService;
import com.maan.eway.repository.SectionMasterRepository;
import com.maan.eway.res.SuccessRes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

/**
* <h2>SectionMasterServiceimpl</h2>
*/
@Service
@Transactional
public class SectionMasterServiceImpl implements SectionMasterService {

	@Autowired
	private SectionMasterRepository repo;

	@PersistenceContext
	private EntityManager em;

	Gson json = new Gson();

	private Logger log = LogManager.getLogger(SectionMasterServiceImpl.class);

	//************************************************INSERT/UPDATE SECTION DETAILS******************************************************\\
	@Override
	public List<String> validateSectionDetails(SectionMasterSaveReq req) {
	
		List<String> errorList = new ArrayList<String>();
	
		try {
			
			if (StringUtils.isBlank(req.getSectionName())) {
//				errorList.add(new Error("01", "SectionName", "Please Select Section  Name "));
				errorList.add("2053");
				
			}else if (req.getSectionName().length() > 100){
//				errorList.add(new Error("01","SectionName", "Please Enter Section  Name within 100 Characters")); 
				errorList.add("2054");
			}else if (StringUtils.isBlank(req.getSectionId())) {
				List<SectionMaster> sectionList = getSectionNameExistDetails(req.getSectionName());
				if (sectionList.size()>0 ) {
//					errorList.add(new Error("01", "Section", "This Section Name Already Exist "));
					errorList.add("2055");
				}
			}else  {
				List<SectionMaster> sectionList =  getSectionNameExistDetails(req.getSectionName() );
				if (sectionList.size()>0 &&  (! req.getSectionId().equalsIgnoreCase(sectionList.get(0).getSectionId().toString())) ) {
//					errorList.add(new Error("01", "Section", "This Section Name Already Exist "));
					errorList.add("2055");
				}
				
			}

			if (StringUtils.isBlank(req.getRegulatoryCode())) {
//				errorList.add(new Error("03", "RegulatoryCode", "Please Enter RegulatoryCode"));
				errorList.add("2041");
			}else if (req.getRegulatoryCode().length() > 20) {
//				errorList.add(new Error("03", "RegulatoryCode", "Please Enter RegulatoryCode in 20 Character Only"));
				errorList.add("2042");
			}
			
			// Date Validation 
			Calendar cal = new GregorianCalendar();
			Date today = new Date();
			cal.setTime(today);cal.add(Calendar.DAY_OF_MONTH, -1);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 50);
			today = cal.getTime();
			if (req.getEffectiveDateStart() == null ) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start "));
				errorList.add("2034");
	
			} else if (req.getEffectiveDateStart().before(today)) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start as Future Date"));
				errorList.add("2035");
			} 

			//Status Validation
			if (StringUtils.isBlank(req.getStatus())) {
//				errorList.add(new Error("05", "Status", "Please Select Status  "));
				errorList.add("2036");
			} else if (req.getStatus().length() > 1) {
//				errorList.add(new Error("05", "Status", "Please Select Valid Status - One Character Only Allwed"));
				errorList.add("2037");
			}else if(!("Y".equalsIgnoreCase(req.getStatus())||"N".equalsIgnoreCase(req.getStatus())||"R".equalsIgnoreCase(req.getStatus())|| "P".equalsIgnoreCase(req.getStatus()))) {
//				errorList.add(new Error("05", "Status", "Please Select Valid Status - Active or Deactive or Pending or Referral "));
				errorList.add("2038");
			}
			
			if (StringUtils.isBlank(req.getCreatedBy())) {
//				errorList.add(new Error("06", "CreatedBy", "Please Enter CreatedBy"));
				errorList.add("2039");
			}else if (req.getCreatedBy().length() > 20) {
//				errorList.add(new Error("06", "CreatedBy", "Enter CreatedBy in 20 Character Only"));
				errorList.add("2040");
			}
			
			if (StringUtils.isBlank(req.getRemarks())) {
//				errorList.add(new Error("08", "Remarks", "Please Enter Remarks"));
				errorList.add("2032");
			}else if (req.getRemarks().length() > 100) {
//				errorList.add(new Error("08", "Remarks", "Please Enter Remarks within 100 Characters"));
				errorList.add("2033");
			}
			if (StringUtils.isBlank(req.getMotorYn())) {
//				errorList.add(new Error("12", "Product Type", "Please Select Product Type "));
				errorList.add("2056");
			}else if (req.getMotorYn().length() >1) {
//				errorList.add(new Error("12", "Product Type", "Please Enter Product Type within 1 Character"));
				errorList.add("2057");
			}

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
//			errorList.add(new Error("01", "CommonError",e.getMessage() ));
		}
		return errorList;
	}
	
	//Section Name Exist Details validation
	public List<SectionMaster> getSectionNameExistDetails(String sectionName) {
		List<SectionMaster> list = new ArrayList<SectionMaster>();
		try {
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
			// Find All
			Root<SectionMaster> b = query.from(SectionMaster.class);
	
			// Select
			query.select(b);
	
			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<SectionMaster> ocpm1 = effectiveDate.from(SectionMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
			effectiveDate.where(a1);
	
			Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
			Predicate n2 = cb.equal(b.get("sectionName"), sectionName );	
			query.where(n1,n2);
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);
			list = result.getResultList();		
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
	
		}
		return list;
	}
	@Transactional
	@Override
	public SuccessRes insertSection(SectionMasterSaveReq req) {
	    SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");
		SuccessRes res = new SuccessRes();
		SectionMaster saveData = new SectionMaster();
		List<SectionMaster> list = new ArrayList<SectionMaster>();
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		
		try {
			Integer amendId=0;
			Date startDate = req.getEffectiveDateStart() ;
			String end = "31/12/2050";
			Date endDate = sdformat.parse(end);
			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
			Date entryDate = null ;
			String createdBy = "" ;
			String sectionId="";
			
			
			if (StringUtils.isBlank(req.getSectionId())) {
					// Save
				    //Long totalCount = repo.count();
					Integer totalCount = getMasterTableCount();
					sectionId = Integer.valueOf(totalCount + 1).toString();
					entryDate = new Date();
					createdBy = req.getCreatedBy();
					saveData.setSectionId(Integer.valueOf(sectionId));
					saveData.setSectionName(req.getSectionName());
				
					res.setResponse("Saved Successfully ");
					res.setSuccessId(sectionId);
	
				} else {
					// Update
					// Get Less than Equal Today Record 
					// Criteria
					sectionId=req.getSectionId().toString();
					CriteriaBuilder cb = em.getCriteriaBuilder();
					CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
					// Find All
					Root<SectionMaster> b = query.from(SectionMaster.class);
	
					// Select
					query.select(b);
	
//					// Effective Date Max Filter
//					Subquery<Long> effectiveDate = query.subquery(Long.class);
//					Root<SectionMaster> ocpm1 = effectiveDate.from(SectionMaster.class);
//					effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
//					Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
//					Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart") , startDate);
//					effectiveDate.where(a1,a2);
//					
					//Order By
					List<Order> orderList = new ArrayList<Order>();
					orderList.add(cb.desc(b.get("effectiveDateStart")));
					
					// Where
					Predicate n1 = cb.equal(b.get("status"), "Y");
				//	Predicate n2 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
					Predicate n3 =  cb.equal(b.get("sectionId"), req.getSectionId() );
	
					query.where(n1, n3).orderBy(orderList);
	
					// Get Result
					TypedQuery<SectionMaster> result = em.createQuery(query);
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
							SectionMaster lastRecord = list.get(0);
								lastRecord.setEffectiveDateEnd(oldEndDate);
								repo.saveAndFlush(lastRecord);
							
						} else {
							amendId = list.get(0).getAmendId() ;
							entryDate = list.get(0).getEntryDate() ;
							createdBy = list.get(0).getCreatedBy();
							saveData = list.get(0) ;
							if (list.size()>1 ) {
								SectionMaster lastRecord = list.get(1);
								lastRecord.setEffectiveDateEnd(oldEndDate);
								repo.saveAndFlush(lastRecord);
							}
						
					    }
					}
					res.setResponse("Updated Successfully");
					res.setSuccessId(sectionId.toString());
				}
			    dozerMapper.map(req, saveData );
				saveData.setSectionId(Integer.valueOf(sectionId));
				saveData.setSectionName(req.getSectionName());
				saveData.setEffectiveDateStart(startDate);
				saveData.setEffectiveDateEnd(endDate);
				saveData.setCreatedBy(createdBy);
				saveData.setStatus(req.getStatus());
				saveData.setEntryDate(entryDate);
				saveData.setUpdatedDate(new Date());
				saveData.setUpdatedBy(req.getCreatedBy());
				saveData.setAmendId(amendId);
				
				saveData.setAmendId(amendId);
				repo.saveAndFlush(saveData);
				log.info("Saved Details is ---> " + json.toJson(saveData));
				
	} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
	}
	
	public Integer getMasterTableCount( ) {
	
		Integer data = 0;
		try {
	
			List<SectionMaster> list = new ArrayList<SectionMaster>();
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
			// Find All
			Root<SectionMaster> b = query.from(SectionMaster.class);
	
			// Select
			query.select(b);
	
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("sectionId")));


			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<SectionMaster> ocpm1 = effectiveDate.from(SectionMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
			effectiveDate.where(a1);
	
			Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
		
			query.where(n1).orderBy(orderList);
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);
			int limit = 0 , offset = 1 ;
			result.setFirstResult(limit * offset);
			result.setMaxResults(offset);
			list = result.getResultList();
			data = list.size() > 0 ? list.get(0).getSectionId() : 0 ;
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
	
		}
		return data;
	}
	
	
	
	///*********************************************************************GET ALL******************************************************\\
	@Override
	public List<SectionMasterRes> getallSectionDetails() {
		List<SectionMasterRes> resList = new ArrayList<SectionMasterRes>();
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
			
			List<SectionMaster> sectionList = new ArrayList<SectionMaster>();
			
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
			// Find All
			Root<SectionMaster> b = query.from(SectionMaster.class);
	
			// Select
			query.select(b);
	
			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<SectionMaster> ocpm1 = effectiveDate.from(SectionMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
			effectiveDate.where(a1);
			
	
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("effectiveDateStart")));
			
			// Where
			Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
			
			query.where(n1).orderBy(orderList);
	
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);
		
			sectionList = result.getResultList();
			sectionList = sectionList.stream().filter(distinctByKey(o -> Arrays.asList(o.getSectionId()))).collect(Collectors.toList());
			sectionList.sort(Comparator.comparing(SectionMaster :: getSectionName ));
			// Map
			for (SectionMaster data : sectionList) {
				SectionMasterRes res = new SectionMasterRes();
	
				res = dozerMapper.map(data, SectionMasterRes.class);
				res.setSectionId(data.getSectionId().toString());
				resList.add(res);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
	
		}
		return resList;
	}
	
	
	///*********************************************************************GET BY ID******************************************************\\
	@Override
	public SectionMasterRes getBySectionId(SectionMasterGetReq req) {
		SectionMasterRes res = new SectionMasterRes();
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		try {
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
			List<SectionMaster> list = new ArrayList<SectionMaster>();
			
			// Find All
			Root<SectionMaster>    c = query.from(SectionMaster.class);		
			
			// Select
			query.select(c );
			
			// AmendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<SectionMaster> ocpm1 = amendId.from(SectionMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			jakarta.persistence.criteria.Predicate a1 = cb.equal(c.get("sectionId"),ocpm1.get("sectionId") );
			amendId.where(a1);
			
			
			
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(c.get("effectiveDateStart")));
			
		    // Where	
		
			jakarta.persistence.criteria.Predicate n1 = cb.equal(c.get("amendId"), amendId);		
			jakarta.persistence.criteria.Predicate n2 = cb.equal(c.get("sectionId"),req.getSectionId()) ;
			query.where(n1 ,n2).orderBy(orderList);
			
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);			
			list =  result.getResultList();  
			res = dozerMapper.map(list.get(0) , SectionMasterRes.class);
			res.setSectionId(list.get(0).getSectionId().toString());
			res.setEntryDate(list.get(0).getEntryDate());
			res.setEffectiveDateStart(list.get(0).getEffectiveDateStart());

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;
	}
	
	//************************************************GET ACTIVE SECTION******************************************\\
	@Override
	public List<SectionMasterRes> getActiveSectionDetails() {
		List<SectionMasterRes> resList = new ArrayList<SectionMasterRes>();
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
		
			List<SectionMaster> list = new ArrayList<SectionMaster>();
	
			
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
			// Find All
			Root<SectionMaster> b = query.from(SectionMaster.class);
	
			// Select
			query.select(b);
	
			//Amend Id Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<SectionMaster> ocpm1 = amendId.from(SectionMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
			amendId.where(a1);
	
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("effectiveDateStart")));
	
			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("status"), "Y");
	
			query.where(n1,n2).orderBy(orderList);
	
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getSectionId()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(SectionMaster :: getSectionName ));
			
			// Map
			for (SectionMaster data : list) {
				SectionMasterRes res = new SectionMasterRes();
	
				res = dozerMapper.map(data, SectionMasterRes.class);
				res.setSectionId(data.getSectionId().toString());
				resList.add(res);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
	
		}
		return resList;
	}
	private static <T> java.util.function.Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Override
	public List<ProductSectionGetRes> getProductSections(ProductSectionsGetReq req) {
		List<ProductSectionGetRes> resList = new ArrayList<ProductSectionGetRes>();
		try {
			
			Date today  = req.getEffectiveDateStart()!=null ?req.getEffectiveDateStart() : new Date();
			Calendar cal = new GregorianCalendar(); 
			cal.setTime(today);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 30);
			today   = cal.getTime();
			
			List<SectionMaster> list = new ArrayList<SectionMaster>();
	
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);
	
			// Find All
			Root<SectionMaster> b = query.from(SectionMaster.class);
	
			// Select
			query.select(b);
	
			// AmendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<SectionMaster> ocpm1 = amendId.from(SectionMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("sectionId"), b.get("sectionId"));
			Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("sectionId"), today);
			amendId.where(a1,a2);
	
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(b.get("sectionName")));
	
			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getInsuranceId());
			Predicate n3 = cb.equal(b.get("status"), "Y");
	
			query.where(n1,n2,n3).orderBy(orderList);
	
			// Get Result
			TypedQuery<SectionMaster> result = em.createQuery(query);
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getSectionId()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(SectionMaster :: getSectionName ));

	
			// Map
			for (SectionMaster data : list) {
				ProductSectionGetRes res = new ProductSectionGetRes();
	
				res.setSectionId(data.getSectionId().toString() );
				res.setSectionName(data.getSectionName());
				res.setRegulatoryCode(data.getRegulatoryCode());
				resList.add(res);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
	
		}
		return resList;
	}

	@Override
	public SuccessRes changeStatusOfSection(SectionMasterChangeStatusReq req) {
		   SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");
			SuccessRes res = new SuccessRes();
			SectionMaster saveData = new SectionMaster();
			List<SectionMaster> list = new ArrayList<SectionMaster>();
			 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
			
			try {
				Integer amendId=0;
				Date startDate = req.getEffectiveDateStart() ;
				String end = "31/12/2050";
				Date endDate = sdformat.parse(end);
				long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
				Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
				Date entryDate = null ;
				String createdBy = "";
				String sectionId = "";

				sectionId = req.getSectionId().toString();
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<SectionMaster> query = cb.createQuery(SectionMaster.class);

				// Find All
				Root<SectionMaster> b = query.from(SectionMaster.class);

				// Select
				query.select(b);
				Subquery<Long> amendId2 = query.subquery(Long.class);
				Root<SectionMaster> ocpm1 = amendId2.from(SectionMaster.class);
				amendId2.select(cb.max(ocpm1.get("amendId")));
				Predicate a1 = cb.equal(b.get("sectionId"), (ocpm1.get("sectionId")));
				amendId2.where(a1);
				// Orderby
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(cb.desc(b.get("effectiveDateStart")));
				// Where
				Predicate n1 = cb.equal(b.get("sectionId"), req.getSectionId());
				Predicate n2 = cb.equal(b.get("amendId"), amendId2);
				query.where(n1, n2).orderBy(orderList);

				// Get Result
				TypedQuery<SectionMaster> result = em.createQuery(query);
				int limit = 0, offset = 2;
				result.setFirstResult(limit * offset);
				result.setMaxResults(offset);
				list = result.getResultList();

				if (list.size() > 0) {
					Date beforeOneDay = new Date(new Date().getTime() - MILLIS_IN_A_DAY);

					if (list.get(0).getEffectiveDateStart().before(beforeOneDay)) {
						amendId = list.get(0).getAmendId() + 1;
						entryDate = new Date();
						createdBy = req.getCreatedBy();
						SectionMaster lastRecord = list.get(0);
						lastRecord.setEffectiveDateEnd(oldEndDate);
						repo.saveAndFlush(lastRecord);

					} else {
						amendId = list.get(0).getAmendId();
						entryDate = list.get(0).getEntryDate();
						createdBy = list.get(0).getCreatedBy();
						saveData = list.get(0);
						if (list.size() > 1) {
							SectionMaster lastRecord = list.get(1);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						}

					}
				}
				res.setResponse("Updated Successfully");
				res.setSuccessId(sectionId.toString());

				dozerMapper.map(list.get(0), saveData);
				saveData.setSectionId(Integer.valueOf(sectionId));
				saveData.setSectionName(list.get(0).getSectionName());
				saveData.setEffectiveDateStart(startDate);
				saveData.setEffectiveDateEnd(endDate);
				saveData.setCreatedBy(createdBy);
				saveData.setStatus(req.getStatus());
				saveData.setEntryDate(entryDate);
				saveData.setUpdatedDate(new Date());
				saveData.setUpdatedBy(req.getCreatedBy());
				saveData.setAmendId(amendId);

				saveData.setAmendId(amendId);
				repo.saveAndFlush(saveData);
				log.info("Saved Details is ---> " + json.toJson(saveData));
				res.setResponse("Status Changed");
				res.setSuccessId(req.getSectionId());
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Exception is ---> " + e.getMessage());
				return null;
			}
			return res;
		}

	}
