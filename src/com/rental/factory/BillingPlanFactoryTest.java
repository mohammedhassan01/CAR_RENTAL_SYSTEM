package com.rental.factory;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BillingPlanFactoryTest {
	@Test
	public void getBillingPlanShouldReturnFOURXFOUR() {
		Vehicle vehicle = new Vehicle("BMW 2002", VehicleType.FOURxFOUR);
		Rental fourXfourRental = new Rental(vehicle, null, null);
		RentalBillingStrategy fourXfourBillingPlan = BillingPlanFactory.getRentalBillingPlan(fourXfourRental);
		assertEquals(FourXFourRental.class, fourXfourBillingPlan.getClass());
	}

	@Test
	public void getBillingPlanShouldReturnSEDAN() {
		Vehicle vehicle = new Vehicle("BMW 2002", VehicleType.SEDAN);
		Rental sedanRental = new Rental(vehicle, null, null);
		RentalBillingStrategy sedanBillingPlan = BillingPlanFactory.getRentalBillingPlan(sedanRental);
		assertEquals(SEDANRental.class, sedanBillingPlan.getClass());
	}

	@Test
	public void getBillingPlanShouldReturnSUV() {
		Vehicle vehicle = new Vehicle("BMW 2002", VehicleType.SUV);
		Rental suvRental = new Rental(vehicle, null, null);
		RentalBillingStrategy suvBillingPlan = BillingPlanFactory.getRentalBillingPlan(suvRental);
		assertEquals(SUVRental.class, suvBillingPlan.getClass());
	}

	@Test
	public void getBillingPlanShouldCarRental() {
		VehicleType newType = new VehicleType(3);
		Vehicle newVehicle = new Vehicle("BMW 2002", newType);
		Vehicle noneVehicleType = new Vehicle("BMW 2002", null);

		Rental newRental = new Rental(newVehicle, null, null);
		RentalBillingStrategy unimplementedBillingPlan = BillingPlanFactory.getRentalBillingPlan(newRental);

		Rental newRental2 = new Rental(noneVehicleType, null, null);
		RentalBillingStrategy unimplementedBillingPlan2 = BillingPlanFactory.getRentalBillingPlan(newRental2);
		assertEquals(CarRental.class, unimplementedBillingPlan.getClass());
		assertEquals(CarRental.class, unimplementedBillingPlan2.getClass());

	}

}
