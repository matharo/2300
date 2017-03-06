import javax.swing.*;
public class TopHatTester {
	public static void main(String args[])
	{
		JFrame frame = new JFrame();
		
		final Icon topHat = new TopHat(200,200);
		final JLabel label = new JLabel(topHat);  //label contains icon
		
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
