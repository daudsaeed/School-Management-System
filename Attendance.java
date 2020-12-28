package schoolmangementsys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Attendance implements Serializable{
	private static final long serialVersionUID = 1L;
	// we will generate attendance list for a course taught by a teacher and it will be marked for all students
	private Teacher teacher;
	private Date date;
	private ArrayList<Boolean> attendanceList = new ArrayList<Boolean>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private Course courseTitle;
	private transient Scanner input = new Scanner(System.in);

	// no arg constructor for course
	Attendance() {
	}

	// parameterized constructor to assign values to data fields
	Attendance(Teacher teacher, Course courseTitle) {
		this.teacher = teacher;
		for (Student student : teacher.getStudents()) {
			students.add(student);
		}
		this.courseTitle = courseTitle;
		date = new Date();
	}

	// mark attendance method to be used by teacher via course
	protected void markAttendance() {
		// checking teacher and course name
		if (teacher.getCourse().getName().equals(courseTitle.getName())) {
			// attendance will be marked
			// display name of student and teacher marks present or absent
			System.out.println("Dear " + teacher.getName() + " mark attendence for subject " + courseTitle.getName()
					+ " for date " + date);
			// in case of neither a nor p i'm marking p
			for (int i = 0; i < students.size(); i++) {
				System.out.println("Student name : " + students.get(i).getName());
				System.out.println("Enter attendence : ");
				char status = input.next().charAt(0);
				if (status == 'p' || status == 'P') {
					attendanceList.add(i, true);
				} else if (status == 'a' || status == 'A') {
					attendanceList.add(i, false);
				} else {
					attendanceList.add(i, true);
				}
			}
		} else {
			System.out.println("Course and Teacher name do not match");
		}
	}

	// date for current attendance record
	public Date getDate() {
		return date;
	}

	// to be used in course and teacher
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < attendanceList.size(); i++) {
			str += students.get(i).getName() + " : " + (attendanceList.get(i) ? "Present" : "Absent") + "\n";
		}
		return str;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public ArrayList<Boolean> getAttendanceList() {
		return attendanceList;
	}

}
