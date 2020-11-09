package com.demo.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "bookings")
public class ContainerDetailsEntity {

	@PrimaryKey
	private String id;

	@Column("container_size")
	private int containerSize;

	@Column("container_type")
	private String containerType;

	@Column("origin")
	private String origin;

	@Column("destination")
	private String destination;

	@Column("quantity")
	private int quantity;

	public ContainerDetailsEntity() {
		super();
	}

	public ContainerDetailsEntity(int containerSize, String containerType, String origin, String destination,
			int quantity) {
		super();
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public String getContainerType() {
		return containerType;
	}

	public String getDestination() {
		return destination;
	}

	public String getId() {
		return id;
	}

	public String getOrigin() {
		return origin;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
