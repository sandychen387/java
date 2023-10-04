package abstract_classes_and_interfaces;

public class Food {
	
	private String name;
	private int calories;
	private int portionSizeOunces;
	
	public Food(String name, int calories, int portionSizeOunces) {
		this.name = name;
		this.calories = calories;
		this.portionSizeOunces = portionSizeOunces;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCalories() { 
		return calories;
	}
	
	public int getPortionSizeOunces() {
		return portionSizeOunces;
	}
	
	@Override
	public String toString() {
		return String.format("Food [name = %10s,calories = %02d,portion size = %02d ounces ]", name,calories,portionSizeOunces);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(this == o) {return true;
	}
		if(o instanceof Food) {
			Food otherF =(Food)o;
			if(name.equalsIgnoreCase(otherF.name)) {
				if(calories == otherF.calories) {
					if(portionSizeOunces == otherF.portionSizeOunces) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
