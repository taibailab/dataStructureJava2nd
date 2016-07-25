package ch03.sec1.test4;

import ch02.sec3.test1.Node;
import ch03.sec1.test2.IStack;

/**
 * 3.1.栈
 * 3.1.4.链栈及其基本操作的实现
 * ->1.链栈的存储结构
 * ->2.链栈类的描述
 * ->在单链表上实现的栈及其基本操作
 * ->3.链栈基本操作的实现
 * -->1)求链栈的长度操作
 * -->[算法3.3].求链栈的长度操作算法。
 * -->2)链栈的入栈操作
 * -->[算法3.4].链栈的入栈操作算法。
 * -->3)链栈的出栈操作
 * -->[算法3.5].链栈的出栈操作算法。
 */
public class LinkStack implements IStack {
	private Node top;	// 栈顶元素的引用

	// 将一个已经存在的栈置成空
	@Override
	public void clear() {
		top = null;
	}

	// 测试栈是否为空
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	// 3.链栈基本操作的实现
	// 1)求链栈的长度操作
	// [算法3.3].求链栈的长度操作算法。
	// 求栈中的数据元素个数并由函数返回其值
	@Override
	public int length() {
		Node p = top;	// 初始化，p指向栈顶结点，length为计数器
		int length = 0;
		while (p != null) {	// 从栈顶结点向后查找，直到p指向栈顶结点
			p = p.next;	// 指向后继结点
			++length;	// 长度增1
		}
		return length;
	}

	// 查看栈顶对象而不移除它，返回栈顶对象
	@Override
	public Object peek() {
		if (!isEmpty()) 
			return top.data;	// 返回栈顶元素
		else 
			return null;
	}

	// 3.链栈基本操作的实现
	// 2)链栈的入栈操作
	// [算法3.4].链栈的入栈操作算法。
	// 把项压入栈顶
	@Override
	public void push(Object x) {
		Node p = new Node(x);	// 构造一个新的结点
		p.next = top;
		top = p;	// 改变栈顶结点
	}

	// 3.链栈基本操作的实现
	// 3)链栈的出栈操作
	// [算法3.5].链栈的出栈操作算法。
	// 移除栈顶对象并作为此函数的值返回该对象
	@Override
	public Object pop() {
		if (!isEmpty()) {
			Node p = top;	// p指向栈顶结点
			top = top.next;
			return p.data;
		} else 
			return null;
	}

	// 打印函数，打印所有栈中的元素(栈顶到栈底)
	@Override
	public void display() {
		Node p = top;	// p指向栈顶结点，q指向p的下一结点
		while (p != null) {	// 打印所有非空的结点
			System.out.print((p.data.toString() + " "));	// 打印
			p = p.next;	// 指向p下一元素
			
		}
	}

}
