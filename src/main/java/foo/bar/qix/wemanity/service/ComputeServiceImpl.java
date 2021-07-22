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
		
		if(number % 3 == ZERO) {
			output.append(Constants.FOO);
			listDetails.add(Constants.DEVISIBLE + 3);
			listDetails.add(calculateOccurrence(input, "3"));
		}
		
		String result =  output.append(BuildDetails(listDetails)).toString();
		System.out.println("result:   " + result);
		return result;
	}
	
	/**
	 * @param input
	 * @param reference
	 * @return le nombre d'occurences dans une chaine de caractères
	 */
    private String calculateOccurrence(String input, String reference) {
    	long count = StringUtils.countOccurrencesOf(input, reference);
		String countString = count > 1 ? count + " " : "";
		return  count > 0 ? Constants.CONTAINS + countString + reference : "";
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
