package ch03.sec2.test4;

import ch02.sec3.test1.Node;
import ch03.sec2.test2.IQueue;

/**
 * 3.2.队列
 * 3.2.4.链队列及其基本操作的实现
 * ->1.链队列的存储结构
 * ->2.链队列类的描述
 * ->链队列类
 * ->3.链队列基本操作的实现
 * ->[算法3.8].链队列的入队操作算法。
 */
public class LinkQueue implements IQueue {
	private Node front;	// 队头的引用
	private Node rear;	// 队尾的引用，指向队尾元素

	// 链队列类的构造函数
	public LinkQueue() {
		front = rear = null;
	}

	// 将一个已经存在的队列置成空
	@Override
	public void clear() {
		front = rear = null;
	}

	// 测试队列是否为空
	@Override
	public boolean isEmpty() {
		return front == null;
	}

	// 求队列中的数据元素个数并由函数返回其值
	@Override
	public int length() {
		Node p = front;
		int length = 0;	// 队列的长度
		while (p != null) {	// 一直查找到队尾
			p = p.next;
			++length;	// 长度增1
		}
		return length;
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果此队列为空，则返回null
	@Override
	public Object peek() {
		if (front != null) 	// 队列非空
			return front.data;
		else {
			return null;
		}
	}

	// 移除队列的头并作为此函数的值返回该对象，如果此队列为空，则返回null
	@Override
	public Object poll() {
		if (front != null) {	// 队列非空
			Node p = front;	// p指向队列头结点
			front = front.next;
			if (p == rear) 	// 被删的节点是队尾结点
				rear = null;
			return p.data;
		} else 
			return null;
	}

	// ->3.链队列基本操作的实现
	// ->[算法3.8].链队列的入队操作算法。
	// 把指定的元素插入队列
	@Override
	public void offer(Object o) {
		Node p = new Node(o);	// 初始化新的结点
		if (front != null) {	// 队列非空
			rear.next = p;
			rear = p;	// 改变队列尾的位置
		} else {
			// 队列为空
			front = rear = p;
		}
	}

	// 打印函数，打印所有队列中的元素(队列头到队列尾)
	@Override
	public void display() {
		if (!isEmpty()) {
			Node p = front;
			while (p != rear.next) {	// 从队头到队尾
				System.out.print(p.data.toString() + " ");
				p = p.next;
			}
		} else {
			System.out.println("此队列为空");
		}
	}

}
