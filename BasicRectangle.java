import java.awt.Color;
import java.awt.Graphics;

public class BasicRectangle extends BasicShape{
	
	public BasicRectangle(Graphics g) {
		super(g);
		x=5;
		y=5;
		paintComponent(g);
	}
	public BasicRectangle(Graphics g, int x, int y, int width, int height, Color c) {
		super(g,x,y,width,height,c);
		paintComponent(g);
	}
	public BasicRectangle(Graphics g, int x, int y, int width, int height, Color c,boolean fill) {
		super(g,x,y,width,height,c,fill);
		paintComponent(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		if(fillShape) {
			g.fillRect(x, y,width,height);
		}
		else {
			g.drawRect(x, y, width, height);
		}
	}
}
