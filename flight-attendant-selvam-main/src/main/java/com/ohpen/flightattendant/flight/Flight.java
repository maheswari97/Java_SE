package com.ohpen.flightattendant.flight;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.ohpen.flightattendant.aircraft.SeatConfiguration;
import com.ohpen.flightattendant.seat.Seat;

public class Flight {

	private final String flightNo;

	private final String origin;

	private final String destination;

	private final Duration flightDuration;

	private final Map<SeatClass, Set<? extends Seat>> seatMap;

	public Flight(String flightNo, String origin, String destination, Duration flightDuration, SeatConfiguration seatConfiguration) {
		this.flightNo = Objects.requireNonNull(flightNo);
		this.origin = Objects.requireNonNull(origin);
		this.destination = Objects.requireNonNull(destination);
		this.flightDuration = Objects.requireNonNull(flightDuration);
		this.seatMap = Objects.requireNonNull(seatConfiguration).getSeatConfiguration();
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public Duration getFlightDuration() {
		return flightDuration;
	}

	public Map<SeatClass, Set<? extends Seat>> getSeatMap() {
		return seatMap;
	}

}
