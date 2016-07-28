package ch03.sec1.test3;

import ch03.sec1.test2.IStack;

/**
 * 3.1.栈
 * 3.1.3.顺序
 * ->1.顺序栈类的描述
 * ->在顺序表上实现的栈及其基本操作
 * ->所有有关顺序栈操作算法的时间复杂度都为O(1)。
 * ->2.顺序栈基本操作的实现
 * ->[算法3.1].顺序栈的入栈操作算法。
 * ->[算法3.2].顺序栈的出栈操作算法。
 */
public class SqStack implements IStack {
	private Object[] stackElem;	// 栈存储空间
	private int top;	// 非空栈中始终表示栈顶元素的下一个位置，当栈为空时其值为0
	
	// 栈的构造函数，构造一个存储空间容量为maxSize的栈
	public SqStack(int maxSize) {
		top = 0;	// 初始化top为0
		stackElem = new Object[maxSize];	// 为栈分配maxSize个存储单元
	}

	// 将一个已经存在的栈置成空
	@Override
	public void clear() {
		top = 0;
	}

	// 测试栈是否为空
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	// 求栈中的数据元素个数并由函数返回其值
	@Override
	public int length() {
		return top;
	}

	// 查看栈顶对象而不移除它，返回栈顶对象
	@Override
	public Object peek() {
		if (!isEmpty()) 	// 栈非空
			return stackElem[top - 1];	// 栈顶元素
		else 	// 栈为空
			return null;
	}

	// 2.顺序栈基本操作的实现
	// [算法3.1].顺序栈的入栈操作算法。
	// 把项压入栈顶
	@Override
	public void push(Object o) throws Exception {
		if (top == stackElem.length) 	// 栈满
			throw new Exception("栈已满");	// 输出异常
		else 	// 栈未满
			stackElem[top++] = o;	// o复制给栈顶元素后，top增1
	}

	// 2.顺序栈基本操作的实现
	// [算法3.2].顺序栈的出栈操作算法。
	// 移除栈顶对象并作为此函数的值返回该对象
	@Override
	public Object pop() {
		if (top == 0) 	// 栈为空
			return null;
		else 	// 栈非空
			return stackElem[--top];	// 修改栈顶指针，返回栈顶元素
	}

	// 打印函数，打印所有栈中的元素(栈顶到栈底)
	@Override
	public void display() {
		for (int i = top - 1; i >= 0; i--) 
			System.out.println(stackElem[i].toString() + " ");	// 打印
	}

}
