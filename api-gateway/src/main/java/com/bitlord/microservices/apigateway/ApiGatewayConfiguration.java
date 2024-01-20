package com.bitlord.microservices.apigateway;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	
	@Bean
	public RouteLocator gatewayRoute ( RouteLocatorBuilder builder ) {	
		
		
		// Create Routes
		return builder.routes()
				
				// custom route (1)
				.route( p -> p.path( "/get" )
						.filters( f -> f
								.addRequestHeader( "MyHeader", "MyURI")  // Add header (Custom)
								.addRequestParameter( "Param", "" ) )   // Add Parameters (Custom)
					.uri( "http://httpbin.org:80" ) ) 
				
				
				// Currency Conversion Route (With Load balance - Eureka)
				.route( p -> p.path( "/currency-conversion/**" )
						.uri( "lb://currency-conversion" ) ) // Find location and load balance
				
				
				// Currency Conversion Feign Route (With Load balance - Eureka)
				.route( p -> p.path( "/currency-conversion-feign/**" )
						.uri( "lb://currency-conversion" ) ) // Find location and load balance
				
				
				
				// Currency Conversion Feign New URL ( http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10 )
				.route( p -> p.path( "/currency-conversion-new/**" )
						
							.filters( f -> f.rewritePath ( 
									"/currency-conversion-new/(?<segment>.*)" , // Which path
									"/currency-conversion-feign/${segment}" )  ) // Rewrite Path
						
						.uri( "lb://currency-conversion" ) )
				
				
				
				.build();
		  
		
	}
	 

}
