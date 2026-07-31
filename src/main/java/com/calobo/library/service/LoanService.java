package com.calobo.library.service;

import java.util.List;

import com.calobo.library.models.request.LoanRequest;
import com.calobo.library.repository.entity.LoanEntity;

public interface LoanService {
    
    List<LoanEntity> getLoanByUser(Long id);
    List<LoanEntity> getLoanByBook(Long id);
    LoanEntity createLoan(LoanRequest request);
    LoanEntity updateLoan(Long id, LoanRequest request);

}
