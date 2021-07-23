package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
	public void should_write_details_when_the_number_is_divisible_by_3(){
		String input = "3";
		String output = computeService.compute(input);	
		assertThat(output).contains(Constants.DIVISIBLE + input);
	}
	
	@Test
	public void should_calculate_recurrence() {
		String input = "563";
		StringBuilder output =  new StringBuilder("5");
		List<String> recurences = computeService.calculateOccurrence(input, output);

		assertThat(recurences).isNotEmpty();
		assertThat(recurences.size()).isEqualTo(2);
		assertThat(recurences.get(0)).isEqualTo(Constants.CONTAINS + 3);
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
	public void should_write_divisible_when_the_number_is_divisible_by_7() {
		String input = "7";
		String output = computeService.compute(input);	
		assertThat(output).contains(Constants.DIVISIBLE + input);
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
