

public class RentalDataJsonFormatter implements Formatter<RentalData> {

	@Override
	public String getValue(RentalData rentalData) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("{\"kilometerRented\":"+"\""+rentalData.getKilometersRented()+"\"");
		stringBuilder.append(", \"daysRented\":"+"\""+rentalData.getDaysRented()+"\"");
		stringBuilder.append(", \"lateFee\":"+"\""+rentalData.isLateFee()+"\"}");
		return stringBuilder.toString();
	}
	
	
}