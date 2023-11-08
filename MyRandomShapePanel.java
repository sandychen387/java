import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;

public class MyRandomShapePanel extends JPanel{
	private final int MAX_X,MAX_Y,MAX_SHAPE_WIDTH,MAX_SHAPE_HEIGHT;
	private Random rand;
	
	public MyRandomShapePanel() {
		MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		MAX_SHAPE_WIDTH=MAX_X/4;
		MAX_SHAPE_HEIGHT=MAX_Y/4;
		
		setPreferredSize(new Dimension(MAX_X/2,MAX_Y/2));
		
		rand=new Random();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		for(int i=0;i<1000;i++) {
			Color randColor=new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			new BasicRectangle(g,rand.nextInt(MAX_X),rand.nextInt(MAX_Y),
					rand.nextInt(MAX_SHAPE_WIDTH),rand.nextInt(MAX_SHAPE_HEIGHT),randColor,(i%2==0));
			new BasicOval(g,rand.nextInt(MAX_X),rand.nextInt(MAX_Y),
					rand.nextInt(MAX_SHAPE_WIDTH),rand.nextInt(MAX_SHAPE_HEIGHT),randColor,(i%2==0));
			new BasicTriangle(g,rand.nextInt(MAX_X),rand.nextInt(MAX_Y),
					rand.nextInt(MAX_SHAPE_WIDTH),rand.nextInt(MAX_SHAPE_HEIGHT),randColor,(i%2==0));
		}
	}
}
