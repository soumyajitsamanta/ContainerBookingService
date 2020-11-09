package com.demo.dao;

import com.demo.bean.BookContainerResponse;
import com.demo.entity.ContainerDetailsEntity;

import reactor.core.publisher.Mono;

public interface BookingsStorageService {
	Mono<BookContainerResponse> storeContainerBooking(ContainerDetailsEntity containerDetailsEntity);
}
