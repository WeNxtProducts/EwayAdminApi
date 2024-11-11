/*
 * Created on 2022-11-21 ( 15:19:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "ConstantTableDetails" ( stored in table "constant_table_details" )
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
public class ConstantTableDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Integer    itemId ;
    
    private String     companyId ;
    
    private String     branchCode ;
    
    private Integer    productId ;
    
    private Integer    amendId ;
    
     
}
