import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class MarsIcon implements Icon{ //to initialize -- Icon[,Comparable,Serializable...]
	public MarsIcon(int size)
	{
		this.size = size;
	}
	public int getIconWidth()
	{
		return size;
	}
	public int getIconHeight()
	{
		return size;
	}
	public void paintIcon(Component c, Graphics g, int x, int y) //always called by Swing
	{	//programmer never calls this because Swing manages Component and Graphics
		//step 1: switch to Graphics2D (newer, specialized, advanced--subclass of Graphics)
		
		Graphics2D g2 = (Graphics2D)g;
		
		//step 2: draw out the Component--what you want the icon to look like
		//we want a circle and to color it red
		
		Ellipse2D.Double planet = new Ellipse2D.Double(x,y,size,size);
			//x and y = initial positions, relative to top left corner
			//size of circle should fill size of icon area --size
		
		g2.setColor(Color.RED); //current color
		g2.fill(planet); //fill planet with color red, current color
		//g2.draw(planet); //draws outline in current color 
	}
	private int size;
}