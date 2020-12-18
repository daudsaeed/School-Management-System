package schoolmangementsys;
import java.util.ArrayList;
import java.util.Scanner;


public class Course extends Attendance{
	
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	private String name;
	private int creditHours;
	private Schedule schedule;
	private ArrayList <Student> students = new ArrayList<Student>(); //teacher // Courses
	//Changing Teacher to ArrayList.
	private ArrayList <Teacher> teachers = new ArrayList<Teacher>();
	//complete record of subject's attendance
	private ArrayList<Attendance> attendance = new ArrayList<Attendance>();
	private int index = 0;
	private Scanner input = new Scanner(System.in);
	
	//no argument Constructor
	Course(){
	}
	
	
	//Parameterized Constructor
	Course(String name, int creditHours) {
		//This keyword here is used to distinguish between 
		//instance variable and the local variable :)
		this.name = name;
		this.creditHours = creditHours;
		//It is not necessary that course has a schedule right now 
		// or maybe the schedule is not created yet for the course (logically speaking)
	}
	
	
	
	//Parameterized constructor with schedule
	Course(String name, int creditHours, Schedule schedule){
		//Using to this keyword to invoke constructor
		this(name, creditHours);
		this.schedule = schedule;
	}


	
	//return the course info
	public String getInfo() {
		String courseInfo = "Course Info: \n";
		courseInfo+= "Course Name: " + this.getName() + "\n";
		courseInfo+= "Credit Hours: " + this.getCreditHours() + "\n";
		if(this.schedule != null) {
			courseInfo+= "Schedule: " + this.schedule.toString();
		}

		//Added the for each loop
		for (Teacher teacher: teachers){
			if(teacher != null) {
				courseInfo+= "Teacher Name: " + teacher.getName() + "\n";
			}
		}
		
		return courseInfo;
		
	}
	
	//Add student method
	public void addStudent(Student student) {
			students.add(student);	
	}
	
	//Add teacher method
	public void addTeacher(Teacher teacher) {
		if(teacher==null) {
			System.out.println("teacher is null");
		}
		else {
			teachers.add(teacher);
		}
	}
	
	//adding attendance
	private void addAttendance(Teacher teacher) {
		if(teacher==null) {
			System.out.println("null hai yeh");
		}
		attendance.add(index , new Attendance(teacher,this));
	}
	
	//teacher will mark attendance through course
	//we'll check if a student tries to access it then an error would be generated
	//o is the person who called this method
	public void markAttendance(Teacher t) {
		addAttendance(t);
		attendance.get(index).markAttendance();
		index++;
	}

	//printing attendance for course/teacher
	public void printAttendance() {
		System.out.println("Course : "+name);
		for (Attendance value : attendance) {
			System.out.println("\nTeacher : "+value.getTeacher().getName());
			System.out.println("\nDate : " + value.getDate());
			System.out.println(value);
		}
	}
	
	//create course method
	public Object create() {
		System.out.print("Enter course name: ");
		this.name = input.nextLine();
		System.out.print("Enter credit hours: ");
		this.creditHours = input.nextInt();
		//discard \n
		input.nextLine();
		System.out.print("Is schedule created? (Y or N)");
		char created = input.nextLine().charAt(0);
		if(created=='N'||created=='n') {
			Schedule newSchedule = new Schedule();
			setSchedule((Schedule)newSchedule.create());
		}
		//we will search for teacher in school
		Teacher tCourse = School.searchForTeacher("");
		if(tCourse==null) {
			System.out.println("teacher not found");
		}
		return this;
	}
	
	//Getter and Setter for Name.
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	//getter and setter for credit hours.

	public int getCreditHours() {
		return creditHours;
	}



	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	//Getter and setter for schedule.

	public Schedule getSchedule() {
		return schedule;
	}



	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	//Getter and setter for students array
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList <Student> students) {
		for(Student student:students) {
	         this.students.add(student);
	      }
	}

	//Getter and Setter for Teacher.
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	//getter for attendance
	public ArrayList<Attendance> getAttendance() {
		return attendance;
	}
}