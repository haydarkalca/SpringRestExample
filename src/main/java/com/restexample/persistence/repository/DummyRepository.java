package com.restexample.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import com.restexample.persistence.entity.DummyEntity;

public interface  DummyRepository extends CrudRepository<DummyEntity, Long> {

}
