import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFirstJP extends JPanel implements ActionListener{
	
	private JLabel jl1;
	private JButton jbUp,jbDown;
	private int counter =0;
	
	public MyFirstJP() {
		
		setLayout(new GridLayout(3,1));
		jl1.setText("HI");
		jl1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,40));
		
		jbUp=new JButton(" = ");
		jbDown=new JButton(" - ");
		
		jbUp.setForeground(Color.GREEN);
		jbDown.setForeground(Color.RED);
		
		jbUp.addActionListener(this);
		jbDown.addActionListener(this);
		
		jbUp.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
		jbDown.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
		
		add(jl1);
		add(jbUp);
		add(jbDown);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton)e.getSource();
		
		if(btnClicked.equals(jbUp)) {
			counter++;
			jl1.setText("counter = "+counter);
		}
		else if(btnClicked.equals(jbDown)) {
			counter--;
			jl1.setText("counter = "+counter);
		}
		else {
			System.out.println("WHAT WAS CLICKED?"+btnClicked.toString());
		}
	}
	

}
