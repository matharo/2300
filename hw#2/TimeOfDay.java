/* Exercise 3.10 pg 134
 * Implement a class TimeOfDay that stores a time between 
 * 00:00:00 and 23:59:59. Supply a constructor 
 * TimeOfDay(int hours, int minutes, int seconds) and accessor
 * methods to get the current hours, minutes, and seconds. 
 * Supply methods:
 * 
 *  	TimeOfDay addSeconds(int seconds)
 *  	int secondsFrom(TimeOfDay other)
 *  
 * The first method returns a TimeOfDay obj that is the given 
 * number of seconds away from the current object. The second 
 * method computes the number of seconds between two TimeOfDay
 * objects. Use three integers for the hours, minutes, and 
 * seconds as the internal representation.*/

//stores time -- receives hours, minutes, seconds from user
public class TimeOfDay {

	private int hours, minutes, seconds;
	private int totalSeconds;
	
	public TimeOfDay(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		
		//convert hours and minutes to seconds
		totalSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
	}
	
	public TimeOfDay addSeconds(int seconds)
	{
		int total = totalSeconds + seconds;
		
		//calculate- dividing by seconds, and find any remainders
		int hrs = total / 3600; //returns floor -- need to get any remainders
		int remainders = total - (hrs * 3600); 
		
		int mins = remainders / 60; //also get floor
		remainders = remainders - (mins * 60);
		
		int secs = remainders; //secs left after mins and hrs subtracted
		
		return new TimeOfDay(hrs,mins,secs);
	}
	
	public int secondsFrom(TimeOfDay other)
	{
		int difference;
		if (this.totalSeconds > other.totalSeconds)
		{
			difference = this.totalSeconds - other.totalSeconds;
		}
		else
		{
			difference = other.totalSeconds - this.totalSeconds;
		}
		return difference;
	}
	
	private int getHours()
	{
		return hours;
	}
	private int getMinutes()
	{
		return minutes;
	}
	private int getSeconds()
	{
		return seconds;
	}
	
	public static void main(String args[])
	{
		TimeOfDay td = new TimeOfDay(5,11,23);
		TimeOfDay t2 = td.addSeconds(34); //returns obj
		System.out.println(t2.getSeconds()); //equal 57 seconds
		
		TimeOfDay tt = new TimeOfDay(5,11,00);
		System.out.println(t2.secondsFrom(tt)); //returns 57 seconds
	}
}
