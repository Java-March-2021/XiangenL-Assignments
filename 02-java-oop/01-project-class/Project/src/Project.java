
public class Project {
	private String name;
	private String description;
	private double initialCost;
	
	public String elevatorPitch(String name, String description, double initialCost) {
		this.name = name;
		this.description = description;
		this.initialCost = initialCost;
		return name + "(" + initialCost + "):" + description;
	}
//	constructor
	public Project() {
		
	}
	public Project(String name) {
		this.name = name;
	}
	
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Project(String name, String description, double initialCost) {
		this.name = name;
		this.description = description;
		this.initialCost = initialCost;
	}
//	getter, setter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setInitialCost(double initialCost) {
		this.initialCost = initialCost;
	}
	
	public double getInitialCost() {
		return initialCost;
	}
}
