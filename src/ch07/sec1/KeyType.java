package ch07.sec1;

/**
 * 7.1.排序的基本概念<br>
 * ->5.待排序记录的类描述<br>
 * ->顺序表记录关键字类<br>
 * ->顺序表记录结点关键字类<br>
 */
public class KeyType implements Comparable<KeyType> {
	public int key;	// 关键字
	
	public KeyType() {
	}
	
	public KeyType(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(KeyType another) {	// 覆盖Cpmparable接口中比较关键字大小的方法
		int thisVal = this.key;
		int anotherVal = another.key;
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}
	
	@Override
	public String toString() {	// 覆盖toString()方法
		return key + "";
	}

}
