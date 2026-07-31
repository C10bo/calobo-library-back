package com.calobo.library.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    
    private Long userId;
    private Long bookId;
    private String loanDate;
    private String returnDate;
    private String loanStatus;

}
