import javax.swing.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class TopHat implements Icon {
	private int width, height;
	
	public TopHat(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public int getIconHeight()
	{
		return height;
	}
	public int getIconWidth()
	{
		return width;
	}
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		//params Rectangle2D.Double(x position, y position, length, width)
		//vert long rectangle on top
		Rectangle2D.Double hatRect = new Rectangle2D.Double(x+width/3,y+height/6,width/3,height/2);
		
		//white rectangle in between
		Rectangle2D.Double bandRect = new Rectangle2D.Double(x+width/3,y+13*height/24,width/3,height/8);
		
		//horz long rectangle on bottom
		Rectangle2D.Double brimRect = new Rectangle2D.Double(x+width/6,y+4*height/6,2*width/3,height/6);
		
		g2.setPaint(Color.BLACK);
		g2.fill(hatRect);
		g2.fill(brimRect);
		
		g2.setPaint(Color.WHITE);
		g2.fill(bandRect);
	}
}
