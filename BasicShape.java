import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class BasicShape extends JComponent{
	
	protected int x,y,width,height;
	protected Color color;
	protected boolean fillShape;

	public BasicShape(Graphics g) {
		x=0;
		y=0;
		width=20;
		height=50;
		color=Color.blue;
		fillShape=false;
	}

	public BasicShape(Graphics g,int x,int y,int width,int height,Color c) {
		this.x = x;
		this.y=y;
		this.width=width;
		this.height=height;
		color=c;
		fillShape=false;
	}
	
	public BasicShape(Graphics g,int x, int y, int width, int height, Color c,boolean fill) {
		this.x=x;
		this.y=y;
		this.width= width;
		this.height=height;
		color=c;
		fillShape=fill;
	}
}
