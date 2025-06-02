package org.example.myapigateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    private final Logger logger = LoggerFactory.getLogger(FallBackController.class);

    @GetMapping("/fallback/book")
    public String bookTest(){
        return "📘 Book Service is currently unavailable. " +
                "Please try again later okay.. dont worry !!.";

    }

    @GetMapping("/fallback/booktest2")
    public String bookTest2(){
        logger.info("🚨 Fallback triggered after retries failed!");
        return "📘 Book Service is currently unavailable.";

    }
}
