
public class GarageVisit {

	private int price;
	private String mechanicName;
	
	public GarageVisit(int price, String mechanicName) {
		super();
		this.price = price;
		this.mechanicName = mechanicName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMechanicName() {
		return mechanicName;
	}
	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}
	
	public int getCommetVisit() {
		return (int)(price * 1.17);
	}
	
}
