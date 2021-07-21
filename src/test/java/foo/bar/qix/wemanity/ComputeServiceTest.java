package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import foo.bar.qix.wemanity.service.ComputeService;

@SpringBootTest
public class ComputeServiceTest {
	
	@Autowired
	private ComputeService computeService;
	
	@Test
	public void sould_write_foo_when_the_number_is_devisible_by_3(){
		// given
		String input = "3";
		
		// when
		String output = computeService.compute(input);
		
		//then
		assertThat(output).contains("Foo");
		
	}

}
