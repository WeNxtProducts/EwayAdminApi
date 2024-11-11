/*
 * Created on 2023-01-11 ( 13:27:45 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.maan.eway.bean;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;



/**
 * Composite primary key for entity "NotifTemplateMaster" ( stored in table "notif_template_master" )
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
public class NotifTemplateMasterId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String       notifTemplateCode ;
    
    private String     companyId ;
    
    private Long       productId ;
    
    private Integer       amendId ;
     
}
