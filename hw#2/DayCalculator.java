import javax.swing.*; //JFrame, JLabel, JTextField, JPanel
import java.awt.FlowLayout;
import java.awt.event.*; //ActionEvent, ActionListener
import java.util.GregorianCalendar;
import java.util.Calendar; //get Calendar instance variables

public class DayCalculator extends JFrame
{
	public static void main(String args[])
	{
		DayCalculator frame = new DayCalculator("Day Calculator");
	}

	public DayCalculator(String title) //constructor, adds stuff to JFrame
	{
		super(title);
		
		//main panel holding everything
		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		add(panel);
		
		//nested panel that hold labels for month,day,year
		final JPanel textLabels = new JPanel();
		textLabels.setLayout(new FlowLayout());;
		panel.add(textLabels);
		
		JLabel monthLabel = new JLabel("Month (MM):  "); //month label
		textLabels.add(monthLabel);
		
		JLabel dayLabel = new JLabel("Day (DD):  "); //day label
		textLabels.add(dayLabel);
		
		JLabel yrLabel = new JLabel("Year (YYYY):  "); //year label
		textLabels.add(yrLabel);
		
		//set all default text of textfields to current date
		//month is 0-12, need to +1
		JTextField month = new JTextField(Integer.toString(currDate.get(Calendar.MONTH)+1));
		panel.add(month);
		
		JTextField day = new JTextField(Integer.toString(currDate.get(Calendar.DAY_OF_MONTH))); 
		panel.add(day);
		
		JTextField year = new JTextField(Integer.toString(currDate.get(Calendar.YEAR)));
		panel.add(year);
		
		
		//label that returns days between dates
		JLabel daysLabel = new JLabel();
		panel.add(daysLabel); //bottom of calcPanel
		
		//buttons that calculates days
		JButton calcButton = new JButton("Calculate Days between Dates");
		panel.add(calcButton); //top of calcPanel
		calcButton.addActionListener(new ActionListener() //make button work
			{
				public void actionPerformed(ActionEvent e)
				{
					fillCalendars(Integer.parseInt(day.getText()),
							Integer.parseInt(month.getText()),
							Integer.parseInt(year.getText()));
				
					daysLabel.setText("The number of days between "
							+ "these two dates are: " + getDifference());
				}
			});
		
		//frame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);
		setVisible(true);
	}
	
	//both initalized to default time
	private GregorianCalendar currDate = new GregorianCalendar();
	private GregorianCalendar newDate = new GregorianCalendar();
	
	private int getDifference() //returns difference between days
	{
		//getTimeInMillis returns long
		long newDateInDays = (newDate.getTimeInMillis())/(24*60*60*1000);
		long currDateInDays = (currDate.getTimeInMillis())/(24*60*60*1000);
		
		if (newDateInDays > currDateInDays)
		{
			return (int)(newDateInDays - currDateInDays);
		}
		else
		{
			return (int)(currDateInDays - newDateInDays);
		}
	}
	private void fillCalendars(int d, int m, int y) //change calendars variables
	{
		int day = Calendar.DAY_OF_MONTH;
		int month = Calendar.MONTH;
		int year = Calendar.YEAR;
		
		//if newDate is default, currDate will just be set default again
		currDate.set(day, newDate.get(day));
		currDate.set(month,newDate.get(month));
		currDate.set(year,newDate.get(year));
			
		newDate.set(day,d);
		newDate.set(month,m-1); //because months are 0-11
		newDate.set(year,y);
	}	
}