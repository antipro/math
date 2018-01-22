/*
 * @author antipro
 * 创建于 2010-8-1
 * 后缀表达式计算类
 */
package algorithm.stackandqueue;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixInterpreter {
	private String postfixString, outputString;

	/*--------------------------------------------------*/
	private boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
	}

	/*--------------------------------------------------*/
	private boolean isSpace(char c) {
		return c == ' ';
	}

	/*---------------------------------------------------*/
	public void interpretPostfix() {
		Stack<Double> evalStack = new Stack<Double>();
		double leftOperand, rightOperand;
		char c;
		StringTokenizer parser = new StringTokenizer(postfixString, "+-*/^ ", true);
		while (parser.hasMoreElements()) { // postfixString有更多的token
			String token = parser.nextToken(); // 得到下一个token
			c = token.charAt(0); // 让c成为token的第一个字符
			if ((token.length() == 1) && isOperator(c)) { // 如果token是一个操作符
				rightOperand = evalStack.pop().doubleValue();
				leftOperand = evalStack.pop().doubleValue();
				switch (c) { // 执行运算
				case '+':
					evalStack.push(leftOperand + rightOperand);
					break;
				case '-':
					evalStack.push(leftOperand - rightOperand);
					break;
				case '*':
					evalStack.push(leftOperand * rightOperand);
					break;
				case '/':
					evalStack.push(leftOperand / rightOperand);
					break;
				case '^':
					evalStack.push(Math.exp(Math.log(leftOperand * rightOperand)));
					break;
				default:
					break;
				}
			} else if ((token.length() == 1) && isSpace(c)) { // 如果token是空格则忽略
				;
			} else { // 如果token是数值则压入堆栈
				evalStack.push(Double.valueOf(token));
			}
		}
		output("Value of postfix expression = " + evalStack.pop()); // 弹出最后的结果
	}

	/*--------------------------------------------*/
	private void output(String s) {
		outputString = s;
	}

	/*--------------------------------------------*/
	public void setInput(String input) {
		postfixString = input;
	}

	public String getOutput() {
		return outputString;
	}
}
