package org.example.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("test")
    public Map<?,?> test(
            @RequestHeader(value = "App-Key", required = false) String clientHeader,
            @RequestHeader(value = "X-Gateway-Header", required = false) String gatewayHeader
    ){

        Map<String, String> res = new HashMap<>();
        res.put("message", "Hello from Book Service");

        // checking for the gateway header
        var theGatewayHeader = gatewayHeader == null ? "not found" : gatewayHeader;
        var theClientHeader = clientHeader == null ? "not found" : clientHeader;

        res.put("the AddRequestHeader", theGatewayHeader);
        res.put("the client header", theClientHeader);

        return res;
    }

    @GetMapping("/test2")
    public String simpleTest(){
        return "Hiiiii";
    }

}
