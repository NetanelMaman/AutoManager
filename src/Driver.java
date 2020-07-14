
public class Driver extends User{

	private int age;
	private int drivingExperience;
	private int drivingLicenseType;
	private int parkingReports = 0;
	private int drivingReports = 0;
	private int dailyFuel = 0;
	
	public Driver(String ID, String firstName, String lastName, String phoneNumber,
						String email, String password, int age, int drivingExperience, int drivingLicenseType) {
		super(ID, firstName, lastName, phoneNumber, email, password);
		this.age=age;
		this.drivingExperience=drivingExperience;
		this.drivingLicenseType=drivingLicenseType;


		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	public int getDrivingLicenseType() {
		return drivingLicenseType;
	}

	public void setDrivingLicenseType(int drivingLicenseType) {
		this.drivingLicenseType = drivingLicenseType;
	}

	public int getParkingReports() {
		return parkingReports;
	}

	public void setParkingReports(int parkingReports) {
		this.parkingReports = parkingReports;
	}

	public int getDrivingReports() {
		return drivingReports;
	}

	public void setDrivingReports(int drivingReports) {
		this.drivingReports = drivingReports;
	}

	public int getDailyFuel() {
		return dailyFuel;
	}

	public void setDailyFuel(int dailyFuel) {
		this.dailyFuel = dailyFuel;
	}

}
