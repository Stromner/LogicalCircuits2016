package data;



/**
 * Class containing the basic building blocks for logical circuits (AND, OR, XOR, NOT). The
 * input signals to the block can be set separately through {@link #setInputSignals(Cable, 
 * Cable)} if none exist when creating the block. Other blocks can be connected to this block by
 * adding the cable that's returned from {@link #getOutput()} to one of its input.
 * <P>
 * Once the input cables have been set a signal through the block can be simulated by calling 
 * {@link #simulateNextCycle()}.
 * 
 * @author David Strömner
 */

public class TwoInputBlock implements java.io.Serializable{
	private static final long serialVersionUID = 8227115129599814838L;
	private Cable inputOne, inputTwo, output;
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
		
		output = new Cable(0);
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
		
		output = new Cable(0);
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
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
	 * Update the output with the current input for this block.
	 */
	public int simulateNextCycle(){
		output.writeSignal(op.apply(inputOne.readSignal(), inputTwo.readSignal()));
		
		return output.readSignal();
	}
	
	public Cable getOutput(){
		return output;
	}
	
	public Cable getInputOne(){
		return inputOne;
	}
	
	public Cable getInputTwo(){
		return inputTwo;
	}
	
	public boolean isStartingBlock(){
		return startingBlock;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		result = 37*result+output.readSignal();
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
		return output.readSignal() == tib.output.readSignal() && inputOne.hashCode() == tib.inputOne.hashCode() && 
				inputTwo.hashCode() == tib.inputTwo.hashCode() && 
				startingBlock == tib.startingBlock && id == tib.id;
	}
}
