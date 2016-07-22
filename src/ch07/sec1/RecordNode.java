package ch07.sec1;

/**
 * 第7章.内排序
 * 7.1.排序的基本概念
 * ->待排序的顺序表记录类
 * ->顺序表记录结点类
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
	
	/*
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
	*/
	
	@Override
	public String toString() {	// 覆盖toString()方法
		return "[" + key + "," + element + "]";
	}

}
