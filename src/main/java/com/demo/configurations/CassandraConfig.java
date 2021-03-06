package com.demo.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = { "com.demo.repository" })
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspaceName}")
	String keyspaceName;

	@Override
	protected String getLocalDataCenter() {
		return "datacenter1";
	}

	@Override
	protected String getKeyspaceName() {
		return keyspaceName;
	}
}