package schoolmangementsys;
import java.util.ArrayList;

/**
 * Teacher Class
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
	
	
	
	//Get Teacher Info
	public String getTeacherInfo() {
		String teacherInfo = "Teacher Info: \n";
		teacherInfo+= "Teacher Name: " + this.getName() + "\n";
		teacherInfo+= "Teach: " + course.getName() + "\n";
		teacherInfo+= "Office hours: " + officeHours.toString() + "\n";
		
		return teacherInfo;
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
	
	//attendance will be marked and printed using course
	public void markAttendance() {
		course.markAttendance(this);
	}
	public void printAttendance() {
		course.printAttendance();
	}

 }
