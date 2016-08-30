package data;

import java.util.HashSet;
import java.util.Set;

/**
 * Class containing the basic building blocks for logical circuits (AND, OR, XOR, NOT). The
 * input signals to the block can be set separately through {@link #setInputSignals(Cable, 
 * Cable)} if none exist when creating the block. Other blocks can be connected to this block
 * through the {@link #addReceivingCable(Cable)} method, to disconnect a cable from this
 * block's output call {@link #removeReceivingCable(Cable)} with the specific {@link Cable} as
 * the parameter.
 * <P>
 * Once the input cables have been set a signal through the block can be simulated by calling 
 * {@link #simulateNextCycle()}.
 * 
 * @author David Strömner
 */

public class TwoInputBlock {
	private int output;
	private Cable inputOne, inputTwo;
	private Set<Cable> recivingCables;
	private Operations op;
	private Boolean startingBlock;
	private final int id;
	
	/**
	 * 
	 * @param op operation that this block performs.
	 * @param startingBlock if true the simulation will start with this block.
	 */
	public TwoInputBlock(Operations op, Boolean startingBlock){
		if(op.equals(Operations.NOT)){
			System.out.println("WARNING: x2 is unconnected in a NOT block");
		}
		
		output = 0;
		recivingCables = new HashSet<Cable>();
		this.op = op;
		this.startingBlock = startingBlock;
		id = IDGenerator.getId();
	}

	/**
	 * 
	 * @param op operation that this block performs.
	 * @param startingBlock if true the simulation will start with this block.
	 * @param inputOne {@link Cable} for the first input.
	 * @param inputTwo {@link Cable} for the first second.
	 */
	public TwoInputBlock(Operations op, Boolean startingBlock, Cable inputOne, Cable inputTwo){
		if(op.equals(Operations.NOT)){
			System.out.println("WARNING: x2 is unconnected in a NOT block");
		}
		
		output = 0;
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		recivingCables = new HashSet<Cable>();
		this.op = op;
		this.startingBlock = startingBlock;
		id = IDGenerator.getId();
	}
	
	/**
	 * Set the input signals for this block
	 * @param inputOne Signal for the first input.
	 * @param inputTwo Signal for the second input.
	 * @throws IllegalArgumentException if input isn't 0 or 1.
	 */
	public void setInputSignals(Cable inputOne, Cable inputTwo){
		if( (inputOne.readSignal() != 0 && inputOne.readSignal() != 1) || (inputTwo.readSignal() != 0 && inputTwo.readSignal() != 1)){
			throw new IllegalArgumentException("Input can only be 1 or 0.");
		}
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
	}
	
	/**
	 * Update the output with the current input for this block. After updating all
	 * cables connected to this output gets updated.
	 */
	public void simulateNextCycle(){
		output = op.apply(inputOne.readSignal(), inputTwo.readSignal());

		for(Cable e: recivingCables){
			e.writeSignal(output);
		}
	}
	
	/**
	 * @return The signal for the output on this block.
	 */
	public int getOutput(){
		return output;
	}
	
	/**
	 * Tries to link a new cable from this blocks output.
	 * @param cable to be added to the output.
	 * @return true if the cable could be added, false otherwise.
	 */
	public boolean addReceivingCable(Cable cable){
		if(recivingCables.contains(cable)){
			System.out.println("WARNING: Cable already exists in the block " + id + '.');
			return false;
		}
		recivingCables.add(cable);
		return true;
	}
	
	/**
	 * Tries to remove a cable from this blocks output.
	 * @param cable to be removed from the output.
	 * @return true if the cable could be removed, false otherwise.
	 */
	public boolean removeReceivingCable(Cable cable){
		if(recivingCables.contains(cable)){
			recivingCables.remove(cable);
			return true;
		}
		System.out.println("WARNING: Cable " + cable.getId() + " already exists in the block " + id + '.');
		return false;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		result = 37*result+output;
		result = 37*result+(inputOne==null ? 0:inputOne.hashCode());
		result = 37*result+(inputTwo==null ? 0:inputOne.hashCode());
		result = 37*result+(startingBlock ? 0:1);
		result = 37*result+id;
		return result;
	}
	
	@Override
	public boolean equals(Object o){
		// Self check
		if(this == o){
			return true;
		}
		// Null check
		if(o == null){
			return false;
		}
		// Type check and cast
		if(getClass() != o.getClass()){
			return false;
		}
		
		// Compare fields
		TwoInputBlock tib = (TwoInputBlock) o;
		return output == tib.output && inputOne.hashCode() == tib.inputOne.hashCode() && 
				inputTwo.hashCode() == tib.inputTwo.hashCode() && 
				startingBlock == tib.startingBlock && id == tib.id;
	}
}
