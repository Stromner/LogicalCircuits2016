import graphical.ui.DesignView;

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
		DesignView canvas = new DesignView();
		
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
		
		/*int kRuns = 5;
		// Run and save a component
		TwoInputBlock b1, b2, b3;
		b1 = new TwoInputBlock(Operations.AND, true);
		b2 = new TwoInputBlock(Operations.XOR, true);
		b3 = new TwoInputBlock(Operations.OR, false);
		
		Cable s1,s2;
		s1 = new Cable(1);
		s2 = new Cable(1);
		
		b1.setInputSignals(s1, b3.getOutput());
		b2.setInputSignals(s2, b3.getOutput());
		b3.setInputSignals(b1.getOutput(), b2.getOutput());
		
		for(int i=0;i<kRuns;i++){
			System.out.print(b1.simulateNextCycle());
			System.out.print(b2.simulateNextCycle());
			System.out.print(b3.simulateNextCycle());
			
			System.out.println("");
		}
		
		List<TwoInputBlock> blocks = new ArrayList<TwoInputBlock>();
		blocks.add(b1);
		blocks.add(b2);
		blocks.add(b3);
		Component.saveComponent("C:/Users/David/Dropbox/SyncOwnComputers/Programming/Eclipse/LogicalCircuits/src/test.block", blocks);
		
		System.out.println("");
		
		// Load and run a component
		try {
			List<TwoInputBlock> blocksN = Component.loadComponent("C:/Users/David/Dropbox/SyncOwnComputers/Programming/Eclipse/LogicalCircuits/src/test.block");
			for(int i=0;i<kRuns;i++){
				for(TwoInputBlock tib:blocksN){
					System.out.print(tib.simulateNextCycle());
				}
				
				System.out.println("");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}*/
	}
}
