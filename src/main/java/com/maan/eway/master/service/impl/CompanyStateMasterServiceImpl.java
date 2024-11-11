/*
*  Copyright (c) 2019. All right reserved
* Created on 2022-08-24 ( Date ISO 2022-08-24 - Time 12:58:26 )
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
import com.maan.eway.bean.CompanyStateMaster;
import com.maan.eway.bean.StateMaster;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.CompanyStateMasterChangeStatusReq;
import com.maan.eway.master.req.CompanyStateMasterDropDownReq;
import com.maan.eway.master.req.CompanyStateMasterGetAllReq;
import com.maan.eway.master.req.CompanyStateMasterGetReq;
import com.maan.eway.master.req.CompanyStateMasterSaveReq;
import com.maan.eway.master.req.CompanyStateMultiInsertReq;
import com.maan.eway.master.req.CompanyStateNonSelectedReq;
import com.maan.eway.master.res.CompanyStateMasterRes;
import com.maan.eway.master.service.CompanyStateMasterService;
import com.maan.eway.repository.CompanyStateMasterRepository;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;


/**
 * <h2>CompanyStateMasterServiceImpl</h2>
 */
@Service
@Transactional
public class CompanyStateMasterServiceImpl implements CompanyStateMasterService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CompanyStateMasterRepository repo;

	Gson json = new Gson();

	private Logger log = LogManager.getLogger(CompanyStateMasterServiceImpl.class);

//***********************************************UPDATE STATE DETAILS******************************************************\\
	@Transactional
	@Override
	public SuccessRes updateCompanyState(CompanyStateMasterSaveReq req) {
		SuccessRes res = new SuccessRes();
		CompanyStateMaster saveData = new CompanyStateMaster();
		List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");

		try {
			
			Date startDate = req.getEffectiveDateStart() ;
			String end = "31/12/2050";
			Date endDate = sdformat.parse(end);
			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
			Date entryDate = null ;
			String createdBy = "" ;
			String stateId = "";
			Integer amendId=0;

				// Update
				// Get Less than Equal Today Record
				// Criteria
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);

				// Find All
				Root<CompanyStateMaster> b = query.from(CompanyStateMaster.class);

				// Select
				query.select(b);

				// Order By
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(cb.asc(b.get("effectiveDateStart")));
				// Where
				Predicate n1 = cb.equal(b.get("status"), "Y");
			//	Predicate n2 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
				Predicate n3 = cb.equal(b.get("stateId"), req.getStateId());
				Predicate n4 = cb.equal(b.get("countryId"),req.getCountryId());
				Predicate n5 = cb.equal(b.get("regionCode"),req.getRegionCode());

				query.where(n1, n3,n4,n5);// .orderBy(orderList);

				// Get Result
				TypedQuery<CompanyStateMaster> result = em.createQuery(query);
				int limit = 0 , offset = 2 ;
				result.setFirstResult(limit * offset);
				result.setMaxResults(offset);
				list = result.getResultList();


				if (list.size() > 0) {
					Date beforeOneDay = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
					
					if ( list.get(0).getEffectiveDateStart().before(beforeOneDay)  ) {
						amendId = list.get(0).getAmendId() + 1 ;
						entryDate = new Date() ;
						createdBy = req.getCreatedBy();
						CompanyStateMaster lastRecord = list.get(0);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						
					} else {
						amendId = list.get(0).getAmendId() ;
						entryDate = list.get(0).getEntryDate() ;
						createdBy = list.get(0).getCreatedBy();
						saveData = list.get(0) ;
						if (list.size()>1 ) {
							CompanyStateMaster lastRecord = list.get(1);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						}
					
				    }
				}
				res.setResponse("Updated Successfully ");
				res.setSuccessId(req.getStateId());
			

			dozerMapper.map(req, saveData);
			saveData.setStateId(Integer.valueOf(req.getStateId()));
			saveData.setStateShortCode(req.getStateShortCode());
			saveData.setStateName(req.getStateName());
			saveData.setEffectiveDateStart(req.getEffectiveDateStart());
			saveData.setEffectiveDateEnd(endDate);
			saveData.setStatus(req.getStatus());
			saveData.setEntryDate(new Date());
			saveData.setAmendId(amendId);
			saveData.setUpdatedBy(req.getCreatedBy());
			saveData.setUpdatedDate(new Date());
			
			repo.saveAndFlush(saveData);

			log.info("Saved Details is ---> " + json.toJson(saveData));
		
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
	}

	@Override
	public 	List<Error> validateUpdateCompanyStateDetails(CompanyStateMasterSaveReq req) {

		List<Error> errorList = new ArrayList<Error>();

		try {
				if (StringUtils.isBlank(req.getStateName())) {
					errorList.add(new Error("01", "StateName", "Please Select State  Name " ));
				} else if (req.getStateName().length() > 100) {
					errorList.add(new Error("01", "StateName", "Please Enter State Name within 100 Characters" ));
				}
								// Date Validation
				Calendar cal = new GregorianCalendar();
				Date today = new Date();
				cal.setTime(today);
				cal.add(Calendar.DAY_OF_MONTH, -1);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 50);
				today = cal.getTime();
				if (req.getEffectiveDateStart() == null) {
					errorList.add(new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start " ));

				} else if (req.getEffectiveDateStart().before(today)) {
					errorList.add(
							new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start as Future Date" ));
				} 
				else if (StringUtils.isBlank(req.getRegionCode())) {
					errorList.add(new Error("02", "RegionCode", "Please Select Region Code  "));
				} else if (req.getRegionCode().length() > 20) {
					errorList.add(new Error("02", "RegionCode","Please Enter Region Code within 100 Characters in  "));
				} else if (StringUtils.isBlank(req.getCompanyId())) {
					errorList.add(new Error("03", "InsuranceId", "Please Select InsuranceId"));
				} else if (StringUtils.isBlank(req.getCoreAppCode())) {
					errorList.add(new Error("05", "CoreAppCode", "Please Enter CoreAppCode"));
				} else if (req.getCoreAppCode().length() > 20) {
					errorList.add(new Error("05", "CoreAppCode", "Please Enter CoreAppCode within 20 Characters"));
				} else if (!req.getCoreAppCode().equalsIgnoreCase("99999")) {
					List<CompanyStateMaster> coreAppCode = getCoreAppCodeExistDetails(req.getCoreAppCode(),req.getEffectiveDateStart(), req.getEffectiveDateEnd(), req.getCompanyId());
					if (coreAppCode.size() > 0
							&& (!req.getRegionCode().equalsIgnoreCase(coreAppCode.get(0).getRegionCode()))) {
						errorList.add(new Error("05", "CoreAppCode", "This core App Code  Already Exist "));
					}
				}
				// Status Validation
				if (StringUtils.isBlank(req.getStatus())) {
					errorList.add(new Error("05", "Status", "Please Enter Status" ));
				} else if (req.getStatus().length() > 1) {
					errorList.add(new Error("06", "Status", "Enter Status 1 Character Only" ));
				} else if (!("Y".equals(req.getStatus()) || "N".equals(req.getStatus())|| "R".equals(req.getStatus()) || "P".equals(req.getStatus()))) {
					errorList.add(new Error("06", "Status", "Please Enter Status" ));
				}

				if (StringUtils.isBlank(req.getCreatedBy())) {
					errorList.add(new Error("07", "CreatedBy", "Please Enter CreatedBy" ));
				} else if (req.getCreatedBy().length() > 50) {
					errorList.add(new Error("07", "CreatedBy", "Please Enter CreatedBy within 100 Characters" ));
				}

				
				if (StringUtils.isBlank(req.getRegulatoryCode())) {
					errorList.add(new Error("08", "RegulatoryCode", "Please Enter RegulatoryCode" ));
				} else if (req.getRegulatoryCode().length() > 20) {
					errorList.add(new Error("08", "RegulatoryCode", "Please Enter RegulatoryCode within 20 Characters" ));
				}
				if (StringUtils.isBlank(req.getRemarks())) {
					errorList.add(new Error("09", "Remarks", "Please Enter Remarks" ));
				} else if (req.getRemarks().length() > 100) {
					errorList.add(new Error("09", "Remarks", "Please Enter Remarks within 100 Characters" ));
				}
				if (StringUtils.isBlank(req.getStateShortCode())) {
					errorList.add(new Error("10", "StateShortCode", "Please Enter StateShortCode" ));
				} else if (req.getStateShortCode().length() > 20) {
					errorList
							.add(new Error("10", "StateShortCode", "Please Enter StateShortCode within 20 Characters" ));
				}
				if (StringUtils.isBlank(req.getStateId())) {
					errorList.add(new Error("11", "StateId", "Please Select State Id " ));
				} 

			
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			errorList.add(new Error("10", "Common Error",e.getMessage()));
		}
		return errorList;
	}

	public List<CompanyStateMaster> getCoreAppCodeExistDetails(String coreAppCode , Date effStartDate , Date effEndDate , String companyId  ) {
	List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();
		try {
			Calendar cal = new GregorianCalendar();
			cal.setTime(effStartDate);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 1);
			effStartDate = cal.getTime();
			cal.set(Calendar.HOUR_OF_DAY, 1);cal.set(Calendar.MINUTE, 1);
			effEndDate = cal.getTime();

			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);

			// Find All
			Root<CompanyStateMaster> b = query.from(CompanyStateMaster.class);

			// Select
			query.select(b);

			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<CompanyStateMaster> ocpm1 = effectiveDate.from(CompanyStateMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a2 = cb.equal(ocpm1.get("coreAppCode"), b.get("coreAppCode"));
			Predicate a3 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), effStartDate);
			Predicate a7 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
	
			effectiveDate.where(a1, a2, a3, a7);

			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
			Root<CompanyStateMaster> ocpm2 = effectiveDate2.from(CompanyStateMaster.class);
			effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
			Predicate a4 = cb.equal(ocpm2.get("companyId"), b.get("companyId"));
			Predicate a5 = cb.equal(ocpm2.get("coreAppCode"), b.get("coreAppCode"));
			Predicate a6 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), effEndDate);
			Predicate a9 = cb.equal(ocpm2.get("companyId"), b.get("companyId"));
			Predicate a10 = cb.equal(ocpm2.get("stateId"), b.get("stateId"));
			effectiveDate2.where(a4, a5, a6, a9, a10);

			Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
			Predicate n2 = cb.equal(b.get("effectiveDateEnd"), effectiveDate2);
			Predicate n3 = cb.equal(b.get("coreAppCode"), coreAppCode);
			Predicate n4 = cb.equal(b.get("companyId"), companyId);
	
			query.where(n1, n2, n3, n4);
			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);
			list = result.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());

		}
		return list;
	}

///*********************************************************************GET ALL******************************************************\\
	@Override
	public List<CompanyStateMasterRes> getallCompanyStateDetails(CompanyStateMasterGetAllReq req) {
		List<CompanyStateMasterRes> resList = new ArrayList<CompanyStateMasterRes>();
		DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
			
			List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();
			
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);

			// Find All
			Root<CompanyStateMaster> b = query.from(CompanyStateMaster.class);

			// Select
			query.select(b);

			// amendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<CompanyStateMaster> ocpm1 = amendId.from(CompanyStateMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("stateId"), b.get("stateId"));
			Predicate a2 = cb.equal(ocpm1.get("countryId"), b.get("countryId"));
			Predicate a3 = cb.equal(ocpm1.get("regionCode"), b.get("regionCode"));
			amendId.where(a1,a2,a3);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(b.get("stateName")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("companyId"), req.getCompanyId());
			query.where(n1,n2).orderBy(orderList);

			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);		
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getStateId()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(CompanyStateMaster :: getStateName ));
			
			// Map
			for (CompanyStateMaster data : list) {
				CompanyStateMasterRes res = new CompanyStateMasterRes();

				res = dozerMapper.map(data, CompanyStateMasterRes.class);
				res.setStateId(data.getStateId().toString());
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
///*********************************************************************GET BY ID******************************************************\\
	@Override
	public CompanyStateMasterRes getByCompanyStateId(CompanyStateMasterGetReq req) {
		CompanyStateMasterRes res = new CompanyStateMasterRes();
		DozerBeanMapper dozerMapper = new  DozerBeanMapper();

		try {
			
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 1);
			today = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);
			List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();

			// Find All
			Root<CompanyStateMaster> c = query.from(CompanyStateMaster.class);

			// Select
			query.select(c);

			// amendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<CompanyStateMaster> ocpm1 = amendId.from(CompanyStateMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			jakarta.persistence.criteria.Predicate a1 = cb.equal(c.get("stateId"), ocpm1.get("stateId"));
			jakarta.persistence.criteria.Predicate a2 = cb.equal(c.get("countryId"), ocpm1.get("countryId"));
			jakarta.persistence.criteria.Predicate a3 = cb.equal(c.get("regionCode"), ocpm1.get("regionCode"));
			amendId.where(a1,a2,a3);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("stateName")));

			// Where

			jakarta.persistence.criteria.Predicate n1 = cb.equal(c.get("amendId"), amendId);	
			jakarta.persistence.criteria.Predicate n2 = cb.equal(c.get("companyId"),req.getCompanyId());
			Predicate n3 = cb.equal(c.get("status"), "Y");

			query.where(n1, n2,n3).orderBy(orderList);

			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getStateId()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(CompanyStateMaster :: getStateName ));
			
			res = dozerMapper.map(list.get(0), CompanyStateMasterRes.class);
			res.setStateId(list.get(0).getStateId().toString());
			res.setEntryDate(list.get(0).getEntryDate());
			res.setEffectiveDateStart(list.get(0).getEffectiveDateStart());
			res.setEffectiveDateEnd(list.get(0).getEffectiveDateEnd());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;
	}
//**********************************************************DROPDOWN********************************************************************\\
	@Override
	public List<DropDownRes> getCompanyStateMasterDropdown(CompanyStateMasterDropDownReq req) {
		List<DropDownRes> resList = new ArrayList<DropDownRes>();
		try {
			Date today  = new Date();
			Calendar cal = new GregorianCalendar(); 
			cal.setTime(today);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 1);
			today   = cal.getTime();
			cal.set(Calendar.HOUR_OF_DAY, 1);cal.set(Calendar.MINUTE, 1);
			Date todayEnd = cal.getTime();
			
			// Criteria
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);
			List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();
			
			// Find All
			Root<CompanyStateMaster>    c = query.from(CompanyStateMaster.class);		
			
			// Select
			query.select(c );
			
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(c.get("stateName")));
			
			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<CompanyStateMaster> ocpm1 = effectiveDate.from(CompanyStateMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(c.get("stateId"),ocpm1.get("stateId") );
			Predicate a2 = cb.equal(c.get("companyId"), ocpm1.get("companyId") );
			Predicate a4 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
			effectiveDate.where(a1,a2,a4);
			
			// Effective Date End
			Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
			Root<CompanyStateMaster> ocpm2 = effectiveDate2.from(CompanyStateMaster.class);
			effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
			jakarta.persistence.criteria.Predicate a5 = cb.equal(c.get("stateId"), ocpm2.get("stateId"));
			jakarta.persistence.criteria.Predicate a6 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
			jakarta.persistence.criteria.Predicate a7 = cb.equal(c.get("companyId"), ocpm2.get("companyId"));
			effectiveDate2.where(a5, a6,a7);

		    // Where	
			jakarta.persistence.criteria.Predicate n1 = cb.equal(c.get("status"), "Y");
			jakarta.persistence.criteria.Predicate n2 = cb.equal(c.get("effectiveDateStart"), effectiveDate);
			jakarta.persistence.criteria.Predicate n3 = cb.equal(c.get("effectiveDateEnd"), effectiveDate2);
			jakarta.persistence.criteria.Predicate n4 = cb.equal(c.get("companyId"), req.getCompanyId());
			jakarta.persistence.criteria.Predicate n5 = cb.equal(c.get("countryId"), req.getCountryId());
			
			query.where(n1,n2,n3,n4,n5).orderBy(orderList);
			
			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);			
			list =  result.getResultList();  
			
			for(CompanyStateMaster data : list ) {
				// Response
				DropDownRes res = new DropDownRes();
				res.setCode(data.getStateId().toString());
				res.setCodeDesc(data.getStateName());
				resList.add(res);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;
	}

//************************************************GET ACTIVE STATE******************************************\\
	@Override
	public List<CompanyStateMasterRes> getActiveCompanyStateDetails(CompanyStateMasterGetAllReq req) {
		List<CompanyStateMasterRes> resList = new ArrayList<CompanyStateMasterRes>();
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
			List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();

			
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);

			// Find All
			Root<CompanyStateMaster> b = query.from(CompanyStateMaster.class);

			// Select
			query.select(b);

			// amendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<CompanyStateMaster> ocpm1 = amendId.from(CompanyStateMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("stateId"), b.get("stateId"));
			Predicate a2 = cb.equal(ocpm1.get("countryId"), b.get("countryId"));
			Predicate a3 = cb.equal(ocpm1.get("regionCode"), b.get("regionCode"));

			amendId.where(a1,a2,a3);

			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(b.get("stateName")));

			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("status"), "Y");
			Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId());
		

			query.where(n1, n2,n3).orderBy(orderList);

			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);
			list = result.getResultList();
			list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getStateName()))).collect(Collectors.toList());
			list.sort(Comparator.comparing(CompanyStateMaster :: getStateName ));
		
			// Map
			for (CompanyStateMaster data : list) {
				CompanyStateMasterRes res = new CompanyStateMasterRes();

				res = dozerMapper.map(data, CompanyStateMasterRes.class);
				res.setStateId(data.getStateId().toString());
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
	public SuccessRes changeStatusOfCompanyStateMaster(CompanyStateMasterChangeStatusReq req) {
		SuccessRes res = new SuccessRes();
		try {
			
			List<CompanyStateMaster> list = new ArrayList<CompanyStateMaster>();
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<CompanyStateMaster> query = cb.createQuery(CompanyStateMaster.class);
	
			// Find All
			Root<CompanyStateMaster> b = query.from(CompanyStateMaster.class);
	
			// Select
			query.select(b);
	
			// amendId Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<CompanyStateMaster> ocpm1 = amendId.from(CompanyStateMaster.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("stateId"), b.get("stateId"));
			amendId.where(a1);
	
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("stateId")));
	
			// Where
			Predicate n1 = cb.equal(b.get("amendId"), amendId);
			Predicate n2 = cb.equal(b.get("stateId"), req.getStateId() );
			Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId() );
	
			query.where(n1,n2,n3).orderBy(orderList);
	
			// Get Result
			TypedQuery<CompanyStateMaster> result = em.createQuery(query);
			list = result.getResultList();
			CompanyStateMaster updateRecord = list.get(0);
				updateRecord.setStatus(req.getStatus());
				repo.save(updateRecord);
		
			res.setResponse("Status Changed");
			res.setSuccessId(req.getStateId());
		} catch(Exception e ) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;
	}
//*****************************************NON SELECTED ***************************************\\
	@Override
	public List<CompanyStateMasterRes> getallNonSelectedCompanyState(CompanyStateNonSelectedReq req) {
		List<CompanyStateMasterRes> resList = new ArrayList<CompanyStateMasterRes>();
		DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
			Date today  = req.getEffectiveDateStart()!=null ?req.getEffectiveDateStart() : new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 1);
			today = cal.getTime();
			List<StateMaster>stateList = new ArrayList<StateMaster>();
			//Pagination
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 100 : Integer.valueOf(req.getOffset());
	
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<StateMaster> query = cb.createQuery(StateMaster.class);
	
			// Find All
			Root<StateMaster> b = query.from(StateMaster.class);
	
			// Select
			query.select(b);
	
			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
			Root<StateMaster> ocpm1 = effectiveDate.from(StateMaster.class);
			effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
			Predicate a1 = cb.equal(ocpm1.get("stateId"), b.get("stateId"));
			Predicate a2 = cb.equal(ocpm1.get("countryId"), b.get("countryId"));
			Predicate a3 = cb.lessThanOrEqualTo(b.get("effectiveDateStart"),today);
			effectiveDate.where(a1,a2,a3);
	
			// Effective Date Max Filter
			Subquery<Timestamp> effectiveDate5 = query.subquery(Timestamp.class);
			Root<StateMaster> ocpm5 = effectiveDate5.from(StateMaster.class);
			effectiveDate5.select(cb.greatest(ocpm5.get("effectiveDateEnd")));
			Predicate a4 = cb.equal(ocpm5.get("stateId"), b.get("stateId"));
			Predicate a5 = cb.lessThanOrEqualTo(b.get("effectiveDateStart"),today);
			Predicate a6 = cb.equal(ocpm5.get("countryId"), b.get("countryId"));
			effectiveDate5.where(a4,a5,a6);
			
			// Order By
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.asc(b.get("stateName")));
			
			// Company State Effective Date Max Filter
			Subquery<Long> region = query.subquery(Long.class);
			Root<CompanyStateMaster> ps = region.from(CompanyStateMaster.class);
			Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
			Root<CompanyStateMaster> ocpm2 = effectiveDate2.from(CompanyStateMaster.class);
			effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateStart")));
			Predicate eff1 = cb.equal(ocpm2.get("stateId"), ps.get("stateId"));
			Predicate eff3 = cb.equal(ocpm2.get("companyId"), ps.get("companyId"));
			Predicate eff4 = cb.lessThanOrEqualTo(ocpm2.get("effectiveDateStart"),today);
			effectiveDate2.where(eff1,eff3,eff4);
			
			// Re Filter
			region.select(ps.get("stateId"));
			Predicate ps1 = cb.equal(ps.get("stateId"), b.get("stateId"));
			Predicate ps3 = cb.equal(ps.get("companyId"), req.getCompanyId());
			Predicate ps4 = cb.equal(ps.get("effectiveDateStart"),effectiveDate2);
			Predicate ps5 = cb.equal(ps.get("status"),"Y");
			region.where(ps1,ps3,ps4,ps5);
			
			// Where
			Expression<String>e0= b.get("stateId");
			
			Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
			Predicate n2 = cb.equal(b.get("status"), "Y");
			Predicate n3 = e0.in(region).not();
			Predicate n4 = cb.equal(b.get("effectiveDateEnd"), effectiveDate5);
			Predicate n5 = cb.equal(b.get("countryId"), req.getCountryId());
			query.where(n1,n2,n3,n4,n5).orderBy(orderList);
	
			// Get Result
			TypedQuery<StateMaster> result = em.createQuery(query);
			result.setFirstResult(limit * offset);
			result.setMaxResults(offset);
			stateList = result.getResultList();
			
			// Map
			for (StateMaster data : stateList) {
				CompanyStateMasterRes res = new CompanyStateMasterRes();
	
				res = dozerMapper.map(data, CompanyStateMasterRes.class);
				resList.add(res);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
	
		}
		return resList;
	}
	//**********************************************************Insert Validation *******************************************\\ 
	@Override
	public List<Error> validateCompanyStateDetails(List<CompanyStateMultiInsertReq> reqList) {
		List<Error> errorList = new ArrayList<Error>();
		try {
		
			Long row = 0L ;
			for (CompanyStateMultiInsertReq req : reqList) {
				row = row + 1 ;
				
				if (StringUtils.isBlank(req.getRegionCode())) {
					errorList.add(new Error("01", "RegionCode", "Please Enter RegionCode in  Row No : " + row));
				}
				
				if (StringUtils.isBlank(req.getStateId()) ) {
					errorList.add(new Error("02", "StateId", "Please Enter StateId  in  Row No : " + row));
				}
			    if (StringUtils.isBlank(req.getCompanyId())) {
					errorList.add(new Error("03", "InsuranceId", "Please Enter InsuranceId  in Row No :" + row));
				} else if (req.getCompanyId().length() > 20) {
					errorList.add(new Error("03", "InsuranceId", "Please Enter InsuranceId within 20 Characters  in Row No :" + row));
				} 
			    
			    if (StringUtils.isBlank(req.getCreatedBy())) {
					errorList.add(new Error("04", "CreatedBy", "Please Select CreatedBy  Id in Row No :" + row));
				}
			}
	
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			errorList.add(new Error("05", "CommonError", e.getMessage()));
		}
		return errorList;
	}
	//**********************************************************Insert *******************************************\\
	@Override
	public SuccessRes insertCompanyState(List<CompanyStateMultiInsertReq> reqList) {
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");
		SuccessRes res = new SuccessRes();
		CompanyStateMaster saveData = new CompanyStateMaster();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();

		try {
			Calendar cal = new GregorianCalendar();
			Date today = new Date();
			cal.setTime(new Date());cal.set(Calendar.HOUR_OF_DAY, today.getHours());cal.set(Calendar.MINUTE, today.getMinutes());
			cal.set(Calendar.SECOND, today.getSeconds());
			Date effDate = cal.getTime();
			Date endDate = sdformat.parse("12/12/2050");
			cal.setTime(sdformat.parse("12/12/2050"));
			cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 50);
			endDate = cal.getTime();
			cal.setTime(today);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 30);
			today = cal.getTime();
			cal.setTime(today);cal.set(Calendar.HOUR_OF_DAY, 1);cal.set(Calendar.MINUTE, 1);
			Date todayEnd = cal.getTime();
			for (CompanyStateMultiInsertReq req : reqList) {

				String stateId = req.getStateId();
				Integer amendId = 0;
				// Update
				// Get Less than Equal Today Record
				// Criteria
				List<StateMaster> list = new ArrayList<StateMaster>();

				// Find Latest Record
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<StateMaster> query = cb.createQuery(StateMaster.class);

				// Find All
				Root<StateMaster> b = query.from(StateMaster.class);

				// Select
				query.select(b);

				// Effective Date Max Filter
				Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
				Root<StateMaster> ocpm1 = effectiveDate.from(StateMaster.class);
				effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
				Predicate a1 = cb.equal(b.get("countryId"), ocpm1.get("countryId"));
				Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
				Predicate a3 = cb.equal(b.get("regionCode"), ocpm1.get("regionCode"));
				effectiveDate.where(a1, a2,a3);

				// Effective Date Max Filter
				Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
				Root<StateMaster> ocpm2 = effectiveDate2.from(StateMaster.class);
				effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
				Predicate a4 = cb.equal(b.get("countryId"), ocpm2.get("countryId"));
				Predicate a5 = cb.equal(b.get("regionCode"), ocpm2.get("regionCode"));
				Predicate a6 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
				effectiveDate2.where(a4, a5,a6);

				// Order By
				List<Order> orderList = new ArrayList<Order>();
				orderList.add(cb.asc(b.get("stateName")));

				// Where
				Predicate n1 = cb.equal(b.get("effectiveDateStart"), effectiveDate);
				Predicate n2= cb.equal(b.get("effectiveDateEnd"), effectiveDate2);
				Predicate n3 = cb.equal(b.get("stateId"), req.getStateId());
				Predicate n4 = cb.equal(b.get("status"), "Y");
				Predicate n5 = cb.equal(b.get("regionCode"), req.getRegionCode());

				query.where(n1, n2, n3,n4,n5).orderBy(orderList);

				// Get Result
				TypedQuery<StateMaster> result = em.createQuery(query);
				list = result.getResultList();

				res.setResponse("Saved Successfully ");
				res.setSuccessId(stateId);

				dozerMapper.map(list.get(0), saveData);
				saveData.setStateId(Integer.valueOf(stateId));
				saveData.setCompanyId(req.getCompanyId());
				saveData.setCreatedBy(req.getCreatedBy());
				saveData.setEffectiveDateStart(effDate);
				saveData.setEffectiveDateEnd(endDate);
				saveData.setCoreAppCode("99999");
				saveData.setEntryDate(new Date());
				saveData.setAmendId(amendId);
				repo.saveAndFlush(saveData);

				log.info("Saved Details is ---> " + json.toJson(saveData));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
	}

}