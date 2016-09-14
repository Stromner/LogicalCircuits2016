import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.UIManager;

import data.Component;
import data.Simulation;
import data.TwoInputBlock;
import graphical.ui.BasicWindow;

/**
 * 
 * @author David Strömner
 */

public class Controller {
	public static void main(String[] args) {
		// Run the UI in its own thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
        			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        		} catch( Exception e ) {
        			e.printStackTrace();
        		}
            	BasicWindow canvas = new BasicWindow();
            }
        });
		
		// Open the schematic for the file received in args[0]
		// and simulate it.
		try {
			List<TwoInputBlock> blocks = Component.loadComponent(args[0]);
			Simulation simulation = new Simulation();
			simulation.simulate(blocks);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Couldn't find the specified class.");
			e.printStackTrace();
			return;
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Couldn't find the file \"" + args[0] + "\".");
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
