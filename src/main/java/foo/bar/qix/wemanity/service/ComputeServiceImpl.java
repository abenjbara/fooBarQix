package foo.bar.qix.wemanity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.utils.Constants;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	
	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		List<String> listDetails = new ArrayList<>();
		int number = Integer.valueOf(input);
				
		if(number % Constants.THREE == ZERO) {
			output.append(Constants.FOO);
			listDetails.add(Constants.DIVISIBLE + 3);
		}
		if(number % Constants.FIVE == ZERO) {
			output.append(Constants.BAR);
			listDetails.add(Constants.DIVISIBLE + 5);
		}
		if(number % Constants.SEVEN == ZERO) {
			output.append(Constants.QIX);
			listDetails.add(Constants.DIVISIBLE + 7);
		}
		
		listDetails.addAll(this.calculateOccurrence(input, output));
		
		// sinon on retourne le meme numero
		if(output.isEmpty()) {
			return input;
		}
		
		String result =  output.append(BuildDetails(listDetails)).toString();
		System.out.println("result:   " + result);
		return result;
	}
	
	/**
	 * @param input
	 * @param output 
	 * @param reference
	 * @return le nombre d'occurences dans une chaine de caractères
	 */
	@Override
    public List<String> calculateOccurrence(String input, StringBuilder output) {
    	List<String> recurrences = new ArrayList<>();
    	for(int n: Constants.DIVIDERS) {
    		long count = StringUtils.countOccurrencesOf(input, String.valueOf(n));	
    		System.out.println(n + "occure " + count + " times");
    		if(count > 0) {
    			
    			for (int i = 1; i <= count; i++) {
    				output.append(Constants.getStringvalueof(n));
    			}
    			String countString = count > 1 ? count + " " : "";
    			recurrences.add(Constants.CONTAINS + countString + String.valueOf(n));
    		}
    	}
    	
		return recurrences;
	}

    /**
     * Construit le output a partir d'une liste de String
     * @param listDetails
     */
	private String BuildDetails(List<String> listDetails) {
		StringBuilder details = new StringBuilder();
		
		if(!listDetails.isEmpty()) {
			details.append(" (");
			for(String d: listDetails) {
				if(!d.isEmpty()) {
					details.append(d + ",");
				}
			}
			
			details.deleteCharAt(details.length() -1); // suppression de la derniere virgule
			
			details.append(")");
		}
		return details.toString();
	}
	
}
