package org.example.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    private final Logger  logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("test")
    public Map<?,?> test(
            @RequestHeader(value = "App-Key", required = false) String clientHeader,
            @RequestHeader(value = "X-Gateway-Header", required = false) String gatewayHeader
    ) throws InterruptedException {

        Thread.sleep(10000);  // for the circuit breaker

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
    public ResponseEntity<?> testRetry(){
        // for the retry... to see if this is called the number of retry times
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("not available");
    }

}
