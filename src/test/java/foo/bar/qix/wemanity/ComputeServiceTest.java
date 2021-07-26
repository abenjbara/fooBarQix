package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import foo.bar.qix.wemanity.service.ComputeService;
import foo.bar.qix.wemanity.utils.Constants;

@SpringBootTest
public class ComputeServiceTest {
	
	@Autowired
	private ComputeService computeService;
	
	@Test
	public void should_write_foo_when_the_number_is_divisible_by_3(){
		// given
		String input = "3";
		
		// when
		String output = computeService.compute(input);
		
		// then
		assertThat(output).contains(Constants.FOO);		
	}
	
	@Test
	public void should_calculate_recurrence() {
		String input = "563";
		StringBuilder output = computeService.calculateOccurrence(input);

		assertThat(output).isNotEmpty();
		assertThat(output.toString()).isEqualTo(Constants.FOO+Constants.BAR);
	}

	@Test
	public void should_write_bar_when_the_number_is_divisible_by_5(){
		String input = "5";
		String output = computeService.compute(input);
		assertThat(output).contains(Constants.BAR);		
	}
	
	@Test
	public void should_write_qix_when_the_number_is_divisible_by_7() {
		String input = "7";
		String output = computeService.compute(input);
		assertThat(output).contains(Constants.QIX);
	}
	
	
	@Test
	public void should_write_the_same_number_when_its_not_divisible_by_3_5_or_7() {
		String input = "8";
		String output = computeService.compute(input);	
		assertThat(output).isEqualTo(input);
	}
	
	@Test
	public void should_add_foo_for_each_digit_3() {
		String input = "3";
		String output = computeService.compute(input);	
		assertThat(output).contains(Constants.FOO+Constants.FOO);
	}
	
}
