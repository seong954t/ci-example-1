package univ.lecture;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	public int calculate(String exp) {
		int data = 0;
		if (exp.contains(")")) {
			// StringTokenizer st = new StringTokenizer(exp, ")");
			// String cal = st.nextToken();
			// while (st.hasMoreTokens()) {
			// String save = st.nextToken();
			// StringTokenizer st1 = new StringTokenizer(cal, "(");
			// String save1 = st1.nextToken();
			// if (st1.hasMoreTokens()) {
			// String save2 = st1.nextToken();
			// cal = save1 + calculate(save2) + save;
			// } else {
			// cal = calculate(save1) + save;
			// }
			// }
			// exp = cal;
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
				String v = calculate(calcul)+"";
//				do {
//					stack.push(Character.forDigit(v%10, 10));
//					v = v/10;
//				} while (v%10 != 0);
				int i = 0;
				while(v.length() != i){
					stack.push(v.charAt(i++));
				}
			}
			exp = "";
			while (!stack.empty()) {
				exp = stack.pop()+exp;
			}
			// (((3+2)*5)-(2+3))*2
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
