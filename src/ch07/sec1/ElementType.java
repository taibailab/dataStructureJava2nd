package ch07.sec1;

/**
 * 7.1.排序的基本概念
 * ->顺序表记录结点类
 * ->顺序表记录结点数据元素类
 */
public class ElementType {
	public String data;	// 用户可自定义其他数据项
	
	public ElementType() {
	}
	
	public ElementType(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {	// 覆盖toString()方法
		return data;
	}

}
