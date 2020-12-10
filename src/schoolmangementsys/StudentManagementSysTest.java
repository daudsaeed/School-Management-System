package schoolmangementsys;

public class StudentManagementSysTest
{
	public static void main(String[] args) {
		
		
		//Courses. 
		
		Course Math = new Course("Math", 3);
		//Creating instance of the schedule
		Schedule schedule = new Schedule(new String[] {"Monday" , "Wednesday"}, new int [] {9 , 11}, new int[] {2,2});
		Math.setSchedule(schedule);
		
		Course Pyhsics = new Course("Physics", 3);
		//Creating instance of the schedule
		schedule = new Schedule(new String[] {"Tuesday" , "Wednesday"}, new int [] {10 , 9}, new int[] {2,2});
		Math.setSchedule(schedule);
		
		Course Urdu = new Course("Urdu", 2);
		//Creating instance of the schedule
		schedule = new Schedule(new String[] {"Monday" , "Thirsday"}, new int [] {11 , 1}, new int[] {1, 2});
		Math.setSchedule(schedule);
		
		
		//Teachers.
		schedule = new Schedule(new String[] {"Monday" , "Friday"}, new int [] {10 , 20}, new int[] {2, 1});
		Teacher t1 = new Teacher("Zafar Iqbal", Pyhsics, schedule);
		
		schedule = new Schedule(new String[] {"Tuesday" , "Friday"}, new int [] {12 , 14}, new int[] {1, 1});
		Teacher t2 = new Teacher("Ali", Math, schedule);
		
		//Students
		Student s1 = new Student("Dawood", 0 , new Course[] {Math, Pyhsics});
		Student s2 = new Student("Shoaib", 1 , new Course[] {Urdu, Pyhsics});
		Student s3 = new Student("Umair", 2 , new Course[] {Math, Urdu, Pyhsics});
		
		School.addCourse(Math);
		School.addCourse(Pyhsics);
		School.addCourse(Urdu);
		//Print Student information.
		
		
		School.admitStudent(s1);
		School.admitStudent(s2);
		School.admitStudent(s3);
		
		
		//Print Student information.
		
		System.out.println(s1.getStudentInfo());
		System.out.println(s2.getStudentInfo());
		System.out.println(s3.getStudentInfo());
		
		
		
		
		
		
		
		
		
	}
	
}
