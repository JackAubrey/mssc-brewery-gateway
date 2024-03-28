package com.sfg.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jt on 3/5/20.
 */
@Slf4j
@Profile("google")
@Configuration
public class GoogleConfig {

    /**
     * This is just an example of routing requests to Google from localhost. For demonstration only
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
        log.info(">>>> GoogleConfig");
        // given a path
        //      ex: r.path("/googlesearch2")
        // filter
        //      ex: .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
        // route to uri
        //      ex: .uri("https://google.com")
        return builder.routes()
                .route("google", r -> r.path("/googlesearch2")
                        .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                .uri("https://google.com"))
                .build();
    }
}
