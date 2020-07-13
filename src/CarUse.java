
public class CarUse {
	
	
	private int fuel = 0;
	private int expenses = 0;
	private int mileage = 0;
	
	public CarUse(int fuel, int expenses, int mileage) {
		super();
		this.fuel = fuel;
		this.expenses = expenses;
		this.mileage = mileage;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel += fuel;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses += expenses;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage += mileage;
	}
	
	
	
}
