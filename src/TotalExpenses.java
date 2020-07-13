
public class TotalExpenses {
	
	private GarageVisit garage;
	private CarUse usage;
	private Tickets tickets;
	
	public TotalExpenses(GarageVisit garage, CarUse usage, Tickets tickets) {
		super();
		this.garage = garage;
		this.usage = usage;
		this.tickets = tickets;
	}
	
	public void visitGarage() {
		usage.setExpenses(garage.getCommetVisit());
	}
	
	public void makeTest() {
		usage.setExpenses(1517);
	}
	
	public GarageVisit getGarage() {
		return garage;
	}
	public void setGarage(GarageVisit garage) {
		this.garage = garage;
	}
	public CarUse getUsage() {
		return usage;
	}
	public void setUsage(CarUse usage) {
		this.usage = usage;
	}
	public Tickets getTickets() {
		return tickets;
	}
	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}
}
