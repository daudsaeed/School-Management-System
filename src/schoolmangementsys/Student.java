package schoolmangementsys;

public class Student {
	//>>For encapsulation we made (fields) private
	//>>Encapsulation = abstraction + Data Hiding.
	private String name;
	private Course []  courses = new Course[5];
	private int rollNumber;
	private int [] grades;
	private int coursesEnrolled = 0;

	//Parameterized Constructor
	Student(String name, int rollNumber){
		this.name = name;
		this.rollNumber = rollNumber;
	}
	
	//Parameterized Constructor with courses parameter;
	Student(String name , int rollNumber, Course[] courses){
		this(name, rollNumber);
		this.coursesEnrolled = courses.length;
		this.courses=courses;
	}
	
	
	
	/**
	 * Register students to a new course.
	 */
	public void addCourse(Course course) {
		if(course == null || courses.length ==0) {
			//Can replace with GUI
			System.out.println("Error: Course array is NULL");
		}else {
			if(coursesEnrolled < 5) {
				this.courses[this.coursesEnrolled] = course;
				this.coursesEnrolled++;
			}else {
				System.out.println("Error: A student only can take 5"
						+ "courses.");
			}
		}
	}
	
	//Get Student Info
	public String getStudentInfo() {
		String stdInfo = "Student Info \n";
		stdInfo += "Name: " + this.getName() + "\n";
		stdInfo += "Roll Number: " + this.getRollNumber() + "\n";
		
		//For courses array.
		for (int i = 0; i < this.coursesEnrolled; i++) {
			stdInfo+= "Course"+ (i+ 1) + ". "+ courses[i].getName() + "\n";
		}
		return stdInfo;
	}
	
	
	
	//Getter and setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	
	public int getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(int coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}
	private int semster;
	
	
	public int getSemster() {
		return semster;
	}

	public void setSemster(int semster) {
		this.semster = semster;
	}

	
	//1. Remove the course.
	//2. 
	
	
}
