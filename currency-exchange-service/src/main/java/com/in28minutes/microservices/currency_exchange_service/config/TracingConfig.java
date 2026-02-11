package com.in28minutes.microservices.currency_exchange_service.config;


import io.micrometer.tracing.SamplerFunction;
import io.micrometer.tracing.http.HttpRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {

    @Bean
    SamplerFunction<HttpRequest> httpRequestSampler() {
        return request -> {
            if (request == null) {
                return false;
            }

            String path = request.path();

            // Trace only the business endpoint.
            return path != null && path.equals("/currency-exchange/from/USD/to/INR/");

        };
    }
}
