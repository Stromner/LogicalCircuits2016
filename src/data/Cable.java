package data;

/**
 * Class for simulating a basic cable between an input and output between two {@link TwoInputBlock}.
 * 
 * @author David Strömner
 */

public class Cable {
	private int outSignal;
	private final int id;
	
	public Cable(){
		outSignal = 0;
		id = IDGenerator.getId();
	};
	
	
	/**
	 * Write a new signal on the cable.
	 * @param outSignal value of the signal
	 * @throws IllegalArgumentException if input isn't binary.
	 */
	public void writeSignal(int outSignal){
		if(outSignal != 0 && outSignal != 1){
			throw new IllegalArgumentException("Input can only be 1 or 0.");
		}
		this.outSignal = outSignal;
		
	}
	
	public int readSignal(){
		return outSignal;
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		result = 37*result+id;
		result = 37*result+outSignal;
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
		Cable c = (Cable) o;
		return id == c.id && outSignal == c.outSignal;
	}
}
