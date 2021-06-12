package oi.demo.drools.service.impl;


import lombok.extern.log4j.Log4j2;
import oi.demo.drools.dto.OrderRequest;
import oi.demo.drools.service.DroolService;
import oi.demo.drools.service.OrderService;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    private final DroolService droolService;

    public OrderServiceImpl(DroolService droolService) {
        this.droolService = droolService;
    }

    @Override
    public ResponseEntity<Object> processOrder(OrderRequest orderRequest) {
        KieSession session = droolService.getSession();
        session.insert(orderRequest);
        session.fireAllRules();
        session.dispose();
        return new ResponseEntity<>(orderRequest, HttpStatus.ACCEPTED);
    }

}
