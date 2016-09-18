package graphical.ui;

import graphical.WrapLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Extension of {@link JPanel} that adds a toggle panel by implementing a custom listener for when 
 * the mouse is pressed.
 * 
 * @author David Strömner
 */

public class Toolbox extends JPanel {
	private static final long serialVersionUID = -271110687499847217L;
	
	public Toolbox(){
		super();
		setLayout(new WrapLayout());
		
		// Add components
	}
}
