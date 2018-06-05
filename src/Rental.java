public class Rental {
	protected Vehicle vehicle;
	private final RentalData rentalData;
	private final RentalRules rentalRules;
	private RentalBillingStrategy rentalBillingStrategy;

	public RentalRules getRentalRules() {
		return rentalRules;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public RentalBillingStrategy getRentalBillingStrategy() {
		return rentalBillingStrategy;
	}

	public void setRentalBillingStrategy(RentalBillingStrategy rentalBillingStrategy) {
		this.rentalBillingStrategy = rentalBillingStrategy;
	}

	public RentalData getRentalData() {
		return rentalData;
	}

	public Rental(Vehicle vehicle, RentalRules rentalRules, RentalData rentalData) {
		this.rentalRules = rentalRules;
		this.vehicle = vehicle;
		this.rentalData = rentalData;
		this.rentalBillingStrategy = BillingPlanFactory.getRentalBillingPlan(this);
	}

	public double getAmount() {
		return rentalBillingStrategy.getRentalAmount(this);
	}

	public int getRewardPoints(int perRewardPoints) {
		return rentalBillingStrategy.getRentalReward(this, perRewardPoints);
	}

	public String getRentalStatment() {
		return rentalBillingStrategy.getRentalAmountStatment(this);
	}

}
