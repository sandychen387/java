
	public class Student extends Person implements Comparable<Person> {
	    private static int numStudents = 0;
	    private int studentID;
	    private Course[] coursesTaken;
	    private int numCoursesTaken;
	    private boolean isGraduate;
	    private String major;

	    public Student() {
	        super();
	        this.studentID = generateStudentID();
	        this.coursesTaken = new Course[50];
	        this.numCoursesTaken = 0;
	        this.isGraduate = false;
	        this.major = "undeclared";
	    }

	    
	    public Student(boolean isGraduate) {
	        super(); 
	        this.studentID = generateStudentID();
	        this.coursesTaken = new Course[50];
	        this.numCoursesTaken = 0;
	        this.isGraduate = isGraduate;
	        this.major = "undeclared";
	    }

	  
	    public Student(String major, boolean isGraduate) {
	        super(); 
	        this.studentID = generateStudentID();
	        this.coursesTaken = new Course[50];
	        this.numCoursesTaken = 0;
	        this.isGraduate = isGraduate;
	        this.major = major;
	    }

	    public Student(String name, int birthYear, String major, boolean isGraduate) {
	        super(name, birthYear); 
	        this.studentID = generateStudentID();
	        this.coursesTaken = new Course[50];
	        this.numCoursesTaken = 0;
	        this.isGraduate = isGraduate;
	        this.major = major;
	    }

	   
	    public boolean isGraduate() {
	        if(isGraduate) {
	        	return true;
	        }
	        else {
	        	return false;
	        }
	    }

	    public int getNumCoursesTaken() {
	        return numCoursesTaken;
	    }

	    public static int getNumStudents() {
	        return numStudents;
	    }

	    public int getStudentID() {
	        return studentID;
	    }

	    public String getMajor() {
	        return major;
	    }

	    public void setIsGraduate(boolean isGraduate) {
	        this.isGraduate = isGraduate;
	    }

	    public void setMajor(String major) {
	        this.major = major;
	    }

	    public void addCourseTaken(Course course) {
	        if (numCoursesTaken < 50) {
	            coursesTaken[numCoursesTaken] = course;
	            numCoursesTaken++;
	        }
	    }

	 
	    public void addCoursesTaken(Course[] courses) {
	        for (int i = 0; i < courses.length; i++) {
	            Course course = courses[i];
	            if (numCoursesTaken < 50 && course != null) {
	            	coursesTaken[numCoursesTaken] = course;
	                numCoursesTaken++;
	            }
	        }
	    }

	    public Course getCourseTaken(int index) {
	        if (index >= 0 && index < numCoursesTaken) {
	            return coursesTaken[index];
	        }
	        return null;
	    }

	   
	    public String getCourseTakenAsString(int index) {
	        Course course = getCourseTaken(index);
	        if (course != null) {
	            return course.getCourseDept() + "-" + course.getCourseNum();
	        }
	        return "";
	    }

	   
	    public String getAllCoursesTakenAsString() {
	        String result = "";
	        for (int i = 0; i < numCoursesTaken; i++) {
	            String courseString = getCourseTakenAsString(i);
	            if (!courseString.isEmpty()) {
	                result += courseString;
	                if (i < numCoursesTaken - 1) {
	                    result += ", ";
	                }
	            }
	        }
	        return result;
	    }


	  
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	        	return false;
	        }
	        if(obj instanceof Student) {
	        	Student otherStudent = (Student) obj;
	        	if(super.equals(obj)) {
	        		if(this.numCoursesTaken == otherStudent.numCoursesTaken) {
	        			if(this.isGraduate == otherStudent.isGraduate) {
	        				if(this.major.equals(otherStudent.major)) {
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
	        return super.toString() + String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
	                studentID, major, isGraduate ? "Graduate" : "Undergraduate", numCoursesTaken, getAllCoursesTakenAsString());
	    }

	   
	    @Override
	    public int compareTo(Person otherPerson) {
	        if (otherPerson instanceof Student) {
	            Student otherStudent = (Student) otherPerson;
	            return this.numCoursesTaken - otherStudent.numCoursesTaken;
	        }
	        return super.compareTo(otherPerson); 
	    }

	   
	    private int generateStudentID() {
	        numStudents++;
	        return numStudents;
	    }
	}
