package com.ohpen.flightattendant.seat;

import com.ohpen.flightattendant.flight.SeatClass;

// TODO implement appropriate subclasses
public abstract class Seat {

	private final String number;

	private SeatStatus status;

	protected Seat(String number) {
		this.number = number;
		this.status = SeatStatus.AVAILABLE;
	}

	public String getNumber() {
		return number;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public abstract SeatClass getSeatClass();

	public boolean isAvailable() {
		return status == SeatStatus.AVAILABLE;
	}

	@Override
	public String toString() {
		return "Seat{" +
			   "number='" + number + '\'' +
			   ", status=" + status +
			   '}';
	}
}
