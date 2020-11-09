package com.demo.services;

import com.demo.bean.BookContainerRequest;
import com.demo.bean.BookContainerResponse;
import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.CheckBookingAvailableResponse;

import reactor.core.publisher.Mono;

public interface ContainerBookingServiceI {

	Mono<CheckBookingAvailableResponse> checkBookingAvailableForRequest(CheckBookingAvailableRequest body);

	Mono<BookContainerResponse> bookContainer(BookContainerRequest a);

}