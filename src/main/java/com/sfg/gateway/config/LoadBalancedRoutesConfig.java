package com.sfg.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jt on 3/7/20.
 */
@Slf4j
@Profile("local-discovery")
@Configuration
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder builder){
        log.info(">>>> LoadBalancedRoutesConfig");
        return builder.routes()
                .route("beer-service", r -> r.path("/api/v1/beer*", "/api/v1/beer/*", "/api/v1/beerUpc/*")
                        .uri("lb://beer-service"))
                .route("order-service", r -> r.path("/api/v1/customers/**")
                        .uri("lb://order-service"))
                .route("inventory-service", r -> r.path("/api/v1/beer/*/inventory")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("inventoryCB")
//                                        .setFallbackUri("forward:/inventory-failover")
//                                        .setRouteId("inv-failover")
//                                    ))
                        .uri("lb://inventory-service"))
                .route("inventory-failover-service", r -> r.path("/inventory-failover/**")
                        .uri("lb://inventory-failover"))
                .build();
    }

}
