package org.example.myapigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CFilter implements GlobalFilter, Ordered {

    // private final Logger logger = LoggerFactory.getLogger(CFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // var requestPath = exchange.getRequest().getPath().toString();
       //  logger.info("Prefilter -> Request path = {}", requestPath);

        // add the filter to the request
        var modifiedRequest = exchange.getRequest()
                .mutate()
                .header("X-Gateway-Header", "Lab-Gateway")
                .build();


        return chain.filter(
                exchange.mutate()
                        .request(modifiedRequest)
                        .build()
        );
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
