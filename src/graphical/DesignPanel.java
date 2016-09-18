package graphical;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import graphical.ui.Toolbox;

/**
 * Panel containing the components to create new .block components.
 * 
 * @author David Strömner
 */

public class DesignPanel extends JPanel{
	private static final long serialVersionUID = 2377418960000552338L;
	private JPanel toolbox, canvas;
	private JSplitPane splitPane;

	public DesignPanel(){
		super();
		this.setLayout(new GridBagLayout());
		createToolbox();
		createEmptyCanvas();
		createSplitPane();
	}
	
	private void createToolbox(){
		toolbox = new Toolbox();
		toolbox.setBorder((BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "Toolbox")));
	}
	
	private void createEmptyCanvas(){	
		canvas = new JPanel();
		canvas.setLayout(new BorderLayout());
		JTabbedPane tabBar = new JTabbedPane();
		
		JPanel panel = new JPanel();
		tabBar.addTab("Untitled", null, panel);
		
		canvas.add(tabBar, BorderLayout.CENTER);
	}
	
	private void createSplitPane(){
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, toolbox, canvas);
		splitPane.setDividerSize(5);
		splitPane.setContinuousLayout(true);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(splitPane,c);
	}
}
