import java.util.Arrays;

class Doctor implements SeesPatients, Comparable<Doctor>{
		
		private static int numDoctors = 0;
		private String name;
		private int licenseNumber;
		private Patient[] patients;
		protected int numberOfPatients;
		private int birthYear;
		private int patientNumber;
		private Object ailment;
		
		
		public Doctor() {
			name="";
			numDoctors++;
			numberOfPatients=0;
		}
		
		public Doctor(String name) {
			this.name =name;
			this.licenseNumber =++numDoctors;
			this.numberOfPatients=0;
			this.patients=new Patient[SeesPatients.MAX_PATIENTS];
		}
		
		public static int getNumDoctors() {
			return numDoctors;
		}
		
		public int getLicenseNumber() {
			return licenseNumber;
		}
		
		public String getName() {
			return name;
		}
		
		public int getNumberOfPatients() {
			return numberOfPatients;
		}
		
		public String getPatientsAsStrings() {
			String patientList = "patients= ";
			for(int i=0;i<numberOfPatients;i++) {
				patientList+=patients[i];
				if(i<numberOfPatients-1) {
					patientList +=", ";
				}
				patientList+=patients[i];
			}
			return patientList;
		}
		
		public void addPatient(Patient patient) throws PatientException{
			if(numberOfPatients<SeesPatients.MAX_PATIENTS) {
				patients[numberOfPatients++]=patient;
			}else {
				throw new PatientException("Patient capacity has been reached for this doctor.");
			
			}
		}
		
		@Override
		public String toString() {
			return String.format("Doctor: name=%20s | license number=%06d | %s", name, licenseNumber, getPatientsAsString());
		}
		
		@Override
		public boolean equals(Object obj) {
		   if (this == obj) return true;
		   if(obj==null||getClass()!=obj.getClass())return false;
		   Doctor doctor=(Doctor)obj;
		   return numberOfPatients==doctor.numberOfPatients&&name.equals(doctor.name);
		}
	
		
		@Override
		public int compareTo(Doctor otherDoctor) {
			return this.numberOfPatients-otherDoctor.numberOfPatients;
		}

		
		
		@Override
		public Patient[] getPatients() {
			return Arrays.copyOf(patients,numberOfPatients);
		}

		@Override
		public boolean isPatient(Patient patient) {
			 for (int i = 0; i < numberOfPatients; i++) {
		            if (patients[i].equals(patient)) {
		                return true;
		            }
		        }
		        return false;
	}

		@Override
		public String getPatientsAsString() {
			 String patientList = "patients= ";
			    for (int i = 0; i < numberOfPatients; i++) {
			        if (i > 0) {
			            patientList += ", ";
			        }
			        patientList += patients[i];
			    }
			    return patientList;
			}
}	
