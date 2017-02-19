import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class DataAnalyzerTester 
{
	public static void main(String args[])
	{	
		int[] nums;
		try
		{   //raises FileNotFoundException
			Scanner file = new Scanner(new FileReader("numbers.txt"));
			
			int i = 0; //counter to initialize size of array
			while (file.hasNextLine()==true)
			{
				file.nextInt();
				i++;
			}
			nums = new int[i]; //initialize length of array
			
			file.close(); //close file to reset
			
			file = new Scanner(new FileReader("numbers.txt")); //open file again
			
			int p = 0;
			while (file.hasNextLine()) //go through each line and add to array
			{
				nums[p] = file.nextInt();
				p++;
			}
			
			file.close(); //close file
			
			DataAnalyzer dt = new DataAnalyzer(nums);
			dt.minmax();
			dt.avg();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			e.printStackTrace();
		}			
	}
}