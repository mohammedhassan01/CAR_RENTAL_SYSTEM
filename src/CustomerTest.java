import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void addRentalShouldReturnNullPointerException() {
		Customer customer = new Customer("mohamed hassan", FormatType.JSON);
		exception.expect(NullPointerException.class);
		customer.addRentalToList(new Rental(null, null, null));
		assertEquals(1, customer.getRentalsList().size());
	}

	@Test
	public void checkRentalSizeShouldReturnZero() {
		Customer customer = new Customer("mohamed ahmed", FormatType.PLAIN_TEXT);
		Vehicle vehicle = new Vehicle("Fiat 2018", null);
		RentalData rentalData = new RentalData(100, 3, true);
		RentalRules rentalRules = new RentalRules();
		assertEquals(0, customer.getRentalsList().size());
	}

	@Test
	public void addRental() {
		Customer customer = new Customer("mohamed hassan", FormatType.JSON);
		Vehicle vehicle = new Vehicle("Fiat 2018", null);
		RentalData rentalData = new RentalData(100, 3, true);
		RentalRules rentalRules = new RentalRules();

		customer.addRentalToList(new Rental(vehicle, null, null));
		customer.addRentalToList(new Rental(vehicle, rentalRules, null));
		customer.addRentalToList(new Rental(vehicle, rentalRules, rentalData));

		assertEquals(3, customer.getRentalsList().size());
	}
}
