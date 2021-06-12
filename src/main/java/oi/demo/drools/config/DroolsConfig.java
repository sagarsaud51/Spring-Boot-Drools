package oi.demo.drools.config;


import lombok.extern.log4j.Log4j2;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
@Log4j2
public class DroolsConfig {


    private final KieServices kieServices = KieServices.Factory.get();


    @Value("classpath:drools/*.drl")
    Resource[] droolsFiles;

    @Bean
    public KieContainer getKieContainer() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource("drools/discount.drl"));
        registerDroolFiles(kieFileSystem);
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private void registerDroolFiles(KieFileSystem kieFileSystem) throws IOException {
        for(Resource resource: droolsFiles){
            kieFileSystem.write(ResourceFactory.newUrlResource(resource.getURL()));
        }
    }

}
