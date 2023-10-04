
public class Food {
	
	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		 return String.format("Food - name: %10s | calories: %4d", name, calories);
	    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
	            return true;
	        }
		if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
		Food otherFood = (Food) obj;
		return name.equals(otherFood.name) && calories == otherFood.calories;
	    }
	}