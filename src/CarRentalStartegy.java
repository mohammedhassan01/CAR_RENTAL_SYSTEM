
public abstract class CarRentalStartegy implements RentalBillingStrategy {
	private Rental rental;

	public CarRentalStartegy(Rental rental) {
		this.rental = rental;
	}

}
