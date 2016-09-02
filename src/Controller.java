import graphical.ui.BasicWindow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import data.Component;
import data.Simulation;
import data.TwoInputBlock;

/**
 * 
 * @author David Strömner
 */

public class Controller {
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
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
