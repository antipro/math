/*
 * @author antipro
 * 创建于 2010-7-30
 * 括号匹配比较器
 */
package algorithm.stackandqueue;

import java.util.Stack;

public class ParenMatcher {
	private String inputString, outputString;

	/*---------------------------------*/
	private boolean match(char c, char d) { // 当且仅当c和d配对时
		switch (c) { // 验证d是否是c的配对括号
		case '(':
			return (d == ')');
		case '[':
			return (d == ')');
		case '{':
			return (d == ')');
		default:
			return false;
		}
	}// match结束

	/*---------------------------------*/
	/**
	 * 核心验证方法
	 */
	public void parenMatch() {
		Stack<Character> parenStack = new Stack<Character>();
		int n = inputString.length();
		int i = 0;
		char c, d;
		while (i < n) { // 遍历字符串
			d = inputString.charAt(i);
			if (d == '(' || d == '[' || d == '{') {
				parenStack.push(new Character(d)); // 将左括号压入堆栈
			} else if (d == ')' || d == ']' || d == '}') { // 遇到右括号从堆栈中弹出元素对比
				if (parenStack.empty()) { // 堆栈为空不匹配
					output("More right parentheses than left parentheses");
					return;
				} else { // 不为空进行比较
					c = parenStack.pop().charValue();
					if (!match(c, d)) { // 不匹配
						output("Mismatched parentheses: " + c + " and " + d);
						return;
					}
				}
			}
			++i;
		}
		if (parenStack.empty()) { // 堆栈为空表示匹配完毕没有发现错误
			output("Parentheses are balanced properly");
		} else { // 堆栈不为空表示括号数量不对称
			output("More left parentheses than right parentheses");
		}
	}

	/*------------------------------*/
	private void output(String s) {
		outputString = s;
	}

	/*------------------------------*/
	public void setInput(String input) {
		inputString = input;
	}

	/*------------------------------*/
	public String getOutput() {
		return outputString;
	}
}
