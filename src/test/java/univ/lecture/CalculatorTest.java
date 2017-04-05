package univ.lecture;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class CalculatorTest {
    @Test
    public void testCalculatorAdd () {
        Calculator calc = new Calculator();
        int output = calc.calculate("1+1");
        assertThat(output, is(2));
    }
    
    public void testCalculatorSub () {
        Calculator calc = new Calculator();
        int output = calc.calculate("8-5");
        assertThat(output, is(3));
    }
    
    public void testCalculatorMul () {
        Calculator calc = new Calculator();
        int output = calc.calculate("8*3");
        assertThat(output, is(24));
    }
    
    public void testCalculatorDiv () {
        Calculator calc = new Calculator();
        int output = calc.calculate("8/4");
        assertThat(output, is(2));
    }
    
    public void testCalculator () {
    	Calculator calc = new Calculator();
        int output = calc.calculate("(12*3)+2*(3-7)*3");
        assertThat(output, is(12));
    }
}
