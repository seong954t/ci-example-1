package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class CalculatorTest {

	@Test
	public void testCalculatorAdd() {
		Calculator calc = new Calculator();
		int output = calc.calculate("1+1");
		assertThat(output, is(2));
		output = calc.calculate("3+2*(5-2)+3*2");
		assertThat(output, is(15));
	}

	@Test
	public void testCalculatorSub() {
		Calculator calc = new Calculator();
		int output = calc.calculate("3-4");
		assertThat(output, is(-1));
		output = calc.calculate("3+2*((5-2)+3)*2");
		assertThat(output, is(27));
	}

	@Test
	public void testCalculatorMul() {
		Calculator calc = new Calculator();
		int output = calc.calculate("5*6");
		assertThat(output, is(30));
		output = calc.calculate("(3+2)*((5-2)+3)*2");
		assertThat(output, is(60));
	}

	@Test
	public void testCalculatorDiv() {
		Calculator calc = new Calculator();
		int output = calc.calculate("6/2");
		assertThat(output, is(3));
		output = calc.calculate("(5+3)*2");
		assertThat(output, is(16));
	}
}
