package br.com.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
	    return builder.routes()
	            .route(p -> p
	            		.path("/producao-service/**")
	            		.filters(f -> f.stripPrefix(1))
	                    .uri("lb://producao-service"))
	            .route(p -> p
	            		.path("/movimentacao-service/**")
	            		.filters(f -> f.stripPrefix(1))
	                    .uri("lb://movimentacao-service"))
	            .build();
	}


}