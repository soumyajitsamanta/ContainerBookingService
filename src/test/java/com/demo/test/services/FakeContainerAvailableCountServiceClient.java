package com.demo.test.services;

import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.ContainersAvailableCountResponse;
import com.demo.services.client.ContainerAvailableCountServiceClientI;

import reactor.core.publisher.Mono;

public class FakeContainerAvailableCountServiceClient implements ContainerAvailableCountServiceClientI {

	private int count = 0;

	@Override
	public Mono<ContainersAvailableCountResponse> getAvailableContainersObject(CheckBookingAvailableRequest body) {
		ContainersAvailableCountResponse response = new ContainersAvailableCountResponse();
		response.setAvailableSpace(getCount());
		return Mono.just(response);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
