package schoolmangementsys;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable{
	private static final long serialVersionUID = 1L;
	// modifying on 22/12/2020 at 6:40 PM
	// we will display two menus ==> outer to select category - admin, student or teacher
	// second menu will be according to the category selected in the first menu

	// selecting category / first menu
	public static int displayCategories(Scanner cin) {
		int option = 0;
		System.out.println("\nChoose category (0 to exit): ");
		System.out.println("1. Administration");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		option = cin.nextInt();
		// discard \n
		cin.nextLine();
		// checking validity of option
		if (option >= 0 && option < 4) {
			return option;
		} else {
			System.out.println("INVALID CHOICE!!!");
			return option;
		}
	}

	// second menu for admin
	public static void adminOptions(Scanner cin) {
		int option = 0;
		do {
			System.out.println("\nEnter your command");
			System.out.println("0. Go back to categories");
			System.out.println("1. Admit a student");
			System.out.println("2. Add a teacher");
			System.out.println("3. Add a course");
			System.out.println("4. Expel/remove a student");
			System.out.println("5. Remove a teacher");
			System.out.println("6. Remove a course");
			System.out.println("7. Enroll a course for a student");
			System.out.println("8. Assign teacher to a student");
			System.out.println("9. Print information about school");
			System.out.println("10. Print information about a course");
			System.out.println("11. Print list of all courses taught at school");
			System.out.println("12. Print list of all students studying at school");
			System.out.println("13. Print list of all teachers teaching at school");
			option = cin.nextInt();
			// discard \n
			cin.nextLine();
			// switch statement
			switch (option) {
			case 0: // go back to display options
				return;
			case 1:
				addStudent();
				break;
			case 2:
				addTeacher();
				break;
			case 3:
				addCourse();
				break;
			case 4:
				deleteStudent(cin);
				break;
			case 5:
				deleteTeacher(cin);
				break;
			case 6:
				deleteCourse(cin);
				break;
			case 7:
				enrollCourse(cin);
				break;
			case 8:
				assignTeacher(cin);
				break;
			case 9:
				printSchoolInfo();
				break;
			case 10:
				printCourseInfo(cin);
				break;
			case 11:
				School.printCourses();
				break;
			case 12:
				School.printStudents();
				break;
			case 13:
				School.printTeachers();
				break;
			}
		} while (option != 0);
	}

	// second menu for teachers
	public static void teacherOptions(Scanner cin) {
		int option = 0;
		do {
			System.out.println("\nEnter your command");
			System.out.println("0. Go back to categories");
			System.out.println("1. Print information about a teacher");
			System.out.println("2. Get list of students taught by a teacher");
			System.out.println("3. Mark attendance of students");
			System.out.println("4. Pay salary to a teacher");
			option = cin.nextInt();
			// discard \n
			cin.nextLine();
			// switch statement
			switch (option) {
			case 0:
				break;
			case 1:
				printTeacherInfo(cin);
				break;
			case 2:
				printStudentsOfTeacher(cin);
				break;
			case 3:
				markAttendance(cin);
				break;
			case 4:
				payTeacherSalary(cin);
				break;
			}
		} while (option != 0);
	}

	// second menu for students
	public static void studentOptions(Scanner cin) {
		int option = 0;
		do {
			System.out.println("\nEnter your command");
			System.out.println("0. Go back to categories");
			System.out.println("1. Print information about a student");
			System.out.println("2. View attendance of a subject");
			System.out.println("3. View list of teachers and courses");
			System.out.println("4. Pay fee for a student");
			System.out.println("5. Enroll a course");
			option = cin.nextInt();
			// discard \n
			cin.nextLine();
			// switch statement
			switch (option) {
			case 0:
				break;
			case 1:
				printStudentInfo(cin);
				break;
			case 2:
				printStudentAttendance(cin);
				break;
			case 3:
				printStudentCourses(cin);
				break;
			case 4:
				payStudentFee(cin);
				break;
			case 5:
				enrollCourse(cin);
				break;
			}
		} while (option != 0);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//read files at the time when we execute the code and write files when we end it
		School.readData();
		// printing the welcome message
		System.out.println(School.getName());
		System.out.println(School.getTagline());
		System.out.println("\nWelcome to our school management system!");
		System.out.println("\n*******************************************\n");
		Scanner cin = new Scanner(System.in);
		// using do while loop because it has to run at least one time
		// testing the new menus
		int option;
		do {
			option = displayCategories(cin);
			switch (option) {
			case 0:
				break;
			case 1:
				adminOptions(cin);
				break;
			case 2:
				teacherOptions(cin);
				break;
			case 3:
				studentOptions(cin);
				break;
			}
		} while (option != 0);
		School.writeData();
	}

	// utility methods

	// Add a student
	public static void addStudent() {
		Object student = new Student().create();
		School.admitStudent((Student) student);
	}

	// add a teacher
	public static void addCourse() {
		Object course = new Course().create();
		School.addCourse((Course) course);
	}

	// add a teacher
	public static void addTeacher() {
		Object teacher = new Teacher().create();
		if (teacher == null) {
			System.out.println("teacher is null");
			return;
		}
		School.addTeacher((Teacher) teacher);
	}

	// enroll course
	public static void enrollCourse(Scanner cin) {
		System.out.print("Enter student's name: ");
		String studentName = cin.nextLine();
		System.out.print("Enter course name: ");
		String courseName = cin.nextLine();
		Student sName = School.searchForStudent(studentName);
		Course cName = School.searchForCourse(courseName);
		if (cName == null) {
			System.out.println("This course is not taught at our institute");
			return;
		}
		if (sName == null && cName != null) {
			System.out.println("Student does not exist");
			System.out.println("Do you want to enroll this student? (Y/N)");
			char choice = cin.nextLine().charAt(0);
			if (choice == 'N' || choice == 'n') {
				System.out.println("Program will terminate");
				return;
			} else if (choice == 'Y' || choice == 'y') {
				addStudent();
			} else {
				System.out.println("Wrong input ... program will terminate");
				return;
			}
		}
		School.enrollCourse(sName, cName);
	}

	// mark attendance ==> teacher marks attendance using course
	public static void markAttendance(Scanner cin) {
		System.out.print("Enter course name: ");
		String courseName = cin.nextLine();
		System.out.print("Enter teacher name: ");
		String teacherName = cin.nextLine();
		// finding teacher and course
		Course course = School.searchForCourse(courseName);
		Teacher teacher = School.searchForTeacher(teacherName);
		if (course != null && teacher != null) {
			course.markAttendance(teacher);
		} else {
			System.out.println("Course or teacher is invalid");
		}
	}

	// printing attendance for a student
	public static void printStudentAttendance(Scanner cin) {
		System.out.print("Enter student name: ");
		String studentName = cin.nextLine();
		Student student = School.searchForStudent(studentName);
		System.out.print("Enter course name: ");
		String courseName = cin.nextLine();
		Course course = School.searchForCourse(courseName);
		if (student != null && course != null) {
			student.printAttendance(course);
		} else {
			System.out.println("Course or student does not exist");
		}
	}

	// printing attendance for a student
	public static void printTeacherAttendance(Scanner cin) {
		System.out.print("Enter teacher name: ");
		String teacherName = cin.nextLine();
		Teacher teacher = School.searchForTeacher(teacherName);
		if (teacher != null) {
			teacher.printAttendance();
		} else {
			System.out.println("Teacher does not exist");
		}
	}

	// assigning teacher
	// enroll course
	public static void assignTeacher(Scanner cin) {
		System.out.print("Enter student's name: ");
		String studentName = cin.nextLine();
		System.out.print("Enter teacher name: ");
		String teacherName = cin.nextLine();
		Student sName = School.searchForStudent(studentName);
		Teacher tName = School.searchForTeacher(teacherName);
		if (tName == null) {
			System.out.println("This teacher does not exist");
			return;
		}
		if (sName == null && tName != null) {
			System.out.println("Student does not exist");
			System.out.println("Do you want to enroll this student? (Y/N)");
			char choice = cin.nextLine().charAt(0);
			if (choice == 'N' || choice == 'n') {
				System.out.println("Program will terminate");
				return;
			} else if (choice == 'Y' || choice == 'y') {
				addStudent();
			} else {
				System.out.println("Wrong input ... program will terminate");
				return;
			}
		}
		School.assignTeacher(sName, tName);
	}

	// checking and paying fee
	public static void payStudentFee(Scanner cin) {
		System.out.print("Enter student name: ");
		String studentName = cin.nextLine();
		Student student = School.searchForStudent(studentName);
		if (student == null) {
			System.out.println("This student does not exist");
		} else {
			student.payFee(student.getSemesterFee());
		}
	}

	// pay salary to a teacher
	public static void payTeacherSalary(Scanner cin) {
		System.out.print("Enter teacher's name: ");
		String teacherName = cin.nextLine();
		Teacher teacher = School.searchForTeacher(teacherName);
		if (teacher == null) {
			System.out.println("This teacher does not exist");
		} else {
			teacher.paySalary(teacher.getSalary());
		}
	}

	// printing school's info
	public static void printSchoolInfo() {
		School school = new School();
		System.out.println(school.getInfo());
	}
	
	//printing course's info
	public static void printCourseInfo(Scanner cin) {
		System.out.print("Enter course name: ");
		String courseName = cin.nextLine();
		Course course = School.searchForCourse(courseName);
		if(course != null) {
			System.out.println(course.getInfo());
		} else {
			System.out.println("course not found");
		}
	}
	
	// printing teacher's info
	public static void printTeacherInfo(Scanner cin) {
		System.out.print("Enter teacher's name: ");
		String teacherName = cin.nextLine();
		Teacher teacher = School.searchForTeacher(teacherName);
		if (teacher != null) {
			System.out.println(teacher.getInfo());
		} else {
			System.out.println("Teacher not found");
		}
	}

	// printing studeent's info
	public static void printStudentInfo(Scanner cin) {
		System.out.print("Enter student's name: ");
		String studentName = cin.nextLine();
		Student student = School.searchForStudent(studentName);
		if (student != null) {
			System.out.println(student.getInfo());
		} else {
			System.out.println("Student not found");
		}
	}

	// delete student
	public static void deleteStudent(Scanner cin) {
		System.out.print("Enter student's name: ");
		String studentName = cin.nextLine();
		Student student = School.searchForStudent(studentName);
		if (student != null) {
			School.removeStudent(student);
		} else {
			System.out.println("Student does not exist");
		}
	}

	// delete teacher
	public static void deleteTeacher(Scanner cin) {
		System.out.print("Enter teacher's name: ");
		String teacherName = cin.nextLine();
		Teacher teacher = School.searchForTeacher(teacherName);
		if (teacher != null) {
			School.removeTeacher(teacher);
		} else {
			System.out.println("Teacher does not exist");
		}
	}

	// delete course
	public static void deleteCourse(Scanner cin) {
		System.out.print("Enter course name: ");
		String courseName = cin.nextLine();
		Course course = School.searchForCourse(courseName);
		if (course != null) {
			School.removeCourse(course);
		} else {
			System.out.println("Course does not exist");
		}
	}

	// printing teacher's students
	public static void printStudentsOfTeacher(Scanner cin) {
		System.out.print("Enter teacher's name: ");
		String teacherName = cin.nextLine();
		Teacher teacher = School.searchForTeacher(teacherName);
		if (teacher != null) {
			for (Student student : teacher.getStudents()) {
				System.out.println(student.getName());
			}
		} else {
			System.out.println("Teacher not found");
		}
	}

	// printing student's courses and teachers
	public static void printStudentCourses(Scanner cin) {
		System.out.print("Enter student's name: ");
		String studentName = cin.nextLine();
		Student student = School.searchForStudent(studentName);
		if (student != null) {
			for (int i = 0; i < student.getCoursesEnrolled(); i++) {
				System.out.println("Course: " + student.getCourses()[i].getName());
				if (student.getTeachersAssigned() > i) {
					String teacher = student.getTeachers()[i].getName();
					if (teacher != null) {
						System.out.println("Teacher: " + teacher + "\n");
					} else {
						System.out.println("No teacher assigned yet\n");
					}

				}
			}
		} else {
			System.out.println("Student not found");
		}
	}
}
