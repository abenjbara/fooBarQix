package foo.bar.qix.wemanity.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final String FOO = "Foo";
	public static final String BAR = "Bar";
	public static final String QIX = "Qix";
	public static final String DIVISIBLE = "divisible by ";
	public static final String CONTAINS = "contains ";
	public static final int THREE = 3;
	public static final int FIVE = 5;
	public static final int SEVEN = 7;
	public static final List<Integer> DIVIDERS = Arrays.asList(THREE,FIVE,SEVEN);
	
	public static String getStringvalueof(Integer number) {
		switch (number) {
		case THREE:
			return FOO;
		case FIVE:
			return BAR; 	
		case SEVEN:
			return QIX;
	
		}
		return null;
	}
}
