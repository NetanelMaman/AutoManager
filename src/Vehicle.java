
public abstract class Vehicle {
	
	private String IDCar;
	private int mileage;
	private String dateOfTest;
	private TotalExpenses expenses;
	
	public Vehicle(String iDCar, int mileage, String dateOfTest, TotalExpenses expenses) {
		super();
		IDCar = iDCar;
		this.mileage = mileage;
		this.dateOfTest = dateOfTest;
		this.expenses = expenses;
	}
	
	public void goGarage() {
		this.expenses.visitGarage();
	}
	
	public void goTest() {
		this.expenses.makeTest();
	}
	
	
	
	public String getIDCar() {
		return IDCar;
	}
	public void setIDCar(String iDCar) {
		IDCar = iDCar;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getDateOfTest() {
		return dateOfTest;
	}
	public void setDateOfTest(String dateOfTest) {
		this.dateOfTest = dateOfTest;
	}
	public TotalExpenses getExpenses() {
		return expenses;
	}
	public void setExpenses(TotalExpenses expenses) {
		this.expenses = expenses;
	}
	
}
