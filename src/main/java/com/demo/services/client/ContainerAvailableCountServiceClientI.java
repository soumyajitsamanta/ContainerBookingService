package com.demo.services.client;

import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.ContainersAvailableCountResponse;

import reactor.core.publisher.Mono;

public interface ContainerAvailableCountServiceClientI {

	Mono<ContainersAvailableCountResponse> getAvailableContainersObject(CheckBookingAvailableRequest body);

}
