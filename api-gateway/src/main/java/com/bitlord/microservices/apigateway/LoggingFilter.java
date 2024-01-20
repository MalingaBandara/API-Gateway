package com.bitlord.microservices.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;


public class LoggingFilter implements GlobalFilter {
	
	
	// Add Logger
	private Logger logger = LoggerFactory.getLogger( LoggingFilter.class );
	

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		return null;
	}

	
	
}
