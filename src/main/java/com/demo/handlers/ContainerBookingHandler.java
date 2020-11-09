package com.demo.handlers;

import java.util.Set;
import java.util.function.Function;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.bean.BookContainerRequest;
import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.services.ContainerBookingServiceI;

import reactor.core.publisher.Mono;

@Component
public class ContainerBookingHandler {
	@Autowired
	ContainerBookingServiceI containerBookingService;

	@Autowired
	Validator validator;

	public Mono<ServerResponse> checkBookingAvailable(ServerRequest request) {
		
		return request.bodyToMono(CheckBookingAvailableRequest.class)
				.doOnNext(this::validateBeanThrowConstraintException)
				.flatMap(containerBookingService::checkBookingAvailableForRequest)
				.flatMap(value -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(value)))
				.onErrorResume(processExceptionAndSendBack);

	}

	public Mono<ServerResponse> bookContainer(ServerRequest request) {
		return request.bodyToMono(BookContainerRequest.class)
				.doOnNext(this::validateBeanThrowConstraintException)
				.flatMap(containerBookingService::bookContainer)
				.flatMap(value -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(value)))
				.onErrorResume(processExceptionAndSendBack);

	}
	
	Function<? super Throwable, ? extends Mono<? extends ServerResponse>> processExceptionAndSendBack = (Throwable error) -> {
		if(error instanceof ConstraintViolationException) {
			return ServerResponse.badRequest().body(BodyInserters.fromValue("Request Body Invalid."+error.getMessage()));
		} else {
			return ServerResponse.badRequest().body(BodyInserters.fromValue(error.getMessage()));
		}
	};

	private <T> void validateBeanThrowConstraintException(T object) {
		Set<ConstraintViolation<T>> validate = validator.validate(object, Default.class);
		if (!validate.isEmpty()) {
			throw new ConstraintViolationException(validate);
		}
	}
}
