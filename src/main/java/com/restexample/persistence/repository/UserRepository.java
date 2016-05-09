package com.restexample.persistence.repository;
import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.restexample.persistence.entity.UserEntity;

public interface UserRepository extends  PagingAndSortingRepository<UserEntity, Long> //CrudRepository<UserEntity,Long> 
{
	Collection<UserEntity> findByLastName(String param);//collection yaptık çünkü birden fazla satır dönebilir 
	UserEntity findByUserName(String param);///unique için tek bir userEntity kullanmak mantıklı
	UserEntity findByUserNameAndLastName(String userName ,String lastName);

}
