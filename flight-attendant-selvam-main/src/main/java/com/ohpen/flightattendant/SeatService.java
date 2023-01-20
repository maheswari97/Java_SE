package com.ohpen.flightattendant;

import com.ohpen.flightattendant.flight.Flight;
import com.ohpen.flightattendant.flight.SeatClass;
import com.ohpen.flightattendant.seat.NoSeatAvailableException;
import com.ohpen.flightattendant.seat.Seat;
import com.ohpen.flightattendant.seat.SeatNotFoundException;
import com.ohpen.flightattendant.seat.SeatStatus;

import java.util.Set;



public class SeatService {

	/**
	 * Reserve seat on a given flight
	 * @param flight flight
	 * @param seatClass seat class
	 * @return reserved seat
	 * @throws NoSeatAvailableException if there is no seat available
	 */
	public Seat reserveSeat(Flight flight, SeatClass seatClass) throws NoSeatAvailableException {
		// TODO implement
        Seat SeatResult= null;
		for (Set<? extends Seat> i : flight.getSeatMap().values()) {
			for (Seat i2:i){
				if(i2.getSeatClass()==seatClass && i2.isAvailable()) {

					i2.setStatus(SeatStatus.RESERVED);
					SeatResult = i2;
					break;
				}
			}
		}
		if(SeatResult==null)
			throw new NoSeatAvailableException();


		return SeatResult;

	}

	/**
	 * Count all available seats on flight
	 * @param flight flight
	 * @return count of all available seats
	 */
	public long getAvailableSeatsOnFlight(Flight flight) {
		// TODO implement
		long Count=0;
		for (Set<? extends Seat> i : flight.getSeatMap().values()) {
			for (Seat i2:i){
				if(i2.isAvailable()) {
					Count++;
				}
			}
		}
		return Count;
	}

	/**
	 * Count available seats on flight for given seat class
	 * @param flight flight
	 * @param seatClass seat class
	 * @return count of available seats
	 */
	public long countAvailableSeatsBySeatClass(Flight flight, SeatClass seatClass) {
		// TODO implement
		long Count=0;

		//Collection<Set<? extends Seat>> c1=	flight.getSeatMap().values();
		for (Set<? extends Seat> i : flight.getSeatMap().values()) {
			for (Seat i2:i){
				if(i2.isAvailable()  && i2.getSeatClass()==seatClass) {
					Count++;
				}
			}
		}
		return Count;
	}

	/**
	 * Cancel reservation for given seat number. If given seat is available, method has no effect.
	 * @param flight flight
	 * @param seatNumber seat number
	 * @throws SeatNotFoundException if such seat is not found
	 */
	public void cancelReservationForSeat(Flight flight, String seatNumber) throws SeatNotFoundException {
		// TODO implement
		Seat CanceReserveSeat=null;
		for (Set<? extends Seat> i : flight.getSeatMap().values()) {
			for (Seat i2:i){
				if(seatNumber.equals(i2.getNumber()) && !i2.isAvailable()) {
					CanceReserveSeat=i2;
				}
			}
		}

		if(CanceReserveSeat!=null)
			CanceReserveSeat.setStatus(SeatStatus.AVAILABLE);
		else
			throw  new SeatNotFoundException();
	}

}
