package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {

	public int calculate(String exp) {

		return calRPN(infixToPostfix(exp));
	}

	private String infixToPostfix(String exp) {
		Stack<Character> stack = new Stack<>();
		ArrayList<String> postfix = new ArrayList<>();
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < exp.length(); i++) {
			if (isAnOperator(exp.charAt(i))) {
				if (stack.isEmpty()) {
					stack.push(exp.charAt(i));
				} else {
					while (true) {
						if (stack.isEmpty()) {
							stack.push(exp.charAt(i));
							break;
						} else {
							if (precedence(stack.peek()) < precedence(exp.charAt(i))) {
								stack.push(exp.charAt(i));
								break;
							} else
 								postfix.add(stack.pop().toString());
						}

					}
				}
			} else if (exp.charAt(i) == '(') {
				stack.push(exp.charAt(i));
			} else if (exp.charAt(i) == ')') {
				while (!stack.peek().equals('(')) {
					postfix.add(stack.pop().toString());
				}
				if (stack.peek().equals('(')) {
					stack.pop();
				}
			}
			/* 피연산자일 때 */
			else {
				postfix.add(exp.charAt(i)+""); // 후위식 배열에 넣어줌
			}
			/* eos일 때 */
			if (i == exp.length() - 1) {
				while (!stack.isEmpty()) {
					postfix.add(stack.pop().toString());
				}
			}
		}
		for(int i = 0; i < postfix.size(); i++){
			stringBuffer.append(postfix.get(i));
		}
		return stringBuffer.toString();
	}

	private int calRPN(String postfix) {
		Stack<String> cal = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char input = postfix.charAt(i);


			if (isAnOperator(input)) {
				int y = Integer.parseInt(cal.pop());
				int x = Integer.parseInt(cal.pop());
				int z = evaluate(x, y, input);
				cal.push(z+"");
			} else
				cal.push(input+"");
		}
		return Integer.parseInt(cal.peek());
	}

	private int evaluate(int x, int y, char op) {
		int z;

		if (op == '+')
			z = x + y;
		else if (op == '-')
			z = x - y;
		else if (op == '*')
			z = x * y;
		else
			z = x / y;
		return z;
	}

	private int precedence(char token) {
		if (token == '+' || token == '-')
			return 2;
		else if (token == '*' || token == '/')
			return 4;
		else
			return 0;
	}

	private boolean isAnOperator(char c) {
		return "+-/*".indexOf(c) >= 0;
	}
}
