/*
 * Java domain class for entity "PersonalInfo" 
 * Created on 2022-10-11 ( Date ISO 2022-10-11 - Time 15:28:59 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
package com.maan.eway.common.req;

import java.io.Serializable;

import lombok.*;
import java.util.Date;


import java.util.Date;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Domain class for entity "PersonalInfo"
 *
 * @author Telosys Tools Generator
 *
 */
 
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MsPersonalInfoGetallReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Limit")
    private String   limit;
	
	@JsonProperty("Offset")
    private String    offset   ;
	  
}