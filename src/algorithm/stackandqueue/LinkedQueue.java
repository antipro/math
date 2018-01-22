/*
 * @author antipro
 * 创建于 2010-8-4
 * 队列的链式表示
 */
package algorithm.stackandqueue;

class QueueNode {
	Object item;
	QueueNode link;
}

public class LinkedQueue {
	private QueueNode front; // 指向队列首端元素的引用
	private QueueNode rear; // 指向队列末端元素的引用
	private int count;

	/*-----------------------------------*/
	public boolean empty() {
		return (count == 0);
	}

	public void insert(Object newItem) {
		QueueNode temp = new QueueNode();
		temp.item = newItem;
		temp.link = null;
		if (rear == null) {
			front = rear = temp;
		} else {
			rear.link = temp;
			rear = temp;
		}
		count++;
	}

	public Object remove() {
		if (count == 0) {
			return null;
		} else {
			Object tempItem = front.item;
			front = front.link;
			if (front == null) {
				rear = null;
			}
			count--;
			return tempItem;
		}
	}
}
