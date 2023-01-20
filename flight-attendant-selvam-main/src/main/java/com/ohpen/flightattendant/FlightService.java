package com.ohpen.flightattendant;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ohpen.flightattendant.flight.Flight;
import com.ohpen.flightattendant.flight.FlightNotFoundException;
import com.ohpen.flightattendant.flight.SeatClass;
import com.ohpen.flightattendant.seat.Seat;
import com.ohpen.flightattendant.seat.SeatStatus;

public class FlightService {

	private final SeatService seatService = new SeatService();

	private final Set<Flight> flights = new HashSet<>();

	public void addNewFlight(Flight flight) {
		flights.add(flight);
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	/**
	 * Find flight based on flight number
	 * @param flightNo flightNo
	 * @return Optional with found flight or empty
	 */
	public Optional<Flight> findFlight(String flightNo) {
		// TODO implement
		Optional<Flight> Flight = flights.stream().filter(flight -> flight.getFlightNo()==flightNo).findAny();
		return Flight;
	}

	/**
	 * Find all flights for destination, in order by lowest duration first
	 * @param destination destination
	 * @return list of found flights or empty list
	 */
	public List<Flight> findFlightsForDestination(String destination) {
		// TODO implement

		List<Flight> Flight=flights.stream().filter(flight -> flight.getDestination()==destination)
				.sorted((f1, f2) -> f1.getFlightDuration().compareTo(f2.getFlightDuration()))
				.collect(Collectors.toList());
		return Flight;
	}

	/**
	 * Try to reserve seat on a flight.
	 * @param flightNo flight no
	 * @param seatClass seat class
	 * @return Optional of seat, empty if there are no seats available on flight
	 * @throws FlightNotFoundException if there is no such flightNo
	 */
	public Optional<Seat> tryReserveSeatOnFlight(String flightNo, SeatClass seatClass) throws FlightNotFoundException {
		// TODO implement
		Optional<Seat> SeatResult =Optional.empty();
		 Flight Fl= flights.stream().filter(flight -> flight.getFlightNo()==flightNo).findAny().orElseThrow(()->new FlightNotFoundException(flightNo));

		for (Set<? extends Seat> i : Fl.getSeatMap().values()) {
		for (Seat i2:i){
			if(i2.getSeatClass()==seatClass && i2.isAvailable()) {
				i2.setStatus(SeatStatus.RESERVED);
				SeatResult = Optional.of(i2);
					break;
			}
		}
		}
		return SeatResult;
	}

}
