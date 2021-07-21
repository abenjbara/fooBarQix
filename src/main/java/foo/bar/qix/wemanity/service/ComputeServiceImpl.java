package foo.bar.qix.wemanity.service;

import org.springframework.stereotype.Service;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		int number = Integer.valueOf(input);
		
		if(number % 3 == ZERO) {
			output.append("Foo");
		}
		
		return output.toString();
	}

}
