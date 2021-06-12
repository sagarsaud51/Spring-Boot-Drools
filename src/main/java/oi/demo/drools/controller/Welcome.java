package oi.demo.drools.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class Welcome {

    @GetMapping
    public ResponseEntity<Object> welcome(){
        return ResponseEntity.ok("<h2><marquee>Welcome to Drool Seed Project</marquee></h2>");
    }
}
