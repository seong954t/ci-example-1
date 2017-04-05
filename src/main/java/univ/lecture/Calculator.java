package univ.lecture;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	public int calculate(String exp) {
		int data;
		if (exp.contains(")")) {
			int q = 0;
			Stack stack = new Stack<>();
			while (exp.length() != q) {
				StringBuilder calcul = new StringBuilder();
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
					calcul.insert(0, (char) stack.pop());
				}
				String v = Integer.toString(calculate(calcul.toString()));
				int i = 0;
				while(v.length() != i){
					stack.push(v.charAt(i++));
				}
			}
			String exp_data = "";
			while (!stack.empty()) {
				exp_data = stack.pop()+exp_data;
			}
			exp = exp_data;
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
				val += Integer.toString(cal);
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
