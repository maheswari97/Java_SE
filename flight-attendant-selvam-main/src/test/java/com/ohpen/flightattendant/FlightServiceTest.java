package com.ohpen.flightattendant;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import com.ohpen.flightattendant.aircraft.Boeing737SeatConfiguration;
import com.ohpen.flightattendant.flight.Flight;

import static org.assertj.core.api.Assertions.assertThat;

class FlightServiceTest {

	private final FlightService flightService = new FlightService();

	@Test
	void doesNotAddDuplicateFlight() {
		flightService.addNewFlight(createFlight());
		//flightService.addNewFlight(createFlight());

		assertThat(flightService.getFlights()).hasSize(1);
	}

	private Flight createFlight() {
		return new Flight("LO1533", "BTS", "LUT", Duration.ofHours(2), Boeing737SeatConfiguration.newInstance());
	}

}
