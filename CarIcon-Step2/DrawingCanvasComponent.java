import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DrawingCanvasComponent extends JFrame
{
	private ArrayList<SelectableShape> shapes;
	private Point mousePoint;

	public DrawingCanvasComponent()
	{
		shapes = new ArrayList<SelectableShape>();

		addMouseListener(new MouseAdaptor()
		{
			public void mousePressed(MouseEvent e)
			{
				mousePoint = e.getPoint();
				for (SelectableShape s: shapes)
				{
					if (s.contains(mousePoint))
						s.setSelected(!s.isSelected());
				}
				repaint();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				Point lastMousePorint = mousePoint;
				mousePoint = e.getPoint();
				for (SelectableShape s : shapes)
				{
					if (s.isSelected())
					{
						double dx = mousePoint.getX() - lastMousePoint.getX();
						double dy = mousePoint.getY() - lastMousePoint.getY();
						s.translate((int)dx , (int)dy);
					}
				}
				repaint();
			}
		});
	}

	public void add(SelectableShape s)
	{
		shapes.add(s);
		repaint();
	}

	public void removeSelected()
	{
		for (int i = shapes.size()-1; i >=0; i--)
		{
			SelectableShape s = shapes.get(i);
			if (s.isSelected()) shapes.remove(i);
		}
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for (SelectableShape s : shapes)
		{
			s.draw(g2);
			if (s.isSelected())
			{
				s.drawSelection(g2);
			}
		}
	}
}	
