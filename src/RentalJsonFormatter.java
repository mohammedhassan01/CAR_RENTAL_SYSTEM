
public class RentalJsonFormatter implements Formatter<Rental> {

	@Override
	public String getValue(Rental rental) {
		StringBuilder stringBuilder = new StringBuilder();

		Formatter<RentalData> rentalFormatter = JsonFormatterFactory.getFormatter(rental.getRentalData());
		Formatter<Vehicle> vehicleFormatter = JsonFormatterFactory.getFormatter(rental.getVehicle());
		stringBuilder.append("{");
		stringBuilder.append("\"vehicle\":" + vehicleFormatter.getValue(rental.getVehicle()));
		stringBuilder.append(", \"rentalData\":" + rentalFormatter.getValue(rental.getRentalData()));
		stringBuilder.append("}");
		return stringBuilder.toString();
	}

}
