package ch07.sec1;

/**
 * 7.1.排序的基本概念<br>
 * ->5.待排序记录的类描述<br>
 * ->顺序表记录结点类<br>
 * ->顺序表记录结点数据元素类<br>
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
