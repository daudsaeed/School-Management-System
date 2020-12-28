package schoolmangementsys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person implements Management, Serializable{
	private static final long serialVersionUID = 1L;
	//>>For encapsulation we made (fields) private
	//>>Encapsulation = abstraction + Data Hiding.
	private Course []  courses = new Course[5];
	private int rollNumber = 0;
	private int [] grades;
	private int coursesEnrolled = 0;
	private Teacher[] teachers = new Teacher[5];
	private int teachersAssigned = 0;
	private int paidFee;
	private static int semesterFee;
	private static int totalFee; //total fee student has paid up till now
	private transient Scanner input = new Scanner(System.in);
	
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

	//adding another constructor with teachers
	Student(String name , int rollNumber, Course[] courses, Teacher[] teachers){
		this(name, rollNumber);
		this.coursesEnrolled = courses.length;
		this.courses=courses;
		this.teachers = teachers;
	}
	
	public Student() {

	}


	/**
	 * Register students to a new course.
	 */
	public void addCourse(Course course) {
		if(course == null || courses.length ==0) {
			System.out.println("Error: Course array is NULL");
		} else {
			if(coursesEnrolled < 5) {
				this.courses[this.coursesEnrolled] = course;
				this.coursesEnrolled++;
			} else {
				System.out.println("Error: A student only can take 5"
						+ "courses.");
			}
		}
	}

	//adding teacher
	public void addTeacher(Teacher teacher) {
		if(teacher == null || teachers.length ==0) {
			System.out.println("Error: Course array is NULL");
		}else {
			if(teachersAssigned < 5) {
				this.teachers[this.teachersAssigned] = teacher;
				this.teachersAssigned++;
			}else {
				System.out.println("Error: A student only be assigned 5 teachers");
			}
		}
	}
	
	@Override
	//Get Student Info
	public String getInfo() {
		String stdInfo = "Student Info \n";
		stdInfo += super.toString();
		stdInfo += "\nRoll Number: " + this.getRollNumber() + "\n";

		//For courses array.
		for (int i = 0; i < this.coursesEnrolled; i++) {
			stdInfo+= "Course"+ (i+ 1) + ". "+ courses[i].getName() + "\n";
		}
		//adding fee info at 6:51 pm 17/12/2020
		stdInfo+= "Total fee: " + totalFee+"\n";
		stdInfo+= "Paid fee: " + paidFee+"\n";
		stdInfo+= "Due fee: " + dueFee()+"\n";
		return stdInfo;
	}

	//student will view attendance according to subject
	public void printAttendance(Course course) {
		//checking if course is registered for student or not
		boolean present = false;
		for(int i=0; i<coursesEnrolled; i++) {
			if(courses[i].getName().equals(course.getName())) {
				present = true;
				break;
			}
		}
		//printing if present
		if(!present) {
			System.out.println("Course "+course.getName()+" is not registered for student "+name);
			return;
		}
		System.out.println("Student : " + name);
		System.out.println("Course : "+course.getName());
		//printing teacher's name
		//iterating teachers array and finding student's teacher's name
		ArrayList<Teacher> teachers = course.getTeachers();
		for(int i=0; i<teachersAssigned; i++) {
			for(int j=0; j<teachers.size(); j++) {
				if (this.teachers[i].getName().equalsIgnoreCase(teachers.get(j).getName())) {
					System.out.println("Teacher: "+ this.teachers[i].getName());
				}
			}
		}
		//getting attendance list
		ArrayList<Attendance> attendance = new ArrayList<Attendance>();
		for(Attendance a : course.getAttendance()) {
			attendance.add(a);
		}
		for(int i = 0; i<attendance.size(); i++) {
			for(int j = 0 ; j<course.getStudents().size(); j++) {
				if(course.getStudents().get(j).getName().equals(name)) {
					System.out.print("Date : " + attendance.get(i).getDate()+" : ");
					System.out.println(attendance.get(i).getAttendanceList().get(j)?"Present":"Absent");
				}
			}
		}
		System.out.println();
	}

	//Added at 15/12/2020 12:12 am after the attendance and person commit
	//Overriding concept abstract to non-abstract (Overriding)
	@Override
	public Object create(){
		super.create();
		int rollNumber = (School.getStudentCount()) + 1;
		setRollNumber(rollNumber);
		System.out.print("Enter total fee for student " + this.name +": ");
		totalFee = input.nextInt();
		//discard \n
		input.nextLine();
		System.out.print("Set semster fee for student "+this.name +": ");
		semesterFee = input.nextInt();
		//discard \n
		input.nextLine();
		return this;
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

	public Teacher[] getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}

	public int getTeachersAssigned() {
		return teachersAssigned;
	}

	public void setTeachersAssigned(int teachersAssigned) {
		this.teachersAssigned = teachersAssigned;
	}
	
	//managing fee
	public int getPaidFee() {
		return paidFee;
	}

	public void setPaidFee(int fee) {
		this.paidFee = fee;
	}
	
	public void payFee(int fee) {
		paidFee += fee;
		School.addNetWorth(fee);
		System.out.println("Fee paid");
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int fee) {
		totalFee = fee;
	}
	//due fee
	public int dueFee() {
		return totalFee - paidFee;
	}

	public int getSemesterFee() {
		return semesterFee;
	}

	public void setSemesterFee(int fee) {
		semesterFee = fee;
	}
}
