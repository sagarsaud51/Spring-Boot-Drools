package oi.demo.drools.controller;


import oi.demo.drools.constant.ApiConstants;
import oi.demo.drools.dto.LoanRequest;
import oi.demo.drools.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiConstants.LOAN)
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Object> processLoan(@RequestBody LoanRequest loanRequest){
        return loanService.processLoan(loanRequest);
    }
}
