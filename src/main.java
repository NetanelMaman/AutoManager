import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Scanner;
public class main {

	public static DatabaseManager manager;
	
	public static void main(String[] args) {
		manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/Database/Cars",
				System.getProperty("user.dir") + "/Database/Users");
		manager.addCar("732", 500, "27.09", "Hatchback", "Opel Astra", "2017", "Black");
		manager.addCar("731", 600, "27.10", "Hatchback", "Opel Cursa", "2020", "Black");
		manager.addCar("734", 50, "27.09", "Hatchback", "VOLVO", "2021", "Black");
		Scanner s = new Scanner(System.in);
		int option = 1;
		String userId = utils.registerOrLogin();

		
		while(option != 0) {
			System.out.println("Choose operation number:");
			System.out.println("1: Add or Remove a car to manage");
			System.out.println("2: Enter your daily usage");
			System.out.println("3: Show car usage");
			System.out.println("4: Filter usage between dates");
			System.out.println("5: Show drivers usage for a car");
			System.out.println("0: To quit");
			option = s.nextInt();
			s.nextLine();
			switch (option) {
				case 1:
					utils.addOrRemoveCar(userId);
					break;
				case 2:
					utils.addUserInput(userId);
					break;
				case 3:
					utils.costOfCar(userId);
					break;
				case 4:
					utils.usageFromDates(userId);
					break;
				case 5:
					utils.usageOfUsersForCar(userId);
					break;
				default:
					return;
			}
		}
	}	
}
