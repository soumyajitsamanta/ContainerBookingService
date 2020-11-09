package com.demo.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.handlers.ContainerBookingHandler;

@Configuration
public class ContainerBookingRouter {

	@Bean
	public RouterFunction<ServerResponse> route(ContainerBookingHandler containerBookingHandler) {
		RouterFunction<ServerResponse> routerFunction = RouterFunctions
				.route(RequestPredicates.POST("/api/bookings/check-available")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						containerBookingHandler::checkBookingAvailable)
				.andRoute(
						RequestPredicates.POST("/api/bookings/book")
								.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						containerBookingHandler::bookContainer);
		return routerFunction;
	}
}
