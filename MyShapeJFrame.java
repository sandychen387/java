import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyShapeJFrame extends JFrame{
	
	public MyShapeJFrame() {
		JPanel mainJP=new JPanel();
		mainJP.setLayout(new GridLayout(1,2));
		
		MyShapePanel shapeJP=new MyShapePanel();
		shapeJP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		MyShapePanelResponsive shapeRespJP=new MyShapePanelResponsive();
		shapeRespJP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		mainJP.add(shapeJP);
		mainJP.add(shapeRespJP);
		add(mainJP);
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
