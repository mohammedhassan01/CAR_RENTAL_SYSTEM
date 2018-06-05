
public class CarRental implements RentalBillingStrategy {
	private final int BASIC_RENTAL_AMOUNT = 50;
	protected Rental rental;

	protected double basicAmount;

	public CarRental(Rental rental) {
		this.rental = rental;
		basicAmount = BASIC_RENTAL_AMOUNT;
	}

	public double getBasicAmount() {
		return basicAmount;
	}

	public void setBasicAmount(double basicAmount) {
		this.basicAmount = basicAmount;
	}

	protected void validateRentalData() {
		if (rental == null || rental.getVehicle() == null || rental.getRentalData() == null
				|| rental.getRentalRules() == null) {
			throw new NullPointerException("rental data showed contian vehcile, rental data, rentalRules");
		} else if (rental.getRentalData().getDaysRented() < 1) {
			throw new IllegalArgumentException("Number of days < 1");
		}

	}

	protected int getRentalExceededMiles() {
		return rental.getRentalData().getKilometersRented()
				- (rental.getRentalData().getDaysRented() * rental.getRentalRules().MILES_LIMIT_PER_DAY);
	}

	@Override
	public double getRentalAmount(Rental rental) {
		return basicAmount;
	}

	@Override
	public int getRentalReward(Rental rental, int preRewardPoints) {
		return 0;
	}

	@Override
	public String getRentalAmountStatment(Rental rental) {
		return String.valueOf(basicAmount);
	}
}
