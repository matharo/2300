import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;

public class PeopleQueue extends JFrame
{	
	public static void main(String args[])
	{
		ArrayList<String> namesList = new ArrayList<String>();
		
		for (String s : args)
		{
			namesList.add(s);
		}
		
		PeopleQueue frame = new PeopleQueue("People Queue", namesList);
	}
	
	public PeopleQueue(String title, ArrayList<String> list)
	{
		super(title);
		
		//panel on parent window
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		
		//button displays dialog with list of names
		JButton show = new JButton("Show Queue");
		panel.add(show, BorderLayout.NORTH);
		show.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				JOptionPane.showMessageDialog (
						null, 					// access parent window
						displayQueue(list),	// display list of names
						"List of People",				// window title
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		//label that displays which name gets removed
		JLabel removed = new JLabel();
		removed.setHorizontalAlignment(JLabel.CENTER);
		panel.add(removed,BorderLayout.CENTER);
		
		//button that pops first name in the list
		JButton pop = new JButton("Pop Queue");
		panel.add(pop, BorderLayout.SOUTH);
		pop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				removed.setText(popQueue(list));
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,150);
		setVisible(true);
	}
	
	public String displayQueue(ArrayList<String> list)
	{
		while (list.size() != 0)
		{
			String allNames = "";
			for (String names : list)
			{
				allNames += " " + names;
			}	
			return "List of all names: \n" + allNames;
		}
		return "No more names left";
	}
	
	public String popQueue(ArrayList<String> list)
	{
		while(list.size()!=0)
		{
			String removed = list.get(0);
			list.remove(0);
			return "The name " + removed + " was removed.";
		}
		return "No more names left";
	}
}
