package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
	public int calculate(String exp) {
	      int data = 0;
	      if (exp.contains(")")) {
	         int q = 0;
	         Stack stack = new Stack<>();
	         while (exp.length() != q) {
	            String calcul = "";
	            char cal;
	            while (exp.length() != q) {
	               if((cal = exp.charAt(q++)) == ')'){
	                  break;
	               }
	               stack.push(cal);
	            }
	            while (!stack.empty()) {
	               if((char) stack.peek() == '('){
	                  stack.pop();
	                  break;
	               }
	               calcul = (char) stack.pop() + calcul;
	            }
	            String v = Integer.toString(calculate(calcul));
	            int i = 0;
	            while(v.length() != i){
	               stack.push(v.charAt(i++));
	            }
	         }
	         exp = "";
	         while (!stack.empty()) {
	            exp = stack.pop()+exp;
	         }
	      }
	      if (exp.contains("+")) {
	         StringTokenizer st = new StringTokenizer(exp, "+");
	         int cal = calculate(st.nextToken());
	         while (st.hasMoreTokens()) {
	            String name = st.nextToken();
	            cal += calculate(name);
	         }
	         data = cal;
	      } else if (exp.contains("-")) {
	         StringTokenizer st = new StringTokenizer(exp, "-");
	         String val = st.nextToken();
	         char set = val.charAt(val.length() - 1);
	         int cal;
	         if (set == '*' || set == '/') {
	            cal = calculate(st.nextToken());
	            val += cal;
	            cal = -calculate(val);
	         } else {
	            cal = calculate(val);
	            if (!st.hasMoreTokens()) {
	               cal = -cal;
	            }
	         }

	         while (st.hasMoreTokens()) {
	            String name = st.nextToken();
	            cal -= calculate(name);
	         }
	         data = cal;
	      } else if (exp.contains("*")) {
	         StringTokenizer st = new StringTokenizer(exp, "*");
	         int cal = calculate(st.nextToken());
	         while (st.hasMoreTokens()) {
	            String name = st.nextToken();
	            cal *= calculate(name);
	         }
	         data = cal;
	      } else if (exp.contains("/")) {
	         StringTokenizer st = new StringTokenizer(exp, "/");
	         int cal = calculate(st.nextToken());
	         while (st.hasMoreTokens()) {
	            String name = st.nextToken();
	            cal /= calculate(name);
	         }
	         data = cal;
	      } else {
	         data = Integer.parseInt(exp);
	      }
	      return data;
	}
}
