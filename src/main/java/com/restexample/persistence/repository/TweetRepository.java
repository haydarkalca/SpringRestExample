package com.restexample.persistence.repository;

import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.restexample.persistence.entity.TweetEntity;
import com.restexample.persistence.entity.UserEntity;

public interface TweetRepository extends  PagingAndSortingRepository<TweetEntity, Long>{
	
	Collection<TweetEntity> findByUserEntity(UserEntity userEntity);
	Collection<TweetEntity> findByUserEntityId(Long id);
	Collection<TweetEntity> findTop5ByUserEntityIdOrderById(Long id);

}
