package com.bexos.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-service")
public class UserServiceController {

    @GetMapping("/hello")
    public String Hello(@RequestHeader("x-client-type") String clientTypeHeader,
                        @RequestHeader("x-gateway-header") String gatewayHeader){

        return "Hello from user service. \nHeaders:\n" + "x-client-type: " + clientTypeHeader + "\n" +
                "x-gateway-header: " + gatewayHeader + "\n";
    }
}
