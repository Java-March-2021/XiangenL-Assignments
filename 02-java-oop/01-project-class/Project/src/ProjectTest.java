
public class ProjectTest {
	public static void main(String[] args) {
		Project dietProject = new Project();
		Project healthProject = new Project("Healthproject", "build up healthy living patterns");
		Project workoutProject = new Project("Workout","Aerobic exercise", 0);
		
		dietProject.setName("Less Carbohydrates diet");
		dietProject.setDescription("More Protein");
		dietProject.setInitialCost(8);
		
		String name = dietProject.getName();
		String desc = dietProject.getDescription();
		double cost = dietProject.getInitialCost();
		
		System.out.println("Diet name: " + name + ", description: " + desc + ", initialcost: " + cost);
		
		System.out.println(dietProject.elevatorPitch("no food", "only water", 10));
		
		System.out.println(healthProject.elevatorPitch("Healthproject", "build up healthy living patterns", 0));
				
}
}
