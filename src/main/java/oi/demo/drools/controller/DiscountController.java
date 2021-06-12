package oi.demo.drools.controller;


import oi.demo.drools.constant.ApiConstants;
import oi.demo.drools.dto.OrderRequest;
import oi.demo.drools.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.DISCOUNT)
public class DiscountController {

    private final OrderService orderService;

    public DiscountController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Object> placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.processOrder(orderRequest);
    }
}
