/*
 * Created on 2023-03-03 ( 18:59:37 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "YiChargeDetail" ( stored in table "yi_charge_detail" )
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
public class YiChargeDetailId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     chargeCode ;
    
    private String     requestreferenceno ;
    
     
}
