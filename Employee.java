
	public class Employee extends Person {
	    private static int numEmployees = 0;
	    private String deptName;
	    private int employeeID;

	    public Employee() {
	        super();
	        this.deptName = "";
	        this.employeeID = generateEmployeeID();
	    }

	    public Employee(String deptName) {
	        super(); 
	        this.deptName = deptName;
	        this.employeeID = generateEmployeeID();
	    }

	    public Employee(String name, int birthYear, String deptName) {
	        super(name, birthYear); 
	        this.deptName = deptName;
	        this.employeeID = generateEmployeeID();
	    }

	    public String getDeptName() {
	        return deptName;
	    }

	    public static int getNumEmployees() {
	        return numEmployees;
	    }

	    public int getEmployeeID() {
	        return employeeID;
	    }

	    public void setDeptName(String deptName) {
	        this.deptName = deptName;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if(obj instanceof Employee) {
	        	Employee otherEmployee = (Employee) obj;
	        	if(super.equals(obj)) {
	        		if(this.deptName.equals(otherEmployee.deptName)) {
	        		return true;
	        		}
	        	}
	        }
	        return false;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
	    }

	    @Override
	    public int compareTo(Person otherPerson) {
	        if (otherPerson instanceof Employee) {
	            Employee otherEmployee = (Employee) otherPerson;
	            int result = this.employeeID - otherEmployee.employeeID;
	            if(result!=0) {
	            	return result;
	            }
	        }
	    
	        	return super.compareTo(otherPerson);
	    }

	    
	    private static int generateEmployeeID() {
	        numEmployees++;
	        if (numEmployees <= 4) {
	            return numEmployees + 4;
	        } else if (numEmployees >= 5 && numEmployees <= 8) {
	            return numEmployees -4;
	        }else {
	        	return -1;
	        }
	    }
}