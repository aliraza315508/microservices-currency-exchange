Currency Exchange Microservices System

This project is a distributed microservices system built using Spring Boot and Spring Cloud. It demonstrates how multiple services communicate using service discovery, API gateway routing, and distributed tracing.

The system simulates real-world currency exchange and conversion operations and follows modern microservice architecture patterns.

What This Project Demonstrates

Service-to-service communication

Service discovery using Eureka

API Gateway as a single entry point

Distributed tracing with Zipkin

Resilience using retry and rate limiting

Clean microservice separation

Services Included

Naming Server
Acts as the service registry where all services register themselves.

API Gateway
Routes incoming requests to appropriate services and acts as a centralized entry point.

Currency Exchange Service
Provides exchange rates between currencies.

Currency Conversion Service
Uses exchange rate data to calculate currency conversion.

Zipkin
Used to visualize distributed tracing across services.

Technology Used

Java 17
Spring Boot
Spring Cloud
Maven
Docker
Zipkin

How It Works

When a request is made to the API Gateway, it forwards the request to the appropriate service using service discovery instead of hardcoded URLs.

All services register with the Naming Server and communicate using service names.

Tracing information is sent to Zipkin to track request flow between services.

Key Features

Clean separation of services
Container-ready architecture
Observability support
Scalable design
Cloud deployment ready
