package foo.bar.qix.wemanity.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import foo.bar.qix.wemanity.utils.InvalidInputException;

@Service
public class ComputeService {

	/**
	 * @param input
	 * @return une chaine de caractère en fonction du input
	 */
	public String compute(String input) throws InvalidInputException {
		
		List<Operation> operations = Arrays.asList(new ByThree(),new ByFive(), new BySeven());
		
		Compute compute = new Compute(input,operations);
		
		compute.computeDivisible();
		
		compute.computeOccurrences();
		
		compute.checkOuput();
				
		return compute.replaceZeros();
	}	
	
}
