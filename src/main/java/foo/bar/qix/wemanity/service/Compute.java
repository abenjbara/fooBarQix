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
		this.input = input;
		this.output = new StringBuilder();
		this.operations = new ArrayList<>(operations);
	}
	
	/**
	 * check if the operation is divisible
	 * @throws InvalidInputException
	 */
	public void computeDivisible() throws InvalidInputException {
		Integer number;
		// making sure we have correct input format
		try {
			number = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(input + " is not a number");
		}
				
		for(Operation op: operations) {
			output.append(op.checkDivisible(number));
		}
	}
	
	/**
	 * update the operation output if it's contains occurrences
	 */
	public void computeOccurrences() {
		for(Operation op: operations) {
			output.append(op.getOccurrences(input));
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
	
}
