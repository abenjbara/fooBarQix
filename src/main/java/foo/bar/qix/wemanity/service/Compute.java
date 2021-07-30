package foo.bar.qix.wemanity.service;

import java.util.ArrayList;
import java.util.List;

import foo.bar.qix.wemanity.utils.InvalidInputException;

public class Compute {
	
	private String input;
	private StringBuilder output;
	private List<Operation> operations;
	
	public Compute(String input, List<Operation> operations) {
		super();
		
		// making sure we have correct input format
		try {
			Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(input + " is not a number");
		}
	
		this.input = input;
		this.output = new StringBuilder();
		this.operations = new ArrayList<>(operations);
	}
	
	/**
	 * Use strategy design pattern
	 * @param strategy
	 */
	public void processCompute(Strategy strategy) {
		for(Operation op: operations) {
			this.output.append(strategy.compute(input, op));
		}
	}
	
	/**
	 * replace each 0 in the output by '*'
	 */
	public String replaceZeros() {
		try {
		  // throws exception if the output isn't a number
		  Integer.parseInt(output.toString());
		  return output.toString().replaceAll("0", "*");
		} catch (NumberFormatException nfe) {
			input.codePoints()
					 .mapToObj(r -> (char) r)
					 .filter(r -> r == '0')
					 .forEach(r -> output.append("*"));
			
			return output.toString();
		}		
	}

	/**
	 * replace the output by input value if it's empty
	 */
	public void checkOuput() {
		if(output.isEmpty()) {
			output =  new  StringBuilder(input);
		}
	}
	
	//   		-------   Getters and Setters   --------
	public StringBuilder getOutput() {
		return output;
	}

	public void setOutput(StringBuilder output) {
		this.output = output;
	}
	
}
