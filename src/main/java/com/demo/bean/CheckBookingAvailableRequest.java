package com.demo.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.demo.enums.ContainerType;

public class CheckBookingAvailableRequest extends ContainerDetails {

	public CheckBookingAvailableRequest() {
		super();
	}

	public CheckBookingAvailableRequest(@NotNull int containerSize, @NotNull ContainerType containerType,
			@NotNull @Size(min = 5, max = 20) String origin, @NotNull @Size(min = 5, max = 20) String destination,
			@Min(1) @Max(100) @NotNull int quantity) {
		super(containerSize, containerType, origin, destination, quantity);
	}
}
