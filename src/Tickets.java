
public class Tickets {
	
	private int parkingReports;
	private int drivingReports;
	
	public Tickets(int parkingReports, int drivingReports) {
		super();
		this.parkingReports = parkingReports;
		this.drivingReports = drivingReports;
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
	
	
}
