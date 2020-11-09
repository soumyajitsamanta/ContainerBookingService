package com.demo.bean;

public class CheckBookingAvailableResponse {
	boolean available;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckBookingAvailableResponse other = (CheckBookingAvailableResponse) obj;
		if (available != other.available)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckBookingAvailableResponse [available=");
		builder.append(available);
		builder.append("]");
		return builder.toString();
	}

	public CheckBookingAvailableResponse(boolean available) {
		super();
		this.available = available;
	}

	public CheckBookingAvailableResponse() {
		super();
	}

}
