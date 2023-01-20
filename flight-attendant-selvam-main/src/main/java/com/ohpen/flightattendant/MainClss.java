package com.ohpen.flightattendant;

import com.ohpen.flightattendant.aircraft.Boeing737SeatConfiguration;
import com.ohpen.flightattendant.flight.Flight;
import com.ohpen.flightattendant.flight.FlightNotFoundException;
import com.ohpen.flightattendant.flight.SeatClass;
import com.ohpen.flightattendant.seat.NoSeatAvailableException;
import com.ohpen.flightattendant.seat.SeatNotFoundException;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class MainClss {

    public static void main(String[] args) throws FlightNotFoundException, NoSeatAvailableException, SeatNotFoundException {

        final FlightService flightService = new FlightService();

        final  SeatService seatService=new SeatService();

        Flight F1=new Flight("LO1533", "BTS", "LUT", Duration.ofHours(5), Boeing737SeatConfiguration.newInstance());
        Flight F2=new Flight("LO1532", "BTS", "LUT", Duration.ofHours(2), Boeing737SeatConfiguration.newInstance());

      flightService.addNewFlight(F1);
        flightService.addNewFlight(F2);


        flightService.findFlight("LO1533");

        flightService.findFlightsForDestination("LUT");

        flightService.tryReserveSeatOnFlight("LO1533", SeatClass.ECONOMY);



        seatService.reserveSeat(F1,SeatClass.ECONOMY);



        seatService.countAvailableSeatsBySeatClass(F1,SeatClass.ECONOMY);

        seatService.getAvailableSeatsOnFlight(F1);

        seatService.cancelReservationForSeat(F1,"8H");


    }
}
