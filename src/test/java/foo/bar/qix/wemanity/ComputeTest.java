package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.service.ByFive;
import foo.bar.qix.wemanity.service.BySeven;
import foo.bar.qix.wemanity.service.ByThree;
import foo.bar.qix.wemanity.service.Compute;
import foo.bar.qix.wemanity.service.Operation;
import foo.bar.qix.wemanity.utils.Constants;

/**
 * 
 * @author abenjbara
 * 
 * Unit tests
 */
@SpringBootTest
public class ComputeTest {
	
	List<Operation> operations = Arrays.asList(new ByThree(),new ByFive(), new BySeven());
	
	@Test
	public void should_write_foo_when_the_number_is_divisible_by_3(){
		// given
		String input = "3";
		Compute compute = new Compute(input,operations);
		
		//when
		compute.computeDivisible();
		
		// then
		assertThat(compute.getOutput()).contains(Constants.FOO);		
	}
	
	@Test
	public void should_calculate_recurrence() {
		String input = "563";
		Compute compute = new Compute(input,operations);

		compute.computeOccurrences();
		
		assertThat(compute.getOutput()).isNotEmpty();
		assertThat(compute.getOutput().toString()).isEqualTo(Constants.FOO+Constants.BAR);
	}
	
	@Test
	public void should_write_bar_when_the_number_is_divisible_by_5(){
		String input = "5";
		Compute compute = new Compute(input,operations);		
		
		compute.computeDivisible();
		
		String output = compute.getOutput().toString();
		assertThat(output).contains(Constants.BAR);
		assertThat(output).doesNotContain(Constants.FOO);
	}
	
	@Test
	public void should_write_qix_when_the_number_is_divisible_by_7() {
		String input = "7";
		Compute compute = new Compute(input,operations);		
		
		compute.computeDivisible();
		
		String output = compute.getOutput().toString();
		assertThat(output).contains(Constants.QIX);
	}
	
	@Test
	public void should_write_the_same_number_when_its_not_divisible_by_3_5_or_7() {
		String input = "8";
		Compute compute = new Compute(input,operations);
		compute.checkOuput();
		
		assertThat(compute.getOutput().toString()).isEqualTo(input);
	}
	
	
	@Test
	public void should_trace_zero_when_input_is_number() {
		String reference = "1001";
		Compute compute = new Compute(reference,operations);
 
		compute.checkOuput();
		String result = compute.replaceZeros();
		
		assertThat(result).isEqualTo("1**1");
		assertThat(StringUtils.countOccurrencesOf(result, "*")).isEqualTo(2l);
	}
	
	@Test
	public void should_trace_zero_when_input_is_not_number() {
		String reference = "1001";
		Compute compute = new Compute(reference,operations);
		compute.setOutput(new StringBuilder("FooBarQix"));
		
		String result = compute.replaceZeros();
		assertThat(StringUtils.countOccurrencesOf(result, "*")).isEqualTo(2l);
	}
	
}
