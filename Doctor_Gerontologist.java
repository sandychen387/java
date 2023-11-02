
class Gerontologist extends Doctor{
	
	private boolean performsHouseCalls = true;
    private double visitFee=0.0;
    
    
    public Gerontologist(String name) {
        super(name);
    }
    
    public Gerontologist(String name, boolean performsHouseCalls, double visitFee) {
        super(name);
        this.performsHouseCalls = performsHouseCalls;
        this.visitFee = visitFee;
    }
    
    public boolean performsHouseCalls() {
        return performsHouseCalls;
    }
    
    public double getVisitFee() {
        return visitFee;
    }
    
    public void setPerformsHouseCalls(boolean performsHouseCalls) {
        this.performsHouseCalls = performsHouseCalls;
    }
    
    public void setVisitFee(double visitFee) {
        this.visitFee = visitFee;
    }
    
    @Override
    public void addPatient(Patient patient) throws PatientException {
    	
        if (patient.getBirthYear() >=1958) {
           throw new PatientException("Gerontologists can only treat patients over 65.");
        }
        super.addPatient(patient);
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("\nGerontologist: %s | visit fee=%.2f",
                (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
    }

    @Override
    public boolean equals(Object obj) {
    	if(this==obj)return true;
    	if(obj==null||getClass()!=obj.getClass())return false;
    	if(!super.equals(obj))return false;
        
            Gerontologist that = (Gerontologist) obj;
         return performsHouseCalls== that.performsHouseCalls&&Math.abs(visitFee-that.visitFee)
<0.05;
    }     
    }


