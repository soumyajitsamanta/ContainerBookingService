package com.demo.bean.service;

import org.springframework.stereotype.Component;

@Component
public class PrimaryKeyGeneratorService {
	private static int id = 957000000;

	public String getNextKey() {
		id += 1;
		return String.valueOf(id);
	}

	public void reclaimBackKey() {
		id -= 1;
	}
}
