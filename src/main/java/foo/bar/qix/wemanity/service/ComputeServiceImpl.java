package foo.bar.qix.wemanity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.utils.Constants;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	/**
	 * 
	 */
	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		List<String> listDetails = new ArrayList<>();
		int number = Integer.valueOf(input);
		
		if(number % 3 == ZERO) {
			output.append(Constants.FOO);
			listDetails.add("divisible by " + number);
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
    public String calculateOccurrence(String input, String reference) {
    	long count = StringUtils.countOccurrencesOf(input, reference);
		//long count = input.chars().filter(ch -> ch == (char) reference).count();
		String countString = count > 1 ? String.valueOf(count) : "";
		return  count > 0 ? "contains " + countString + reference : "";
	}

    /**
     * Construit le output a partir d'une liste de String
     * @param listDetails
     * @return
     */
	public String BuildDetails(List<String> listDetails) {
		StringBuilder details = new StringBuilder();
		details.append("(");
		for(String d: listDetails) {
			if(!d.isEmpty()) {
				details.append(d + ",");
			}
		}
		
		details.append(")");
		return details.toString();
	}
	
}
