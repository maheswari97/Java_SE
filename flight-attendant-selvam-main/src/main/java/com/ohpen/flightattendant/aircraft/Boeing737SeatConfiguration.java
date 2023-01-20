package com.ohpen.flightattendant.aircraft;

import java.util.*;

import com.ohpen.flightattendant.flight.SeatClass;
import com.ohpen.flightattendant.seat.Seat;

/**
 * Configuration of seats for Egyptair Boeing 737-800B (see picture Egyptair_Boeing_737-800B.jpg in resources folder)
 *
 * Seats in business section: Rows 8 - 11, letters A,C,H,K
 * Seats in economy section: Rows 20 - 42, letters A,B,C,H,J,K
 */
public final class Boeing737SeatConfiguration implements SeatConfiguration {

	private final Set<? extends Seat> businessSeats;
	private final Set<? extends Seat> economySeats;

	private Boeing737SeatConfiguration() {
		businessSeats = createBusinessSeats();
		economySeats = createEconomySeats();
	}

	public static Boeing737SeatConfiguration newInstance() {
		return new Boeing737SeatConfiguration();
	}

	private Set<? extends Seat> createBusinessSeats() {
		// TODO implement - see Javadoc of this class

		 Set<Seat> BS= new HashSet<>();

		ArrayList<Character> al = new ArrayList<Character>();
		al.add('A');
		al.add('C');
		al.add('H');
		al.add('K');


		 for(int ii=8;ii<=11;ii++)
		 {
			 Iterator<Character> itr = al.iterator();
			 while(itr.hasNext()){

				 BS.add(new Seat(ii+ itr.next().toString()) {
					 @Override
					 public SeatClass getSeatClass() {
						 return SeatClass.BUSINESS;
					 }
				 });

			 }
		 }




		return BS;
	}

	private Set<? extends Seat> createEconomySeats() {
		// TODO implement - see Javadoc of this class


		Set<Seat> ES= new HashSet<>();

		ArrayList<Character> al = new ArrayList<Character>();
		al.add('A');
		al.add('B');
		al.add('C');
		al.add('H');
		al.add('J');
		al.add('K');


		for(int ii=20;ii<=42;ii++)
		{
			Iterator<Character> itr = al.iterator();
			while(itr.hasNext()){

				ES.add(new Seat(ii+ itr.next().toString()) {
					@Override
					public SeatClass getSeatClass() {
						return SeatClass.ECONOMY;
					}
				});

			}
		}

		return ES;
	}

	@Override
	public Map<SeatClass, Set<? extends Seat>> getSeatConfiguration() {
		return Map.of(SeatClass.BUSINESS, businessSeats,
					  SeatClass.ECONOMY, economySeats);
	}

}
