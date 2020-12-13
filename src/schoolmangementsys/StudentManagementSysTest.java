package schoolmangementsys;

import java.text.ParseException;

public class StudentManagementSysTest
{
	public static void main(String[] args) throws ParseException {
		
		
		//Courses. 
		
		Course Math = new Course("Math", 3);
		//Creating instance of the schedule
		Schedule schedule = new Schedule(new String[] {"Monday" , "Wednesday"}, new int [] {9 , 11}, new int[] {2,2});
		Math.setSchedule(schedule);
		
		Course Pyhsics = new Course("Physics", 3);
		//Creating instance of the schedule
		schedule = new Schedule(new String[] {"Tuesday" , "Monday"}, new int [] {10 , 9}, new int[] {2,2});
		Pyhsics.setSchedule(schedule);
		
		Course Urdu = new Course("Urdu", 2);
		//Creating instance of the schedule
		schedule = new Schedule(new String[] {"Monday" , "Thirsday"}, new int [] {11 , 1}, new int[] {1, 2});
		Urdu.setSchedule(schedule);
		
		
		//Teachers.
		schedule = new Schedule(new String[] {"Monday" , "saturday"}, new int [] {10 , 20}, new int[] {2, 1});
		Teacher t1 = new Teacher("Zafar Iqbal", Pyhsics, schedule);
		Pyhsics.setTeacher(t1);
		schedule = new Schedule(new String[] {"Tuesday" , "Friday"}, new int [] {12 , 14}, new int[] {1, 1});
		Teacher t2 = new Teacher("Ali", Math, schedule);
		Math.setTeacher(t2);
		
		//Students
		Student s1 = new Student("Mahnoor", 0 , new Course[] {Math, Pyhsics});
		Student s2 = new Student("Fatima Shahzad", 1 , new Course[] {Urdu, Pyhsics});
		Student s3 = new Student("Alisbha Ehsan", 2 , new Course[] {Math, Urdu, Pyhsics});
		
		School.addCourse(Math);
		School.addCourse(Pyhsics);
		School.addCourse(Urdu);
		
		
		
		School.admitStudent(s1);
		School.admitStudent(s2);
		School.admitStudent(s3);
		
		
		//Print Student information.
		
		System.out.println(s1.getStudentInfo());
		System.out.println(s2.getStudentInfo());
		System.out.println(s3.getStudentInfo());
		
		
		//Print the Teacher info
		System.out.println(t1.getTeacherInfo());
		System.out.println(t2.getTeacherInfo());
		
		
		//print course Info
		System.out.println(Pyhsics.getCousrseInfo());
		System.out.println(Math.getCousrseInfo());
		System.out.println(Urdu.getCousrseInfo());
		
		Attendence a = new Attendence();
		a.markAttendence(Pyhsics, s1 , false);
		t1.setAttendence(a);
		Course c = a.getCourse();
		System.out.println("Name: " + c.getName() + "\nPresent: " + a.isPresent());
		Student sa1 = a.getStudent();
		System.out.println("Student Name: " + sa1.getName());
		
	}
	
}
