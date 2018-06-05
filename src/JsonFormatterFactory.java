
public class JsonFormatterFactory {
	
	public static Formatter getFormatter(Object object) {
		if (object.getClass() == RentalData.class) {
			return new RentalDataJsonFormatter();
		} else if (object.getClass() == Rental.class) {
			return new RentalJsonFormatter();
		} else if (object.getClass() == Customer.class) {
			return new CustomerJsonFormatter();
		} else if (object.getClass() == Vehicle.class) {
			return new VehicleJsonFormatter();
		}
		return null;
	}
}
