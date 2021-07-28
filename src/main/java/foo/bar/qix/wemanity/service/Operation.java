package foo.bar.qix.wemanity.service;

import org.springframework.util.StringUtils;


public class Operation {
	
	protected String index;
	
	protected String value;
	
	public StringBuilder getOccurrences(String input) {
		StringBuilder recurrence = new StringBuilder();
		long count = StringUtils.countOccurrencesOf(input, this.value);		
		for (int i = 1; i <= count; i++) {
			recurrence.append(this.index);
		}
		return recurrence;
	}
	
	public String checkDivisible(Integer input) {
		String div = "";
		if(input % Integer.valueOf(this.value) == 0) {
			div = this.index;
		}
		return div;
	}
	
	
	
}
