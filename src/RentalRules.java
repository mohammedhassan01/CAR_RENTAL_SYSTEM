
public class RentalRules {
	public int AMOUNT_PER_DAY = 1;
	public int MILES_LIMIT_PER_DAY = 1;
	public int FACTOR_AFTER_MILE_EXCEED = 1;
	public double RENTAL_LATE_FACTOR = 1;
	public int REWARD_POINTS_FACTOR = 1;
	public int REWARD_POINTS_THRESHOLD = 1;
	public double LATE_MOUNT_FACTOR = 1;
	public double AMOUNT_DISCOUNT_RATE = 0.05;
	public int MILE_RENTAL_THRESHOLD = 200;

	public RentalRules() {
	}

	public RentalRules(RentalRules rentalRules) {
		this.AMOUNT_PER_DAY = rentalRules.AMOUNT_PER_DAY;
		this.MILES_LIMIT_PER_DAY = rentalRules.MILES_LIMIT_PER_DAY;
		this.FACTOR_AFTER_MILE_EXCEED = rentalRules.FACTOR_AFTER_MILE_EXCEED;
		this.RENTAL_LATE_FACTOR = rentalRules.RENTAL_LATE_FACTOR;
		this.REWARD_POINTS_FACTOR = rentalRules.REWARD_POINTS_FACTOR;
		this.REWARD_POINTS_THRESHOLD = rentalRules.REWARD_POINTS_THRESHOLD;
		this.LATE_MOUNT_FACTOR = rentalRules.LATE_MOUNT_FACTOR;
		this.AMOUNT_DISCOUNT_RATE = rentalRules.AMOUNT_DISCOUNT_RATE;
		this.MILE_RENTAL_THRESHOLD = rentalRules.MILE_RENTAL_THRESHOLD;
	}

}
