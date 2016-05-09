package com.restexample.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="dummies")
@Data
@SequenceGenerator(name="dami_seq" ,sequenceName="dami_dbname_seq",initialValue=1,allocationSize=10) //generator type sequence olunca bu değerleri vermak lazım 
public class DummyEntity {	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //Entity bazında sequence lama yapıcak
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="dami_seq") //Database de sequence yaratacak
	private Long id ;	
	
	@Column(unique=true)
    private String description;
    
    @Column(updatable=false)
    private String updatable;
    
    @Column(insertable=false)
    private String insertable;
    
    

}
