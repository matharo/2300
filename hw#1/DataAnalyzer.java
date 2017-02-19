public class DataAnalyzer
{
	int[] numbers;
	
	public DataAnalyzer(int[] num)
	{
		numbers = num;
	}
	public void minmax()
	{
		int min = numbers[0];
		int max = numbers[0];
		for (int i : numbers)
		{
			if (i < min)
			{
				min = i;
			}
			if (max < i)
			{
				max = i;
			}
		}
		System.out.println("The minimum number is: " + min);
		System.out.println("The maximum number is: " + max);
	}
	public void avg()
	{
		int total = 0;
		for (int i : numbers)
		{
			total += i;
		}
		int length = numbers.length;
		double average = (double)total/(double)length;
		System.out.println("The average of all numbers is: " + average);	
	}
}
