/*page 33. Exercise 1.20
 * Write a program that reads input data from a file and prints 
 * the minimum, maximum, and average value of the input data.
 * The file name should be specified on the command line. Use a 
 * DataAnalyzer and a separate class DataAnalyzerTester.
 */

import java.util.Scanner;
import java.io.FileReader;

public class DataAnalyzer
{
	int[] numbers;

	public DataAnalyzer(int[] num)
	{
		numbers = num;
	}

	public int minmax()
	{
		int smallest = numbers[0];
		int max = numbers[0];
		for (int i : numbers)
		{
			if (smallest > i)
			{
				smallest = i;
			}
			if (max < i)
			{
				max = i;
			}
		}
	}
	public double avg()
	{
		int total = 0;
		for (int i : numbers)
		{
			total += i;
		}
		int length = numbers.size();
		double average = (double)total/(double)length;

		return average;
	}

	public static void main (String args[])
	{
		try
		{
		FileReader file = new FileReader("numbers.txt");
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Invalid text file");
		}
		int[] nums;

		while (file.read() != -1)
		{
			String s;
			while (Integer.toString(file.read()) != "/n")
			{
				s += Integer.toString(file.read());
			}
			s = Integer.parseInt(s);
			nums.add(s);
		}

		file.close();

		DataAnalyzer dt = new DataAnalyzer(nums);

		System.out.println("The minimum is : " + dt.minmax());
		System.out.println("The average is : " + dt.avg());
	}
}
