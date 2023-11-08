import java.awt.Color;
import java.awt.Graphics;

public class BasicTriangle extends BasicShape{
	
	public BasicTriangle(Graphics g) {
		super(g);
		int x = 150;
		int y = 150;
		paintComponent(g);
	}

	

	public BasicTriangle(Graphics g, int x, int y, int width, int height, Color c) {
		super(g,x,y,width,height,c);
		paintComponent(g);
	}
	
	public BasicTriangle(Graphics g, int x, int y, int width, int height, Color c, boolean fill) {
		super(g,x,y,width,height,c,fill);
		paintComponent(g);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		int[] xPoints= {x,(x-(int)(width/2.0)),(x+(int)(width/2.0))};
		int[] yPoints= {y,y+height,y+height};
		if(fillShape) {
			g.fillPolygon(xPoints,yPoints,3);
		}
		else {
			g.drawPolygon(xPoints,yPoints,3);
		}
	}

}
