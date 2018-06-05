
public class SEDANRental extends CarRental {

	public SEDANRental(Rental rental) {
		super(rental);
	}

	@Override
	public double getRentalAmount(Rental rental) {
		validateRentalData();
		double amount = basicAmount;
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
		String rentalStatment = "\t\"" + rental.getVehicle().getMakeAndModel() + "\"\tLE "
				+ String.valueOf(getRentalAmount(rental));
		return rentalStatment;
	}

}
