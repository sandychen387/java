import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MyShapePanel extends JPanel{

private final int MAX_X,MAX_Y,MAX_SHAPE_WIDTH,MAX_SHAPE_HEIGHT;
	
	public MyShapePanel() {
		MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		MAX_SHAPE_WIDTH=MAX_X/4;
		MAX_SHAPE_HEIGHT=MAX_Y/4;
		
		setPreferredSize(new Dimension(MAX_X/2,MAX_Y/2));
}
	
	@Override
	protected void paintComponent(Graphics g) {
		new BasicRectangle(g);
		new BasicRectangle(g, 75, 100, 50, 20, Color.RED);
		new BasicRectangle(g, 175, 100, 50, 20, Color.RED,true);
		new BasicRectangle(g, 5, 100, 80, 80, Color.BLUE,true);
		
		new BasicOval(g);
		new BasicOval(g, 75, 100, 50, 20, Color.RED);
		new BasicOval(g, 175, 100, 50, 20, Color.RED,true);
		new BasicOval(g, 5, 100, 80, 80, Color.BLUE,true);
		
		new BasicTriangle(g);
		new BasicTriangle(g, 75, 100, 50, 20, Color.RED);
		new BasicTriangle(g, 175, 100, 50, 20, Color.RED,true);
	}
}