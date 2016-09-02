package graphical;

import graphical.ui.Toolbox;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Panel containing the components to create new .block components.
 * 
 * @author David Strömner
 */

public class DesignPanel extends JPanel{
	private static final long serialVersionUID = 2377418960000552338L;
	private JPanel toolbox, canvas;

	public DesignPanel(){
		super();
		this.setLayout(new GridBagLayout());
		createToolbar();
		createEmptyCanvas();
	}
	
	private void createToolbar(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		toolbox = new Toolbox(c);
		toolbox.setBorder((BorderFactory.createTitledBorder("Toolbar")));
		this.add(toolbox, c);
	}
	
	private void createEmptyCanvas(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		canvas = new JPanel();
		canvas.setLayout(new BorderLayout());
		JTabbedPane tabBar = new JTabbedPane();
		
		JPanel panel = new JPanel();
		tabBar.addTab("Untitled", null, panel);
		
		canvas.add(tabBar, BorderLayout.CENTER);
		this.add(canvas, c);
	}
}
