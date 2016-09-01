package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Explanation
 * 
 * @author David Strömner
 */

public class Simulation {	
	/**
	 * Simulate a signal through the system for an eternity.
	 * @param blocks list of all blocks contained in this system.
	 */
	public void simulate(List<TwoInputBlock> blocks){
		List<TwoInputBlock> currentCycle = new ArrayList<TwoInputBlock>(), nextCycle = new ArrayList<TwoInputBlock>();
		// Find the starting blocks
		for(TwoInputBlock block: blocks){
			if(block.isStartingBlock()){
				currentCycle.add(block);
			}
		}
		
		while(true){
			for(TwoInputBlock block: currentCycle){
				System.out.print(block.simulateNextCycle());
				// Find next cycle of blocks
				for(TwoInputBlock org: blocks){
					// Test the input of all blocks, if the input shares a cable with
					// the output of any block in the currentCycle list then add this block
					// to nextCycle list.
					if( org.getInputOne().equals(block.getOutput()) || org.getInputTwo().equals(block.getOutput()) ){
						if(!nextCycle.contains(org)){
							nextCycle.add(org);
						}
					}
				}
			}
			
			// Set nextCyle to currentCycle
			currentCycle.clear();
			currentCycle = new ArrayList<TwoInputBlock>(nextCycle);
			nextCycle.clear();
			System.out.println("");
			
			// DEBUG PURPOSE
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
