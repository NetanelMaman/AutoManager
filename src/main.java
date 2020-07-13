
public class main {

	public static void main(String[] args) {
		DatabaseManager manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/Database/Cars",
																System.getProperty("user.dir") + "/Database/Users");
		manager.addCar("732", 500, "27.09", "Hatchback", "Opel Astra", "2017", "Black");
		CarUse c = manager.usageFromDB("732");
		c.setExpenses(5000);
		c.setFuel(300);
		c.setMileage(50000);
		manager.updateUsage("732", c);
		manager.addTicket("732", "parking", "350");
		manager.addTicket("732", "driving", "550");
		manager.removeUserToCar("732", "5533");
		manager.removeUserToCar("732", "5511");
		manager.addUser("5533", "N", "M", "1342", "asd", "asd", 30, 7, 2);
		manager.addUser("5511", "N", "M", "1342", "asd", "asd", 30, 7, 2);
		manager.addCarToUser("732", "5511");
		
		manager.reportDriverDaily("5511", "732", "30", "52", "15", "0");
		manager.reportDriverDaily("5511", "731", "30", "52", "15", "0");
		manager.reportDriverDaily("5533", "732", "30", "52", "15", "0");
//		System.out.println(DatabaseManager.getDailyUsage("5511", "13-07-2020 09-30-55"));
		System.out.println(manager.getDailyUsageBetweenDates("5511", "13-07-2020 00-00-00.csv", "14-07-2020 00-00-00.csv"));
		System.out.println(manager.getUserUsageForCar("5511", "732"));
	}

}
