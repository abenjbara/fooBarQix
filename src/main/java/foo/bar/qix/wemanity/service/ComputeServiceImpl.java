package foo.bar.qix.wemanity.service;

import org.springframework.stereotype.Service;

import foo.bar.qix.wemanity.utils.Constants;

@Service
public class ComputeServiceImpl implements ComputeService {

	private static final int ZERO = 0;

	@Override
	public String compute(String input) {
		StringBuilder output = new StringBuilder();
		int number = Integer.valueOf(input);
		
		if(number % 3 == ZERO) {
			output.append(Constants.FOO);
		}
		
		return output.toString();
	}

}
