/*public abstract class Infant extends Person implements Mover {
	
	
	public Infant(String name, int age) {
    }

    

    @Override
    public void move() {
    
        System.out.println("Flail arms and legs");
    }
    
    @Override
    public void move(int count) {
    	
        if (count <= 0) {
        	System.out.println("");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("flail arms and legs\n");
        }
        System.out.println("flail arms and legs\n");
    }

    @Override
    public double metabolizeAccumulatedCalories() {
      
        double weightGain = getCaloriesAccumulator() / 1200.0;
        
        setCaloriesAccumulator(0);
        return weightGain;
    }

    @Override
	public abstract void eat();

    @Override
	public abstract void speak();
}
*/


public class Infant extends Person implements Mover {
	
    private class InfantToy {
    private final String infantToyName;
    private final int infantToyRating;

    public InfantToy(String infantToyName, int infantToyRating) {
    	this.infantToyName = infantToyName;
        this.infantToyRating = infantToyRating;
        }

    public String toString() {
    	return String.format("InfantToy: Toy Name: %20s | Rating %4d\n", infantToyName, infantToyRating);
        }
    }

    private final InfantToy[] toys;
    private int numInfantToys;
	private double weight;

    public Infant() {
        super();
        this.toys = new InfantToy[10];
        this.numInfantToys = 0;
    }

    public Infant(String name, int birthYear, double weight, double height, char gender, int numCarryOn) {
        super();
        this.toys = new InfantToy[10];
        this.numInfantToys = 0;
    }

    public void addInfantToy(String name, int rating) {
        if (numInfantToys < 10) {
            toys[numInfantToys++] = new InfantToy(name, rating);
        } else {
            System.out.println("toys has reached capacity of 10");
        }
    }
    public void setWeight(double weight ) {
    	this.weight = weight;
    }
    public double getWeight() {
        
        return weight;
    }
    public int getNumInfantToys() {
        return numInfantToys;
    }

    public String getInfantToyName(int index) {
        if (index >= 0 && index < numInfantToys) {
            return toys[index].infantToyName;
        }
        return "invalid index " + index;
    }

    public int getInfantToyRating(int index) {
        if (index >= 0 && index < numInfantToys) {
            return toys[index].infantToyRating;
        }
        return -1;
    }

    public int getHighestInfantToyRating() {
        int highestRating = 0;
        for (int i = 0; i < numInfantToys; i++) {
            if (toys[i].infantToyRating > highestRating) {
                highestRating = toys[i].infantToyRating;
            }
        }
        return highestRating;
    }

    @Override
    public double metabolizeAccumulatedCalories() {
       
        double poundsGained = getCaloriesAccumulator() / 1200.0;
      
        weight += poundsGained;
        
        setCaloriesAccumulator(0); 
        return weight;
    }


    @Override
    public String move() {
		return "flail arms and legs";
    	
    }
//    public String move() {
//    	String str = "flail arms and legs";
//        return str;
//    }

    @Override
    public String move(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("flail arms and legs\n");
        }
        return sb+"";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Call the parent class's toString method
        sb.append(String.format("Infant: Number of Toys: %4d | Infant Toys:\n", numInfantToys));
        for (int i = 0; i < numInfantToys; i++) {
            sb.append(toys[i].toString());
        }
        return sb.toString();
    }

    
    public void printDetails() {
         
        System.out.printf("Infant: Number of Toys: %4d | Infant Toys:\n", numInfantToys);
        for (int i = 0; i < numInfantToys; i++) {
            System.out.print(toys[i].toString());
        }
    }

	@Override
	public void eat(Food food) {
		caloriesConsumed += food.getCalories();
		caloriesAccumulator += food.getCalories();
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat(Food[] foods) {
		for (Food food : foods) {
	        caloriesConsumed += food.getCalories();
	        caloriesAccumulator += food.getCalories();
	}
	}
}
