

	public class Course implements Comparable<Course> {
	    private boolean isGraduateCourse;
	    private int courseNum;
	    private String courseDept;
	    private int numCredits;

	   
	    public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
	        this.isGraduateCourse = isGraduateCourse;
	        this.courseNum = courseNum;
	        this.courseDept = courseDept;
	        this.numCredits = numCredits;
	    }

	   
	    public boolean isGraduateCourse() {
	        return isGraduateCourse;
	    }

	    public int getCourseNum() {
	        return courseNum;
	    }

	    public String getCourseDept() {
	        return courseDept;
	    }

	    public int getNumCredits() {
	        return numCredits;
	    }
	    public String getIsGraduateCourse() {
	    	String grad = "";
	    	if(isGraduateCourse) {
	    		grad ="G";
	    	}
	    	else {
	    		grad = "U";
	    	}
	    	return grad;
	    }
	
	    public String getCourseName() {
	        String courseType = getIsGraduateCourse();
	        return courseType + "CMP168";
	    }

	   
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) { 
	            return false;
	        }
	        if(obj instanceof Course) {
	        	Course otherCourse = (Course) obj;
	        	if(this.isGraduateCourse == otherCourse.isGraduateCourse) {
	        		if(this.courseNum == otherCourse.courseNum) {
	        			if(this.numCredits == otherCourse.numCredits) {
	        				if(this.courseDept.equals(otherCourse.courseDept)) {
	        					return true;
	        				}
	        			}
	        		}
	        	}
	        }
	        return false;
	    }

	   
	    @Override
	    public String toString() {
	        return String.format("Course: %s-%d | Number of Credits: %02d | %s",
	                courseDept, courseNum, numCredits, isGraduateCourse ? "Graduate" : "Undergraduate");
	    }

	   
	    @Override
	    public int compareTo(Course otherCourse) {
	        return this.courseNum - otherCourse.courseNum;
	    }
	}


