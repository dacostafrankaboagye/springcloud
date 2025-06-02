package com.bexos.gateway_server;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/fallback/bookservice")
    @ResponseStatus(HttpStatus.OK)
    public String fallbackBookService() {
        return "Book service is currently unavailable. Please try again later.";
    }
}
