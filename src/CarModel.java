
public class CarModel extends Vehicle{

	public CarModel(String iDCar, int mileage, String dateOfTest, TotalExpenses expenses, String type, String modelName,
			int year, String color) {
		super(iDCar, mileage, dateOfTest, expenses);
		this.type = type;
		this.modelName = modelName;
		this.year = year;
		this.color = color;
	}
	private String type;
	private String modelName;
	private int year;
	private String color;
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
	
}
