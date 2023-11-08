import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyShapePanelResponsive extends JPanel implements MouseLISTENER{
	
	private final int MAX_X,MAX_Y,MAX_SHAPE_WIDTH,MAX_SHAPE_HEIGHT;
	
	public MyShapePanelResponsive() {
		MAX_X=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		MAX_Y=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		MAX_SHAPE_WIDTH=MAX_X/4;
		MAX_SHAPE_HEIGHT=MAX_Y/4;
		
		setPreferredSize(new Dimension(MAX_X/2,MAX_Y/2));
		
		addMouseListener((MouseListener) this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int width=50;
		int height=50;
		int x =e.getX();
		int y = e.getY();
		
		int shiftedX=x-(int)(width/2.0);
		int shiftedY= y-(int)(height/2.0);
		new BasicRectangle(this.getGraphics(),shiftedX,shiftedY,width,height,Color.BLUE,false);
		new BasicOval(this.getGraphics(),shiftedX,shiftedY,width,height,Color.RED,false);
		new BasicTriangle(this.getGraphics(),x,shiftedY,width,height,Color.green,false);
	}

		@Override 
		public void mousePressed(MouseEvent e) {
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
}
