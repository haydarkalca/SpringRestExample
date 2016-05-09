package com.restexample.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "userTable")
// db ye basacağı tablo ismini veriyoruz.Camel case i alt çizgiye dönüştürüyor.
@Data
//@Getter
//@Setter
//@ToString
//@EqualsandHashcode  
//Data altındakilerin hepsini karşılıyor.
public class UserEntity extends BaseEntity{
	@Id
	@GeneratedValue//otomatik incremental artacak .auto generate için
	private Long id;

	@Column(length = 140, nullable = false)
	private String userName;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
//	@Column
//	private int age;

//	@Column(precision = 5)
//	// 5'e 0 tanımlıyor uzunluğu
//	private BigDecimal bigdecimalcolumn;
	
//	@Column
//	@Lob
//	private String explanation; //string olduğu için text(clob) yaptı
	
//	@Column
//	@Lob
//	private int encodeInt; //integer olduğu için oid(blob) yaptı
	
	@OneToOne
	private ProfileEntity profile;
	
	@OneToMany(mappedBy="userEntity",cascade={CascadeType.MERGE,CascadeType.REMOVE},fetch=FetchType.LAZY) //ara tablo oluşturmuyor mappedBy kullanınca.Ara tablodan ziyade foreign key lerle oluşturuyor.
	private List<TweetEntity> tweets;						    //remove constraint olsa dahi ilk önce git ilgili tablodan sil demek.daha sonra ana tablodan sil
																//Lazy oncelikle ana entity nin selectini cekiyor.Daha sonra ihtiyac olursa digerlerinin selectini ayrı atıyor.
//	@ManyToMany
//	private List<GroupEntity> groupEntities;

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	
//	@CreatedDate
//	private Date createdDate;
//	
//	@LastModifiedDate
//	private Date lastModifiedDate;  //baseEntity den gelecek

}
