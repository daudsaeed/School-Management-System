package schoolmangementsys;

//Used for office hours 
//And by courses class.


//Schedule Class.
public class Schedule {
	//For encapsulation we made fields private
	//Encapsulation = abstraction + Data Hiding.
	
	private String []  days;
	private int [] time;
	private int [] duration;
	
	//No-Args Constructor
	 Schedule() {
		//Setting the default values.
		 
		//Setting default Days.
		this.days = new String [2];
		this.days[0] = "Monday";
		this.days[1] = "Wednesday";
		
		//Setting default time.
		this.time = new int [2];
		this.time[0] = 10;
		this.time[1] = 10;
		
		//Setting default duration.
		this.duration = new int [2];
		this.duration[0] = 2;
		this.duration[1] = 1;
	}
	//Parameterized Constructor
	 Schedule(String [] days, int [] time, int [] duration) {
		this.days= days;
		this.time = time;
		this.duration = duration;
	}
	
	//Polymorphism (Method Overriding / late Binding / Dynamic binding.)
	@Override
	public String toString() {
		String schedule="";
		
		for(int i = 0; i < days.length; i++) {
			
			//Error that we faced forgetting string is immutabe and can't be changed.
			//Now explicitely assign it to the reference variable
			//In String constant pool now scedule would refer on concan String.
			schedule = schedule.concat(this.days[i] + " at " + this.time[i] + " for " + this.duration[i] + 
					" hours\n");
		}
		
		return schedule;
	}
	
	//End Note: Did't required the setter because paramterized constructor is being used to set values here.
	
	
	//Main Method.Classes can be compiled without main but if you 
	//want to execute the class you need a main method.
	public static void main(String [] args) {
		
		Schedule schedule = new Schedule();
		System.out.println(schedule.toString());
	}
	
	
	
	//Getter and setters; ///Used in Attedence class.
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	public int[] getTime() {
		return time;
	}
	public void setTime(int[] time) {
		this.time = time;
	}
	public int[] getDuration() {
		return duration;
	}
	public void setDuration(int[] duration) {
		this.duration = duration;
	}
}
