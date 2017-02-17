import java.util.Scanner;

public class DaysElapsedTester {
	
	public static void main(String args[])
	{	
		DaysElapsed bday;
		
		Scanner reader = new Scanner(System.in); //reads in user input
		int year;
		int month;
		int day;
		
		System.out.print("Do you want to enter a birthdate (yes/no): "); //asks user for input, if no--uses args
		String user = reader.next();
		
		if (user.equals("yes")) 	//forgot that String must use .equals()
		{							//asks user for birth year, month, and date
			System.out.print("Enter your birth year: ");
			year = reader.nextInt();
			System.out.print("Enter your birth month (between 1-12): ");
			month = reader.nextInt();
			month--; //because months are 0-11, not 1-12
			System.out.print("Enter your birth day (between 1-31): ");
			day = reader.nextInt();
			
			bday = new DaysElapsed(year,month,day); //calls constructor and creates GregorianCalendar obj
			
			System.out.println("The number of days between today and " + year + "/" + month + "/" + day +
					" is: " + bday.getDays() + " days.");
		}
		
		else if (user.equals("no")) //uses default answers, 1990 jan 1
		{
			year = Integer.parseInt(args[0]); //need convert args input from String to int
			month = Integer.parseInt(args[1]);
			month--; //because months are 0-11, not 1-12
			day = Integer.parseInt(args[2]);
			
			bday = new DaysElapsed(year,month,day);
			
			System.out.println("The number of days between today and " + year + "/" + month + "/" + day +
					" is: " + bday.getDays() + " days.");
		}
	
		reader.close();
	}
}
