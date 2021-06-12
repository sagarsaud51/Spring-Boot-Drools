package oi.demo.drools.service;

import oi.demo.drools.dto.LoanRequest;
import org.springframework.http.ResponseEntity;

public interface LoanService {
    ResponseEntity<Object> processLoan(LoanRequest loanRequest);
}
