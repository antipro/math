/*
 * @author antipro
 * 创建于 2010-8-1
 * TODO
 */
/*
 * @author antipro
 * 创建于 2010-7-30
 * 括号配对的检查Applet
 */
package algorithm.stackandqueue;

import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 括号配对的检查Applet
 */
public class PostfixApplet extends Applet implements ActionListener {

	private static final long serialVersionUID = 3229209006005324850L;

	Label instructionLabel, // 用户输入说明
			inputLabel, // 输入文本框标签
			outputLabel; // 输出文本框标签
	TextField inputField, // 输入文本框
			outputField; // 输出文本框
	PostfixInterpreter PI; // 计算结果的对象

	// applet方法:初始化
	public void init() {
		instructionLabel = new Label("Type an input expression in the box below,and press the Enter key.", Label.CENTER);
		add(instructionLabel);
		inputLabel = new Label(" input:");
		add(inputLabel);
		inputField = new TextField(40);
		add(inputField);
		inputField.addActionListener(this);

		outputLabel = new Label(" output:");
		add(outputLabel);
		outputField = new TextField(40);
		add(outputField);
		inputField.requestFocus();
		PI = new PostfixInterpreter();
	}

	/*
	 * 比较事件
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		PI.setInput(arg0.getActionCommand()); // 将输入字符串发送给比较器
		PI.interpretPostfix(); // 计算
		outputField.setText(PI.getOutput()); // 输出结果
	}
}
