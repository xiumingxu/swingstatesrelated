package widgets;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import fr.lri.swingstates.canvas.Canvas;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
public class RectangleItem extends CanvasItem {

	Point firstpoint;

	public RectangleItem(PersistentCanvas c, Color o, Color f, Point p) {
		super(c, o, f);
		shape = new Rectangle(p.x, p.y, 100, 100);
		firstpoint = p;
	}

	public RectangleItem(RectangleItem other) {
		super(other.canvas, other.outline, other.fill);
		shape = new Rectangle((Rectangle) other.shape);
		isSelected = false;
		firstpoint = other.firstpoint;
	}

	public CanvasItem duplicate() {
		RectangleItem r = new RectangleItem(this);
		((Rectangle) r.shape).x += 2;
		((Rectangle) r.shape).y += 2;
		return canvas.addItem(r);
		
	}

	public void update(Point p) {
		((Rectangle) shape).setFrameFromDiagonal(firstpoint, p);
		canvas.repaint();
	}

	public void move(int dx, int dy) {
		((Rectangle) shape).x += dx;
		((Rectangle) shape).y += dy;
		canvas.repaint();
	}

}
