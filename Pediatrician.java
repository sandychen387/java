//import java.util.Arrays;

public class Pediatrician extends Doctor {
	
	private boolean hasPrivatePractics=false;
	private String hospitalName="";
	//private Patient[] patients;
	
	public Pediatrician(String name) {
		super(name);
		//this.patients = new Patient[10];
	}

	public Pediatrician(String name, boolean hasPrivatePractics, String hospitalName) {
	    super(name);
	    this.hasPrivatePractics = hasPrivatePractics;
	    this.hospitalName = hospitalName;
	   // this.patients = new Patient[10];
	}

	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public boolean hasPrivatePractice() {
		
		return hasPrivatePractics;
	}
	 public void setHospitalName(String hospitalName) {
	        this.hospitalName = hospitalName;
	    }
	 
	 @Override
	    public void addPatient(Patient patient) throws PatientException {
	        if (patient.getBirthYear() <= 2005) {
	        	throw new PatientException("Pediatricians can only treat patients under 18.");
	        }
	           
	            super.addPatient(patient);
	        } 
	

		@Override
	    public String toString() {
	        return super.toString() + String.format("\nPediatrician: %s | hospital name=%15s", (hasPrivatePractice() ? "has private practice" : "does not have private practice"), hospitalName);
	    }

	    @Override
	    public boolean equals(Object obj) {
	    	if(this==obj)return true;
	    	if(obj==null||getClass()!=obj.getClass())return false;
	    	if(!super.equals(obj))return false;
	    	Pediatrician that =(Pediatrician)obj;
	    	return hasPrivatePractics==that.hasPrivatePractics&&hospitalName.equals(that.hospitalName);
	    }
	}

