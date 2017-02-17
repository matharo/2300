/* page 32; Exercise 1.10
 * Write a program that computes and prints the sum of integers
 * from 1 to 100 and the sum of integers from 100 to 1000. Create
 * an appropriate class Summer that has no main method for this 
 * purpose. If you don't use BlueJ, create a second class with a 
 * main method to construct two objects of the Summer class
**/

public class Summer
{
	//don't need constructor; automatically defined
	//no parameters need to be used in constructor

	public void sum1to100()
	{
		int sum = 0;
		for (int i = 1; i < 101; i++)
		{
			sum +=i;
		}
		System.out.println("The sum from 1 to 10 is: " + sum);
	}
	public void sum100to1000()
	{
		int sum = 0;
		for (int i = 100; i < 1001; i++)
		{
			sum +=i;
		}
		System.out.println("The sum from 100 to 1000 is: " + sum);
	}

	public static void main(String args[]){
		Summer s = new Summer();
		Summer s2 = new Summer();

		s.sum1to100();
		s.sum100to1000();
	}
}
