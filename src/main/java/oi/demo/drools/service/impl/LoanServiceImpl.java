package oi.demo.drools.service.impl;


import lombok.extern.log4j.Log4j2;
import oi.demo.drools.dto.LoanRequest;
import oi.demo.drools.service.DroolService;
import oi.demo.drools.service.LoanService;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LoanServiceImpl implements LoanService {


    private final DroolService droolService;

    public LoanServiceImpl(DroolService droolService) {
        this.droolService = droolService;
    }

    @Override
    public ResponseEntity<Object> processLoan(LoanRequest loanRequest) {
        KieSession session = droolService.getSession();
        session.insert(loanRequest);
        session.fireAllRules();
        session.dispose();
        return new ResponseEntity<>(loanRequest, HttpStatus.ACCEPTED);
    }
}
