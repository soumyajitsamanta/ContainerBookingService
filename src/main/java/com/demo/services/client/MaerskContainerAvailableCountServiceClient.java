package com.demo.services.client;

import org.springframework.web.reactive.function.client.WebClient;

import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.ContainersAvailableCountResponse;

import reactor.core.publisher.Mono;

public class MaerskContainerAvailableCountServiceClient implements ContainerAvailableCountServiceClientI {
	WebClient webClient = WebClient.create("https://www.maersk.com/api/bookings");

	public WebClient getWebClient() {
		return webClient;
	}

	@Override
	public Mono<ContainersAvailableCountResponse> getAvailableContainersObject(CheckBookingAvailableRequest body) {
		return getWebClient().post().uri("/checkAvailable")
				.body(Mono.just(body), CheckBookingAvailableRequest.class)
				.retrieve()
				.onRawStatus(a -> a > 200, a -> Mono.just(new Exception("Hell No")))
				.onRawStatus(a->a<=200, a -> Mono.just(new Exception("Hell No")) )
				.bodyToMono(ContainersAvailableCountResponse.class)
				.doOnNext(System.err::println);
	}
}
