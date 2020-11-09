package com.demo.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.demo.entity.ContainerDetailsEntity;

public interface BookingsRepositoryCassandra extends ReactiveCassandraRepository<ContainerDetailsEntity, String> {
}
