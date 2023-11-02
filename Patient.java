
public class Patient {
	 private static int numPatients = 0;
	    String name;
	    int birthYear;
	    int patientNumber;
	    String ailment;
	    
	    public Patient(String name, int birthYear, String ailment) {
	        this.name = name;
	        if(isValid(birthYear)) {
	        	this.birthYear = birthYear;
	        	}else {
	        		this.birthYear =0;
	        	}
	        this.ailment = ailment;
	        this.patientNumber = numPatients++;
	    }
	    
	    private boolean isValid(int by) {
			if(by>=0) {
				return true;
			}
			return false;
		}

		public String getName() {
	        return name;
	    }

	    public int getBirthYear() {
	        return birthYear;
	    }

	    public int getPatientNumber() {
	        return patientNumber;
	    }

	    public String getAilment() {
	        return ailment;
	    }
	    
	    public static int getNumPatients() {
	    	return numPatients;
	    }
	    @Override
	    public String toString() {
	        return String.format("Patient [name=%20s | birthYear=%04d | patient number=%06d | ailment=%20s]",
	                name, birthYear, patientNumber, ailment);
	    }
	    
	    
	    @Override
	    public boolean equals(Object obj) {
	    	if(obj instanceof Patient) {
	    		Patient otherP = (Patient)obj;
	    		if(this.name.equals(otherP.name)) {
	    			if(this.birthYear==otherP.birthYear) {
	    				if(this.ailment.equals(otherP.ailment)) {
	    					return true;
	    				}
	    			}
	    		}
	    	}
	    	return false;
	}
}
