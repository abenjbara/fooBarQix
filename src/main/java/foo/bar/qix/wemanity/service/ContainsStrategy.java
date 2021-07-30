package foo.bar.qix.wemanity.service;

import org.springframework.util.StringUtils;

public class ContainsStrategy implements Strategy{

	/**
	 * check if it contains occurrences of some values
	 */
	@Override
	public String compute(String input, Operation operation) {
		
		StringBuilder recurrence = new StringBuilder();
		long count = StringUtils.countOccurrencesOf(input, operation.getValue());		
		for (int i = 1; i <= count; i++) {
			recurrence.append(operation.getIndex());
		}
		return recurrence.toString();
	}

}
