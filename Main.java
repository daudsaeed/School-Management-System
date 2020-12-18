package schoolmangementsys;
import java.util.Scanner;

public class Main {

    //Display Options
    public static int displayOption(){
        int option = 0;
        System.out.println("\nEnter your command");
        System.out.println("1. To add a student");
        System.out.println("2. To add a course");
        System.out.println("3. To add a teacher");
        System.out.println("4. To print list of students");
        System.out.println("5. To print list of courses");
        System.out.println("6. To print list of teachers");
        System.out.println("7. To enroll a student in course");
        System.out.println("8. To mark attendance for a course");
        System.out.println("9. To check attendance for a student");
        System.out.println("10. Assign teacher to a student");
        System.out.println("11. To check total fee and pay fee of a student");
        System.out.println("12. Pay salary to a teacher");
        System.out.println("13. Print school's information");
        System.out.println("To exit: enter 0\n");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        School school = new School();
        //using do while loop because it has to run at least one time
        int option;
        do {
            option = displayOption();
            switch (option){
                case 1:
                	addStudent();
                	break;
                case 2:
                	addCourse();
                	break;
                case 3:
                	addTeacher();
                	break;
                case 4:
                	School.printStudents();
                	break;
                case 5:
                	School.printCourses();
                	break;
                case 6:
                	School.printTeachers();
                	break;
                case 7:
                	enrollCourse(cin);
                	break;
                case 8:
                	markAttendance(cin);
                	break;
                case 9:
                	printStudentAttendance(cin);
                	break;
                case 10:
                	assignTeacher(cin);
                	break;
                case 11:
                	payStudentFee(cin);
                	break;
                case 12:
                	payTeacherSalary(cin);
                	break;
                case 13:
                	System.out.println(school.getInfo());
                	break;
            }
        }while(option != 0);
    }

    //utility methods

    //Add a student
    public static void addStudent(){
        Object student = new Student().create();
        School.admitStudent((Student) student);
    }
    
  //add a teacher
    public static void addCourse() {
        Object course = new Course().create();
        School.addCourse((Course)course);
    }
    
    //add a teacher
    public static void addTeacher() {
        Object teacher = new Teacher().create();
        if(teacher==null) {
        	System.out.println("teacher is null");
        	return;
        }
        School.addTeacher((Teacher)teacher);
    }
    
    //enroll course
    public static void enrollCourse(Scanner cin) {
    	System.out.print("Enter student's name: ");
    	String studentName = cin.nextLine();
    	System.out.print("Enter course name: ");
    	String courseName = cin.nextLine();
    	Student sName = School.searchForStudent(studentName);
    	Course cName = School.searchForCourse(courseName);
    	if(cName == null) {
    		System.out.println("This course is not taught at our institute");
    		return;
    	}
    	if(sName == null && cName!= null) {
    		System.out.println("Student does not exist");
    		System.out.println("Do you want to enroll this student? (Y/N)");
    		char choice = cin.nextLine().charAt(0);
    		if(choice == 'N' || choice == 'n') {
    			System.out.println("Program will terminate");
    			return;
    		}
    		else if(choice == 'Y' || choice == 'y') {
    			addStudent();
    		}
    		else {
    			System.out.println("Wrong input ... program will terminate");
    			return;
    		}
    	}
    	School.enrollCourse(sName, cName);
    }
    
    //mark attendance ==> teacher marks attendance using course
    public static void markAttendance(Scanner cin) {
    	System.out.print("Enter course name: ");
    	String courseName = cin.nextLine();
    	System.out.print("Enter teacher name: ");
    	String teacherName = cin.nextLine();
    	//finding teacher and course
    	Course course = School.searchForCourse(courseName);
    	Teacher teacher = School.searchForTeacher(teacherName);
    	if(course != null && teacher != null) {
    		course.markAttendance(teacher);
    	}
    	else {
    		System.out.println("Course or teacher is invalid");
    	}
    }
    
    //printing attendance for a student
    public static void printStudentAttendance(Scanner cin) {
    	System.out.print("Enter student name: ");
    	String studentName = cin.nextLine();
    	Student student = School.searchForStudent(studentName);
    	System.out.print("Enter course name: ");
    	String courseName = cin.nextLine();
    	Course course = School.searchForCourse(courseName);
    	if(student!= null && course!= null) {
    		student.printAttendance(course);
    	}
    	else {
    		System.out.println("Course or student does not exist");
    	}
    }
    
    //assigning teacher
  //enroll course
    public static void assignTeacher(Scanner cin) {
    	System.out.print("Enter student's name: ");
    	String studentName = cin.nextLine();
    	System.out.print("Enter teacher name: ");
    	String teacherName = cin.nextLine();
    	Student sName = School.searchForStudent(studentName);
    	Teacher tName = School.searchForTeacher(teacherName);
    	if(tName == null) {
    		System.out.println("This teacher does not exist");
    		return;
    	}
    	if(sName == null && tName!= null) {
    		System.out.println("Student does not exist");
    		System.out.println("Do you want to enroll this student? (Y/N)");
    		char choice = cin.nextLine().charAt(0);
    		if(choice == 'N' || choice == 'n') {
    			System.out.println("Program will terminate");
    			return;
    		}
    		else if(choice == 'Y' || choice == 'y') {
    			addStudent();
    		}
    		else {
    			System.out.println("Wrong input ... program will terminate");
    			return;
    		}
    	}
    	School.assignTeacher(sName, tName);
    }
    
    //checking and paying fee
    public static void payStudentFee(Scanner cin) {
    	System.out.print("Enter student name: ");
    	String studentName = cin.nextLine();
    	Student student = School.searchForStudent(studentName);
    	if(student == null) {
    		System.out.println("This student does not exist");
    	}
    	else {
    		student.payFee(student.getSemesterFee());
    	}
    }
    
    //pay salary to a teacher
    public static void payTeacherSalary(Scanner cin) {
    	System.out.print("Enter teacher's name: ");
    	String teacherName = cin.nextLine();
    	Teacher teacher = School.searchForTeacher(teacherName);
    	if(teacher==null) {
    		System.out.println("This teacher does not exist");
    	}
    	else {
    		teacher.paySalary(teacher.getSalary());
    	}
    }
    
}
