package com.calobo.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.calobo.library.controller.api.LoansApi;
import com.calobo.library.models.request.LoanRequest;
import com.calobo.library.repository.entity.LoanEntity;
import com.calobo.library.service.LoanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LoanController implements LoansApi {

    private final LoanService loanService;
    
    @Override
    public ResponseEntity<List<LoanEntity>> getLoanByUser(Long id) {
        return ResponseEntity.ok(loanService.getLoanByUser(id));
    }

    @Override
    public ResponseEntity<List<LoanEntity>> getLoanByBook(Long id) {
        return ResponseEntity.ok(loanService.getLoanByBook(id));
    }

    @Override
    public ResponseEntity<LoanEntity> createLoan(LoanRequest request) {
        return ResponseEntity.ok(loanService.createLoan(request));
    }

    @Override
    public ResponseEntity<LoanEntity> updateLoan(Long id, LoanRequest request) {
        return ResponseEntity.ok(loanService.updateLoan(id, request));
    }

}
