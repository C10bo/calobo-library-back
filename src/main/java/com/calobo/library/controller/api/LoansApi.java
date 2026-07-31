package com.calobo.library.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calobo.library.models.request.LoanRequest;
import com.calobo.library.repository.entity.LoanEntity;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping(path = "/loan")
public interface LoansApi {
    
    @GetMapping("/user/{id}")
    @Operation(summary = "Service to get loans by user", tags = "Loans")
    ResponseEntity<List<LoanEntity>> getLoanByUser(@PathVariable Long id);

    @GetMapping("/book/{id}")
    @Operation(summary = "Service to get loans by book", tags = "Loans")
    ResponseEntity<List<LoanEntity>> getLoanByBook(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Service to create loan", tags = "Loans")
    ResponseEntity<LoanEntity> createLoan(@RequestBody LoanRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Service to update loan", tags = "Loans")
    ResponseEntity<LoanEntity> updateLoan(@PathVariable Long id, @RequestBody LoanRequest request);

}
