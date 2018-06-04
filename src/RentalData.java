
public class RentalData {
    private int kilometersRented;
    private int daysRented;
    private boolean lateFee;
    
    public RentalData(int kilometersRented, int daysRented, boolean lateFee)
    {
    	this.kilometersRented = kilometersRented;
    	this.daysRented = daysRented;
    	this.lateFee = lateFee;
    }
    
	public int getKilometersRented() {
		return kilometersRented;
	}
	public void setKilometersRented(int kilometersRented) {
		this.kilometersRented = kilometersRented;
	}
	public int getDaysRented() {
		return daysRented;
	}
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	public boolean isLateFee() {
		return lateFee;
	}
	public void setLateFee(boolean lateFee) {
		this.lateFee = lateFee;
	}
}
