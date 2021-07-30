package foo.bar.qix.wemanity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import foo.bar.qix.wemanity.service.Compute;
import foo.bar.qix.wemanity.service.ContainsStrategy;
import foo.bar.qix.wemanity.service.DivisionStrategy;
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
	
	Operation byThree = new Operation(Constants.FOO, "3");
	Operation byFive = new Operation(Constants.BAR, "5");
	Operation bySeven = new Operation(Constants.QIX, "7");
	
	List<Operation> operations = Arrays.asList(byThree, byFive, bySeven);
	
	
	@Test
	public void should_calculate_recurrence() {
		String input = "563";
		Compute compute = new Compute(input,operations);

		compute.processCompute(new ContainsStrategy());
		
		assertThat(compute.getOutput()).isNotEmpty();
		assertThat(compute.getOutput().toString()).isEqualTo(Constants.FOO+Constants.BAR);
	}
	
	@Test
	public void should_write_bar_when_the_number_is_divisible_by_5(){
		String input = "5";
		Compute compute = new Compute(input,operations);		
		
		compute.processCompute(new DivisionStrategy());
		
		String output = compute.getOutput().toString();
		assertThat(output).contains(Constants.BAR);
		assertThat(output).doesNotContain(Constants.FOO);
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
