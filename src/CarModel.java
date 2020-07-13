import java.util.ArrayList;

public class CarModel extends Vehicle{

	private String type;
	private String modelName;
	private int year;
	private String color;
	
	public CarModel(String iDCar, int mileage, String dateOfTest, TotalExpenses expenses, String type, String modelName,
			int year, String color) {
		super(iDCar, mileage, dateOfTest, expenses);
		this.type = type;
		this.modelName = modelName;
		this.year = year;
		this.color = color;
	}
	
	public CarModel(ArrayList<String> info) {
		super(info.get(0), Integer.parseInt(info.get(1)), info.get(2),new TotalExpenses(null, null, null));
		this.type = info.get(3);
		this.modelName = info.get(4);
		this.year = Integer.parseInt(info.get(5));
		this.color = info.get(6);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String showCarDetails() {
		return  "ID: " + getIDCar() + ", " + "Mileage: " + Integer.toString(getMileage()) + ", " 
				+ "Date of test: " + getDateOfTest() + ", " + "Type: " + getType() + ", "
				+ "Model name: " + modelName + ", " + "Year: " +  Integer.toString(year) + ", "
				+ "Color: " + color;
	}
}
