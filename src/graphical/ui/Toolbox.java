package graphical.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Extension of {@link JPanel} that adds a toggle panel by implementing a custom listener for when 
 * the mouse is pressed.
 * 
 * @author David Strömner
 */

public class Toolbox extends JPanel {
	private static final long serialVersionUID = -271110687499847217L;
	private boolean isOpen;
	private GridBagConstraints constraints;
	
	/**
	 * @param constraints use internally to change the width of the panel by modifying the panels {@link GridBagConstraints}.
	 */
	public Toolbox(GridBagConstraints constraints){
		super();
		isOpen = false;
		
		this.constraints = constraints;
		this.addMouseListener(new ToolbarListner());
	}
	
	/**
	 * Change the toolbox from open to close and vice versa.
	 */
	public void toggleStatus(){
		isOpen = isOpen == true ? false:true;
	}
	
	/**
	 * @return true if the toolbox panel is open. False otherwise.
	 */
	public boolean checkOpen(){
		return isOpen;
	}
	
	private class ToolbarListner implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {
			if( ((Toolbox) arg0.getComponent()).checkOpen() ){
				constraints.weightx = 0.1;
			}
			else{
				constraints.weightx= 0.25;
			}
			GridBagLayout bag = (GridBagLayout) arg0.getComponent().getParent().getLayout();
			bag.setConstraints(arg0.getComponent(), constraints);
			arg0.getComponent().getParent().revalidate();
			arg0.getComponent().getParent().repaint();
			((Toolbox) arg0.getComponent()).toggleStatus();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
}
