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
	public void sould_write_the_same_number_when_its_not_devisible_by_3_5_or_7(){
		// given
		String input = "1";
		
		// when
		String output = computeService.compute(input);
		
		//then
		assertThat(output).isEqualTo(input);		
	}

}
