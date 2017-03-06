import javax.swing.*;
public class IconTester {
	public static void main(String args[])
	{
		JOptionPane.showMessageDialog(null,"Hello World!","Message",JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("globe.png"));
		
		JOptionPane.showMessageDialog(null,"Hello World!","Message",JOptionPane.INFORMATION_MESSAGE,
				new MarsIcon(200));
		
		System.exit(0);
	}
}
