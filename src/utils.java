import java.util.ArrayList;
import java.util.Scanner;

public class utils {
	public static DatabaseManager manager = DatabaseManager.getInstance(System.getProperty("user.dir") + "/Database/Cars",
			System.getProperty("user.dir") + "/Database/Users");
	
	public static String registerOrLogin() {
		Scanner s = new Scanner(System.in);
		String id;
		System.out.println("Please press 1 to Register and 2 for sign in");
		int option = s.nextInt();
		if (option == 1) {
			System.out.println("Enter your ID");
			id = s.nextLine();
			System.out.println("Enter you first name");
			String fName = s.nextLine();
			System.out.println("Enter your last name");
			String lName = s.nextLine();
			System.out.println("Enter your phone number");
			String phoneNumber = s.nextLine();
			System.out.println("Enter your email");
			String email = s.nextLine();
			System.out.println("Enter your password");
			String password = s.nextLine();
			System.out.println("Enter your age");
			int age = s.nextInt();
			s.nextLine();
			System.out.println("Enter your driving experience");
			int experience = s.nextInt();
			s.nextLine();
			System.out.println("Enter your license type");
			int type = s.nextInt();
			s.nextLine();
			Driver d = new Driver(id, fName, lName, phoneNumber, email, password, age, experience, type);
			
			manager.addUser(d);
		} else {
			System.out.println("Enter your user id");
			s.nextLine();
			id = s.nextLine();
			System.out.println("Enter the password");
			String pass = s.nextLine();
			boolean result = manager.signIn(id, pass); 
			while(!result) {
				System.out.println("User id doesn't exist or password is incorrect");
				System.out.println("Enter your user id");
				id = s.nextLine();
				System.out.println("Enter the password");
				pass = s.nextLine();
				result = manager.signIn(id, pass);
			}
			System.out.println("Welcome back!");
		}
		return id;
	}
	
	/***
	 * Adds a car of choise of add is true and removes otherwise.
	 * @param userId - Id of operating user
	 * @param Add - True for adding, False for removing.
	 */
	public static void addOrRemoveCar(String userId) {
		boolean add = false;
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to add, 2 for remove");
		if (s.nextLine().equals("1")) {
			add = true;
		}
		String id;
		if (add) {
			ArrayList<CarModel> cars = manager.getAllCars(userId, add);
			if (cars.size() == 0) {
				System.out.println("You have all the cars for your own");
				return;
			}
			System.out.println("Here are the available cars, pick 1 car id to add");
			for (CarModel car: cars) {
				System.out.println(car.showCarDetails());
			}
			id = s.nextLine();
			manager.addCarToUser(id, userId);
			manager.addUserToCar(id, userId);
			System.out.println("Added");
		} else {
			ArrayList<CarModel> cars = manager.getAllCars(userId, add);
			if (cars.size() == 0) {
				System.out.println("You have no cars");
				return;
			}
			System.out.println("Here are your cars, pick 1 car id to remove");
			for (CarModel car: cars) {
				System.out.println(car.showCarDetails());
			}
			id = s.nextLine();
			manager.removeCarToUser(id, userId);
			manager.removeUserToCar(id, userId);
			System.out.println("Removed");
		}
	}
	
	public static void addUserInput(String userId) {
		Scanner s = new Scanner(System.in);
		System.out.println("Report you daily usage on one of your cars:");
		ArrayList<CarModel> cars = manager.getAllCars(userId, false);
		if (cars.size() == 0) {
			System.out.println("You have no cars");
			return;
		}
		System.out.println("Here are your cars, pick 1 car id to report on");
		for (CarModel car: cars) {
			System.out.println(car.showCarDetails());
		}
		System.out.println("Enter the car id you wish to report on");
		String id = s.nextLine();
		System.out.println("Fuel amount");
		String fuel = s.nextLine();
		System.out.println("Mileage amount");
		String mileage = s.nextLine();
		System.out.println("If you received parking tickets, add the amount to pay. Enter 0 otherwise");
		String parkingCost = s.nextLine();
		System.out.println("If you received driving tickets, add the amount to pay. Enter 0 otherwise");
		String drivingCost = s.nextLine();
		
		manager.reportDriverDaily(userId, id, fuel, mileage, parkingCost, drivingCost);
		
		manager.updateUsage(id, new CarUse(Integer.parseInt(fuel), Integer.parseInt(mileage),
				Integer.parseInt(mileage)));
		System.out.println("Reported");
	}
	
	public static void costOfCar(String userId) {
		Scanner s = new Scanner(System.in);
		System.out.println("Report you daily usage on one of your cars:");
		ArrayList<CarModel> cars = manager.getAllCars(userId, false);
		if (cars.size() == 0) {
			System.out.println("You have no cars");
			return;
		}
		System.out.println("Here are your cars, pick 1 car id to report on");
		for (CarModel car: cars) {
			System.out.println(car.showCarDetails());
		}
		String carId = s.nextLine();
		TotalExpenses expenses = new TotalExpenses(new GarageVisit(300, "Dvir"), manager.usageFromDB(carId), new Tickets(300, 500));
		System.out.println(expenses.Expenses());
	}
	
	public static void usageFromDates(String userId) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two dates, one early and one later, in the following format:");
		System.out.println("13-07-2020 09-30-55");
		String fromDate = s.nextLine();
		String toDate = s.nextLine();
		System.out.println(manager.getDailyUsageBetweenDates(userId, fromDate, toDate));
	}
	
	public static void usageOfUsersForCar(String userId) {
		Scanner s = new Scanner(System.in);
		System.out.println("Report you daily usage on one of your cars:");
		ArrayList<CarModel> cars = manager.getAllCars(userId, false);
		if (cars.size() == 0) {
			System.out.println("You have no cars");
			return;
		}
		System.out.println("Here are your cars, pick 1 car id to report on");
		for (CarModel car: cars) {
			System.out.println(car.showCarDetails());
		}
		String carId = s.nextLine();
		ArrayList<String> users = manager.getUsersOfCar(carId);
		for (String user: users) {
			System.out.println(manager.getUserUsageForCar(user, carId));
		}
	}

}
