//package com.zettamine;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Routes {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//            .route("STUDENTSERVICE", r -> r.path("/student/**")
//                .uri("lb://STUDENTSERVICE"))
//            .route("DEPARTMENTSERVICE", r -> r.path("/department/**")
//                .uri("lb://DEPARTMENTSERVICE"))
//            .build();
//    }
//}
