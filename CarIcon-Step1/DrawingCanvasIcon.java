import java.awt.*;
import java.swing.*;

public class DrawingCanvasIcon implements Icon
{
	public DrawingCanvasIcon(MoveableShape shape, int width, int height)
	{
		this.shape = shape;
		this.width = width;
		this.height = height;
	}
	public int getIconWidth()
	{	return width;}
	public int getIconHeight()
	{	return height;}
	public void paintIcon(Component C, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;
		shape.draw(g2);
	}
	private int width;
	private int height;
	private MoveableShape shape;
}
