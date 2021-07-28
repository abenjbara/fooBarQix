package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import foo.bar.qix.wemanity.service.ComputeService;
import foo.bar.qix.wemanity.utils.Constants;

/**
 * 
 * @author abenjbara
 * 
 * Integration tests
 */
@SpringBootTest
public class ComputeServiceTest {
	
	@Autowired
	private ComputeService computeService;
	
	
	@Test
	public void should_add_foo_for_each_digit_3() {
		String input = "3";
		String output = computeService.compute(input);	
		assertThat(output).contains(Constants.FOO+Constants.FOO);
	}
	
}
