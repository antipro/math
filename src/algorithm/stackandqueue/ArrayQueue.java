/*
 * @author antipro
 * 创建于 2010-8-4
 * 队列的顺序表示
  */
package algorithm.stackandqueue;

public class ArrayQueue {
	private int front; // 队列首端元素
	private int rear; // 队列要插入的下一个元素的索引
	private int count; // 队列元素数目
	private int capacity; // 数组容量
	private int capacityIncrement; // 数组容量增幅
	private Object[] itemArray; // 数组
	/*----------------------------*/

	public ArrayQueue() {
		front = 0;
		rear = 0;
		count = 0;
		capacity = 10;
		capacityIncrement = 5;
		itemArray = new Object[capacity];
	}

	public boolean empty() {
		return (count == 0);
	}

	public void insert(Object newItem) {
		// 如果itemArray没有足够的空间，
		// 则通过增幅扩展itemArray
		if (count == capacity) {
			capacity += capacityIncrement;
			Object[] tempArray = new Object[capacity];
			if (front < rear) { // 如果元素位于itemArray[front,rear-1]中
				for (int i = front; i < rear; i++) {
					tempArray[i] = itemArray[i];
				}
			} else { // 否则将元素分为两个区
				for (int i = 0; i < rear; i++) {
					tempArray[i] = itemArray[i];
				}
				for (int i = front; i < count; i++) {
					tempArray[i + capacityIncrement] = itemArray[i];
				}
				front += capacityIncrement; // 然后，将front改为指向其新位置
			}
			itemArray = tempArray;
		}
		// 将newItem插入队列当前元素序列的末端
		// 并将队列数量加一。
		itemArray[rear] = newItem;
		rear = (rear + 1) % capacity;
		count++;
	}

	public Object remove() {
		if (count == 0) { // 如果队列为空，返回null
			return null;
		} else { // 否则返回首端元素
			Object tempItem = itemArray[front];
			front = (front + 1) % capacity;
			count--;
			return tempItem;
		}
	}

}
