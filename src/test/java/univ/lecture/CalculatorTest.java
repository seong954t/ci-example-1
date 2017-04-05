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

		output = calc.calculate("3-4");
		assertThat(output, is(-1));
		
		output = calc.calculate("5*6");
		assertThat(output, is(30));
		
		output = calc.calculate("6/2");
		assertThat(output, is(3));
		
		output = calc.calculate("3+2*(5-2)+3*2");
		assertThat(output, is(15));

		output = calc.calculate("3+2*((5-2)+3)*2");
		assertThat(output, is(27));
		
		output = calc.calculate("(3+2)*((5-2)+3)*2");
		assertThat(output, is(60));
		
		output = calc.calculate("(5+3)*2");
		assertThat(output, is(16));
		
		output = calc.calculate("(5+3)/2");
		assertThat(output, is(4));
		
		output = calc.calculate("(3+2)*((5-2)+3)*2+3+2*((5-2)+3)*2");
		assertThat(output, is(87));
		
		output = calc.calculate("(3+2)*((5-2)+3)*2+3");
		assertThat(output, is(63));
		
		output = calc.calculate("(3+2)*((5-2)+3)*2+3*3");
		assertThat(output, is(69));
		
		output = calc.calculate("3+2*((5-2)+3)*2+3*3");
		assertThat(output, is(36));
		
		output = calc.calculate("3+2*((5-2)+3)*2*2");
		assertThat(output, is(51));
		
		output = calc.calculate("3+2*((5-2)+3)*2/9+4");
		assertThat(output, is(7));
		
		output = calc.calculate("2*((5-2)+3)*2/9+6");
		assertThat(output, is(6));
		
		output = calc.calculate("(5+3)/2+(5+3)*2");
		assertThat(output, is(20));
		
		output = calc.calculate("(5+3)/2+(5+3)");
		assertThat(output, is(12));
		
		output = calc.calculate("(5+3)*2+(5+3)");
		assertThat(output, is(24));
		
		output = calc.calculate("(12*(6-3))+4*3");
		assertThat(output, is(48));
		
		output = calc.calculate("(5+3)/2+(5+3)");
		assertThat(output, is(12));
		
		output = calc.calculate("(5+3)*2+(5+3)");
		assertThat(output, is(24));
		
		output = calc.calculate("8*2-(5+3)/2");
		assertThat(output, is(12));
		
		output = calc.calculate("3+(5-1)*4");
		assertThat(output, is(19));
		
		output = calc.calculate("7-(6+3)/2+1");
		assertThat(output, is(4));
		
		output = calc.calculate("8+1*2*(3+(7-1))");
		assertThat(output, is(26));
		
		output = calc.calculate("(4-2)+8/2");
		assertThat(output, is(6));
	}

}
