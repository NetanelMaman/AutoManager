import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class DatabaseManager {
	
	private String carPath = System.getProperty("user.dir") + "/Database/Cars";
	private String userPath = System.getProperty("user.dir") + "/Database/Users";
	private static DatabaseManager manager_instance = null;
	
	public static DatabaseManager getInstance(String carPath, String userPath) {
		if (manager_instance == null) {
			manager_instance = new DatabaseManager(carPath, userPath);
		}
		return manager_instance;
	}
	
	private DatabaseManager(String carPath, String userPath) {
		this.carPath = carPath;
		this.userPath = userPath;
	}
	
	public  void addCar(String id, int mileage, String dateOfTest, String type, String modelName, String year, String color) {
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + id);
			if (!Files.isDirectory(p)) {
				Files.createDirectories(p);
				File users = new File(carPath + "/" + id + "/Users.csv");
				users.createNewFile();
				File file = new File(carPath + "/" + id + "/Usage.csv");
				writer = new FileWriter(file, true);
				writer.write("Car ID," + id + "\r\n");
				writer.write("Mileage," + Integer.toString(mileage) + "\r\n");
				writer.write("Date of test," + dateOfTest + "\r\n");
				writer.write("Car type," + type + "\r\n");
				writer.write("Model name," + modelName + "\r\n");
				writer.write("Production year," + year + "\r\n");
				writer.write("Car color," + color + "\r\n");
				writer.write("Fuel," + "0" + "\r\n");
				writer.write("Expenses," + "0" + "\r\n");
				writer.close();
			}
		}
		catch (IOException e) {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
	
	public  CarUse usageFromDB(String id) {
		BufferedReader br = null;
		FileReader reader = null;
		try {
			Path p = Paths.get(carPath + "/" + id);
			if (Files.isDirectory(p)) {
				reader = new FileReader(carPath + "/" + id + "/Usage.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
				
				br.close();
				reader.close();
				
				return new CarUse(Integer.parseInt(lines.get(7).split(",")[1]),
						Integer.parseInt(lines.get(8).split(",")[1]), Integer.parseInt(lines.get(1).split(",")[1]));
			}
		} catch (IOException e) {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public  void updateUsage(String id, CarUse usage) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + id);
			if (Files.isDirectory(p)) {
				reader = new FileReader(carPath + "/" + id + "/Usage.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
				
				br.close();
				reader.close();
				
				File file = new File(carPath + "/" + id + "/Usage.csv");
				file.delete();
				file = new File(carPath + "/" + id + "/Usage.csv");
				writer = new FileWriter(file, true);
				
				String mileage = Integer.toString(usage.getMileage());
				String fuel = Integer.toString(usage.getFuel());
				String expense = Integer.toString(usage.getExpenses());
				
				writer.write(lines.get(0) + "\r\n");
				writer.write("Mileage," + mileage + "\r\n");
				writer.write(lines.get(2) + "\r\n");
				writer.write(lines.get(3) + "\r\n");
				writer.write(lines.get(4) + "\r\n");
				writer.write(lines.get(5) + "\r\n");
				writer.write(lines.get(6) + "\r\n");
				writer.write("Fuel," + fuel + "\r\n");
				writer.write("Expenses," + expense + "\r\n");
				writer.close();
				
			}
		} catch (IOException e) {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void updateUsage(String id, String mileage, String fuel) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + id);
			if (Files.isDirectory(p)) {
				reader = new FileReader(carPath + "/" + id + "/Usage.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				
				while ((line = br.readLine()) != null) {
					lines.add(line);
				}
				
				br.close();
				reader.close();
				
				File file = new File(carPath + "/" + id + "/Usage.csv");
				file.delete();
				file = new File(carPath + "/" + id + "/Usage.csv");
				writer = new FileWriter(file, true);
				
				mileage = Integer.toString(Integer.parseInt(mileage) + Integer.parseInt(lines.get(1).split(",")[1]));
				fuel = Integer.toString(Integer.parseInt(fuel) + Integer.parseInt(lines.get(7).split(",")[1]));
				
				writer.write(lines.get(0) + "\r\n");
				writer.write("Mileage," + mileage + "\r\n");
				writer.write(lines.get(2) + "\r\n");
				writer.write(lines.get(3) + "\r\n");
				writer.write(lines.get(4) + "\r\n");
				writer.write(lines.get(5) + "\r\n");
				writer.write(lines.get(6) + "\r\n");
				writer.write("Fuel," + fuel + "\r\n");
				writer.write(lines.get(8) + "\r\n");
				writer.close();
				
			}
		} catch (IOException e) {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	/***
	 * Add parking/driving ticket to the car
	 * @param id - id of the car
	 * @param type - driving or parking
	 * @param cost - cost of the ticket
	 */
	public  void addTicket(String id, String type, String cost) {
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + id);
			if (Files.isDirectory(p)) {
				p = Paths.get(carPath + "/" + id + "/Tickets");
				if (!Files.isDirectory(p)) {
					Files.createDirectories(p);
				}
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String d = formatter.format(date);
				d = d.replaceAll(":", "-");
				String fileName = type + d; 
				File file = new File(carPath + "/" + id + "/Tickets/" + fileName + ".csv");
				writer = new FileWriter(file, true);
				writer.write("Type," + type + "\r\n");
				writer.write("Date," + d + "\r\n");
				writer.write("Cost," + cost + "\r\n");
				writer.close();
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void addUserToCar(String carId, String userId) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + carId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(carPath + "/" + carId + "/Users.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				boolean exist = false;
				
				while ((line = br.readLine()) != null) {
					if (line.split(",")[1].equals(userId)) {
						exist = true;
						break;
					}
					lines.add(line);
				}
				
				br.close();
				reader.close();
				if (exist) {
					return;
				}
				 
				File file = new File(carPath + "/" + carId + "/Users.csv");
				file.delete();
				file = new File(carPath + "/" + carId + "/Users.csv");
				writer = new FileWriter(file, true);
				for (String l: lines) {
					writer.write(l + "\r\n");
				}
				
				writer.write("UserID," + userId + "\r\n");
				writer.close();
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void removeUserToCar(String carId, String userId) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(carPath + "/" + carId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(carPath + "/" + carId + "/Users.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				boolean exist = false;
				
				while ((line = br.readLine()) != null) {
					if (line.split(",")[1].equals(userId)) {
						exist = true;
					} else {
						lines.add(line);	
					}					
				}
				
				br.close();
				reader.close();
				if (!exist) {
					return;
				}
				 
				File file = new File(carPath + "/" + carId + "/Users.csv");
				file.delete();
				file = new File(carPath + "/" + carId + "/Users.csv");
				writer = new FileWriter(file, true);
				for (String l: lines) {
					writer.write(l + "\r\n");
				}
				writer.close();
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void addUser(String id, String firstName, String lastName, String phoneNumber,
			String email, String password, int age, int drivingExperience, int drivingLicenseType) {
		FileWriter writer = null;
		try {
			Path p = Paths.get(userPath + "/" + id);
			if (!Files.isDirectory(p)) {
				Files.createDirectories(p);
				File users = new File(userPath + "/" + id + "/Cars.csv");
				users.createNewFile();
				File file = new File(userPath + "/" + id + "/Info.csv");
				writer = new FileWriter(file, true);
				writer.write("ID," + id + "\r\n");
				writer.write("First Name," + firstName + "\r\n");
				writer.write("Last Name," + lastName + "\r\n");
				writer.write("Phone Number," + phoneNumber + "\r\n");
				writer.write("Email," + email + "\r\n");
				writer.write("Password," + password + "\r\n");
				writer.write("Age," + Integer.toString(age) + "\r\n");
				writer.write("Driving Experience," + Integer.toString(drivingExperience) + "\r\n");
				writer.write("Driving License Type," + Integer.toString(drivingLicenseType) + "\r\n");
				writer.close();
			}
		}
		catch (IOException e) {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
	
	public  void addCarToUser(String carId, String userId) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(userPath + "/" + userId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(userPath + "/" + userId + "/Cars.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				boolean exist = false;
				
				while ((line = br.readLine()) != null) {
					if (line.split(",")[1].equals(carId)) {
						exist = true;
						break;
					}
					lines.add(line);
				}
				
				br.close();
				reader.close();
				if (exist) {
					return;
				}
				 
				File file = new File(userPath + "/" + userId + "/Cars.csv");
				file.delete();
				file = new File(userPath + "/" + userId + "/Cars.csv");
				writer = new FileWriter(file, true);
				for (String l: lines) {
					writer.write(l + "\r\n");
				}
				
				writer.write("CarID," + carId + "\r\n");
				writer.close();
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void removeCarToUser(String carId, String userId) {
		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		try {
			Path p = Paths.get(userPath + "/" + carId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(userPath + "/" + userId + "/Cars.csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				boolean exist = false;
				
				while ((line = br.readLine()) != null) {
					if (line.split(",")[1].equals(carId)) {
						exist = true;
					} else {
						lines.add(line);	
					}					
				}
				
				br.close();
				reader.close();
				if (!exist) {
					return;
				}
				 
				File file = new File(userPath + "/" + userId + "/Cars.csv");
				file.delete();
				file = new File(userPath + "/" + userId + "/Cars.csv");
				writer = new FileWriter(file, true);
				for (String l: lines) {
					writer.write(l + "\r\n");
				}
				writer.close();
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public  void reportDriverDaily(String userId, String carId, String fuel, String mileage, String parkingCost, String drivingCost) {
		FileWriter writer = null;
		try {
			Path p = Paths.get(userPath + "/" + userId);
			if (Files.isDirectory(p)) {
				p = Paths.get(userPath + "/" + userId + "/Daily");
				if (!Files.isDirectory(p)) {
					Files.createDirectories(p);
				}
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String d = formatter.format(date);
				d = d.replaceAll(":", "-");
				String fileName = d; 
				File file = new File(userPath + "/" + userId + "/Daily/" + fileName + ".csv");
				writer = new FileWriter(file, true);
				writer.write("Car Id," + carId + "\r\n");
				writer.write("Fuel," + fuel + "\r\n");
				writer.write("Mileage," + mileage + "\r\n");
				writer.close();
				
				if (!parkingCost.equals("0")) {
					addTicket(carId, "parking", parkingCost);
				}
				if (!drivingCost.equals("0")) {
					addTicket(carId, "driving", drivingCost);
				}
				
				updateUsage(carId, mileage, fuel);
			}
		} catch (IOException e) {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
	public  String getDailyUsage(String userId, String date) {
		BufferedReader br = null;
		FileReader reader = null;
		try {
			Path p = Paths.get(userPath + "/" + userId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(userPath + "/" + userId + "/Daily/" + date + ".csv");
				br = new BufferedReader(reader);
				ArrayList<String> lines = new ArrayList<String>();
				String line;
				String usage = "";
				
				while ((line = br.readLine()) != null) {
					usage += line + "\r\n";
				}
				
				br.close();
				reader.close();
				
				return usage;
			}
		} catch (IOException e) {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public  String getDailyUsageBetweenDates(String userId, String fromDate, String toDate) {
		Path p = Paths.get(userPath + "/" + userId);
		if (Files.isDirectory(p)) {
			File folder = new File(userPath + "/" + userId + "/Daily");
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles == null) {
				return null;
			}
			String usages = "";
			String[] filePaths;
			String filePath;
			for(File f: listOfFiles) {
				filePaths = f.getPath().split(Pattern.quote(File.separator));
				filePath = filePaths[filePaths.length - 1];
				if (filePath.compareToIgnoreCase(fromDate) >= 0 && filePath.compareToIgnoreCase(toDate) <= 0) {
					usages += getDailyUsage(userId, filePath.split(".csv")[0]);
				}
			}
			return usages;
		}
		return null;
	}
	
	public  String getUserUsageForCar(String userId, String carId) {
		String usage = "";
		int fuel = 0, mileage = 0;
		String[] usages;
		usage = getDailyUsageBetweenDates(userId, "0", "9");
		if (usage != null && !usage.equals("")) {
			usages = usage.split("\r\n");
			for (int i = 0; i < usages.length; i+=3) {
				if (usages[i].split(",")[1].equals(carId)) {
					fuel += Integer.parseInt(usages[i+1].split(",")[1]);
					mileage += Integer.parseInt(usages[i+2].split(",")[1]);
				}
			}
		}
		usage = "";
		usage += "CarId," + carId + "\r\n";
		usage += "Fuel," + Integer.toString(fuel) + "\r\n";
		usage += "Mileage," + Integer.toString(mileage) + "\r\n";
		return usage;
	}
	
	private  String userPassword(String userId) {
	
		BufferedReader br = null;
		FileReader reader = null;
		try {
			Path p = Paths.get(userPath + "/" + userId);
			if (Files.isDirectory(p)) {
				reader = new FileReader(userPath + "/" + userId + "/Info.csv");
				br = new BufferedReader(reader);
				String line;
				
				while ((line = br.readLine()) != null) {
					if (line.split(",")[0].equals("Password")) {
						br.close();
						reader.close();
						return line.split(",")[1];
					}
				}
				
				br.close();
				reader.close();
				
				
			}
		} catch (IOException e) {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public  boolean signIn(String userId, String password) {
		return password.equals(userPassword(userId));
	}
}
