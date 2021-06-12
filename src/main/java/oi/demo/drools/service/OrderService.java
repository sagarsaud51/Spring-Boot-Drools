package oi.demo.drools.service;


import oi.demo.drools.dto.OrderRequest;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<Object> processOrder(OrderRequest orderRequest);
}
