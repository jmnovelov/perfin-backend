package com.perfin.repositories;

import com.perfin.entities.Period;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Long> {
    
    Period findById(long id);
}
