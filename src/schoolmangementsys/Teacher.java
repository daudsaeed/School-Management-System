package schoolmangementsys;
import java.util.ArrayList;



/**
 * Teach can teach a single course and manages a default schedule.
 * Teacher Name: Bucky Roberts
 * Course  Name: Visual Basic.
 * Office  Hour: Monday 10 2h , Friday 20 1h 
 */
public class Teacher {
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	private String name;
	private Course course;
	private Schedule officeHours;
	
	
	//Parameterized Constructor;
	Teacher(String name, Course course, Schedule officeHours){
		this.name = name;
		this.course = course;
		this.officeHours = officeHours;
	}
	
	//Get All the students  by the teacher.
	public ArrayList <Student> getStudents() {
		ArrayList <Student> students = new ArrayList<Student>();
		if(course != null) {
			for(Student student: course.getStudents()) {
				students.add(student);
			}
		}
		return students;
		
	}
	
	//Getter and Setter.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Schedule getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(Schedule officeHours) {
		this.officeHours = officeHours;
	}
	
	
	
 }
