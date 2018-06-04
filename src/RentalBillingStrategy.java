
public interface RentalBillingStrategy {
	public double getRentalAmount(Rental rental);
	public int getRentalReward(Rental rental , int preRewardPoints);
	public String getRentalAmountStatment(Rental rental);
}
