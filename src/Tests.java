import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Tests {
	DatabaseManager manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/TestDatabase/Cars",
			System.getProperty("user.dir") + "/TestDatabase/Users");
	@Test
	public void insertUser() {
		Driver d = new Driver("313391187", "Netanel", "Maman", "054", "netanelM", "123456", 25, 8, 2);
		//manager.addUser("313391187", "Netanel", "Maman", "054", "netanelM", "123456", 25, 8, 2);
		manager.addUser(d);
		assertEquals(true, manager.signIn("313391187", "123456"),
				"Should return true because we have signed in with the correct password");
		assertEquals(false, manager.signIn("313391187", "12345"),
				"Should return false because we have signed in with the wrong password");
	}
	
	@Test
	public void addCarToUser() {
		manager.addCar("2315342", 500, "27.09", "Hatchback", "Opel Astra", "2017", "Black");
		manager.addUserToCar("2315342", "313391187");
		String usage = "";
		usage += "CarId," + "2315342" + "\r\n";
		usage += "Fuel," + Integer.toString(0) + "\r\n";
		usage += "Mileage," + Integer.toString(0) + "\r\n";
		assertEquals(usage, manager.getUserUsageForCar("313391187", "2315342"),
				"Checks that the usage is still 0 because the car has been added recently");
		manager.reportDriverDaily("313391187", "2315342", "30", "500", "0", "0");
		assertNotEquals("", manager.getUserUsageForCar("313391187", "2315342"));
	}
}
