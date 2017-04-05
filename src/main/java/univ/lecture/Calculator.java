package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {

	public int calculate(String exp) {
		StringTokenizer st = new StringTokenizer(exp, "+-*/()", true);
		ArrayList<String> exps = new ArrayList<>();
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			exps.add(token);
		}
		
		
		return calRPN(infixToPostfix(exps.toArray(new String[exps.size()])));
	}

	private String[] infixToPostfix(String[] exp) {
		Stack<String> stack = new Stack<>();
		ArrayList<String> postfix = new ArrayList<>();
		
		for (int i = 0; i < exp.length; i++) {
			if (isAnOperator(exp[i])) {
				if (stack.isEmpty()) {
					stack.push(exp[i]);
				} else {
					while (true) {
						if (stack.isEmpty()) {
							stack.push(exp[i]);
							break;
						} else {
							if (precedence(stack.peek()) < precedence(exp[i])) {
								stack.push(exp[i]);
								break;
							} else
 								postfix.add(stack.pop());
						}

					}
				}
			} else if (exp[i].equals("(")) {
				stack.push(exp[i]);
			} else if (exp[i].equals(")")) {
				while (!stack.peek().equals("(")) {
					postfix.add(stack.pop().toString());
				}
				if (stack.peek().equals("(")) {
					stack.pop();
				}
			}
			/* 피연산자일 때 */
			else {
				postfix.add(exp[i]); // 후위식 배열에 넣어줌
			}
			/* eos일 때 */
			if (i == exp.length - 1) {
				while (!stack.isEmpty()) {
					postfix.add(stack.pop());
				}
			}
		}

		return postfix.toArray(new String[postfix.size()]);
	}

	private int calRPN(String[] postfix) {
		Stack<String> cal = new Stack<>();

		for (int i = 0; i < postfix.length; i++) {
			String input = postfix[i];


			if (isAnOperator(input)) {
				int y = Integer.parseInt(cal.pop());
				int x = Integer.parseInt(cal.pop());
				int z = evaluate(x, y, input);
				cal.push(z+"");
			} else
				cal.push(input);
		}
		return Integer.parseInt(cal.peek());
	}

	private int evaluate(int x, int y, String op) {
		int z;

		if (op.equals("+"))
			z = x + y;
		else if (op.equals("-"))
			z = x - y;
		else if (op.equals("*"))
			z = x * y;
		else
			z = x / y;
		return z;
	}

	private int precedence(String token) {
		if (token.equals("+") || token.equals("-"))
			return 2;
		else if (token.equals("*") || token.equals("/"))
			return 4;
		else
			return 0;
	}

	private boolean isAnOperator(String s) {
		return "+-/*".indexOf(s) >= 0;
	}
}
