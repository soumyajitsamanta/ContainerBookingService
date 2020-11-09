package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bean.BookContainerResponse;
import com.demo.bean.service.PrimaryKeyGeneratorService;
import com.demo.entity.ContainerDetailsEntity;
import com.demo.repository.BookingsRepositoryCassandra;

import reactor.core.publisher.Mono;

@Component
public class BookingsStorageServiceCassandraImpl implements BookingsStorageService {

	@Autowired
	PrimaryKeyGeneratorService keyGeneratorService;

	@Autowired
	BookingsRepositoryCassandra repository;

	@Override
	public Mono<BookContainerResponse> storeContainerBooking(ContainerDetailsEntity containerDetailsEntity) {
		containerDetailsEntity.setId(keyGeneratorService.getNextKey());
		Mono<ContainerDetailsEntity> insert = repository.insert(containerDetailsEntity)
				.doOnError(exception -> keyGeneratorService.reclaimBackKey());
		return insert.map(ContainerDetailsEntity::getId).map(id -> new BookContainerResponse(id, null));
	}
}
