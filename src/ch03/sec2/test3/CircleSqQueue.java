package ch03.sec2.test3;

import ch03.sec2.test2.IQueue;

/**
 * 3.2.队列
 * 3.2.3.顺序队列及其基本操作的实现
 * ->1.顺序队列的存储结构
 * ->2.循环顺序队列类的描述
 * -->1)少用一个存储单元
 * ->循环顺序队列类
 * ->3.循环顺序队列基本操作的实现
 * -->1)循环顺序队列的入队操作
 * --->(1)判断循环顺序队列是否为满，若满，则抛出异常后结束操作；否则转(2)。
 * --->(2)先将新的数据元素x存入rear所指示的数组存储位置中，使其成为新的队尾元素，再将rear值循环加1，使rear始终指向队尾的下一个存储位置。
 * --->[算法3.6].循环顺序队列的入队操作算法。
 * -->2)循环顺序队列的出队操作
 * --->(1)判断循环顺序队列是否为空，若为空，则返回空值；否则转(2)。
 * --->(2)先取出front所指的队首元素的值，再将front值循环加1。
 * --->[算法3.7].循环顺序队列的出队操作算法。
 */
public class CircleSqQueue implements IQueue {
	private Object[] queueElem;	// 队列存储空间
	private int front;	// 队首的引用，若队列不空，指向队首元素
	private int rear;	// 队尾的引用，若队列不空，指向队尾元素的下一个位置

	// 循环队列类的构造函数
	public CircleSqQueue(int maxSize) {
		front = rear = 0;	// 队头、队尾初始化为0
		queueElem = new Object[maxSize];	// 为队列分配maxSize个存储单元
	}

	// 将一个已经存在的队列置成空
	@Override
	public void clear() {
		front = rear = 0;
	}

	// 测试队列是否为空
	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	// 求队列中的数据元素个数并由函数返回其值
	@Override
	public int length() {
		return (rear - front + queueElem.length) % queueElem.length;
	}

	// 查看队列的头而不移除它，返回队列顶对象，如果次队列为空，则返回null
	@Override
	public Object peek() {
		if (front == rear) 	// 队列为空
			return null;
		else 
			return queueElem[front];	// 返回队首元素
	}

	// ->3.循环顺序队列基本操作的实现
	// -->2)循环顺序队列的出队操作
	// --->(1)判断循环顺序队列是否为空，若为空，则返回空值；否则转(2)。
	// --->(2)先取出front所指的队首元素的值，再将front值循环加1。
	// ->[算法3.7].循环顺序队列的出队操作算法。
	// 移除队列的头并作为此函数的值返回该对象，如果次队列为空，则返回null
	@Override
	public Object poll() {
		if (front == rear) 	// 队列为空
			return null;
		else {
			Object t = queueElem[front];	// 取出队首元素
			front = (front + 1) % queueElem.length;	// 更改队首的位置
			return t;
		}
	}

	// ->3.循环顺序队列基本操作的实现
	// -->1)循环顺序队列的入队操作
	// --->(1)判断循环顺序队列是否为满，若满，则抛出异常后结束操作；否则转(2)。
	// --->(2)先将新的数据元素x存入rear所指示的数组存储位置中，使其成为新的队尾元素，再将rear值循环加1，使rear始终指向队尾的下一个存储位置。
	// ->[算法3.6].循环顺序队列的入队操作算法。
	// 把指定的元素插入队列
	@Override
	public void offer(Object x) throws Exception {
		if ((rear + 1) % queueElem.length == front) 	// 队列满1
//		if (length() == queueElem.length) 
			throw new Exception("队列已满");	// 输出异常
		else {	// 队列未满
			queueElem[rear] = x;	// x赋给队尾元素
			rear = (rear + 1) % queueElem.length;	// 修改队尾指针
		}
			
	}

	// 打印函数，打印所有队列中的元素(队首到队尾)
	@Override
	public void display() {
		if (!isEmpty()) {
			for (int i = front; i != rear; i = (i + 1) % queueElem.length) 
				// 从队首到队尾
				System.out.print(queueElem[i].toString() + " ");
		} else {
			System.out.println("此队列为空");
		}
	}

	public Object[] getQueueElem() {
		return queueElem;
	}
	public void setQueueElem(Object[] queueElem) {
		this.queueElem = queueElem;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}

}
