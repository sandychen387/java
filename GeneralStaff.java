
	public class GeneralStaff extends Employee {
	    private String duty;

	  
	    public GeneralStaff() {
	        super(); 
	        this.duty = "";
	    }

	
	    public GeneralStaff(String duty) {
	        super();
	        this.duty = duty;
	    }

	  
	    public GeneralStaff(String deptName, String duty) {
	        super(deptName); 
	        this.duty = duty;
	    }

	    
	    public GeneralStaff(String name, int birthYear, String deptName, String duty) {
	        super(name, birthYear, deptName); 
	        this.duty = duty;
	    }

	   
	    public String getDuty() {
	        return duty;
	    }
	   
	   
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if(obj instanceof GeneralStaff) {
	        	GeneralStaff otherStaff = (GeneralStaff) obj;
	        	if(super.equals(obj)) {
	        		if(this.duty.equals(otherStaff.duty)) {
	        			return true;
	        		}
	        	}
	        }
	        return false;
	    }

	 
	    @Override
	    public String toString() {
	    	return String.format("Person: Name: %30s | Birth Year: %4d Employee: Department: %20s | Employee Number: %3d GeneralStaff: Duty: %10s",
	                getName(), getBirthYear(), getDeptName(), getEmployeeID(), duty);
	    }
	  
	}

