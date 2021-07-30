package foo.bar.qix.wemanity.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import foo.bar.qix.wemanity.utils.Constants;
import foo.bar.qix.wemanity.utils.InvalidInputException;

@Service
public class ComputeService {

	/**
	 * @param input
	 * @return une chaine de caractère en fonction du input
	 */
	public String compute(String input) throws InvalidInputException {
		
		Operation byThree = new Operation(Constants.FOO, "3");
		Operation byFive = new Operation(Constants.BAR, "5");
		Operation bySeven = new Operation(Constants.QIX, "7");
		
		List<Operation> operations = Arrays.asList(byThree, byFive, bySeven);
		
		Compute compute = new Compute(input,operations);
		
		compute.processCompute(new DivisionStrategy());
		
		compute.processCompute(new ContainsStrategy());
		
		compute.checkOuput();
				
		return compute.replaceZeros();
	}	
	
}
