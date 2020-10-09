package com.perfin.restservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.perfin.repositories.AccountRepository;
import com.perfin.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AccountControler {

    @Autowired
    private AccountRepository repository;

    @GetMapping("/account")
    public List<Account> findAll() {
        final List<Account> accounts = new ArrayList<>();
        repository.findAll().forEach(a -> accounts.add(a));
        return accounts;
    }

    @PutMapping("/account")
    public ResponseEntity<Object> upsert(@RequestBody Account account) {
        Account savedAccount = repository.save(account);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAccount.getAccountId()).toUri();
        return ResponseEntity.ok().location(location).build();
    }
}