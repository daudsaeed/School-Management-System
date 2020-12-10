package schoolmangementsys;
import java.util.ArrayList;



public class Course {
	
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	private String name;
	private int creditHours;
	private Schedule schedule;
//	private Student [] students;
	private ArrayList <Student> students = new ArrayList<Student>();
	private Teacher teacher;
	
	//Empty Constructor
//	Course(){}
	
	
	//Parameterized Constructor
	Course(String name, int creditHours) {
		//This keyword here is used to distinguis between 
		//instance variable and the local variable :)
		this.name = name;
		this.creditHours = creditHours;
		//It is not neccasry that course has a schedule right now 
		// or maybe the schedule is not created yet for the course (logicial speaking)
	}
	
	
	
	//Parameterized constructor with schedule
	Course(String name, int creditHours, Schedule schedule){
		//Using to this keyword to invoke constrctor
		this(name, creditHours);
		this.schedule = schedule;
	}


	
	//Getter and Setter Methods.
	
	
	
	
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

	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
	
	//Add student method
	public void addStudent(Student student) {
		
		students.add(student);
		
	}
	
	
	
	
}
