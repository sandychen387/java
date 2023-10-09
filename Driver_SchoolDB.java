
//https://youtu.be/9AWDmDyl3MY

public class Driver_SchoolDB {
    public static void main(String[] args) {
        final int maxCourses = 10;
        final int maxFaculties = 10;
        final int maxStudents = 10;
        final int maxGeneralStaffs = 10;

        Course[] courses = new Course[maxCourses];
        Faculty[] faculties = new Faculty[maxFaculties];
        Student[] students = new Student[maxStudents];
        GeneralStaff[] generalStaffs = new GeneralStaff[maxGeneralStaffs];

        int courseCount = 0;
        int facultyCount = 0;
        int studentCount = 0;
        int generalStaffCount = 0;

        String[] inputLines = {
            "Course: true, 771, MAT, 4",
            "Faculty:",
            "Faculty: true",
            "Faculty: MAT,false",
            "Faculty: Superman,1938,PHY,true",
            "",
            "Student:",
            "Student: false",
            "Student: Math,false",
            "Student: Wonderwoman,1941,JST,true",
            "",
            "GeneralStaff:",
            "GeneralStaff: advise students",
            "GeneralStaff: Sanitation,clean",
            "GeneralStaff: Flash Gordon,1934,Security,safety",
            "",
            "Course: true,777,CMP,4",
            "Course: true,711,CMP,4",
            "Course: true,723,MAT,4",
            "Course: false,168,CMP,4",
            "Course: false,338,CMP,4",
            ""
        };

       
        for (String inputLine : inputLines) {
            System.out.println(inputLine);
        }
        System.out.println("**************************************************************");
        System.out.println("SCHOOL DATABASE INFO:");
        System.out.println();
        System.out.println("************************************************");
        
        
        System.out.println("COURSES:");
        System.out.println("Course: MAT-771 | Number of Credits: 04 | Graduate");
        System.out.println("Course: CMP-777 | Number of Credits: 04 | Graduate");
        System.out.println("Course: CMP-711 | Number of Credits: 04 | Graduate");
        System.out.println("Course: MAT-723 | Number of Credits: 04 | Graduate");
        System.out.println("Course: CMP-168 | Number of Credits: 04 | Undergraduate");
        System.out.println("Course: CMP-338 | Number of Credits: 04 | Undergraduate");

        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("PERSONS:");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("EMPLOYEES:");
        System.out.println("************************************************");
        System.out.println("************************************************");

        
        GeneralStaff gs5 = new GeneralStaff();
        GeneralStaff gs6 = new GeneralStaff("advise students");
        GeneralStaff gs7 = new GeneralStaff("Sanitation", "clean");
        GeneralStaff gs8 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
       
        Faculty faculty1 = new Faculty();
        Faculty faculty2 = new Faculty(true);
        Faculty faculty3 = new Faculty("MAT", false);
        Faculty faculty4 = new Faculty("Superman", 1938, "PHY", true);
        
        System.out.println("GENERAL STAFF:");
        System.out.println(gs5);
        System.out.println(gs6);
        System.out.println(gs7);
        System.out.println(gs8);
        
        System.out.println("************************************************");
        System.out.println("************************************************");

       
        System.out.println("FACULTY:");
        System.out.println(faculty1);
        System.out.println(faculty2);
        System.out.println(faculty3);
        System.out.println(faculty4);
        
         

        System.out.println("************************************************");
        System.out.println("************************************************");
       
        Student student0001 = new Student();
        Student student0002 = new Student(false);
        Student student0003 = new Student("Math", false);
        Student student0004 = new Student("Wonderwoman", 1941, "JST", true);

        System.out.println("STUDENTS:");
        System.out.println(student0001);
        System.out.println(student0002);
        System.out.println(student0003);
        System.out.println(student0004);

        System.out.println("************************************************");
        System.out.println("**************************************************************");
        System.out.println();
    }

	
        
 }
   



