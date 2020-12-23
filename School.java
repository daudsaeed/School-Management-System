package schoolmangementsys;
import java.util.ArrayList;

public class School implements Management{
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	
	
	//Name of the school
	private static String name = "Haziq and Fatima: Girls International school";
	private static String tagline = "Every Student Matters , Every Moment Counts"; //a brilliant tag line by our group leader dawood:)
	
	//List of all the students and their count
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static int studentCount;
	

	//List of courses in school and their count
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static int courseCount;
	
	//list of all teachers
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private static int teacherCount;
	
	//net worth and total salary paid to teachers
	private static int netWorth = 1000000; //initial net worth of school
	private static int totalSalarayPaid;
	private static int totalFeeReceived;

	//getting info
	@Override
	public String getInfo() {
		String info = "";
		info+= name+"\n"+tagline+"\n";
		info+="Courses: \n";
		int i = 1;
		for(Course course : courses) {
			info+=i+". "+course.getName()+"\n";
			i++;
		}
		info+= "Number of teachers: "+teacherCount+"\n";
		info+= "Number of students: "+studentCount+"\n";
		info+="Net Worth: "+netWorth+"\n";
		return info;
	}
	
	//Admit the student (Student Panel).
	
	public static void admitStudent(Student student) {
		students.add(student);
		studentCount++;
	}
	
	//add teacher
	public static void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		teacherCount++;
	}
	
	//Add courses ( Admin Panel).
	public static void addCourse(Course course) {
		courses.add(course);
		courseCount++;
	}
	
	//remove student
	public static void removeStudent(Student student) {
		students.remove(student);
		studentCount--;
	}
	
	//remove teacher
	public static void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
		teacherCount--;
	}
	
	//remove course
	public static void removeCourse(Course course) {
		courses.remove(course);
		courseCount--;
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
	
	//assign teacher to student 
		public static void assignTeacher(Student student, Teacher teacher) {
			
			if(student != null && teacher != null) {
				
				Teacher [] teachers = student.getTeachers();
				
				if(teacher != null && student.getTeachersAssigned() < 5) { 
		
					student.addTeacher(teacher);
					teacher.addStudent(student);
					
				}
					
					
			}else {
				System.out.println("Error: Student or teacher can't be NULL");
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

	//searching a student in the course array list
		public static Student searchForStudent(String studentName) {
			//teacher name can not be null or empty string
			Student student = null;
			if(studentName!=null && !studentName.equals("")) {
				for(Student s : students) {
					if(s.getName().equalsIgnoreCase(studentName)) {
						student = s;
					}
				}
			}
			return student;
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
    
    //getter method
    public static int getNetWorth() {
    	return netWorth;
    }
    
    //updating net worth ==> increasing if fee is received & decreasing if salary is paid
    public static void addNetWorth(int amount) {
    	totalFeeReceived += amount;
    	netWorth += amount;
    }
    public static void subtractNetWorth(int amount) {
    	totalSalarayPaid += amount;
    	netWorth -= amount;
    }
    
    //only getters because we won't set these :)
    public static String getName() {
		return name;
	}

	public static String getTagline() {
		return tagline;
	}
}

