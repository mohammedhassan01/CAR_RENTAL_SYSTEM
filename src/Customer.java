import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {
	private String name;
	private List<Rental> rentalsList;
	private double totalRentalAmount;
	private int totalRentalRewardPoints;
	private FormatType formatType;
	private Formatter formatter; 
	
	public void setTotalRentalAmount(double totalRentalAmount) {
		this.totalRentalAmount = totalRentalAmount;
	}

	public int getTotalRentalRewardPoints() {
		totalRentalRewardPoints = 0;
		for (Rental rental : rentalsList) {
			totalRentalRewardPoints = rental.getRewardPoints(totalRentalRewardPoints);
		}
		return totalRentalRewardPoints;
	}

	public void setTotalRentalRewardPoints(int totalRentalRewardPoints) {
		this.totalRentalRewardPoints = totalRentalRewardPoints;
	}

	public Customer(String name, FormatType formatType) {
		this.name = name;
		this.formatType = formatType;
		rentalsList = new ArrayList<>();
		calculateCustomerFormatter();
	}
	
	private void calculateCustomerFormatter()
	{
		if (formatType.getTypeId() == FormatType.JSON.getTypeId())
		{
			formatter =   JsonFormatterFactory.getFormatter(this);
		}
		else if(formatType.getTypeId() == FormatType.PLAIN_TEXT.getTypeId()){
			formatter =   PlainTextFormatterFactory.getFormatter(this);
		}
	}

	public void addRentalToList(Rental rentalItem) {
		rentalsList.add(rentalItem);
	}

	public String getName() {
		return name;
	}

	public double getTotalRentalAmount() {
		this.totalRentalAmount = 0;
		for (Rental rental : rentalsList) {
			totalRentalAmount += rental.getAmount();
		}
		return totalRentalAmount;
	}

	public String statement() {
		StringBuilder statment = new StringBuilder();
		statment.append("Rental Record for:" + this.name + "\n");
		for (Rental rental : this.rentalsList) {
			statment.append(rental.getRentalStatment());
			statment.append("\n");
		}
		statment.append("Amount owed is LE " + getTotalRentalAmount() + "\n");
		statment.append("You earned: " + String.valueOf(getTotalRentalRewardPoints()) + " new Reward Points");
		statment.append("\n\n");
		return statment.toString();
	}

	public List<Rental> getRentalsList() {
		return rentalsList;
	}

	public void setRentalsList(List<Rental> rentalsList) {
		this.rentalsList = rentalsList;
	}
	
	public String getCustomerFormattedStatment()
	{
		return formatter.getValue(this);
	}
}
