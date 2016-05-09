package com.restexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restexample.persistence.entity.DummyEntity;
import com.restexample.persistence.repository.DummyRepository;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    public Iterable<DummyEntity> dummies() {
        return dummyRepository.findAll();
    }


    public DummyEntity save(DummyEntity dummyEntity) {
        dummyEntity = dummyRepository.save(dummyEntity);
        return dummyEntity;
    }

    public DummyEntity update(DummyEntity dummy, Long id) {
    	if(id == 99) {
            throw new RuntimeException();
        }
        DummyEntity founded = dummyRepository.findOne(id);
        founded.setDescription(dummy.getDescription());
        founded.setUpdatable(dummy.getUpdatable());

        return dummyRepository.save(founded);

    }
}
