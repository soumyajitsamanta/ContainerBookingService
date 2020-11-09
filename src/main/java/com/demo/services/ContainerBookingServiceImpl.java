package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bean.BookContainerRequest;
import com.demo.bean.BookContainerResponse;
import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.CheckBookingAvailableResponse;
import com.demo.bean.ContainersAvailableCountResponse;
import com.demo.constants.ErrorMessages;
import com.demo.dao.BookingsStorageService;
import com.demo.entity.ContainerDetailsEntity;
import com.demo.services.client.ContainerAvailableCountServiceClientI;

import reactor.core.publisher.Mono;

@Component
public class ContainerBookingServiceImpl implements ContainerBookingServiceI {

	@Autowired
	ContainerAvailableCountServiceClientI client;

	@Autowired
	BookingsStorageService bookingsStorage;

	@Override
	public Mono<CheckBookingAvailableResponse> checkBookingAvailableForRequest(CheckBookingAvailableRequest request) {
		return client.getAvailableContainersObject(request).onErrorReturn(new ContainersAvailableCountResponse(0))
				.map(externalResponse -> new CheckBookingAvailableResponse(externalResponse.getAvailableSpace() > 0));
	}

	@Override
	public Mono<BookContainerResponse> bookContainer(BookContainerRequest a) {
		return bookingsStorage
				.storeContainerBooking(new ContainerDetailsEntity(a.getContainerSize(), a.getContainerType().name(),
						a.getOrigin(), a.getDestination(), a.getQuantity()))
				.onErrorReturn(new BookContainerResponse(null, ErrorMessages.SYSTEM_ERROR));
	}

}
