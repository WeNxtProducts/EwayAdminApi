/*
 * Created on 2022-11-21 ( 15:20:29 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "SectionCoverMaster" ( stored in table "section_cover_master" )
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
public class SectionCoverMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Integer    coverId ;
    
    private Integer    sectionId ;
    
    private Integer    productId ;
    
    private String     companyId ;
    
    private Integer    subCoverId ;
    
    private Integer    amendId ;
    
    private String     agencyCode;
    
    private String     branchCode ;
    
     
}