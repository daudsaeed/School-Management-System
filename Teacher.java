package schoolmangementsys;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Teacher Class
 */
public class Teacher extends Person implements Management{
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	private Course course;
	private Schedule officeHours;
	private Scanner input = new Scanner(System.in);
	
	//no arg constructor
	Teacher(){
		course = null;
		officeHours = null;
	}
	
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
	
	
	@Override
	//Get Teacher Info
	public String getInfo() {
		String teacherInfo = "Teacher Info: \n";
		teacherInfo+= super.toString()+"\nTeacher Name: " + this.getName() + "\n";
		if(course!=null) {
			teacherInfo+= "Course: " + course.getName() + "\n";
		}
		teacherInfo+= "Office hours: " + officeHours.toString() + "\n";
		return teacherInfo;
	}
	
	//creating teacher ==> incomplete
	@Override
	public Object create(){
		super.create();
		System.out.print("Enter course name: ");
		String courseName = input.nextLine();
		Course tCourse = School.searchForCourse(courseName);
		Schedule schedule = new Schedule();
		setOfficeHours((Schedule)schedule.create());
		setCourse(tCourse);
		if(tCourse==null) {
			System.out.println("course not found");
		}
		else {
			//i am assigning the teacher to course
			tCourse.setTeacher(this);
		}
		return this;
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
