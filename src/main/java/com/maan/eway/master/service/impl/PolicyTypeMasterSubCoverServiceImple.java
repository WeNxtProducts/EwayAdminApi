package com.maan.eway.master.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maan.eway.bean.TravelPolicyType;
import com.maan.eway.error.Error;
import com.maan.eway.master.req.GetPolicyTypesubcoverReq;
import com.maan.eway.master.req.PolicyTypeMasterSubCoverSingleSaveReq;
import com.maan.eway.master.req.PolicyTypeSubCoverMasterGetAllReq;
import com.maan.eway.master.res.PolicyTypeSubCoverMasterGetRes;
import com.maan.eway.master.service.PolicyTypeMasterSubCoverService;
import com.maan.eway.repository.TravelPolicyTypeRepository;
import com.maan.eway.res.SuccessRes2;

@Transactional
@Service 
public class PolicyTypeMasterSubCoverServiceImple  implements PolicyTypeMasterSubCoverService{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	@PersistenceContext
	private EntityManager em;
	private Logger log=LogManager.getLogger(PolicyTypeMasterSubCoverServiceImple.class);
	
	@Autowired
	private TravelPolicyTypeRepository repository;

//	@Override
//	public List<Error> validatePolicyTypeSubCover(PolicyTypeMasterSubCoverSaveReq req) {
//		List<Error> errorList = new ArrayList<Error>();
//		try {
//			
//			// Date Validation 
//			Calendar cal = new GregorianCalendar();
//			Date today = new Date();
//			cal.setTime(today);cal.add(Calendar.DAY_OF_MONTH, -1);cal.set(Calendar.HOUR_OF_DAY, 23);cal.set(Calendar.MINUTE, 50);
//			today = cal.getTime();
//			if (req.getEffectiveDateStart() == null ) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Select Effective Date"));
//	
//			} else if (req.getEffectiveDateStart().before(today)) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Select Effective Date as Future Date"));
//			} 
//			
//			if (StringUtils.isBlank(req.getCreatedBy())) {
//				errorList.add(new Error("06", "CreatedBy", "Please Enter CreatedBy"));
//			}else if (req.getCreatedBy().length() > 50) {
//				errorList.add(new Error("06", "CreatedBy", "Please Enter CreatedBy within 100 Characters"));
//			} 
//						
//			// Other Errors	
//			if (StringUtils.isBlank(req.getCompanyId())) {
//				errorList.add(new Error("01", "Insurance Id", "Please Select InsuranceId"));
//				
//			}
//			if (StringUtils.isBlank(req.getBranchCode())) {
//				errorList.add(new Error("01", "BranchCode", "Please Select BranchCode"));
//				
//			}
//			if (StringUtils.isBlank(req.getProductId())) {
//				errorList.add(new Error("02", "ProductId", "Please Enter ProductId"));
//			}
//			if (StringUtils.isBlank(req.getPolicyTypeId())) {
//				errorList.add(new Error("02", "PolicyTypeId", "Please Select PolicyTypeId"));
//			}
//			if (StringUtils.isBlank(req.getPlanTypeId())) {
//				errorList.add(new Error("02", "PlanTypeId", "Please Select PlanTypeId"));
//			}
//			
////			if (StringUtils.isBlank(req.getRemarks()) ) {
////				errorList.add(new Error("03", "Remark", "Please Enter Remark "));
////			}else if (req.getRemarks().length() > 100){
////				errorList.add(new Error("03","Remark", "Please Enter Remark within 100 Characters")); 
////			}
//			
//			if (StringUtils.isBlank(req.getCoverId())) {
//				errorList.add(new Error("02", "CoverId", "Please Select CoverId"));
//			}
//			if (StringUtils.isBlank(req.getCoverStatus())) {
//				errorList.add(new Error("05", "Cover Status", "Please Select Cover Status"));
//			} else if (req.getCoverStatus().length() > 1) {
//				errorList.add(new Error("05", "Cover Status", "Please Select Valid Cover Status - 1 Character Only Allwed"));
//			}
//			
//			if (StringUtils.isBlank(req.getCoverDesc())) {
//				errorList.add(new Error("02", "CoverDesc", "Please Enter CoverDesc in row "));
//			} 
//			if (StringUtils.isBlank(req.getPolicyTypeDesc())) {
//				errorList.add(new Error("02", "PolicyTypeDesc", "Please Enter PolicyTypeDesc in row "));
//			} 
//			if (StringUtils.isBlank(req.getPlanTypeDesc())) {
//				errorList.add(new Error("02", "PlanTypeDesc", "Please Enter PlanTypeDesc in row "));
//			} 
//			
//			
//			Set<String> uniqueElements = new HashSet<>();
//			int row = 0 ;
//			
//			if(req.getTravelSubCover().size()>0) {
//				
//				for(PolicyTypeSubCoverMasterGetRes sub : req.getTravelSubCover()) {
//							row = row + 1; 
//							
//							if (StringUtils.isBlank(sub.getCurrency())) {
//								errorList.add(new Error("02", "Currency", "Please Enter Currency in row "+ row));
//							}
//							if (StringUtils.isBlank(sub.getExcessAmt())) {
//								errorList.add(new Error("02", "ExcessAmt", "Please Enter ExcessAmt in row "+ row));
//							}
//							if (StringUtils.isBlank(sub.getSubCoverDesc())) {
//								errorList.add(new Error("02", "SubCoverDesc", "Please Enter SubCoverDesc in row "+ row));
//							} else if (! uniqueElements.add(sub.getSubCoverDesc())) {
//									errorList.add(new Error("02", "SubCoverDesc", "SubCover '" + sub.getSubCoverDesc() + "' Already Exists in row "+ row));
//							}
//							
//							if (StringUtils.isBlank(sub.getSumInsured())) {
//								errorList.add(new Error("02", "SumInsured", "Please Enter SumInsured in row "+ row));
//							}
//							if (StringUtils.isBlank(sub.getStatus())) {
//								errorList.add(new Error("05", "SubCover Status", "Please Select SubCover Status"));
//							} else if (sub.getStatus().length() > 1) {
//								errorList.add(new Error("05", "SubCover Status", "Please Select Valid SubCover Status - 1 Character Only Allwed"));
//							}
//							
//						}
//					} else {
//						errorList.add(new Error("05", "SubCover", "Please Enter SubCover Details"));
//			}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		return errorList;
//					 
//		
//	
//	}
//
//	@Override
//	public SuccessRes2 insertPolicyTypeSubCover(PolicyTypeMasterSubCoverSaveReq req) {
//		SuccessRes2 res = new SuccessRes2();
//		try {
//			// Update Old Records
//			Integer amendId = upadateOldSubCovers(req ) ; //effectivedate end
//			Integer sNo = 0 ;
//		
//			// Insert New Records
//			res = insertNewSubCovers(req , amendId , sNo);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.info("Exception is --->" + e.getMessage());
//			return null;
//		}
//		return res;
//	
//	}
//
//	
//	private SuccessRes2 insertNewSubCovers(PolicyTypeMasterSubCoverSaveReq req, Integer amendId, Integer sNo) {
//		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/YYYY");
//		SuccessRes2 res = new SuccessRes2();
//		DozerBeanMapper dozerMapper = new  DozerBeanMapper();
//		List<TravelPolicyType> saveList = new ArrayList<TravelPolicyType>();
//		try {
//			String end = "31/12/2050";
//			Date endDate = sdformat.parse(end);
//			String coverid = req.getCoverId();
//		
//			res.setResponse("Updated Successfully");
//			res.setSuccessId(coverid);
//		
//			
//			for ( PolicyTypeSubCoverMasterGetRes data :  req.getTravelSubCover() ) {
//				TravelPolicyType saveData = new TravelPolicyType();
//				// Save New Records
//				sNo = sNo + 1 ;
//				saveData = dozerMapper.map(req, TravelPolicyType.class );
//				
//				saveData.setEffectiveStartdate(req.getEffectiveDateStart());
//				saveData.setEffectiveEnddate(endDate);
//				saveData.setEntryDate(new Date());
//				saveData.setAmendId(amendId);
//				saveData.setSubCoverId(sNo);
//				saveData.setSubCoverDesc(data.getSubCoverDesc());
//				saveData.setSumInsured(data.getSumInsured());
//				saveData.setExcessAmt(data.getExcessAmt());
//				saveData.setStatus(data.getStatus());
//				saveData.setCurrency(data.getCurrency());
//				saveData.setUpdatedBy(req.getCreatedBy());
//				saveData.setUpdatedDate(new Date());
//				
//				saveList.add(saveData);
//			}
//			repository.saveAllAndFlush(saveList);
//			
//		} catch (Exception e) {
//		e.printStackTrace();
//		log.info("Exception is --->" + e.getMessage());
//		return null;
//	}
//	return res;
//	
//	}
//
//	private Integer upadateOldSubCovers(PolicyTypeMasterSubCoverSaveReq req) {
//		List<TravelPolicyType> list = new ArrayList<TravelPolicyType>();
//		Integer amendId = 0 ;
//		try {
//			long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24; //milliseconds in a day
//			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime() - MILLIS_IN_A_DAY);
//			Date entryDate = new Date();
//			
//			// FInd Old Record
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<TravelPolicyType> query = cb.createQuery(TravelPolicyType.class);
//		
//			Root<TravelPolicyType> b = query.from(TravelPolicyType.class);
//		
//			query.select(b);
//			
//			// Max AmendId
//			Subquery<Long> maxAmendId = query.subquery(Long.class);
//			Root<TravelPolicyType> ocpm1 = maxAmendId.from(TravelPolicyType.class);
//			maxAmendId.select(cb.max(ocpm1.get("amendId")));
//			Predicate a1 = cb.equal(ocpm1.get("productId"), b.get("productId"));
//			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
//			Predicate a3 = cb.equal(ocpm1.get("policyTypeId"),b.get("policyTypeId"));
//			Predicate a4 = cb.equal(ocpm1.get("planTypeId"),b.get("planTypeId"));
//			Predicate a5 = cb.equal(ocpm1.get("coverId"),b.get("coverId"));
//			Predicate a7 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
//			maxAmendId.where(a1,a2,a3,a4,a5,a7);
//
//		
//			List<Order> orderList = new ArrayList<Order>();
//			orderList.add(cb.desc(b.get("amendId")));
//			
//			
//			Predicate n1 = cb.equal(b.get("companyId"), req.getCompanyId());
//			Predicate n2 = cb.equal(b.get("productId"), req.getProductId());
//			Predicate n3 = cb.equal(b.get("policyTypeId"), req.getPolicyTypeId());
//			Predicate n4 = cb.equal(b.get("coverId"), req.getCoverId());
//			Predicate n5 = cb.equal(b.get("planTypeId"), req.getPlanTypeId());
//			Predicate n6 = cb.equal(b.get("branchCode"), req.getBranchCode());
//			Predicate n7 = cb.notEqual(b.get("subCoverId"), "0" );
//			Predicate n10 = cb.equal(b.get("amendId"), maxAmendId);
//			
//			query.where(n1,n2,n3,n4,n5,n6,n7,n10).orderBy(orderList);
//		
//			TypedQuery<TravelPolicyType> result = em.createQuery(query);
//			list = result.getResultList();
//			
//			if(list.size()>0) {
//				Date beforeOneDay = new Date(new Date().getTime() - MILLIS_IN_A_DAY);
//			
//				if ( list.get(0).getEffectiveStartdate().before(beforeOneDay)  ) { //old effstartdate past -- end date changed
//					amendId = list.get(0).getAmendId() + 1 ;
//					entryDate = new Date() ;
//					
//					CriteriaBuilder cb2 = em.getCriteriaBuilder();
//				
//					CriteriaUpdate<TravelPolicyType> update = cb2.createCriteriaUpdate(TravelPolicyType.class);
//				
//					Root<TravelPolicyType> m = update.from(TravelPolicyType.class);
//				
//					update.set("updatedBy", req.getCreatedBy());
//					update.set("updatedDate", entryDate);
//					update.set("effectiveEnddate", oldEndDate);
//					
//					n1 = cb.equal(m.get("companyId"), req.getCompanyId());
//					n2 = cb.equal(m.get("productId"), req.getProductId());
//					n3 = cb.equal(m.get("branchCode"), req.getBranchCode());
//					n4 = cb.equal(m.get("policyTypeId"), req.getPolicyTypeId());
//					n5 = cb.equal(m.get("planTypeId"), req.getPlanTypeId());
//					n6 = cb.equal(m.get("coverId"), req.getCoverId());
//					n7 = cb.notEqual(m.get("subCoverId"), "0" );
//					n10 = cb.equal(m.get("amendId"), list.get(0).getAmendId());
//					update.where(n1,n2,n3,n4,n5,n6,n7,n10);
//			
//					em.createQuery(update).executeUpdate();
//					
//				} else { 	// old effstartdate today or future-- delete
//					
//					amendId = list.get(0).getAmendId() ;
//					repository.deleteAll(list);
//			    }
//			}
//			
//		} catch (Exception e) {
//		e.printStackTrace();
//		log.info("Exception is --->" + e.getMessage());
//		return null;
//	}
//	return amendId;
//	
//	}

	@Override
	public List<PolicyTypeSubCoverMasterGetRes> getallPolicyTypesubcover(PolicyTypeSubCoverMasterGetAllReq req) {
		List<PolicyTypeSubCoverMasterGetRes> resList = new ArrayList<PolicyTypeSubCoverMasterGetRes>();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			today = cal.getTime();  //beginning of the date
			
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
			Date todayEnd = cal.getTime(); //today end
			
			List<TravelPolicyType> list = new ArrayList<TravelPolicyType>();
		
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TravelPolicyType> query = cb.createQuery(TravelPolicyType.class);

			// Find All
			Root<TravelPolicyType> b = query.from(TravelPolicyType.class);

			// Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<TravelPolicyType> ocpm1 = amendId.from(TravelPolicyType.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("productId"), b.get("productId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("policyTypeId"),b.get("policyTypeId"));
			Predicate a4 = cb.equal(ocpm1.get("planTypeId"),b.get("planTypeId"));
			Predicate a5 = cb.equal(ocpm1.get("coverId"),b.get("coverId"));
			Predicate a7 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
			Predicate a9 = cb.equal(ocpm1.get("coverId"),  b.get("coverId"));
			Predicate a10 = cb.notEqual(ocpm1.get("subCoverId"), "0");
	
			amendId.where(a1,a2,a3,a4,a5,a7,a9,a10);

			Predicate n1 = cb.equal(b.get("amendId"),amendId);
			Predicate n2 = cb.equal(b.get("productId"), req.getProductId() );	
			Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId() );		
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			Predicate n5 = cb.equal(b.get("coverId"), req.getCoverId());
			Predicate n6 =  cb.equal(b.get("policyTypeId"), req.getPolicyTypeId()); 
			Predicate n7 =  cb.equal(b.get("planTypeId"), req.getPlanTypeId()); 
//			Predicate n8 = cb.lessThanOrEqualTo(b.get("effectiveStartdate"), today);
//			Predicate n9 = cb.greaterThanOrEqualTo(b.get("effectiveEnddate"), todayEnd);
			Predicate n11 = cb.notEqual(b.get("subCoverId"), "0");
			
		
			List<Order> orderList = new ArrayList<Order>();
			orderList.add(cb.desc(b.get("subCoverId")));
			query.where(n1, n2,n3,n4, n5, n6, n7, n11).orderBy(orderList);
			
			TypedQuery<TravelPolicyType> result = em.createQuery(query);
			list = result.getResultList();
			
			if(list.size()>0) {
				
				for(TravelPolicyType data : list) {
					PolicyTypeSubCoverMasterGetRes res = new PolicyTypeSubCoverMasterGetRes();
					res = dozerMapper.map(data,  PolicyTypeSubCoverMasterGetRes.class);
					resList.add(res);
					
				}
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
	
		}
		return resList;
	}

	@Override
	public PolicyTypeSubCoverMasterGetRes getPolicyTypesubcover(GetPolicyTypesubcoverReq req) {
		PolicyTypeSubCoverMasterGetRes res = new PolicyTypeSubCoverMasterGetRes();
		DozerBeanMapper dozerMapper = new DozerBeanMapper();
		try {
			Date today = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			today = cal.getTime();  //beginning of the date
			
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
			Date todayEnd = cal.getTime(); //today end
			
			List<TravelPolicyType> list = new ArrayList<TravelPolicyType>();
		
			// Find Latest Record
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TravelPolicyType> query = cb.createQuery(TravelPolicyType.class);

			// Find All
			Root<TravelPolicyType> b = query.from(TravelPolicyType.class);

			// Select
			query.select(b);

			// Amend ID Max Filter
			Subquery<Long> amendId = query.subquery(Long.class);
			Root<TravelPolicyType> ocpm1 = amendId.from(TravelPolicyType.class);
			amendId.select(cb.max(ocpm1.get("amendId")));
			Predicate a1 = cb.equal(ocpm1.get("productId"), b.get("productId"));
			Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
			Predicate a3 = cb.equal(ocpm1.get("policyTypeId"),b.get("policyTypeId"));
			Predicate a4 = cb.equal(ocpm1.get("planTypeId"),b.get("planTypeId"));
			Predicate a5 = cb.equal(ocpm1.get("coverId"),b.get("coverId"));
			Predicate a7 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
			Predicate a9 = cb.equal(ocpm1.get("coverId"),  b.get("coverId"));
			Predicate a10 = cb.equal(ocpm1.get("subCoverId"),  b.get("subCoverId"));
			Predicate a11 = cb.notEqual(ocpm1.get("subCoverId"),  "0");
	
			amendId.where(a1,a2,a3,a4,a5,a7,a9,a10, a11);

			Predicate n1 = cb.equal(b.get("amendId"),amendId);
			Predicate n2 = cb.equal(b.get("productId"), req.getProductId() );	
			Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId() );		
			Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
			Predicate n5 = cb.equal(b.get("coverId"), req.getCoverId());
			Predicate n6 =  cb.equal(b.get("policyTypeId"), req.getPolicyTypeId()); 
			Predicate n7 =  cb.equal(b.get("planTypeId"), req.getPlanTypeId()); 
//			Predicate n8 = cb.lessThanOrEqualTo(b.get("effectiveStartdate"), today);
//			Predicate n9 = cb.greaterThanOrEqualTo(b.get("effectiveEnddate"), todayEnd);
			Predicate n10 = cb.equal(b.get("subCoverId"), req.getSubCoverId());
			Predicate n11 = cb.notEqual(b.get("subCoverId"),  "0");
			
		
			query.where(n1, n2,n3,n4, n5, n6, n7, n10, n11);
			
			TypedQuery<TravelPolicyType> result = em.createQuery(query);
			list = result.getResultList();

			if (list.size() > 0) 
				res = dozerMapper.map(list.get(0), PolicyTypeSubCoverMasterGetRes.class);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return res;
	
	}

	@Override
	public List<String> validatePolicyTypeSubCover(PolicyTypeMasterSubCoverSingleSaveReq req) {
	
		List<String> errorList = new ArrayList<String>();
		try {
			Date today1 = new Date();
			Calendar cal = new GregorianCalendar();
			cal.setTime(today1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			today1 = cal.getTime();  //beginning of the date
			
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MILLISECOND, 999);
			Date todayEnd1 = cal.getTime(); //today end
			
			// Date Validation 
			Calendar cal1 = new GregorianCalendar();
			Date today = new Date();
			cal1.setTime(today);cal1.add(Calendar.DAY_OF_MONTH, -1);cal1.set(Calendar.HOUR_OF_DAY, 23);cal1.set(Calendar.MINUTE, 50);
			today = cal1.getTime();
			if (req.getEffectiveDateStart() == null ) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Select Effective Date"));
				errorList.add("1261");
	
			} else if (req.getEffectiveDateStart().before(today)) {
//				errorList.add(new Error("04", "EffectiveDateStart", "Please Select Effective Date as Future Date"));
				errorList.add("1262");
			} 
			
			if (StringUtils.isBlank(req.getCreatedBy())) {
//				errorList.add(new Error("06", "CreatedBy", "Please Enter CreatedBy"));
				errorList.add("1270");
			}else if (req.getCreatedBy().length() > 50) {
//				errorList.add(new Error("06", "CreatedBy", "Please Enter CreatedBy within 100 Characters"));
				errorList.add("1271");
			} 
						
			// Other Errors	
			if (StringUtils.isBlank(req.getCompanyId())) {
//				errorList.add(new Error("01", "Insurance Id", "Please Select InsuranceId"));
				errorList.add("1255");
				
			}
			if (StringUtils.isBlank(req.getBranchCode())) {
//				errorList.add(new Error("01", "BranchCode", "Please Select BranchCode"));
				errorList.add("1256");
				
			}
			if (StringUtils.isBlank(req.getProductId())) {
//				errorList.add(new Error("02", "ProductId", "Please Enter ProductId"));
				errorList.add("1313");
			}
			if (StringUtils.isBlank(req.getPolicyTypeId())) {
//				errorList.add(new Error("02", "PolicyTypeId", "Please Select PolicyTypeId"));
				errorList.add("1990");
			}
			if (StringUtils.isBlank(req.getPlanTypeId())) {
//				errorList.add(new Error("02", "PlanTypeId", "Please Select PlanTypeId"));
				errorList.add("1993");
			}

			
			if (StringUtils.isBlank(req.getCoverId())) {
//				errorList.add(new Error("02", "CoverId", "Please Select CoverId"));
				errorList.add("2004");
			}
			if (StringUtils.isBlank(req.getCoverStatus())) {
//				errorList.add(new Error("05", "Cover Status", "Please Select Cover Status"));
				errorList.add("2005");
			} else if (req.getCoverStatus().length() > 1) {
//				errorList.add(new Error("05", "Cover Status", "Please Select Valid Cover Status - 1 Character Only Allwed"));
				errorList.add("2006");
			}
			
			if (StringUtils.isBlank(req.getCoverDesc())) {
//				errorList.add(new Error("02", "CoverDesc", "Please Enter CoverDesc"));
				errorList.add("2007");
			} 
			if (StringUtils.isBlank(req.getPolicyTypeDesc())) {
//				errorList.add(new Error("02", "PolicyTypeDesc", "Please Enter PolicyTypeDesc "));
				errorList.add("2009");
			} 
			if (StringUtils.isBlank(req.getPlanTypeDesc())) {
//				errorList.add(new Error("02", "PlanTypeDesc", "Please Enter PlanTypeDesc "));
				errorList.add("2010");
			} 

			if (StringUtils.isBlank(req.getCurrency())) {
//				errorList.add(new Error("02", "Currency", "Please Enter Currency  " ));
				errorList.add("2011");
			}
			if (StringUtils.isBlank(req.getExcessAmt())) {
//				errorList.add(new Error("02", "ExcessAmt", "Please Enter ExcessAmt "));
				errorList.add("2012");
			}
			
//			if (StringUtils.isBlank(req.getSubCoverId())) {
//				errorList.add(new Error("02", "SubCoverId", "Please Enter SubCoverId " ));
//			}
			
			if (StringUtils.isBlank(req.getSubCoverDesc())) {
//				errorList.add(new Error("02", "SubCoverDesc", "Please Enter SubCoverDesc " ));
				errorList.add("2013");
			}
			
		

			if (StringUtils.isBlank(req.getSumInsured())) {
//				errorList.add(new Error("02", "SumInsured", "Please Enter SumInsured in row " ));
				errorList.add("2014");
			}
			if (StringUtils.isBlank(req.getStatus())) {
//				errorList.add(new Error("05", "SubCover Status", "Please Select SubCover Status"));
				errorList.add("2015");
			} else if (req.getStatus().length() > 1) {
//				errorList.add(new Error("05", "SubCover Status","Please Select Valid SubCover Status - 1 Character Only Allwed"));
						
				errorList.add("2016");
			}
			
			//Duplication find
			if(StringUtils.isNotBlank(req.getCompanyId()) &&  StringUtils.isNotBlank(req.getBranchCode()) && StringUtils.isNotBlank(req.getProductId()) && 
					StringUtils.isNotBlank(req.getPolicyTypeId()) && StringUtils.isNotBlank(req.getPlanTypeId()) && StringUtils.isNotBlank(req.getSubCoverDesc())  
					&& StringUtils.isNotBlank(req.getCoverId()) && StringUtils.isBlank(req.getSubCoverId())) {
				List<TravelPolicyType> list = new ArrayList<TravelPolicyType>();
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<TravelPolicyType> query = cb.createQuery(TravelPolicyType.class);

				// Find All
				Root<TravelPolicyType> b = query.from(TravelPolicyType.class);

				// Select
				query.select(b);

				// Amend ID Max Filter
				Subquery<Long> amendId = query.subquery(Long.class);
				Root<TravelPolicyType> ocpm1 = amendId.from(TravelPolicyType.class);
				amendId.select(cb.max(ocpm1.get("amendId")));
				Predicate a1 = cb.equal(ocpm1.get("productId"), b.get("productId"));
				Predicate a2 = cb.equal(ocpm1.get("companyId"), b.get("companyId"));
				Predicate a3 = cb.equal(ocpm1.get("policyTypeId"),b.get("policyTypeId"));
				Predicate a4 = cb.equal(ocpm1.get("planTypeId"),b.get("planTypeId"));
				Predicate a5 = cb.equal(ocpm1.get("coverId"),b.get("coverId"));
				Predicate a7 = cb.equal(ocpm1.get("branchCode"), b.get("branchCode"));
				Predicate a8 = cb.notEqual(ocpm1.get("subCoverId"),  "0");
		
				amendId.where(a1,a2,a3,a4,a5,a7, a8);

				Predicate n1 = cb.equal(b.get("amendId"),amendId);
				Predicate n2 = cb.equal(b.get("productId"), req.getProductId() );	
				Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId() );		
				Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
				Predicate n5 = cb.equal(b.get("coverId"), req.getCoverId());
				Predicate n6 =  cb.equal(b.get("policyTypeId"), req.getPolicyTypeId()); 
				Predicate n7 =  cb.equal(b.get("planTypeId"), req.getPlanTypeId()); 
				Predicate n8 = cb.notEqual(b.get("subCoverId"),  "0");
//				Predicate n8 = cb.lessThanOrEqualTo(b.get("effectiveStartdate"), today1);
//				Predicate n9 = cb.greaterThanOrEqualTo(b.get("effectiveEnddate"), todayEnd1);
			
				query.where(n1, n2,n3,n4, n5, n6, n7, n8);
				
				TypedQuery<TravelPolicyType> result = em.createQuery(query);
				list = result.getResultList();
				
				if(list.size()>0) {
					
					List<TravelPolicyType> dup = list.stream().filter(o -> (o.getSubCoverDesc()==null?"":o.getSubCoverDesc().trim().replaceAll("\\s+", "")).equalsIgnoreCase(req.getSubCoverDesc().trim().replaceAll("\\s+", ""))).collect(Collectors.toList());
					if(dup.size()>0)
//						errorList.add(new Error("02", "SubCoverDesc","SubCover '" + req.getSubCoverDesc() + "' Already Exists"));
					errorList.add("2017");
								
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return errorList;
					 
		
	
	
	}

	@Override
	public SuccessRes2 insertPolicyTypeSubCover(PolicyTypeMasterSubCoverSingleSaveReq req) {
		SuccessRes2 res = new SuccessRes2();
		TravelPolicyType saveData = new TravelPolicyType();
		DozerBeanMapper dozerMapper = new  DozerBeanMapper();
		try {
			Integer amendId = 0;
			Date StartDate = req.getEffectiveDateStart();
			String end = "31/12/2050";
			Date endDate = sdf.parse(end);
			long MILLS_IN_A_DAY = 1000*60*60*24;
			Date oldEndDate = new Date(req.getEffectiveDateStart().getTime()- MILLS_IN_A_DAY);
			Date entryDate = null;
			String createdBy ="";
			Integer subCoverId = 0;
			
			List<TravelPolicyType> old = repository.findByProductIdAndBranchCodeAndCompanyIdAndCoverIdAndPolicyTypeIdAndPlanTypeIdOrderBySubCoverIdDesc(
					Integer.valueOf(req.getProductId()), req.getBranchCode(), req.getCompanyId(),
					Integer.valueOf(req.getCoverId()),Integer.valueOf(req.getPolicyTypeId()),Integer.valueOf(req.getPlanTypeId()) );
			
			//if(old.size()<=0 ) {   //Insert
			if(StringUtils.isBlank(req.getSubCoverId())) {
				
				subCoverId = old.get(0).getSubCoverId() + 1;
				
				entryDate = new Date();
				createdBy = req.getCreatedBy();
				res.setResponse("Saved Successfully");
				
			}
			else {  //update
				
				subCoverId = Integer.valueOf( req.getSubCoverId());
				
				List<TravelPolicyType> list = new ArrayList<TravelPolicyType>();
				
				// Find Latest Record
				CriteriaBuilder cb = em.getCriteriaBuilder();
				CriteriaQuery<TravelPolicyType> query = cb.createQuery(TravelPolicyType.class);

				// Find All
				Root<TravelPolicyType> b = query.from(TravelPolicyType.class);

				// Select
				query.select(b);

				List<Order> orderList = new ArrayList<Order>();
			    orderList.add(cb.desc(b.get("amendId")));
		
				Predicate n2 = cb.equal(b.get("productId"), req.getProductId() );	
				Predicate n3 = cb.equal(b.get("companyId"), req.getCompanyId() );		
				Predicate n4 = cb.equal(b.get("branchCode"), req.getBranchCode());
				Predicate n5 = cb.equal(b.get("coverId"), req.getCoverId());
				Predicate n6 =  cb.equal(b.get("policyTypeId"), req.getPolicyTypeId()); 
				Predicate n7 =  cb.equal(b.get("planTypeId"), req.getPlanTypeId()); 
				Predicate n10 = cb.equal(b.get("subCoverId"), req.getSubCoverId());
				Predicate n11 = cb.notEqual(b.get("subCoverId"),  "0");
		
				query.where(n2,n3,n4, n5, n6, n7,n10, n11) ;
			
				TypedQuery<TravelPolicyType> result = em.createQuery(query);
				int limit=0, offset=2;
				result.setFirstResult(limit * offset);
				result.setMaxResults(offset);
				list = result.getResultList();
				
				if(list.size()>0) {
					Date beforeOneDay = new Date(new Date().getTime()- MILLS_IN_A_DAY);
					
					if(list.get(0).getEffectiveStartdate().before(beforeOneDay)) {
						amendId = list.get(0).getAmendId()+1;
						entryDate = new Date();
						createdBy = req.getCreatedBy();
						TravelPolicyType lastRecord = list.get(0);
						lastRecord.setEffectiveEnddate(oldEndDate);
						repository.saveAndFlush(lastRecord);
					}
					else {
						amendId = list.get(0).getAmendId();
						entryDate = list.get(0).getEntryDate();
						createdBy = list.get(0).getUpdatedBy();
					
						if(list.size()>1) {
							TravelPolicyType lastRecord = list.get(1);	
							lastRecord.setEffectiveEnddate(oldEndDate);
							repository.saveAndFlush(lastRecord);
						}
					}
				}
				res.setResponse("Updated Successfully");
				
			}
			
			dozerMapper.map(req, saveData);
			
			saveData.setSubCoverId(subCoverId);
			saveData.setEffectiveStartdate(StartDate);
			saveData.setEffectiveEnddate(endDate);
			saveData.setEntryDate(entryDate);
			saveData.setUpdatedBy(req.getCreatedBy());
			saveData.setUpdatedDate(new Date());
			saveData.setAmendId(amendId);
			
			repository.saveAndFlush(saveData);
			res.setSuccessId(subCoverId.toString());
			
			}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Exception is --> " + e.getMessage());
			return null;
		}
		return res;
	}

}