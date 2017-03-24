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

	public void sum(int l, int h)
	{
		int low = l;
		int high = h;
		int sum = 0;
		for (int i = l; i < h+1; i++)
		{
			sum +=i;
		}
		System.out.println("The sum from 1 to 10 is: " + sum);
	}

	public static void main(String args[]){
		Summer s = new Summer();
		
		s.sum(1,100);
		s.sum(100,1000);
	}
}
