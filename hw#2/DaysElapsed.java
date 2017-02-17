/* Exercise 3.6 pg 133
 * Write a program that computes the number of days 
 * that have elapsed since you were born. Use the 
 * GregorianCalendar class, not the Day class of
 * this chapter */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DaysElapsed 
{
	private GregorianCalendar birthday;
	
	public DaysElapsed(int year, int month, int dayOfMonth)
	{
		birthday = new GregorianCalendar(year,month,dayOfMonth); //initialize birthday
	}
	
	public int getDays() //calculates days between current date and birthdate
	{
		return getCurrentTime() - getBirthTime(); //returns days as int
	}
	
	private int getCurrentTime() //number days from current time to epoch
	{
		GregorianCalendar current = new GregorianCalendar(); //set Calendar to current times

		current.set(Calendar.HOUR_OF_DAY,0); //clear hour/minute/second/millisecond of current time
		current.set(Calendar.MINUTE,0);
		current.set(Calendar.SECOND,0);
		current.set(Calendar.MILLISECOND,0); //because only year/month/day is set for birthday, not time

		//gets current time since epoch in milliseconds and converts to days
		long days = (current.getTimeInMillis())/(24*60*60*1000); //24hrs,60mins,60secs,1000milisecs
		return (int)days; //getTimeInMillis returns long, so days casted from long to int
		
	}
	private int getBirthTime() //days from birthdate to epoch
	{
		//gets time from birthday to epoch in milliseconds and converts to days
		long days = (birthday.getTimeInMillis())/(24*60*60*1000); //getTimeInMillis returns long
		return (int)days;
	}
}
