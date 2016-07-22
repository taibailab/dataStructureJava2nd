package ch02.sec3.test1;

/**
 * 2.3.线性表的链式存储及其实现
 * 2.3.1.单链表的表示
 * ->单链表的节点
 */
public class Node {
	public Object data;	// 存放节点值
	public Node next;	// 后继节点的引用
	
	public Node() {	// 无参数时的构造函数
		this(null, null);
	}
	
	public Node(Object data) {	// 构造值为data的节点
		this(data, null);
	}
	
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

}
