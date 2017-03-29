import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
public class AnimationTester
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame();
		final MoveableShape shape = new CarShape(0,0,CAR_WIDTH); //makes a car that moves
		
		Icon icon = new DrawingCanvasIcon(shape,ICON_WIDTH,ICON_HEIGHT);	//draws the car

		final JLabel label = new JLabel(icon);	//car is inside a label

		frame.setLayout(new FlowLayout());
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

		final int DELAY = 100;	//ms between timer tickets

		Timer t = new Timer(DELAY, new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				shape.translate(1,0);
				label.repaint();
			}
		});
		t.start();
	}
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
}
