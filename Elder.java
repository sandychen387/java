package hw5;

public class Elder extends Person implements Mover {
	private String name;
	private int age;
	private double weight;
	public Elder() {
		name = "";
		age = 0;
	}
	public Elder(String name, int age) {
		this.name = name;
		this.age = age;
    }

	public void setWeight(double weight ) {
    	this.weight = weight;
    }
    public double getWeight() {
        
        return weight;
    }

    @Override
    public void speak() {
    	System.out.println("How are you, my dear?");
    }

    @Override
    public String move() {
    	return "ouch my back wait for me";
    }

    
    @Override
    public String move(int count) {
        if (count <= 0) {
        	return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("ouch my back wait for me");
        if (i < count - 1) {
            result.append("\n"); 
        }
        }
        return result.toString();
    }

    @Override
    public double metabolizeAccumulatedCalories() {
      
        double poundsGained = getCaloriesAccumulator() / 300.0;
        
        weight += poundsGained;
        
        setCaloriesAccumulator(0); 
        return weight;
    }
    
    @Override
    public void eat() {};

	@Override
	public void eat(Food[] foods) {
		for (Food food : foods) {
	        caloriesConsumed += food.getCalories();
	        caloriesAccumulator += food.getCalories();
	}
		
	}

	@Override
	public void eat(Food food) {
		caloriesConsumed += food.getCalories();
		caloriesAccumulator += food.getCalories();
	}

}
