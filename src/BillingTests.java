import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/////////////////////////////////////////////////////////////
/////////// This is where your tests should go //////////////
/////////////////////////////////////////////////////////////
public class BillingTests {

	private Rental rental1;
	private Rental rental2;
	private Rental rental3;
	private Rental rental4;
	private Rental rentalZeroDays;
	private Rental rentalWithNullRules;
	private RentalRules SEDANRentalRules;
	private RentalRules FOURXFOURRentalRules;
	private Vehicle blueHonda;

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private RentalData rentalDataZeroDays;
	private Vehicle greyJeep;
	private Vehicle redSunny;
	private Vehicle blueBMW;

	@Before
	public void setUp() {
		blueHonda = new Vehicle("Blue Honda 2008", VehicleType.SEDAN);
		greyJeep = new Vehicle("Grey Jeep 2013", VehicleType.FOURxFOUR);
		redSunny = new Vehicle("Red Sunny 2014", VehicleType.SEDAN);
		blueBMW = new Vehicle("Blue X3 2017", VehicleType.SUV);

		RentalData rentalData1 = new RentalData(431, 4, false);
		RentalData rentalData2 = new RentalData(744, 4, false);
		RentalData rentalData3 = new RentalData(591, 3, true);
		RentalData rentalData4 = new RentalData(240, 5, false);

		rentalDataZeroDays = new RentalData(431, 0, false);

		RentalRules SUVRentalRules = new RentalRules();
		SUVRentalRules.AMOUNT_PER_DAY = 150;
		SUVRentalRules.MILES_LIMIT_PER_DAY = 70;
		SUVRentalRules.FACTOR_AFTER_MILE_EXCEED = 2;
		SUVRentalRules.LATE_MOUNT_FACTOR = 0.3;
		SUVRentalRules.REWARD_POINTS_THRESHOLD = 5;
		SUVRentalRules.REWARD_POINTS_FACTOR = 2;

		FOURXFOURRentalRules = new RentalRules(SUVRentalRules);
		FOURXFOURRentalRules.AMOUNT_PER_DAY = 200;

		SEDANRentalRules = new RentalRules(SUVRentalRules);
		SEDANRentalRules.AMOUNT_PER_DAY = 100;
		SEDANRentalRules.MILES_LIMIT_PER_DAY = 50;
		SEDANRentalRules.RENTAL_LATE_FACTOR = 0.03;

		rental1 = new Rental(blueHonda, SEDANRentalRules, rentalData1);
		rental2 = new Rental(greyJeep, FOURXFOURRentalRules, rentalData2);
		rental3 = new Rental(redSunny, SEDANRentalRules, rentalData3);
		rental4 = new Rental(blueBMW, SUVRentalRules, rentalData4);

		rentalWithNullRules = new Rental(blueHonda, null, rentalDataZeroDays);

	}

	@Test
	public void caluculateAmountForCarShouldReturnValue() {
		double rentalMount = BillingPlanFactory.getRentalBillingPlan(rental1).getRentalAmount(rental1);
		assertEquals(912.0, rentalMount, 0);

	}

	@Test
	public void caluculateAmountForCarShouldThrowException() {

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Number of days < 1");
		rentalZeroDays = new Rental(blueHonda, SEDANRentalRules, rentalDataZeroDays);
		BillingPlanFactory.getRentalBillingPlan(rentalZeroDays).getRentalAmount(rentalZeroDays);
	}

	@Test
	public void calculateAmountShouldReturnBasicValue() {
		RentalData rentalData = new RentalData(0, 1, false);
		RentalRules zeroCost = new RentalRules(FOURXFOURRentalRules);
		zeroCost.AMOUNT_PER_DAY = 0;
		zeroCost.MILES_LIMIT_PER_DAY = 1;
		Rental rental = new Rental(blueBMW, zeroCost, rentalData);
		double amount = BillingPlanFactory.getRentalBillingPlan(rental).getRentalAmount(rental);
		assertEquals(50, amount, 0);

	}

	@Test
	public void caluculateAmountForCarShouldThrowExceptionNullPointerException() {

		exception.expect(NullPointerException.class);
		BillingPlanFactory.getRentalBillingPlan(rentalWithNullRules).getRentalAmount(rentalWithNullRules);
	}
}
