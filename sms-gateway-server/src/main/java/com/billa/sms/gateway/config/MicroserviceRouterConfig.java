package com.billa.sms.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.billa.sms.gateway.filters.CustomGatewayFilter;

@Configuration
public class MicroserviceRouterConfig {

	CustomGatewayFilter gatewayFilter;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		RouteLocatorBuilder.Builder builder2 = builder.routes();

		builder2.route("path_users",
				r -> r.path("/users/**")
						.filters(f -> f.filter(gatewayFilter).circuitBreaker(
								c -> c.setName("USERS-SERVICE").setFallbackUri("forward:/circuitbreakerfallback")))
						.uri("lb://USERS-SERVICE"));

		builder2.route("id_password",
				r -> r.path("/password/**")
						.filters(f -> f.filter(gatewayFilter).circuitBreaker(
								c -> c.setName("PASSWORD-SERVICE").setFallbackUri("forward:/fallbackPassword")))
						.uri("lb://PASSWORD-SERVICE"));

		builder2.route("id_messagebroker",
				r -> r.path("/messagebroker/**")
						.filters(f -> f.circuitBreaker(
								c -> c.setName("BROKER-SERVICE").setFallbackUri("forward:/circuitbreakerfallback")))
						.uri("lb://BROKER-SERVICE"));

		builder2.route("id_customers", r -> r.path("/customers/**").filters(
				f -> f.circuitBreaker(c -> c.setName("CUSTOMER-SERVICE").setFallbackUri("forward:/fallbackCustomer")))
				.uri("lb://CUSTOMER-SERVICE"));
		//
		builder2.route("id_ecomm", r -> r.path("/ecomm/**").filters(
				f -> f.circuitBreaker(c -> c.setName("ECOMM-SERVICES").setFallbackUri("forward:/generalFallback")))
				.uri("lb://ECOMM-SERVICES"));

		builder2.route("id_movie", r -> r.path("/movie/**").filters(
				f -> f.circuitBreaker(c -> c.setName("MOVIE-SERVICES").setFallbackUri("forward:/generalFallback")))
				.uri("lb://MOVIE-SERVICES"));
//
		builder2.route("id_accounts", r -> r.path("/accounts/**").filters(
				f -> f.circuitBreaker(c -> c.setName("ACCOUNT-SERVICE").setFallbackUri("forward:/fallbackAccount")))
				.uri("lb://ACCOUNT-SERVICE"));

		builder2.route("id_transactions", r -> r.path("/transactions/**").filters(
				f -> f.circuitBreaker(c -> c.setName("TRANSACTION-SERVICE").setFallbackUri("forward:/fallbackTrans")))
				.uri("lb://TRANSACTION-SERVICE"));

		return builder2.build();
	}
}
