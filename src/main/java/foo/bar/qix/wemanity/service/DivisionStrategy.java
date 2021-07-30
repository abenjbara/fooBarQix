package foo.bar.qix.wemanity.service;

public class DivisionStrategy implements Strategy{

	/**
	 * check if the operation is divisible
	 */
	@Override
	public String compute(String input, Operation operation) {
		String div = "";
		if( Integer.valueOf(input) % Integer.valueOf(operation.getValue()) == 0) {
			div = operation.getIndex();
		}
		return div;
	}

}
