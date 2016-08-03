package ch07.sec1;

/**
 * 第7章.内排序<p>
 * 7.1.排序的基本概念<br>
 * ->1.排序的定义<br>
 * ->2.排序的分类<br>
 * -->1)内部排序与外部排序<br>
 * -->2)稳定排序与不稳定排序<br>
 * ->3.内排序的方法<br>
 * -->1)插入类排序方法是将无序子序列中的一个或几个记录"插入"到有序序列中，从而增加记录的有序子序列的长度。<br>
 * -->2)交换类排序方法是指通过“交换”无序序列中的记录，从而得到其中关键字最小或最大的记录，并将它加入到有序子序列中，以此方法增加记录的有序子序列的长度。<br>
 * -->3)选择类排序方法是指从记录的无序子序列中“选择”关键字最小或最大的记录，并将它加入到有序子序列中，以此方法增加记录的有序子序列的长度。<br>
 * -->4)归并类排序方法是指通过“归并”两个或两个以上的记录有序子序列，逐步增加记录有序序列的长度。<br>
 * ->4.排序算法的性能评价<br>
 * ->5.待排序记录的类描述<br>
 * ->待排序的顺序表记录类<br>
 * ->顺序表记录结点类<br>
 */
public class RecordNode {
	public Comparable key;	// 关键字
	public Object element;	// 数据元素
	
	public RecordNode() {
	}
	
	public RecordNode(Comparable key) {	// 构造方法1
		this.key = key;
	}
	
	public RecordNode(Comparable key, Object element) {	// 构造方法2
		this.key = key;
		this.element = element;
	}

	public Comparable getKey() {
		return key;
	}

	public void setKey(Comparable key) {
		this.key = key;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	@Override
	public String toString() {	// 覆盖toString()方法
		return "[" + key + "," + element + "]";
	}

}
