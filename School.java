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
	
	//list of all teachers
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private static int teacherCount = 0;
	
	//Admit the student (Student Pannel).
	
	public static void admitStudent(Student student) {
		students.add(student);
		studentCount++;
	}
	
	//add teacher
	public static void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		teacherCount++;
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
	
	//searching a course in the course array list
	public static Course searchForCourse(String course) {
		//course name can not be null or empty string
		Course courseName = null;
		if(course!=null && !course.equals("")) {
			for(Course c : courses) {
				if(c.getName().equalsIgnoreCase(course)) {
					courseName = c;
				}
			}
		}
		return courseName;
	}
	
	//searching a teacher in the course array list
		public static Teacher searchForTeacher(String teacherName) {
			//teacher name can not be null or empty string
			Teacher teacher = null;
			if(teacherName!=null && !teacherName.equals("")) {
				for(Teacher t : teachers) {
					if(t.getName().equalsIgnoreCase(teacherName)) {
						teacher = t;
					}
				}
			}
			return teacher;
		}
	
	public static int getStudentCount() {
		return studentCount;
	}
	

    //printing info about all students
    public static void printStudents() {
    	for(Student student : students) {
    		System.out.println(student.getInfo());
    	}
    }
    
    //printing info about all students
    public static void printTeachers() {
    	for(Teacher teacher : teachers) {
    		System.out.println(teacher.getInfo());
    	}
    }
    
    //printing all courses
    public static void printCourses() {
    	for(Course course : courses) {
    		System.out.println(course.getInfo());
    	}
    }
}

