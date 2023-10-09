
public class Faculty extends Employee {
	    private Course[] coursesTaught;
	    private int numCoursesTaught;
	    private boolean isTenured;

	   
	    public Faculty() {
	        super();
	        this.coursesTaught = new Course[100];
	        this.numCoursesTaught = 0;
	        this.isTenured = false;
	    }

	    
	    public Faculty(boolean isTenured) {
	        super(); 
	        this.coursesTaught = new Course[100];
	        this.numCoursesTaught = 0;
	        this.isTenured = isTenured;
	    }

	   
	    public Faculty(String deptName, boolean isTenured) {
	        super(deptName); 
	        this.coursesTaught = new Course[100];
	        this.numCoursesTaught = 0;
	        this.isTenured = isTenured;
	    }

	   
	    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
	        super(name, birthYear, deptName); 
	        this.coursesTaught = new Course[100];
	        this.numCoursesTaught = 0;
	        this.isTenured = isTenured;
	    }

	   
	    public boolean isTenured() {
	        return isTenured;
	    }

	    public int getNumCoursesTaught() {
	        return numCoursesTaught;
	    }

	   
	    public void setIsTenured(boolean isTenured) {
	        this.isTenured = isTenured;
	    }

	    
	    public void addCourseTaught(Course course) {
	        if (numCoursesTaught < 100) {
	            coursesTaught[numCoursesTaught] = course;
	            numCoursesTaught++;
	        }
	    }

	  
	    public void addCoursesTaught(Course[] courses) {
	        for (int i = 0; i < courses.length; i++) {
	            Course course = courses[i];
	            if (numCoursesTaught < 100 && course != null) {
	                coursesTaught[numCoursesTaught] = course;
	                numCoursesTaught++;
	            }
	        }
	    }


	   
	    public Course getCourseTaught(int index) {
	        if (index >= 0 && index < numCoursesTaught) {
	            return coursesTaught[index];
	        }
	        return null;
	    }

	  
	    public String getCourseTaughtAsString(int index) {
	        Course course = getCourseTaught(index);
	        if (course != null) {
	            return course.getCourseDept() + "-" + course.getCourseNum();
	        }
	        return "";
	    }

	    
	    
	    public String getAllCoursesTaughtAsString() {
	    	String result = "";
	    	for(int index = 0; index < numCoursesTaught; index++) {
	    		result += coursesTaught[index].toString();
	    	}
	    	return result;
	    }
	    
	    public String getIsTenured() {
	    	String tenure = "";
	    	if(isTenured) {
	    		tenure = "Is Tenured";
	    	}
	    	else {
	    		tenure = "Not Tenured";
	    	}
	    	return tenure;
	    }
	    
	   
	   
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if(obj instanceof Faculty) {
	        	Faculty otherFaculty = (Faculty) obj;
	        	if(super.equals(obj)) {
	        		if(this.numCoursesTaught == otherFaculty.numCoursesTaught) {
	        			if(this.isTenured == otherFaculty.isTenured) {
	        				return true;
	        			}
	        		}
	        	}
	        }
	        return false;
	    }

	    
	    @Override
	    public String toString() {
	    	return String.format("Person: Name: %30s | Birth Year: %4d Employee: Department: %20s | Employee Number: %3d Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
	                getName(), getBirthYear(), getDeptName(), getEmployeeID(), (isTenured ? "Is Tenured" : "Not Tenured"), numCoursesTaught, getAllCoursesTaughtAsString());
	    }

	    
	    @Override
	    public int compareTo(Person otherPerson) {
	        if (otherPerson instanceof Faculty) {
	            Faculty otherFaculty = (Faculty) otherPerson;
	            return this.numCoursesTaught - otherFaculty.numCoursesTaught;
	        }
	        return super.compareTo(otherPerson); 
	    }
	}
