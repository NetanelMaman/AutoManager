import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Scanner;
public class main {

	public static DatabaseManager manager;
	
	public static void main(String[] args) {
		
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
