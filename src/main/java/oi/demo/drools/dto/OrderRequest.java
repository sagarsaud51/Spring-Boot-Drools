package oi.demo.drools.dto;


import lombok.Data;

@Data
public class OrderRequest {

    private Integer orderId;
    private String paymentType;
    private Double totalPrice;
    private Double discount;
}
