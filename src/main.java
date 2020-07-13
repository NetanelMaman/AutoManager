
public class main {

	public static void main(String[] args) {
		DatabaseManager.addCar("732", 500, "27.09", "Hatchback", "Opel Astra", "2017", "Black");
		CarUse c = DatabaseManager.usageFromDB("732");
		c.setExpenses(5000);
		c.setFuel(300);
		c.setMileage(50000);
		DatabaseManager.updateUsage("732", c);
		DatabaseManager.addTicket("732", "parking", "350");
		DatabaseManager.addTicket("732", "driving", "550");
		DatabaseManager.removeUserToCar("732", "5533");
		DatabaseManager.removeUserToCar("732", "5511");
		DatabaseManager.addUser("5533", "N", "M", "1342", "asd", "asd", 30, 7, 2);
		DatabaseManager.addUser("5511", "N", "M", "1342", "asd", "asd", 30, 7, 2);
		DatabaseManager.addCarToUser("732", "5511");
		
		DatabaseManager.reportDriverDaily("5511", "732", "30", "52", "15", "0");
	}

}
