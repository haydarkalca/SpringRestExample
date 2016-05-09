package com.restexample.persistence.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class GroupEntity {
	@Id
	private Long id;
	
	private String title;
	
//	@ManyToMany
//	private List<UserEntity> userEntityList;

}
