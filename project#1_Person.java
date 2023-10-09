

	public class Person implements Comparable<Person> {
	    private String name;
	    private int birthYear;

	   
	    public Person() {
	        this.name = "";
	        this.birthYear = 0;
	    }

	    public Person(String name, int birthYear) {
	        this.name = name;
	        this.birthYear = birthYear;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getBirthYear() {
	        return birthYear;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setBirthYear(int year) {
	        this.birthYear = year;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if(obj instanceof Person) {
	        	Person otherPerson = (Person) obj;
	        	if(this.name.equals(otherPerson.name)) {
	        		if(this.birthYear == otherPerson.birthYear) {
	        			return true;
	        		}
	        	}
	        }
	        return false;
	    }

	    @Override
	    public String toString() {
	        return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	    }

	    @Override
	    public int compareTo(Person otherPerson) {
	        return this.birthYear - otherPerson.birthYear;
	    }
	}


