package foo.bar.qix.wemanity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.utils.Constants;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;
	private static final int THREE = 3;
	private static final int FIVE = 5;

	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		List<String> listDetails = new ArrayList<>();
		int number = Integer.valueOf(input);
		
		if(number % THREE == ZERO) {
			output.append(Constants.FOO);
			listDetails.add(Constants.DEVISIBLE + 3);
	//		listDetails.add(calculateOccurrence(input, "3"));
		}
		if(number % FIVE == ZERO) {
			output.append(Constants.BAR);
			listDetails.add(Constants.DEVISIBLE + 5);
	//		listDetails.add(calculateOccurrence(input, "5"));
		}
				
		listDetails.addAll(this.calculateOccurrence(input));
		
		String result =  output.append(BuildDetails(listDetails)).toString();
		System.out.println("result:   " + result);
		return result;
	}
	
	/**
	 * @param input
	 * @param reference
	 * @return le nombre d'occurences dans une chaine de caractères
	 */
	@Override
    public List<String> calculateOccurrence(String input) {
    	List<String> recurrences = new ArrayList<>();
    	int[] nums = {THREE,FIVE};
    	for(int n: nums) {
    		long count = StringUtils.countOccurrencesOf(input, String.valueOf(n));		
    		if(count > 0) {
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
			details.append("(");
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
