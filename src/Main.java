import java.awt.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException {

		ArrayList<String> data = new ArrayList<String>();

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

		Customer virginGates = new Customer("Virgin Gates", FormatType.JSON);
		Customer sharmDreams = new Customer("Sharm Dreams", FormatType.PLAIN_TEXT);

		virginGates.addRentalToList(rental1);
		virginGates.addRentalToList(rental2);
		virginGates.addRentalToList(rental3);

		
		String tt = virginGates.getCustomerFormattedStatment();


		sharmDreams.addRentalToList(rental4);

		virginGates.statement();
		sharmDreams.statement();
		System.out.println(virginGates.statement());
		System.out.println("-------------------");
		System.out.println(
				"Rental Record for:Virgin Gates\n\t\"Blue Honda 2008\"\tLE 912.0\n\t\"Grey Jeep 2013\"\tLE 850.0\n\t\"Red Sunny 2014\"\tLE 1268.96\nAmount owed is LE 3030.96\nYou earned: 4 new Reward Points\n\n");

	}

}
