package com.maan.eway.batch.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Builder
@Table(name="seq_refno")


public class SqlSeqNumber implements Serializable {
 
private static final long serialVersionUID = 1L;
 
    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="REQUEST_REFERENCE_NO", nullable=false)
    private Long       requestReferenceNo ;

    //--- ENTITY DATA FIELDS 

    //--- ENTITY LINKS ( RELATIONSHIP )


}