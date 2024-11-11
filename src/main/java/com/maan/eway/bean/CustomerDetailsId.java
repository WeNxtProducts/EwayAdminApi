/*
 * Created on 2022-09-02 ( 18:14:51 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


import java.util.Date;

/**
 * Composite primary key for entity "CoverMaster" ( stored in table "cover_master" )
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
public class CustomerDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer     customerId;
    private String     gstNo ;

    
     
}
