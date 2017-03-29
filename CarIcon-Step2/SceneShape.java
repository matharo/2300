import java.awt.*;
import java.awt.geom.*;
public interface SceneShape()
{
	void translate(int dx, int dy);

	void draw(Graphics2D g2);
	void drawSelection(Graphics2D g2);	

	boolean isSelected();
	void setSelected();

	boolean contains(Point2D p);
}
