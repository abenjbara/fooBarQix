package foo.bar.qix.wemanity.service;

import java.util.List;

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
	List<String> calculateOccurrence(String input, StringBuilder output);

	/**
	 * Construit le output a partir d'une liste de String
	 * @param listDetails
	 */
	void Display(StringBuilder output, List<String> listDetails);

}
