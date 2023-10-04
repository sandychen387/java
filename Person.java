public abstract class Person extends Passenger {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
		name = "";
		age =0;
	}

	public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void speak();

    @Override
    public double metabolizeAccumulatedCalories() {
      
        return 0.0;
    }
}
