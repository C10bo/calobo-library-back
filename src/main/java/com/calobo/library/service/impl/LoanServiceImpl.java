package com.calobo.library.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.calobo.library.models.request.LoanRequest;
import com.calobo.library.repository.BookRepository;
import com.calobo.library.repository.LoanRepository;
import com.calobo.library.repository.UserRepository;
import com.calobo.library.repository.entity.BookEntity;
import com.calobo.library.repository.entity.LoanEntity;
import com.calobo.library.repository.entity.UserEntity;
import com.calobo.library.service.LoanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    @Override
    public List<LoanEntity> getLoanByUser(Long id) {
        return loanRepository.findByUserId(id);
    }

    @Override
    public List<LoanEntity> getLoanByBook(Long id) {
        return loanRepository.findByBookId(id);
    }

    @Override
    public LoanEntity createLoan(LoanRequest request) {
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario No Existe"));
        BookEntity book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Libro No Existe"));

        boolean hasLoan = loanRepository .existsByUserIdAndBookIsbnAndLoanStatus(
            user.getId(),
            book.getIsbn(),
            "ACTIVE"
        );

        if(hasLoan){
            throw new RuntimeException("Ya solicito un ejemplar del libro");
        }

        LoanEntity loan = LoanEntity.builder()
                .user(user)
                .book(book)
                .loanDate(LocalDate.parse(request.getLoanDate()))
                .returnDate(LocalDate.parse(request.getReturnDate()))
                .loanStatus(request.getLoanStatus())
                .build();

        loanRepository.save(loan);

        return loan;
    }

    @Override
    public LoanEntity updateLoan(Long id, LoanRequest request) {
        LoanEntity loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Prestamo No Registra"));

        loan.setLoanDate(LocalDate.parse(request.getLoanDate()));
        loan.setReturnDate(LocalDate.parse(request.getReturnDate()));
        loan.setLoanStatus(request.getLoanStatus());
        return null;
    }

}
