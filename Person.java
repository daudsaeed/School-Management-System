package schoolmangementsys;

import java.util.ArrayList;
import java.util.Scanner;

public class Person{
	//common fields of both student and teacher
	protected String name;
	protected String idCardNo;
	protected String dob;//date of birth
	protected String gender;
	protected String email;
	protected String phoneNo;
	protected String address;
	protected String department;//like we are in CS dept
	protected String city;
	protected ArrayList<String> courseArray = new ArrayList<>();//courses that student will study or teacher will teach
	
	private Scanner input = new Scanner(System.in);
	
	//create method ==> to add data members
	public Object create() {
		System.out.print("Enter name: ");
		this.name = input.nextLine();
		System.out.print("Enter ID Card number: ");
		this.idCardNo = input.nextLine();
		System.out.print("Enter date of birth: ");
		this.dob = input.nextLine();
		System.out.print("Enter gender: ");
		this.gender = input.nextLine();
		System.out.print("Enter email ID: ");
		this.email = input.nextLine();
		System.out.print("Enter phone no.: ");
		this.phoneNo = input.nextLine();
		System.out.print("Enter address: ");
		this.address = input.nextLine();
		System.out.print("Enter department: ");
		this.department = input.nextLine();
		System.out.print("Enter city name: ");
		this.city =  input.nextLine();
		return this;
	}
	
	//get info for printing
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Name: "+name);
		info.append("\nID Card No.: "+idCardNo);
		info.append("\nDate of Birth: "+dob);
		info.append("\nGender: "+gender);
		info.append("\nEmail ID: "+email);
		info.append("\nPhone no.: "+phoneNo);
		info.append("\nAddress: "+address);
		info.append("\nDepartment: "+department);
		info.append("\nCity: "+city);
		return info.toString();
	}
	
	//setters and getters
	
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//id card
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	
	//dob
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	//gender
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//phone no
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	//address
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//department
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	//city
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//courses
	public ArrayList<String> getcourseArray() {
		return courseArray;
	}
	public void setcourseArray(ArrayList<String> courses) {
		this.courseArray = courses;
	}
	
}
