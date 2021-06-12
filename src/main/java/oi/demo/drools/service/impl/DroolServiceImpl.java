package oi.demo.drools.service.impl;

import lombok.extern.log4j.Log4j2;
import oi.demo.drools.service.DroolService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class DroolServiceImpl implements DroolService {

    private final KieContainer kieContainer;

    public DroolServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public KieSession getSession() {
        return kieContainer.newKieSession();
    }
}
