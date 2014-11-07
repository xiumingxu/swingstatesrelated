package widgets;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;

import fr.lri.swingstates.canvas.Canvas;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
@SuppressWarnings("serial")
public class PersistentCanvas extends Canvas {

	private ArrayList<CanvasItem> items;

	public PersistentCanvas(int w, int h) {
		super(w,h);
		items = new ArrayList<CanvasItem>();
	}
	
	public PersistentCanvas() {
		super();
		items = new ArrayList<CanvasItem>();
	}

	public CanvasItem getItemAt(Point p) {
		// TODO pick the 2D item under the Point p
		// You can use the function contain(Point p) of each CanvasItem
		for (CanvasItem item : items){
			if (item.contains(p)){
				item.select();
				return item;
			}
		}
		return null;
	}

	public CanvasItem addItem(CanvasItem item) {
		if (item == null)
			return null;
		items.add(item);
		repaint();
		return item;
	}

	public void removeItem(CanvasItem item) {
		if (item == null)
			return;
		items.remove(item);
		repaint();
	}

	public void paint(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		for (CanvasItem item : items)
			item.paint(g);
	}

}
