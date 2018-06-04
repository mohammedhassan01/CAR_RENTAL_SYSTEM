
public class BillingPlanFactory {
	private BillingPlanFactory(){
	}
	public static RentalBillingStrategy getRentalBillingPlan(Rental rental) {
		if (rental.getVehicle().getVehicleType() == VehicleType.FOURxFOUR) {
			return new FourXFourRental(rental);
		} else if (rental.getVehicle().getVehicleType() == VehicleType.SEDAN) {
			return new SEDANRental(rental);
		} else if (rental.getVehicle().getVehicleType() == VehicleType.SUV) {
			return new SUVRental(rental);
		} else {
			return null;
		}
	}

}
