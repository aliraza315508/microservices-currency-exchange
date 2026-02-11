package com.in28minutes.microservices.api_gateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()

                /*.route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
 */
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))

                .route(p -> p.path("/currency-conversion-microservices/**")
                        .uri("lb://currency-conversion-microservices"))

                .route(p -> p.path("/currency-conversion-microservices-feign/**")
                        .uri("lb://currency-conversion-microservices" ))

                .route(p -> p.path("/currency-conversion-microservices-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-microservices-new/(?<segment>.*)",
                                "/currency-conversion-microservices-feign/${segment}"
                        ))
                        .uri("lb://currency-conversion-microservices"))


                .build();
    }

}
