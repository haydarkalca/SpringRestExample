package com.restexample.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tweets")
@Data
public class TweetEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String content;

	@ManyToOne
	private UserEntity userEntity;// mappedBy da buradaki isim ile almamız lazım
									// UserEntity tarafında

	// @CreatedDate
	// private Date createdDate;
	//
	// @LastModifiedDate
	// private Date lastModifiedData;
}
