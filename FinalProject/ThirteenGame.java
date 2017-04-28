import javax.swing.JFrame;

public class ThirteenGame {
	
	public static void main (String[] args)
	{
		
		
		
		JFrame frame = new JFrame("Thirteen");
		
		GamePanel game = new GamePanel();
		frame.add(game);
		
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


}
