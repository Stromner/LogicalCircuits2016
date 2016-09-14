package graphical.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import graphical.DesignPanel;

/**
 * View for creating new components in. 
 * 
 * @author David Strömner
 */

public class BasicWindow {
	private JFrame frame;
	private Menu menu;
	
	public BasicWindow(){
		frame = new JFrame("Logical Circuits 2016");
		menu = new Menu(frame);
		DesignPanel panel = new DesignPanel(); // TODO Move somewhere else, should not be a part of the basic window
		frame.add(panel);
		
		frame.setSize(800,800); // TODO set window start size to the minimum size to fit the basic components in
		frame.setVisible(true);
		// Close program upon exit from window
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });
	}
}
