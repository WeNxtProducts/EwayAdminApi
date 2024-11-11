/*
 * Created on 2023-05-11 ( 16:43:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.batch.entity;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "EserviceMotorDetailsRaw" ( stored in table "eservice_motor_details_raw" )
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
public class EserviceMotorDetailsRawId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Integer    companyId ;
    
    private Integer    productId ;
    
    private Integer    sectionId ;
    
    private Integer    typeid ;
    
    private String     requestReferenceNo ;
    
    private Integer    vehicleId ;
    
     
}
