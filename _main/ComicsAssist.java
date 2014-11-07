package _main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fr.lri.swingstates.canvas.CEllipse;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CSegment;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.Canvas;
import widgets.*;

/**
 * @author Xiuming XU E-mail:gracexuxiuming@gmail.com
 * @version created on：Nov 1, 2014 7:30:16 PM
 */
public class ComicsAssist extends JFrame {
	private JPanel menubar;
	private JPanel tools;
	private JPanel layers;

	private int width;
	private int height;
	
	private JPanel whole;

	// canvas
	private Canvas canvas;
	private Vector<CRectangle> panels;
	
	
	protected String mode;

	// private String mode;// 2 modes, one for Page setting, one for panel

	ComicsAssist(int w, int h) {
		width = w;
		height = h;
		initLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initLayout() {

		// pack();
		Container pane = getContentPane();
		whole = new JPanel(new FlowLayout());
		
		// Create the canvas for drawing
		canvas = new Canvas(300, 300);
		CEllipse u = (CEllipse) canvas.newEllipse(50, 50, 40, 30).setFillPaint(new GradientPaint(50, 50, Color.CYAN, 90, 80, Color.DARK_GRAY));
		CSegment i = (CSegment)canvas.newSegment(200, 50, 250, 110).setStroke(new BasicStroke(2));
		
		Font font = new Font("verdana", Font.PLAIN, 24);
		canvas.newText(30, 200, "Hello", font).setFillPaint(Color.GREEN);
		canvas.newPolyLine(150, 250).lineTo(190, 240).lineTo(200, 200).lineTo(210, 240).lineTo(250, 250).
		lineTo(210, 260).lineTo(200, 300).lineTo(190, 260).close().setFillPaint(Color.YELLOW).setTransparencyFill(0.5f);
		canvas.newRectangle(150, 150, 40, 30).setFillPaint(Color.BLUE);
		
		/******************/
		
		
		whole.add(canvas);
		pane.add(whole);
		setSize(800,600);
		//change item's frame
		setVisible(true);
	}
	private void run(){
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
		});
	}
	/******Listeners********/
	private ActionListener modeListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// TODO you can use the function updateTitle();
			String seMo = e.getActionCommand();
			if (seMo.equals("Select/Move")){
				mode = "Select/Move";
			}else if (seMo.equals("Rectangle")){
				mode = "Rectangle";
			}else if(seMo.equals("Ellipse")){
				mode = "Ellipse";
			}else if(seMo.equals("Line")){
				mode = "Line";
			}else if(seMo.equals("Path")){
				mode = "Path";
			}else if(seMo.equals("Resize")){
				mode = "Resize";
			}else{
			}
		}
	};


	public static void main(String[] args) {
		new ComicsAssist(800, 600);
	}

}
