
public class FourXFourRental implements RentalBillingStrategy {
	
	private Rental rental ;
	
	public  FourXFourRental(Rental rental) {
		this.rental = rental ;
	}

	@Override
	public double getRentalAmount(Rental rental) {
		int amount = 50 ;
		amount += rental.getRentalRules().AMOUNT_PER_DAY * rental.getRentalData().getDaysRented();
		if(rental.getRentalData().isLateFee())
		{
			amount += amount * rental.getRentalRules().RENTAL_LATE_FACTOR ;
		}
		if(rental.getRentalData().getKilometersRented() >= rental.getRentalRules().MILE_RENTAL_THRESHOLD &&
				rental.getRentalData().getDaysRented() > 10)
		{
			amount -= amount*rental.getRentalRules().AMOUNT_DISCOUNT_RATE;
		}
		return amount ;
	}
	
	@Override
	public String getRentalAmountStatment(Rental rental) {
		String rentalStatment = "\t\""+rental.getVehicle().getMakeAndModel()+"\"\tLE"+ String.valueOf(getRentalAmount(rental));
		return rentalStatment;
	}
	
	@Override
	public int getRentalReward(Rental rental, int preRewardPoints) {
		int rewardPoints = preRewardPoints ;
		if(!rental.getRentalData().isLateFee())
		{
			rewardPoints++;
			rewardPoints *= (rental.getRentalRules().REWARD_POINTS_FACTOR) ;
		}
		return rewardPoints;
	}
}
