package com.demo.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.demo.enums.ContainerType;

public class ContainerDetails {

	@NotNull
	private int containerSize;

	@NotNull
	private ContainerType containerType;
	
	@NotNull
	@Size(min = 5, max = 20)
	private String origin;
	
	@NotNull
	@Size(min = 5, max = 20)
	private String destination;
	
	@Min(1)
	@Max(100)
	@NotNull
	private int quantity;

	public ContainerDetails() {
		super();
	}

	

	public ContainerDetails(@NotNull int containerSize, @NotNull ContainerType containerType,
			@NotNull @Size(min = 5, max = 20) String origin, @NotNull @Size(min = 5, max = 20) String destination,
			@Min(1) @Max(100) @NotNull int quantity) {
		super();
		this.containerSize = containerSize;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContainerDetails other = (ContainerDetails) obj;
		if (containerSize != other.containerSize)
			return false;
		if (containerType != other.containerType)
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	public int getContainerSize() {
		return containerSize;
	}

	public ContainerType getContainerType() {
		return containerType;
	}

	public String getDestination() {
		return destination;
	}

	public String getOrigin() {
		return origin;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + containerSize;
		result = prime * result + ((containerType == null) ? 0 : containerType.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + quantity;
		return result;
	}

	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
	}

	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContainerDetails [containerSize=");
		builder.append(containerSize);
		builder.append(", containerType=");
		builder.append(containerType);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

}