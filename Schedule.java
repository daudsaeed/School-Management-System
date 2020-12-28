package schoolmangementsys;

import java.io.Serializable;
import java.util.Scanner;

//Used for office hours 
//And by courses class.

//Schedule Class.
public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;
	// For encapsulation we made fields private
	// Encapsulation = abstraction + Data Hiding.

	private String[] days = new String[2];
	private int[] time = new int[2];
	private int[] duration = new int[2];
	private transient Scanner input = new Scanner(System.in);

	// No-Args Constructor
	Schedule() {
		// Setting the default values.

		// Setting default Days.
		this.days = new String[2];
		this.days[0] = "Monday";
		this.days[1] = "Wednesday";

		// Setting default time.
		this.time = new int[2];
		this.time[0] = 10;
		this.time[1] = 10;

		// Setting default duration.
		this.duration = new int[2];
		this.duration[0] = 2;
		this.duration[1] = 1;
	}

	// Parameterized Constructor
	Schedule(String[] days, int[] time, int[] duration) {
		this.days = days;
		this.time = time;
		this.duration = duration;
	}

	// Polymorphism (Method Overriding / late Binding / Dynamic binding.)
	@Override
	public String toString() {
		String schedule = "";
		for (int i = 0; i < days.length; i++) {
			// Error that we faced forgetting string is immutable and can't be changed.
			// Now explicitly assign it to the reference variable
			// In String constant pool now schedule would refer on concat String.
			schedule = schedule.concat(this.days[i] + " at " + this.time[i] + " for " + this.duration[i] + " hours\n");
		}
		return schedule;
	}

	public Object create() {
		for (int i = 0; i < days.length; i++) {
			System.out.print("Enter name of day: ");
			days[i] = input.nextLine();
			System.out.print("Enter time (an integer in 24 hour format): ");
			time[i] = input.nextInt();
			// discard \n
			input.nextLine();
			System.out.print("Enter duration (in hours): ");
			duration[i] = input.nextInt();
			// discard \n
			input.nextLine();
		}
		return this;
	}
}
