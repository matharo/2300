import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MathProblem 
{
	public static void main(String args[])
	{
		MathProblem mp = new MathProblem();
		
		JFrame frame = new JFrame("Math Problem");
		frame.setLayout(new FlowLayout()); //add stuff in order you want it to display
		
		JLabel problem = new JLabel("9 * 4 = ");
		frame.add(problem);

		
		final JTextField answer = new JTextField("",5); //initial field,field length
		frame.add(answer);
		
		answer.addFocusListener(mp.new JTextFieldFocusListener(answer)); //call created class
		
		JButton check = new JButton("Check Answer");
		frame.add(check);
		
		final JLabel result = new JLabel("     "); //may not display if empty
		frame.add(result);
		
		check.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int decNum = Integer.parseInt(answer.getText());
				
				if (decNum == 36)
				{
					result.setText("Correct!");
				}
				else
				{
					result.setText("Try Again");
				}
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setVisible(true);
	}
	
	//inner class inside a class 
	protected class JTextFieldFocusListener implements FocusListener
	{
		JTextField textField;
		
		public JTextFieldFocusListener(JTextField text)
		{
			textField = text;
		}
		
		public void focusLost(final FocusEvent pE){} //do nothin
		public void focusGained(final FocusEvent pE){
			textField.selectAll();
		}
	}
}
