package foo.bar.qix.wemanity.service;

public interface ComputeService {

	/**
	 * 
	 * @param input
	 * @return une chaine de caractère en fonction du input
	 */
	String compute(String input);

	/**
	 * @param input
	 * @param output 
	 * @param reference
	 * @return “Foo”, “Bar”, “Qix” pour chaque nombre 3,5, 7
	 */
	StringBuilder getOccurrences(String input);

	/**
	 * replace each 0 in the output by '*'
	 * @param input
	 * @param output
	 * @return 
	 */
	String replaceZeros(String input, String output);

}
