package com.demo.test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.demo.bean.BookContainerRequest;
import com.demo.bean.CheckBookingAvailableRequest;
import com.demo.bean.service.PrimaryKeyGeneratorService;
import com.demo.dao.BookingsStorageServiceCassandraImpl;
import com.demo.enums.ContainerType;
import com.demo.repository.BookingsRepositoryCassandra;
import com.demo.services.ContainerBookingServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = { ContainerBookingServiceImpl.class, PrimaryKeyGeneratorService.class,
		FakeContainerAvailableCountServiceClient.class, PrimaryKeyGeneratorService.class,
		BookingsStorageServiceCassandraImpl.class })
public class ContainerBookingServiceImplTest {

	@MockBean
	BookingsRepositoryCassandra bookingsRepositoryCassandra;

	@Autowired
	FakeContainerAvailableCountServiceClient externalService = new FakeContainerAvailableCountServiceClient();

	@Autowired
	PrimaryKeyGeneratorService keyGeneratorService;

	@Autowired
	ContainerBookingServiceImpl service;

	@Test
	void testCheckBookingAvailableObject() {
		externalService.setCount(0);
		CheckBookingAvailableRequest request = new CheckBookingAvailableRequest();
		service.checkBookingAvailableForRequest(request)
				.subscribe(booking -> Assertions.assertFalse(booking.isAvailable()));
	}

	@Test
	void testCheckBookingAvailableWhenConatinerPresent() {
		externalService.setCount(10);
		CheckBookingAvailableRequest request = new CheckBookingAvailableRequest();
		service.checkBookingAvailableForRequest(request)
				.subscribe(booking -> Assertions.assertTrue(booking.isAvailable()));
	}

	@Test
	void testBookContainer() {
		BookContainerRequest a = new BookContainerRequest();
		a.setContainerSize(10);
		a.setContainerType(ContainerType.DRY);
		a.setDestination("destination");
		a.setOrigin("origin");
		a.setQuantity(3);
		service.bookContainer(a);
	}

}
