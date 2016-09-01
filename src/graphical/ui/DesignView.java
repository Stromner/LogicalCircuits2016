package graphical.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * View for creating new components in. 
 * 
 * @author David Strömner
 */

public class DesignView {
	private JFrame frame;
	private Menu menu;
	
	public DesignView(){
		frame = new JFrame("Logical Circuits 2016");
		menu = new Menu(frame);
		
		frame.setSize(800,800);
		frame.setVisible(true);
		// Close program upon exit from window
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });
	}
}
