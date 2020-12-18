//package schoolmangementsys;
//
//public class StudentManagementSysTest
//{
//	public static void main(String[] args) {
//		
//		
//		//Courses. 
//		
//		Course Math = new Course("Math", 3);
//		//Creating instance of the schedule
//		Schedule schedule = new Schedule(new String[] {"Monday" , "Wednesday"}, new int [] {9 , 11}, new int[] {2,2});
//		Math.setSchedule(schedule);
//		
//		Course Pyhsics = new Course("Physics", 3);
//		//Creating instance of the schedule
//		schedule = new Schedule(new String[] {"Tuesday" , "Wednesday"}, new int [] {10 , 9}, new int[] {2,2});
//		Pyhsics.setSchedule(schedule);
//		
//		Course Urdu = new Course("Urdu", 2);
//		//Creating instance of the schedule
//		schedule = new Schedule(new String[] {"Monday" , "Thirsday"}, new int [] {11 , 1}, new int[] {1, 2});
//		Urdu.setSchedule(schedule);
//		
//		
//		//Teachers.
//		schedule = new Schedule(new String[] {"Monday" , "Friday"}, new int [] {10 , 20}, new int[] {2, 1});
//	//	Teacher t1 = new Teacher("Zafar Iqbal", Pyhsics, schedule);
//	//	Pyhsics.addTeacher(t1);
//		schedule = new Schedule(new String[] {"Tuesday" , "Friday"}, new int [] {12 , 14}, new int[] {1, 1});
//		//Teacher t2 = new Teacher("Ali", Math, schedule);
//		//Math.addTeacher(t2);
//		
//		//Students
//		Student s1 = new Student("Mahnoor", 0 , new Course[] {Math, Pyhsics});
//		Student s2 = new Student("Fatima Shahzad", 1 , new Course[] {Urdu, Pyhsics});
//		Student s3 = new Student("Alisbha Ehsan", 2 , new Course[] {Math, Urdu, Pyhsics});
//		
//		//courses ki student wali list had no students so I added this
//		Pyhsics.addStudent(s1); Pyhsics.addStudent(s2); Pyhsics.addStudent(s3);
//		Math.addStudent(s1); Math.addStudent(s3);
//		Urdu.addStudent(s2); Urdu.addStudent(s3);
//		
//		School.addCourse(Math);
//		School.addCourse(Pyhsics);
//		School.addCourse(Urdu);
//		
//		
//		
//		School.admitStudent(s1);
//		School.admitStudent(s2);
//		School.admitStudent(s3);
//		
//		//Print Student information.
//		
//		System.out.println(s1.getInfo());
//		System.out.println(s2.getInfo());
//		System.out.println(s3.getInfo());
//		
//		
//		//Print the Teacher info
//	//	System.out.println(t1.getInfo());
//	//	System.out.println(t2.getInfo());
//		
//		
//		//print course Info
//		System.out.println(Pyhsics.getInfo());
//		System.out.println(Math.getInfo());
//		System.out.println(Urdu.getInfo());
//		
//		//Testing attendance for 3 days
//		//here is the error ==> teacher has no students ==> removed :)
//	//	Pyhsics.markAttendance(t1);
//		//Pyhsics.markAttendance(t1);
//		//Pyhsics.markAttendance(t1);
//		Pyhsics.printAttendance();
//
//		s1.printAttendance(Pyhsics);
//		s2.printAttendance(Pyhsics);
//		s3.printAttendance(Pyhsics);
//	}
//	
//}
