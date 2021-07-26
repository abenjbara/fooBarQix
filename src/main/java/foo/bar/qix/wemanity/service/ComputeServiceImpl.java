package foo.bar.qix.wemanity.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.utils.Constants;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	
	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		int number = Integer.valueOf(input);
				
		if(number % Constants.THREE == ZERO) {
			output.append(Constants.FOO);
		}
		if(number % Constants.FIVE == ZERO) {
			output.append(Constants.BAR);
		}
		if(number % Constants.SEVEN == ZERO) {
			output.append(Constants.QIX);
		}
		
		output.append(this.calculateOccurrence(input));
		
		// sinon on retourne le meme numero
		if(output.isEmpty()) {
			return input;
		}
		
		System.out.println("result:   " + output);
		return output.toString();
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
	
	/**
	 * @param input
	 * @param output 
	 * @param reference
	 * @return le nombre d'occurences dans une chaine de caractères
	 */
	@Override
    public StringBuilder calculateOccurrence(String input) {
		StringBuilder output = new StringBuilder();
    	for(int n: Constants.DIVIDERS) {
    		long count = StringUtils.countOccurrencesOf(input, String.valueOf(n));	
    		if(count > 0) {		
    			for (int i = 1; i <= count; i++) {
    				output.append(getStringvalueof(n));
    			}			
    		}
    	}    
    	return output;
	}
	
}
