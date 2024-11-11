/*
 * Created on 2022-11-21 ( 15:20:04 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "EserviceMotorDetails" ( stored in table "eservice_motor_details" )
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
public class EserviceMotorDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     customerReferenceNo ;
    
    private String     requestReferenceNo ;
    
    private String     idNumber ;
    
    private Integer    riskId ;
  
    
     
}