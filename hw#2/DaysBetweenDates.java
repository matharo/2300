import javax.swing.*; //JFrame, JLabel, JTextField, JPanel
import java.awt.BorderLayout;
import java.awt.event.*; //ActionEvent, ActionListener, TextListener
import java.util.GregorianCalendar;

public class DaysBetweenDates extends JFrame
{
	public static void main(String args[])
	{
		DaysBetweenDates frame = new DaysBetweenDates("Calculate the days");
	}

	private GregorianCalendar currDate = new GregorianCalendar().getInstance();
	private Gregoriancalendar newDate = new GregorianCalendar();

	private int month;
	private int day;
	private int year;	

	public DaysBetweenDates(String title)
	{
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);

		//set all default text of textfields to current date
		JTextField day = new JTextField(getDay()); 
		panel.add(day, BorderLayout.CENTER);

		JTextField month = new JTextField(getMonth());
		panel.add(month,BorderLayout.WEST);

		JTextField year = new JTextField(getYear());
		panel.add(year,BorderLayout.EAST);

		JLabel dayLabel = new JLabel("The difference between these two dates are: " + getDifference());

	private int getYear()
	{
		if (year.getText().equals("")
		{
			return currDate.get(Calendar.YEAR());
		}
		else
		{
			return year.getText();
		}
	}	

	private int getMonth()
	{
		if (month.getText().equals("")
		{
			return currDate.get(Calendar.MONTH());
		}
		else
		{
			return month.getText();
		}
	}

	private int getDay()
	{
		if (day.getText().equals("")
		{
			return currDate.get(Calendar.DAY_OF_MONTH);
		}
		else
		{
			return day.getText();
		}
	}

	private int getDifference() //returns difference between days
	{
	
	}

}
