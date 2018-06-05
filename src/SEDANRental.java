
public class SEDANRental implements RentalBillingStrategy {

	private Rental rental;

	public SEDANRental(Rental rental) {
		this.rental = rental;
	}

	private int getRentalExceededMiles() {
		return rental.getRentalData().getKilometersRented() - 
				(rental.getRentalData().getDaysRented() * rental.getRentalRules().MILES_LIMIT_PER_DAY);
	}

	@Override
	public double getRentalAmount(Rental rental) {
		double amount = 50 ;
		amount += rental.getRentalRules().AMOUNT_PER_DAY * rental.getRentalData().getDaysRented();
		if (getRentalExceededMiles() > 0) {
			amount += (getRentalExceededMiles() * rental.getRentalRules().FACTOR_AFTER_MILE_EXCEED);
		}
		if (rental.getRentalData().isLateFee()) {
			amount += (amount * rental.getRentalRules().RENTAL_LATE_FACTOR);
		}
		return amount;
	}

	@Override
	public int getRentalReward(Rental rental, int preRewardPoints) {
		int rewardPoints = preRewardPoints;
		if (!rental.getRentalData().isLateFee()) {
			rewardPoints++;
		}
		return rewardPoints;
	}

	@Override
	public String getRentalAmountStatment(Rental rental) {
		String rentalStatment = "\t\""+rental.getVehicle().getMakeAndModel()+"\"\tLE"+ String.valueOf(getRentalAmount(rental));
		return rentalStatment;
	}

}
