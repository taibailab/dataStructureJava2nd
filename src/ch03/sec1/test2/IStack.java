package ch03.sec1.test2;

/**
 * 第3章.栈与队列
 * 3.1.栈
 * 3.1.1.栈的概念
 * 3.1.2.栈的抽象数据类型描述
 * ->栈的接口
 */
public interface IStack {
	// 将一个已经存在的栈置成空
	public void clear();
	
	// 测试栈是否为空
	public boolean isEmpty();
	
	//求栈中的数据元素个数并由函数返回其值
	public int length();
	
	// 查看栈顶对象而不移除它，返回栈顶对象
	// 取栈顶元素操作peek(): 读取栈顶元素并返回其值，若栈为空，则返回null。
	public Object peek();
	
	// 把项压入栈顶
	// 入栈操作push(x): 将数据元素压入栈顶。
	public void push(Object x) throws Exception;
	
	// 移除栈顶对象并作为此函数的值返回该对象
	// 出栈操作pop(); 删除并返回栈顶元素
	public Object pop();
	
	// 打印函数，打印所有栈中的元素(栈底到栈顶)
	public void display();

}
