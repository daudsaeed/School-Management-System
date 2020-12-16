package schoolmangementsys;
import java.util.Scanner;

public class Main {

    //Display Options
    public static int displayOption(){
        int option = 0;
        System.out.println("Enter your command.\n");
        System.out.println("To add a student: enter 1\n");
        System.out.println("To add a course: enter 2\n");
        System.out.println("To add a teacher: enter 3\n");
        System.out.println("To print list of students: enter 4\n");
        System.out.println("To print list of courses: enter 5\n");
        System.out.println("To print list of teachers: enter 6\n");
        System.out.println("To exit: enter 0\n");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }
    
    public static void main(String[] args) {
        //using do while loop because it has to run atleast one time
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
            }
        }while(option != 0);
    }

    //utilty methods

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
        School.addTeacher((Teacher)teacher);
    }
    
}
