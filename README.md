
# API Gateway Microservice

This repository contains the source code for the API Gateway Microservice of the Currency Conversion and Exchange API project. 

## Project Overview

This repository contains the API Gateway Microservice for a currency conversion and exchange application. The API Gateway is the entry point that routes incoming client requests to the appropriate microservices within the architecture. It handles load balancing, service discovery, and routing, making the overall microservices architecture scalable and manageable.

## Key Features

- Routing and forwarding requests to microservices.
- Load balancing using Spring Cloud Gateway.
- Service discovery using Eureka.
- Centralized entry point for all external API calls.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Cloud Gateway**
- **Eureka Server**
- **Docker**

## Project Structure and Code Explanation

1. **API Gateway Configuration**:
   - The main configuration routes requests based on path patterns to specific microservices.
   
   ```yaml
   spring:
     cloud:
       gateway:
         routes:
           - id: currency-conversion
             uri: lb://CURRENCY-CONVERSION
             predicates:
               - Path=/currency-conversion/**
   ```

2. **Service Discovery with Eureka**:
   - The API Gateway registers with Eureka and discovers other microservices dynamically.

   ```java
   @EnableDiscoveryClient
   @SpringBootApplication
   public class ApiGatewayApplication {
       public static void main(String[] args) {
           SpringApplication.run(ApiGatewayApplication.class, args);
       }
   }
   ```

3. **Docker Integration**:
   - Docker is used for containerizing the microservice and running it in a distributed environment.

## Commits and Project Evolution

1. **Initial Setup**: Created the project and set up basic routing and service discovery.
2. **Load Balancing and Routing**: Implemented Spring Cloud Gateway for request routing and load balancing.
3. **Containerization**: Added Docker support for easy deployment.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/API-Gateway.git
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Run the service:
   ```bash
   mvn spring-boot:run
   ```
4. Ensure Eureka Server and other microservices are running for full functionality.

## Purpose and Future Enhancements

This project is designed to be part of a distributed microservices architecture, demonstrating my understanding of API gateway patterns and microservices communication. Future enhancements could include adding security features, rate limiting, and advanced routing capabilities.

## Main Repository

- [Currency Conversion and Exchange API](https://github.com/MalingaBandara/Currency-Conversion-Exchange-Microservices)

## What's Covered in This Microservice

- Routing of requests to appropriate microservices.
- Load balancing of requests.
- Utilization of Docker for containerization and deployment.


## License

This project is licensed under the MIT License.
