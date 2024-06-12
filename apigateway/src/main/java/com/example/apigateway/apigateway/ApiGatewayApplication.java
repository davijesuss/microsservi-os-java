package com.example.apigateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("order_service", r -> r.path("/orders/**")
						.uri("lb://order-service"))
				.route("payment_service", r -> r.path("/payments/**")
						.uri("lb://payment-service"))
				.route("shipping_service", r -> r.path("/shippings/**")
						.uri("lb://shipping-service"))
				.build();
	}
}
