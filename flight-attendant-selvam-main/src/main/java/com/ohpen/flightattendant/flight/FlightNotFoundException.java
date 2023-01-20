package com.ohpen.flightattendant.flight;

public class FlightNotFoundException extends Exception {

	public FlightNotFoundException(String flightNo) {
		super("Flight with number " + flightNo + " does not exist.");
	}
}
