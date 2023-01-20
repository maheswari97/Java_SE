package com.ohpen.flightattendant.aircraft;

import java.util.Map;
import java.util.Set;

import com.ohpen.flightattendant.flight.SeatClass;
import com.ohpen.flightattendant.seat.Seat;

public interface SeatConfiguration {

	Map<SeatClass, Set<? extends Seat>> getSeatConfiguration();

}
