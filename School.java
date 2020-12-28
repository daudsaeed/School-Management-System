package schoolmangementsys;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class School implements Management, Serializable{

	private static final long serialVersionUID = 1L;
	// For encapsulation we made fields private
	// Encapsulation = abstraction + Data Hiding.

	// Name of the school
	private static String name = "Girls International School";
	private static String tagline = "Every Student Matters , Every Moment Counts"; // a brilliant tagline by our group leader dawood:)

	// List of all the students and their count
	private static ArrayList<Student> students = new ArrayList<Student>();
	private static int studentCount;

	// List of courses in school and their count
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static int courseCount;

	// list of all teachers
	private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private static int teacherCount;

	// net worth and total salary paid to teachers
	private static int netWorth = 1000000; // initial net worth of school
	private static int totalSalarayPaid;
	private static int totalFeeReceived;

	// getting info
	@Override
	public String getInfo() {
		String info = "";
		info += name + "\n" + tagline + "\n";
		info += "Courses: \n";
		int i = 1;
		for (Course course : courses) {
			info += i + ". " + course.getName() + "\n";
			i++;
		}
		info += "Number of teachers: " + teacherCount + "\n";
		info += "Number of students: " + studentCount + "\n";
		info += "Net Worth: " + netWorth + "\n";
		return info;
	}
	
	//reading file
	@SuppressWarnings("unchecked")
	public static void readData() throws IOException, ClassNotFoundException {
		final String fileName = "SchoolData.dat";
		File file = new File(fileName);
		//checking if file does not exist
		if(!file.exists()) {
			file.createNewFile();
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SchoolData.dat"));
			School.students = (ArrayList<Student>) ois.readObject();
			School.studentCount = ois.readInt();
			School.courses = (ArrayList<Course>) ois.readObject();
			School.courseCount = ois.readInt();
			School.teachers = (ArrayList<Teacher>) ois.readObject();
			School.teacherCount = ois.readInt();
			School.netWorth = ois.readInt();
			School.totalSalarayPaid = ois.readInt();
			School.totalFeeReceived = ois.readInt();
			ois.close();
		}catch(EOFException e) {
			System.out.println("");
		}
	}
	
	//writing data to file
	public static void writeData() throws FileNotFoundException, IOException {
		final String fileName = "SchoolData.dat";
		File file = new File(fileName);
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(students);
			oos.writeInt(studentCount);
			oos.writeObject(courses);
			oos.writeInt(courseCount);
			oos.writeObject(teachers);
			oos.writeInt(teacherCount);
			oos.writeInt(netWorth);
			oos.writeInt(totalSalarayPaid);
			oos.writeInt(totalFeeReceived);
			oos.close();
		} catch(Exception e) {
			System.out.println("Exception in code");
		}
	}
	
	// Admit the student (Student Panel).
	public static void admitStudent(Student student) {
		students.add(student);
		studentCount++;
	}

	// add teacher
	public static void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		teacherCount++;
	}

	// Add courses ( Admin Panel).
	public static void addCourse(Course course) {
		courses.add(course);
		courseCount++;
	}

	// remove student
	public static void removeStudent(Student student) {
		students.remove(student);
		studentCount--;
	}

	// remove teacher
	public static void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
		teacherCount--;
	}

	// remove course
	public static void removeCourse(Course course) {
		courses.remove(course);
		courseCount--;
	}

	// Enroll course method
	public static void enrollCourse(Student student, Course course) {
		if (student != null && course != null) {
			Course[] courses = student.getCourses();
			if (course != null && student.getCoursesEnrolled() < 5) {
				student.addCourse(course);
				course.addStudent(student);
			}
		} else {
			System.out.println("Error: Student or course can't be NULL");
		}
	}

	// assign teacher to student
	public static void assignTeacher(Student student, Teacher teacher) {
		if (student != null && teacher != null) {
			Teacher[] teachers = student.getTeachers();
			if (teacher != null && student.getTeachersAssigned() < 5) {
				student.addTeacher(teacher);
				teacher.addStudent(student);
			}
		} else {
			System.out.println("Error: Student or teacher can't be NULL");
		}
	}

	// searching a course in the course array list
	public static Course searchForCourse(String course) {
		// course name can not be null or empty string
		Course courseName = null;
		if (course != null && !course.equals("")) {
			for (Course c : courses) {
				if (c.getName().equalsIgnoreCase(course)) {
					courseName = c;
				}
			}
		}
		return courseName;
	}

	// searching a teacher in the course array list
	public static Teacher searchForTeacher(String teacherName) {
		// teacher name can not be null or empty string
		Teacher teacher = null;
		if (teacherName != null && !teacherName.equals("")) {
			for (Teacher t : teachers) {
				if (t.getName().equalsIgnoreCase(teacherName)) {
					teacher = t;
				}
			}
		}
		return teacher;
	}

	// searching a student in the course array list
	public static Student searchForStudent(String studentName) {
		// teacher name can not be null or empty string
		Student student = null;
		if (studentName != null && !studentName.equals("")) {
			for (Student s : students) {
				if (s.getName().equalsIgnoreCase(studentName)) {
					student = s;
				}
			}
		}
		return student;
	}

	public static int getStudentCount() {
		return studentCount;
	}

	// printing info about all students
	public static void printStudents() {
		System.out.println("List of students:");
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}

	// printing info about all students
	public static void printTeachers() {
		System.out.println("List of teachers:");
		for (Teacher teacher : teachers) {
			System.out.println(teacher.getName());
		}
	}

	// printing all courses
	public static void printCourses() {
		System.out.println("List of courses:");
		for (Course course : courses) {
			System.out.println(course.getName());
		}
	}

	// getter method
	public static int getNetWorth() {
		return netWorth;
	}

	// updating net worth ==> increasing if fee is received & decreasing if salary
	// is paid
	public static void addNetWorth(int amount) {
		totalFeeReceived += amount;
		netWorth += amount;
	}

	public static void subtractNetWorth(int amount) {
		totalSalarayPaid += amount;
		netWorth -= amount;
	}

	// only getters because we won't set these :)
	public static String getName() {
		return name;
	}

	public static String getTagline() {
		return tagline;
	}
}
