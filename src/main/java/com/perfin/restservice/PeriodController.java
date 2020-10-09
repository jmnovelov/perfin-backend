package com.perfin.restservice;

import java.net.URI;

import com.perfin.entities.Period;
import com.perfin.repositories.PeriodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PeriodController {
    
    @Autowired
    private PeriodRepository repository;

    @GetMapping("/period/{id}")
    public Period findPeriodById(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    @PutMapping("/period")
    public ResponseEntity<Object> upsert(@RequestBody Period period) {
        Period savedPeriod = repository.save(period);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPeriod.getPeriodId()).toUri();

        return ResponseEntity.ok().location(location).build();
    }
}
