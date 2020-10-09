package com.perfin.restservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.perfin.entities.Budget;
import com.perfin.repositories.BudgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class BudgetController {
    
    @Autowired
    private BudgetRepository repository;

    @GetMapping("/budget")
    public List<Budget> getAllBudgets() {
        List<Budget> result = new ArrayList<>();
        repository.findAll().forEach(b -> result.add(b));
        return result;
    }

    @PutMapping("/budget")
    public ResponseEntity<Object> upsert(@RequestBody Budget budget) {
        Budget savedBudget = repository.save(budget);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBudget.getBudgetId()).toUri();

        return ResponseEntity.ok().location(location).build();
    }
}
