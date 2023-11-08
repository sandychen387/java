import java.awt.Color;
import java.awt.Graphics;

public class BasicOval extends BasicShape{
	
	
	public BasicOval(Graphics g) {
		super(g);
		x=105;
		y=125;
		paintComponent(g);
	}
	public BasicOval(Graphics g, int x, int y, int width, int height, Color c) {
		super(g,x,y,width,height,c);
		paintComponent(g);
	}
	public BasicOval(Graphics g, int x, int y, int width, int height, Color c,boolean fill) {
		super(g,x,y,width,height,c,fill);
		paintComponent(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		if(fillShape) {
			g.fillOval(x, y,width,height);
		}
		else {
			g.drawOval(x, y, width, height);
		}
	}
}
