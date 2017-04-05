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
	   }
	   
	   @Test
	   public void testCalculatorSub() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3-4");
	      assertThat(output, is(-1));
	   }

	   @Test
	   public void testCalculatorMul() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("5*6");
	      assertThat(output, is(30));
	   }
	   
	   @Test
	   public void testCalculatorDiv() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("6/2");
	      assertThat(output, is(3));
	   }

	   @Test
	   public void testCalculator() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3+2*(5-2)+3*2");
	      assertThat(output, is(15));
	   }

	   @Test
	   public void testCalculator2() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3+2*((5-2)+3)*2");
	      assertThat(output, is(27));
	   }

	   @Test
	   public void testCalculator3() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(3+2)*((5-2)+3)*2");
	      assertThat(output, is(60));
	   }

	   @Test
	   public void testCalculator4() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(5+3)*2");
	      assertThat(output, is(16));
	   }

	   @Test
	   public void testCalculator5() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(5+3)/2");
	      assertThat(output, is(4));
	   }

	   @Test
	   public void testCalculator6() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(3+2)*((5-2)+3)*2+3+2*((5-2)+3)*2");
	      assertThat(output, is(87));
	   }

	   @Test
	   public void testCalculator7() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(3+2)*((5-2)+3)*2+3");
	      assertThat(output, is(63));
	   }

	   @Test
	   public void testCalculator8() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(3+2)*((5-2)+3)*2+3*3");
	      assertThat(output, is(69));
	   }

	   @Test
	   public void testCalculator9() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3+2*((5-2)+3)*2+3*3");
	      assertThat(output, is(36));
	   }

	   @Test
	   public void testCalculator10() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3+2*((5-2)+3)*2*2");
	      assertThat(output, is(51));
	   }

	   @Test
	   public void testCalculator11() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("3+2*((5-2)+3)*2/9+4");
	      assertThat(output, is(7));
	   }

	   @Test
	   public void testCalculator12() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("2*((5-2)+3)*2/9+6");
	      assertThat(output, is(6));
	   }

	   @Test
	   public void testCalculator13() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(5+3)/2+(5+3)*2");
	      assertThat(output, is(20));
	   }

	   @Test
	   public void testCalculator14() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(5+3)/2+(5+3)");
	      assertThat(output, is(12));
	   }

	   @Test
	   public void testCalculator15() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(5+3)*2+(5+3)");
	      assertThat(output, is(24));
	   }
	   
	   @Test
	   public void testCalculator16() {
	      Calculator calc = new Calculator();
	      int output = calc.calculate("(12*(6-3))+4*3");
	      assertThat(output, is(48));
	   }
   @Test
    public void testCalculator17() {
       Calculator calc = new Calculator();
       int output = calc.calculate("(5+3)/2+(5+3)");
       assertThat(output, is(12));
    }

    @Test
    public void testCalculatorAdd18() {
       Calculator calc = new Calculator();
       int output = calc.calculate("(5+3)*2+(5+3)");
       assertThat(output, is(24));
    }
    
    @Test
    public void testCalculatorAdd19() {
       Calculator calc = new Calculator();
       int output = calc.calculate("8*2-(5+3)/2");
       assertThat(output, is(12));
    }
    
    @Test
    public void testCalculatorAdd20() {
       Calculator calc = new Calculator();
       int output = calc.calculate("3+(5-1)*4");
       assertThat(output, is(19));
    }
}
