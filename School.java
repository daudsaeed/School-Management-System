package schoolmangementsys;
import java.util.ArrayList;

public class School {
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	
	
	//Name of the school
	private static String name = "Haziq and Fatima: Girls International school";
	private static String tagline = "Charity School";
	
	//List of all the students and their count
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static int studentCount = 0;
	
	//List of courses in school and their count
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static int courseCount = 0;
	
	
	
	//Admit the student (Student Pannel).
	
	public static void admitStudent(Student student) {
		students.add(student);
		studentCount++;
	}
	
	//Add courses ( Admin Pannel).
	public static void addCourse(Course course) {
		courses.add(course);
		courseCount++;
	}
	
	
	//Enroll course method 
	public static void enrollCourse(Student student, Course course) {
		
		if(student != null && course != null) {
			
			Course [] courses = student.getCourses();
			
			if(course != null && student.getCoursesEnrolled() < 5) { 
	
				student.addCourse(course);
				course.addStudent(student);
				
			}
				
				
		}else {
			System.out.println("Error: Student or course can't be NULL");
		}
	}
	
}


//File handling rati hn
// Java Swing rati hn


//Create a student metod.
//Manage Students
//Print student info (course ka lahaz sa)
//Staff management ( delete teacher , add teacher , assigning teacher to another course)

// Fee wala bana hn 
// Teacher salary





