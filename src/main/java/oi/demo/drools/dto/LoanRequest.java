package oi.demo.drools.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanRequest {

    private BigDecimal monthlyIncome;
    private BigDecimal appliedLoan;
    private Boolean approved = false;

}
