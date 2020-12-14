package schoolmangementsys;

import java.util.ArrayList;

public class Person {
	//common fields of both student and teacher
	private String name;
	private String idCardNo;
	private String dob;//date of birth
	private String gender;
	private String email;
	private String phoneNo;
	private String address;
	private String department;//like we are in CS dept
	private String city;
	private ArrayList<String> courses = new ArrayList<>();//courses that student will study or teacher will teach
	
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
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
}
