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
	 * @return le nombre d'occurences dans une chaine de caractères
	 */
	StringBuilder calculateOccurrence(String input);

}
