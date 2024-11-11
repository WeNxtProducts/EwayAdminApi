/*
 * Created on 2022-11-21 ( 15:19:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


import java.util.Date;

/**
 * Composite primary key for entity "CompanyTaxSetup" ( stored in table "company_tax_setup" )
 *
 * @author Telosys
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductTaxSetupId implements Serializable {

	
	private Integer taxId;
    private Integer productId ;
	private String companyId;
    private Integer amendId;
    private String branchCode ;
    private String   countryId;
    private String   taxFor;
         
}
