package com.demo.bean;

public class ContainersAvailableCountResponse {
	long availableSpace;

	public ContainersAvailableCountResponse() {
		super();
	}

	public ContainersAvailableCountResponse(long availableSpace) {
		super();
		this.availableSpace = availableSpace;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContainersAvailableCountResponse other = (ContainersAvailableCountResponse) obj;
		if (availableSpace != other.availableSpace)
			return false;
		return true;
	}

	public long getAvailableSpace() {
		return availableSpace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (availableSpace ^ (availableSpace >>> 32));
		return result;
	}

	public void setAvailableSpace(long availableSpace) {
		this.availableSpace = availableSpace;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckBookingAvailableExternalResponse [availableSpace=");
		builder.append(availableSpace);
		builder.append("]");
		return builder.toString();
	}

}
