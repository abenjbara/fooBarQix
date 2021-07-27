package foo.bar.qix.wemanity.service;

import org.hibernate.result.Output;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.utils.Constants;
import foo.bar.qix.wemanity.utils.InvalidInputException;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	
	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		int number ; 
		
		// making sure we have correct input format
		try {
			number = Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new InvalidInputException(input + " is not a number");
		}
		
		// check if divisible		
		if(number % Constants.THREE == ZERO) {
			output.append(Constants.FOO);
		}
		if(number % Constants.FIVE == ZERO) {
			output.append(Constants.BAR);
		}
		if(number % Constants.SEVEN == ZERO) {
			output.append(Constants.QIX);
		}
		
		output.append(this.getOccurrences(input));
		
		// otherwise we keep the same input
		if(output.isEmpty()) {
			output = new StringBuilder(input);
		}
		
		return replaceZeros(input, output);
	}
	
	
	private String getStringvalueof(Integer number) {
		switch (number) {
			case Constants.THREE:
				return Constants.FOO;
			case Constants.FIVE:
				return Constants.BAR; 	
			case Constants.SEVEN:
				return Constants.QIX;
		}
		return null;
	}
	
	
	@Override
    public StringBuilder getOccurrences(String input) {
		StringBuilder output = new StringBuilder();
    	for(int n: Constants.DIVIDERS) {
    		long count = StringUtils.countOccurrencesOf(input, String.valueOf(n));		
			for (int i = 1; i <= count; i++) {
				output.append(getStringvalueof(n));
			}			
    	}    
    	return output;
	}


	@Override
	public String replaceZeros(String reference, StringBuilder output) {
		try {
		  // throws exception if the output isn't a number
		  Integer.parseInt(output.toString());
		  return output.toString().replaceAll("0", "*");
		} catch (NumberFormatException nfe) {
			reference.codePoints()
					 .mapToObj(r -> (char) r)
					 .filter(r -> r == '0')
					 .forEach(r -> output.append("*"));
			
			return output.toString();
		}
		
	}
	
}
