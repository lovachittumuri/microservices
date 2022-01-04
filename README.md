# microservices
Micro services

## Application.yml file - Hystrix Dashboard - API - GateWay

spring:
   application:
      name: API-GATEWAY
   cloud:
     gateway:
      routes:
        - id: USER-SERVICE
          uri: lb://USER-SERVICE
          predicates:
            - Path=/user/**
          filters:
            - name: Hystrix
              args:
                name: USER-SERVICE
                fallbackUri: forward:/userServiceFallBack
        - id: DEPARTMENT-SERVICE
          uri: lb://DEPARTMENT-SERVICE
          predicates:
          - Path=/department/**
          filters:
            - name: Hystrix
              args:
                name: DEPARTMENT-SERVICE
                fallbackUri: forward:/departmentServiceFallBack

hystrix:
  command:
    fallbackcmd:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 4000
           
management:
  endpoints:
   web:
    exposure:
      include: hystrix.stream
           
                           
#========= API- GATEWAY Service Registry =====  

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/


