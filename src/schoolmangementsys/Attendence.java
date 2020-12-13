package schoolmangementsys;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate; 

import java.util.Scanner;

public class Attendence {
	private Course course; //From the course we can get the schedule;
	private boolean present = false;
	private String date = null;
	private Student student;
	private Schedule schedule;
	private String [] days;
	
	
	
	//Mark the attendence of the student.
	public boolean markAttendence(Course course, Student student , boolean present) 
			throws java.text.ParseException {
		this.course = course;
		this.student = student;
		boolean check = false;
		
		//used to get the day
		schedule = course.getSchedule();
		this.days = schedule.getDays();
		
		//See if the course is taught as the same day as today
		for(int i = 0; i < days.length; i++) {
			if(getDay().toLowerCase().equals(days[i])) {
				check = true; break;
			}
		}
		
		if(check == false) {
			System.out.println("Sorry, Current day doesn't match with days "
					+ "you teach your so you've to enter date manually when"
					+ "you've taken your class. ");
			System.out.print("Enter Date (d-m-yyy): ");
			Scanner cin = new Scanner(System.in);
			String date = cin.nextLine();
			this.setDate(date, present);
			
		}else {
			this.date = getDate();
			this.present = present;
		}
		return false;
	}
	
	//Get the day 
	public static String getDay() {
		LocalDate currentDate = LocalDate.now();
		DayOfWeek dow = currentDate.getDayOfWeek();
		return dow.toString();
	}
	
	//Get te current date
	public static String getDate() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.toString();
	}
	
	
	public void setDate(String date , boolean present) throws java.text.ParseException {
		if(isValid(date)) {
			this.date = date;
			this.present = present;
		}else {
			System.out.println("Sorry date is not valid.");
		}
	}
	
	//Check if the date is valid.

	public static boolean isValid(final String date) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
		boolean valid = false;

	   try {
	            // Doesn't ceck for leap year
	            sdf.parse(date);
	            // This also ceck for leap year
	            sdf.setLenient(false);
	            valid = true;

	   } catch (ParseException e) {
	      System.out.println("Invalid Date");
	      valid = false;
	   }
	   	  return valid;
	}

	
	
	
	//Getter and Setters
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
