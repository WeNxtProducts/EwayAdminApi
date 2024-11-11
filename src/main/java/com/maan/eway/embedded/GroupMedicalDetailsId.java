/*
 * Created on 2023-07-31 ( 13:52:09 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.embedded;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


import java.util.Date;

/**
 * Composite primary key for entity "GroupMedicalDetails" ( stored in table "group_medical_details" )
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
public class GroupMedicalDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     mobileNo ;
    
    private String     planOpted ;
    
    private Date       inceptionDate ;
    
    private Date       expiryDate ;
    
     
}