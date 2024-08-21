package com.java.controller;

import com.java.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    private static final Logger logger=LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public Map<String, String> hello(@RequestParam(defaultValue = "world") String name){

        //MDC.put("UserId","1234");
        logger.info("The name was "+name);

        return Map.of("greeting", "Hello "+name);
    }


    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        System.out.println("greet");
        if ("error".equalsIgnoreCase(name)) {

            throw new CustomException("Custom exception triggered");
        }
        logger.info("The name was "+name);
        return "The name is "+name;
    }
}
