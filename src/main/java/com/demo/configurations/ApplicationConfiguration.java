package com.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.services.client.ContainerAvailableCountServiceClientI;
import com.demo.services.client.MaerskContainerAvailableCountServiceClient;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public ContainerAvailableCountServiceClientI getContainerAvailableCountClient() {
		return new MaerskContainerAvailableCountServiceClient();
	}

}
