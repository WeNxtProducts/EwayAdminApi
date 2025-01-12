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
import com.maan.eway.bean.OneTimeTableDetails;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.ColumnNameDropDownlReq;
import com.maan.eway.master.req.GetAllOneTimeTableDetailsReq;
import com.maan.eway.master.req.GetOneTimeTableDetailsReq;
import com.maan.eway.master.req.InsertOneTimeTableReq;
import com.maan.eway.master.res.GetAllOneTimeTableDetailsRes;
import com.maan.eway.master.service.OneTimeTableDetailsService;
import com.maan.eway.repository.OneTimeTableDetailsRepository;
import com.maan.eway.res.DropDownRes;
import com.maan.eway.res.SuccessRes2;

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
* <h2>BankMasterServiceimpl</h2>
*/
@Service
@Transactional
public class OneTimeTableDetailsServiceImpl implements OneTimeTableDetailsService {

@PersistenceContext
private EntityManager em;

@Autowired
private OneTimeTableDetailsRepository repo;

Gson json = new Gson();

private Logger log=LogManager.getLogger(OneTimeTableDetailsServiceImpl.class);


@Override
public List<DropDownRes> tableName() {
	List<DropDownRes> resList = new ArrayList<DropDownRes>();
	try {
	//	List<OneTimeTableDetails> getList = repo.findByItemTypeAndStatusOrderByItemCodeAsc("ONE_TIME_TABLE", "Y");
		List<OneTimeTableDetails> getList = new ArrayList<OneTimeTableDetails>();
		String itemType = "ONE_TIME_TABLE"; 
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		today = cal.getTime();
		Date todayEnd = cal.getTime();
		
		// Criteria
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OneTimeTableDetails> query=  cb.createQuery(OneTimeTableDetails.class);
		// Find All
		Root<OneTimeTableDetails> c = query.from(OneTimeTableDetails.class);
		
		//Select
		query.select(c);
		// Order By
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(c.get("itemId")));
		
		
		// Effective Date Start Max Filter
		Subquery<Timestamp> effectiveDate = query.subquery(Timestamp.class);
		Root<OneTimeTableDetails> ocpm1 = effectiveDate.from(OneTimeTableDetails.class);
		effectiveDate.select(cb.greatest(ocpm1.get("effectiveDateStart")));
		Predicate a1 = cb.equal(c.get("itemId"),ocpm1.get("itemId"));
		Predicate a2 = cb.lessThanOrEqualTo(ocpm1.get("effectiveDateStart"), today);
		Predicate b2 = cb.equal(c.get("companyId"),ocpm1.get("companyId"));
		Predicate b4 = cb.equal(c.get("parentId"),ocpm1.get("parentId"));
		effectiveDate.where(a1,a2,b2,b4);
		
		// Effective Date End Max Filter
		Subquery<Timestamp> effectiveDate2 = query.subquery(Timestamp.class);
		Root<OneTimeTableDetails> ocpm2 = effectiveDate2.from(OneTimeTableDetails.class);
		effectiveDate2.select(cb.greatest(ocpm2.get("effectiveDateEnd")));
		Predicate a3 = cb.equal(c.get("itemId"),ocpm2.get("itemId"));
		Predicate a4 = cb.greaterThanOrEqualTo(ocpm2.get("effectiveDateEnd"), todayEnd);
		Predicate b3= cb.equal(c.get("companyId"),ocpm2.get("companyId"));
		Predicate b5 = cb.equal(c.get("parentId"),ocpm2.get("parentId"));
		effectiveDate2.where(a3,a4,b3,b5);
					
		// Where
		Predicate n1 = cb.equal(c.get("status"),"Y");
		Predicate n2 = cb.equal(c.get("effectiveDateStart"),effectiveDate);
		Predicate n3 = cb.equal(c.get("effectiveDateEnd"),effectiveDate2);	
		Predicate n4 = cb.equal(c.get("companyId"), "99999");
		Predicate n10 = cb.equal(c.get("itemType"),itemType);
		
	
		query.where(n2,n3,n4,n10,n1).orderBy(orderList);
	

		TypedQuery<OneTimeTableDetails> result = em.createQuery(query);
		getList = result.getResultList();
		for (OneTimeTableDetails data : getList) {
			DropDownRes res = new DropDownRes();
			res.setCode(data.getItemCode());
			res.setCodeDesc(data.getItemValue());
			resList.add(res);
		}
		resList.sort(Comparator.comparing(DropDownRes :: getCodeDesc));
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;
}


@Override
public List<DropDownRes> columnName(ColumnNameDropDownlReq req) {
	List<DropDownRes> resList = new ArrayList<DropDownRes>();
	try {
		List<OneTimeTableDetails> getList = repo.findByItemIdAndStatusOrderByItemCodeAsc(Integer.valueOf(req.getItemId()), "Y");
		for (OneTimeTableDetails data : getList) {
				if(!data.getItemType().equalsIgnoreCase("ONE_TIME_TABLE")) {
					DropDownRes res = new DropDownRes();
					res.setCode(data.getItemCode());
					res.setCodeDesc(data.getDisplayName());
					resList.add(res);
				}
		}
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;
}


@Override
public List<GetAllOneTimeTableDetailsRes> getAllOneTimeTableDetails(GetAllOneTimeTableDetailsReq req) {
	List<GetAllOneTimeTableDetailsRes> resList = new ArrayList<GetAllOneTimeTableDetailsRes>();
	DozerBeanMapper mapper = new DozerBeanMapper();
	List<OneTimeTableDetails> list = new ArrayList<OneTimeTableDetails>();
	try {
	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OneTimeTableDetails> query = cb.createQuery(OneTimeTableDetails.class);

		Root<OneTimeTableDetails> b = query.from(OneTimeTableDetails.class);

		query.select(b);

		//AmendId
		Subquery<Long> amendId = query.subquery(Long.class);
		Root<OneTimeTableDetails> ocpm1 = amendId.from(OneTimeTableDetails.class);
		amendId.select(cb.max(ocpm1.get("amendId")));
		Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
		amendId.where(a2);

	
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(b.get("parentId")));
		
	
		Predicate n1 = cb.equal(b.get("amendId"), amendId);
		Predicate n2 = cb.equal(b.get("companyId"), req.getCompanyId());
	
		query.where(n1,n2).orderBy(orderList);

	
		TypedQuery<OneTimeTableDetails> result = em.createQuery(query);
		list = result.getResultList();
		
		list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getParentId()))).collect(Collectors.toList());
		
		
		for (OneTimeTableDetails data : list) {
			GetAllOneTimeTableDetailsRes res = new GetAllOneTimeTableDetailsRes();
			res = mapper.map(data, GetAllOneTimeTableDetailsRes.class);
			
					resList.add(res);
				
		}
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;
}


@Override
public GetAllOneTimeTableDetailsRes getOneTimeTableDetails(GetOneTimeTableDetailsReq req) {
	GetAllOneTimeTableDetailsRes res  = new GetAllOneTimeTableDetailsRes();
	DozerBeanMapper mapper = new DozerBeanMapper();
	List<OneTimeTableDetails> list = new ArrayList<OneTimeTableDetails>();
	try {
	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OneTimeTableDetails> query = cb.createQuery(OneTimeTableDetails.class);

		Root<OneTimeTableDetails> b = query.from(OneTimeTableDetails.class);

		query.select(b);

		//AmendId
		Subquery<Long> amendId = query.subquery(Long.class);
		Root<OneTimeTableDetails> ocpm1 = amendId.from(OneTimeTableDetails.class);
		amendId.select(cb.max(ocpm1.get("amendId")));
		Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
		Predicate a1 = cb.equal(b.get("parentId"), ocpm1.get("parentId"));
		amendId.where(a2,a1);

	
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(b.get("parentId")));
		
		
		Predicate n1 = cb.equal(b.get("amendId"), amendId);
		Predicate n2 = cb.equal(b.get("companyId"), req.getCompanyId());
		Predicate n3 = cb.equal(b.get("parentId"), req.getParentId());
		query.where(n1,n2,n3).orderBy(orderList);
	
		TypedQuery<OneTimeTableDetails> result = em.createQuery(query);
		list = result.getResultList();
		
		list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getParentId()))).collect(Collectors.toList());
		
		if(list.size()>0) {
			res = mapper.map(list.get(0), GetAllOneTimeTableDetailsRes.class);
		
		}
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return res;
}

private static <T> java.util.function.Predicate<T> distinctByKey(java.util.function.Function<? super T, ?> keyExtractor) {
    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}


@Override
public List<GetAllOneTimeTableDetailsRes> getActiveOneTimeTableDetails(GetAllOneTimeTableDetailsReq req) {
	List<GetAllOneTimeTableDetailsRes> resList = new ArrayList<GetAllOneTimeTableDetailsRes>();
	DozerBeanMapper mapper = new DozerBeanMapper();
	List<OneTimeTableDetails> list = new ArrayList<OneTimeTableDetails>();
	try {
	
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<OneTimeTableDetails> query = cb.createQuery(OneTimeTableDetails.class);

		Root<OneTimeTableDetails> b = query.from(OneTimeTableDetails.class);

		query.select(b);

		//AmendId
		Subquery<Long> amendId = query.subquery(Long.class);
		Root<OneTimeTableDetails> ocpm1 = amendId.from(OneTimeTableDetails.class);
		amendId.select(cb.max(ocpm1.get("amendId")));
		Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
		amendId.where(a2);

	
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(cb.asc(b.get("parentId")));
		
	
		Predicate n1 = cb.equal(b.get("amendId"), amendId);
		Predicate n2 = cb.equal(b.get("companyId"), req.getCompanyId());
		Predicate n3 = cb.equal(b.get("status"), "Y");
		query.where(n1,n2,n3).orderBy(orderList);

	
		TypedQuery<OneTimeTableDetails> result = em.createQuery(query);
		list = result.getResultList();
		
		list = list.stream().filter(distinctByKey(o -> Arrays.asList(o.getParentId()))).collect(Collectors.toList());
		
		
		for (OneTimeTableDetails data : list) {
			GetAllOneTimeTableDetailsRes res = new GetAllOneTimeTableDetailsRes();
			res = mapper.map(data, GetAllOneTimeTableDetailsRes.class);
			resList.add(res);
				
		}
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Exception is ---> " + e.getMessage());
		return null;
	}
	return resList;
}


@Override
public List<Error> insertOneTimeTableVali(InsertOneTimeTableReq req) {
	List<Error> errorList = new ArrayList<Error>();

	try {
		// Date Validation 
		Calendar cal = new GregorianCalendar();
		Date today = new Date();
		cal.setTime(today);cal.add(Calendar.DAY_OF_MONTH, -1);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 50);
		today = cal.getTime();
		if (req.getEffectiveDateStart() == null || StringUtils.isBlank(req.getEffectiveDateStart().toString())) {
			errorList.add(new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start"));
	
		} else if (req.getEffectiveDateStart().before(today)) {
			errorList.add(new Error("04", "EffectiveDateStart", "Please Enter Effective Date Start as Future Date"));
		}
		
		
		// Status Validation
		if (StringUtils.isBlank(req.getStatus())) {
			errorList.add(new Error("05", "Status", "Please Enter Status"));
		} else if (req.getStatus().length() > 1) {
			errorList.add(new Error("05", "Status", "Enter Status in One Character Only"));
		} 
		
		
		if(StringUtils.isNotBlank(req.getParentId())) {
			if (StringUtils.isBlank(req.getUpdatedBy())) {
				errorList.add(new Error("09", "CreatedBy", "Please Select UpdatedBy"));
			}else if (req.getCreatedBy().length() > 100){
				errorList.add(new Error("09","UpdatedBy", "Please Enter UpdatedBy within 100 Characters")); 
			}	
		} else {
			if (StringUtils.isBlank(req.getCreatedBy())) {
				errorList.add(new Error("09", "CreatedBy", "Please Select CreatedBy"));
			}else if (req.getCreatedBy().length() > 100){
				errorList.add(new Error("09","CreatedBy", "Please Enter CreatedBy within 100 Characters")); 
			}	
		}
		
		if (StringUtils.isBlank(req.getCompanyId())) {
			errorList.add(new Error("05", "CompanyId", "Please Enter CompanyId"));
		}
		
		if (StringUtils.isBlank(req.getItemCode())) {
			errorList.add(new Error("05", "ItemCode", "Please Enter ItemCode"));
		}
		if (StringUtils.isBlank(req.getItemId())) {
			errorList.add(new Error("05", "ItemId", "Please Enter ItemId"));
		}
		if (StringUtils.isBlank(req.getItemType())) {
			errorList.add(new Error("05", "ItemType", "Please Enter ItemType"));
		}
		if (StringUtils.isBlank(req.getItemValue())) {
			errorList.add(new Error("05", "ItemValue", "Please Enter ItemValue"));
		}
		
		if (StringUtils.isBlank(req.getDisplayName())) {
			errorList.add(new Error("05", "DisplayName", "Please Enter DisplayName"));
		}
		
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return errorList;
}


@Override
public SuccessRes2 insertOneTimeTable(InsertOneTimeTableReq req) {
	 SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");
	 SuccessRes2 res = new SuccessRes2();
		OneTimeTableDetails saveData = new OneTimeTableDetails();
	
		 DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		
		try {
			Integer amendId=0;
			Date entryDate = null;
			String end = "31/12/2050";
			Date endDate = sdformat.parse(end);
			String patentId="";	
			String createdBy = "";
			
			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
			
			if (StringUtils.isBlank(req.getParentId())) { //insert
					
				OneTimeTableDetails ot = repo.findFirstByCompanyIdOrderByParentIdDesc(req.getCompanyId());
				entryDate = new Date();
				
				if(ot==null)
					patentId = "1";
				else
					patentId = 	 ot.getParentId()==null?"1": String.valueOf(ot.getParentId().intValue() + 1);
				
					res.setResponse("Saved Successfully ");
					res.setSuccessId(patentId);
				

				} else {
					// Update
					Date beforeOneDay = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
					patentId = req.getParentId();
					
					List<OneTimeTableDetails> update = repo.findByCompanyIdAndParentIdOrderByAmendIdDesc(req.getCompanyId(), 
							Integer.valueOf(req.getParentId()));
					
					if ( update.get(0).getEffectiveDateStart().before(beforeOneDay)  ) { //old
						amendId = update.get(0).getAmendId() + 1 ;
						entryDate = new Date() ;
						createdBy = req.getCreatedBy();
						OneTimeTableDetails lastRecord = update.get(0);
						lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						
					} else { //future
						amendId = update.get(0).getAmendId() ;
						entryDate = update.get(0).getEntryDate() ;
						createdBy = update.get(0).getCreatedBy();
						saveData = update.get(0) ;
						if (update.size()>1 ) {
							OneTimeTableDetails lastRecord = update.get(1);
							lastRecord.setEffectiveDateEnd(oldEndDate);
							repo.saveAndFlush(lastRecord);
						}
					}		
					
					res.setResponse("Updated Successfully ");
					res.setSuccessId(patentId);
				}
			  dozerMapper.map(req, saveData );
			  saveData.setAmendId(amendId);
			  saveData.setParentId(patentId==null?1:Integer.valueOf(patentId));
			 
			  	saveData.setEntryDate(entryDate);
				saveData.setEffectiveDateEnd(endDate);
				saveData.setEntryDate(new Date());
				saveData.setUpdatedDate(new Date());
				saveData.setUpdatedBy(req.getUpdatedBy()==null?"":req.getUpdatedBy());
				saveData.setCreatedBy(createdBy);
				
				repo.saveAndFlush(saveData);
				
				log.info("Saved Details is ---> " + json.toJson(saveData));
				
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
}

}
