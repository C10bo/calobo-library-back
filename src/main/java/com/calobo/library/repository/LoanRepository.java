package com.calobo.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calobo.library.repository.entity.LoanEntity;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    List<LoanEntity> findByUserId(Long userId);
    List<LoanEntity> findByBookId(Long bookId);
    boolean existsByUserIdAndBookIsbnAndLoanStatus(
        Long userId,
        String isbn,
        String loanStatus
    );
    
}
