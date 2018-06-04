import org.junit.Assert;
import org.junit.Test;

public class CharacterizationTest {
    @Test
    public void testTypicalOutput() {

        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Vehicle greyJeep = new Vehicle("Grey Jeep 2013", Vehicle.FOURxFOUR);
        Vehicle RedSunny = new Vehicle("Red Sunny 2014", Vehicle.SEDAN);
        Vehicle BlueBMW = new Vehicle("Blue X3 2017", Vehicle.SUV);

        Rental hondaRental = new Rental(blueHonda, 431, 4, false);
        Rental jeepRental = new Rental(greyJeep, 744, 4, false);
        Rental sunnnyRental = new Rental(RedSunny, 591, 3, true);
        Rental x3Rental = new Rental(BlueBMW, 240, 5, false);

        Customer virginGates = new Customer("Virgin Gates");
        Customer sharmDreams = new Customer("Sharm Dreams");

        virginGates.addRental(hondaRental);
        virginGates.addRental(jeepRental);
        virginGates.addRental(sunnnyRental);

        sharmDreams.addRental(x3Rental);

        Assert.assertEquals("Rental Record for:Virgin Gates\n\t\"Blue Honda 2008\"\tLE 912.0\n\t\"Grey Jeep 2013\"\tLE 850.0\n\t\"Red Sunny 2014\"\tLE 1268.96\nAmount owed is LE 3030.96\nYou earned: 4 new Reward Points\n\n",virginGates.statement());

        Assert.assertEquals("Rental Record for:Sharm Dreams\n\t\"Blue X3 2017\"\tLE 760.0\nAmount owed is LE 760.0\nYou earned: 1 new Reward Points\n\n",sharmDreams.statement());

    }
}
