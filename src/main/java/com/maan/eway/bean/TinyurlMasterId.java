/*
 * Created on 2023-05-26 ( 13:02:01 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "TinyurlMaster" ( stored in table "tinyurl_master" )
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
public class TinyurlMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Integer    sno ;
    
    private String     companyId ;
    
    private Integer    productId ;
    
    private String     branchCode ;
    
    private Integer    amendId ;
    
     
}