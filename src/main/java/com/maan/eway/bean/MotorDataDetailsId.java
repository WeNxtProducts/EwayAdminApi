/*
 * Created on 2022-11-21 ( 15:20:16 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "MotorDataDetails" ( stored in table "motor_data_details" )
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
public class MotorDataDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     quoteNo ;
    
    private String     requestReferenceNo ;
    
    private String     vehicleId ;
    
     
}
