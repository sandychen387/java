package abstract_classes_and_interfaces;

public class Dog extends Pet implements Comparable<Dog>{
		
		private static int numberOfDogs = 0;
		private int dogNumber;
		private String name;
		private double weight;
		private double height;
		private boolean isVaccinated;
		private int ageInDogYears;
		public static final double ACCURACY_RANGE_HEIGHT = 0.5;
		public static final double ACCURACY_RANGE_WEIGHT =0.8;
		
		public Dog() {//default constructor
			numberOfDogs++;//incrementing the counter
			dogNumber = numberOfDogs;//use the counter to assign the current dog its number
			name = "Doggie Doe";
			weight = 0;
			height = 0;
			isVaccinated = false;
			ageInDogYears = 0;
		}
		public Dog(String name) {//overloaded constructor
			this();//call the default constructor
			if(name != null) {
				this.name = name;
			}
		}
		
		public Dog(String name, double weight, double height) {//overloaded constructor
			this(name);
			if(isValid(height)) {
				this.height = height;
			}
			if(isValid(weight)) {
				this.weight = weight;
			}
		}
		
		public Dog(double weight, double height) {//overloaded constructor
			this();
			if(isValid(height)) {
				this.height = height;
			}
			if(isValid(weight)) {
				this.weight = weight;
			}
		}
		
		public Dog(String name, double wt, double ht, boolean isVac, int ageDY) {//fully overloaded constructor
			this();
			if(name != null) {
				this.name = name;
			}
			if(isValid(weight)) {
					weight = wt;
			}
			if(ht > 0) {
					this.height = ht;
			}//height = ht
			isVaccinated = isVac;
			if(isValid(ageDY)) {ageInDogYears = ageDY;
			}
		}
		
			protected boolean isValid(int x) {
				return x > 0;
			}
			protected boolean isValid(double x) {
				return x > 0;
			}
			
			public void setName(String name) {
				if(name != null) {
					this.name = name;
				}
			}
			
			public void setWeight(double w) {
				weight = w;
			}
			
			public void setHeight(double ht) {
				height = ht;
			}
			
			public void setIsVaccinated(boolean vacStatus) {
				isVaccinated = vacStatus;
			}
			
			public void setAgeInDogYears(int age) {
				ageInDogYears = age;
			}
			
			public String getName() {
				return name;
			}
			
			public double getWeight() {
				return weight;
			}
			
			public double getHeight() {
				return height;
			}
			
			public static int getNumberOfDogs() {
				return numberOfDogs;
			}
			
			public int getDogNumber() {
				return dogNumber;
			}
			
			public int getAgeInDogYears() {
				return ageInDogYears;
			}
			
			public boolean isVaccinated() {
				return isVaccinated;
			}
			
			public boolean getIsVaccinated() {
				return isVaccinated;
			}
			
			public void sit() {
				System.out.println("I " + name + " will woof sit now. ");
			}
			
			
			@Override
			public String toString() {
				String s = "Dog details\n" +
			"dog number = " + dogNumber + ", name = " + name + ", height = "
			+height + ",weight= " + weight;
				if(isVaccinated) {
					s += " is vaccinated";
				}
				else {
					s += " is NOT vaccinated";
				}
				s += ", age in dog years = " + ageInDogYears;
				return s;
			}
			@Override
			public boolean equals(Object obj) {
				if(obj == null) {
					return false;
				}
				if(this == obj) {
					return true;
				}
				if(obj instanceof Dog) {
					Dog otherD = (Dog) obj;
					if(this.ageInDogYears == otherD.ageInDogYears) {
						if(this.isVaccinated == otherD.isVaccinated){
							if(Math.abs(this.weight - otherD.weight) < ACCURACY_RANGE_WEIGHT) {
								if(Math.abs(this.height - otherD.height) < ACCURACY_RANGE_HEIGHT) {
									if(this.name.equalsIgnoreCase(otherD.name)) {
										return true;
									}
								}
							}
						}
					}
				}
				return false;
			}
			
			@Override
			public void play() {
				System.out.println("I " + name + " will play with " + getFavoriteToy());
			}
			
			@Override
			public void eat() {
				System.out.println("\nWOOF! Iam a dog that loves to eat " + getFavoriteFood());
			}
			
			@Override
			public void eat(Food f) {
				System.out.println("WOOF! I will eat " + f.getName() + " now.");
			}
			
			@Override
			public double metabolizeFood(Food f) {
				return f.getCalories()/METABOLISM_RATING_MEDIUM;
			}
			
			@Override
			public void speak(String s) {
				speak();
				System.out.println(s);
			}
			
			@Override
			public void speak() {
				System.out.println("Woo");
			}
			
			@Override
			public int compareTo(Dog otherD) {
				if(this.dogNumber > otherD.dogNumber) {
					return 1;
				}
				else if(this.dogNumber < otherD.dogNumber) {
					return -1;
				}
				else {
					return 0;
				}
			}
	}





























