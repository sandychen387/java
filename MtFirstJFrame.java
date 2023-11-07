import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MtFirstJFrame extends JFrame{
	
	public void MyFirstJFrame() {
		JPanel mainJP = new JPanel();
		mainJP.setBackground(Color.RED);
		
		MyFirstJP jp1=new MyFirstJP();
		jp1.setBackground(Color.BLUE);
		
		MyFirstJP jp2 = new MyFirstJP();
		jp2.setBackground(Color.GREEN);
		
		mainJP.add(jp1);
		mainJP.add(jp2);
		add(mainJP);
		
		setSize(500,500);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
