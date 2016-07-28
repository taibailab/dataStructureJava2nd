package ch03.sec2.test6;

/**
 * 3.2.队列
 * 3.2.6.优先级队列
 * ->1.优先级队列类的描述
 * ->充当优先队列结点类Node的数据域data
 */
public class PriorityQData {
	public Object elem;	// 结点的值
	public int priority;	// 结点的优先级

	// 构造函数
	public PriorityQData(Object elem, int priority) {
		this.elem = elem;
		this.priority = priority;
	}

}
