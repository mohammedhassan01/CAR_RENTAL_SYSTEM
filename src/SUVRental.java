
public class SUVRental extends CarRental {

	public SUVRental(Rental rental) {
		super(rental);
	}

	@Override
	public double getRentalAmount(Rental rental) {
		double amount = basicAmount;
		amount += rental.getRentalRules().AMOUNT_PER_DAY * rental.getRentalData().getDaysRented();
		if (getRentalExceededMiles() > 0) {
			amount += getRentalExceededMiles() * rental.getRentalRules().FACTOR_AFTER_MILE_EXCEED;
		}
		if (rental.getRentalData().isLateFee()) {
			amount += amount * rental.getRentalRules().RENTAL_LATE_FACTOR;
		}
		if (rental.getRentalData().getKilometersRented() > rental.getRentalRules().MILE_RENTAL_THRESHOLD) {
			amount -= amount * rental.getRentalRules().AMOUNT_DISCOUNT_RATE;
		}
		return amount;
	}

	@Override
	public String getRentalAmountStatment(Rental rental) {
		String rentalStatment = "\t\"" + rental.getVehicle().getMakeAndModel() + "\"\tLE "
				+ String.valueOf(getRentalAmount(rental));
		return rentalStatment;
	}

	@Override
	public int getRentalReward(Rental rental, int preRewardPoints) {
		int rewardPoints = preRewardPoints;
		if (!rental.getRentalData().isLateFee()) {
			rewardPoints++;
			if (rental.getRentalData().getDaysRented() > rental.getRentalRules().REWARD_POINTS_THRESHOLD) {
				rewardPoints += (rental.getRentalData().getDaysRented()
						- rental.getRentalRules().REWARD_POINTS_THRESHOLD);
			}
		}
		return rewardPoints;
	}

}
