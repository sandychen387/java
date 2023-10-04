

public abstract class Passenger implements Eater {
	private String name;
	private int birthYear;
	private double weight;
	private double height;
	private char gender;
	private int numCarryOn;
	public int caloriesConsumed;
    public int caloriesAccumulator;
	
	
	public Passenger() {
		name = "";
		birthYear = 1900;
		weight = 0.0;
		height = -1.0;
		gender = 'u';
		numCarryOn = 0;
		this.caloriesConsumed = 0;
        this.caloriesAccumulator = 0;
	}
   
    public Passenger(String name, int birthYear, double weight, double height,char gender, int numCarryOn) {
		this.name = name;
		this.birthYear =birthYear;
		if(weight >= 0.0) {
			this.weight = weight;
		}
		else {
			this.weight = -1.0;
		}
		if(height >= 0.0) {
			this.height = height;
		}
		else {
			this.height = -1.0;
		}
		if(gender == 'f'||gender == 'm'||gender == 'u') {
			this.gender = gender;
		}else {
			this.gender = 'u';
		}
		if(numCarryOn >= 0 && numCarryOn <= 2) {
			this.numCarryOn = numCarryOn;
		}else if(numCarryOn < 0) {
			this.numCarryOn =0;
		}else {
			this.numCarryOn =2;
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getBirthYear() {
		  return birthYear;
	  }
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight < 0) {
			this.weight = -1.0;
		}
		else {
			this.weight = weight;
		}
	}
	
	public double getHeight() {
		 return height;
	 }
	public void setHeight(double height) {
		if(height < 0) {
			this.height = -1.0;
		}
		else {
			this.height = height;
		}
	}
	
	public int getNumCarryOn() {
		return numCarryOn;
	}
	public void setNumCarryOn(int numCarryOn) {
		if(numCarryOn < 0) {
			this.numCarryOn = 0;
		}
		else if(numCarryOn > 2) {
			this.numCarryOn = 2;
		}
		else {
			this.numCarryOn = numCarryOn;
		}
	}
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
        if (gender == 'f' || gender == 'm' || gender == 'u') {
            this.gender = gender;
        } else {
            this.gender = 'u';
        }
    }
	
	public int calculateAge(int currentYear) {
		if(currentYear < birthYear) {
			return -1;
		}
		return currentYear - birthYear;
	}
	
	
	public boolean isFemale() {
		return gender == 'f';
	}
	
	public boolean isMale() {
		return gender == 'm';
	}
	
	public void gainWeight() {
		weight+=1.0;;
	}
	
	public void gainWeight(double amount) {
		if(amount >= 0) {
			weight += amount;
		}
	}
	
public void loseWeight() {
		
		if(weight > 0) {
			weight -=1.0;;
		}
		if(weight < 0) {
			weight =0;
		}
	}
	
	public void loseWeight(double amount) {
		if(amount >= 0) {
			weight -= amount;
		}
		if(weight < 0) {
			weight =0;
		}
		
	}
	
	
	public double calculateBMI() {
		if(height <= 0) {
			return -1;
		}
		return (weight * 703)/ (height * height);
	}
	
	

	public void printDetails() {
		System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d%n",
				name, birthYear, weight, height,gender,numCarryOn);
	}
	@Override
	public String toString() {
		return String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n" ,
				name, birthYear, weight, height,gender,numCarryOn);
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass()!= o.getClass()) {
			return false;
		}
		if(o instanceof Passenger) {
		Passenger otherPassenger = (Passenger) o;
		if(this.birthYear == otherPassenger.birthYear) {
			if(this.gender == otherPassenger.gender) {
				if(this.name.equalsIgnoreCase(otherPassenger.name)){
					if(Math.abs(weight - otherPassenger.weight) <= 0.5) {
						if(Math.abs(height - otherPassenger.height) <= 0.5){
							if(this.numCarryOn == otherPassenger.numCarryOn) {
								
							}
							return true;
						}
					}
				}
				
			}
		}
		
	}
		return false;
	}
	
    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesAccumulator() {
        return caloriesAccumulator;
    }

    public void setCaloriesAccumulator(int caloriesAccumulator) {
        this.caloriesAccumulator = caloriesAccumulator;
    }

    public abstract double metabolizeAccumulatedCalories();

    @Override
    public void eat(Food food) {
        caloriesConsumed += food.getCalories();
        caloriesAccumulator += food.getCalories();
    }

}


