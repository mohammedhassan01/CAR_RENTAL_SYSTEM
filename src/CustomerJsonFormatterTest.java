import org.junit.Before;
import org.junit.Test;

public class CustomerJsonFormatterTest {

	@Before
	public void setup(){
		Vehicle blueHonda = new Vehicle("Blue Honda 2008", VehicleType.SEDAN);
		Vehicle greyJeep = new Vehicle("Grey Jeep 2013", VehicleType.FOURxFOUR);
		Vehicle RedSunny = new Vehicle("Red Sunny 2014", VehicleType.SEDAN);
		Vehicle BlueBMW = new Vehicle("Blue X3 2017", VehicleType.SUV);

		RentalData rentalData1 = new RentalData(431, 4, false);
		RentalData rentalData2 = new RentalData(744, 4, false);
		RentalData rentalData3 = new RentalData(591, 3, true);
		RentalData rentalData4 = new RentalData(240, 5, false);

		RentalRules SUVRentalRules = new RentalRules();
		SUVRentalRules.AMOUNT_PER_DAY = 150;
		SUVRentalRules.MILES_LIMIT_PER_DAY = 70;
		SUVRentalRules.FACTOR_AFTER_MILE_EXCEED = 2;
		SUVRentalRules.LATE_MOUNT_FACTOR = 0.3;
		SUVRentalRules.REWARD_POINTS_THRESHOLD = 5;
		SUVRentalRules.REWARD_POINTS_FACTOR = 2;

		RentalRules FOURXFOURRentalRules = new RentalRules(SUVRentalRules);
		FOURXFOURRentalRules.AMOUNT_PER_DAY = 200;

		RentalRules SEDANRentalRules = new RentalRules(SUVRentalRules);
		SEDANRentalRules.AMOUNT_PER_DAY = 100;
		SEDANRentalRules.MILES_LIMIT_PER_DAY = 50;
		SEDANRentalRules.RENTAL_LATE_FACTOR = 0.03;

		Rental rental1 = new Rental(blueHonda, SEDANRentalRules, rentalData1);
		Rental rental2 = new Rental(greyJeep, FOURXFOURRentalRules, rentalData2);
		Rental rental3 = new Rental(RedSunny, SEDANRentalRules, rentalData3);
		Rental rental4 = new Rental(BlueBMW, SUVRentalRules, rentalData4);

		JSON json = new JSON();

		Customer virginGates = new Customer("Virgin Gates", FormatType.PLAIN_TEXT);
		Customer sharmDreams = new Customer("Sharm Dreams", FormatType.PLAIN_TEXT);

		virginGates.addRentalToList(rental1);
		virginGates.addRentalToList(rental2);
		virginGates.addRentalToList(rental3);

		Formatter<Customer> formatter = JsonFormatterFactory.getFormatter(virginGates);
		String tt = formatter.getValue(virginGates);

		System.out.println(tt);
		// JSONObject jsonObject = json.toJSON(virginGates);

		sharmDreams.addRentalToList(rental4);
	}
	@Test
	public void getjosn()
	{
		
	}
}
