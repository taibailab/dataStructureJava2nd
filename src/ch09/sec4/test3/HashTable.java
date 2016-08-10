package ch09.sec4.test3;

import ch02.sec3.test1.LinkList;
import ch02.sec3.test1.Node;

/**
 * 9.4.哈希表查找<p>
 * 9.4.1.哈希表的定义<br>
 * ->根据设定的哈希函数H(key)和所选中的处理冲突的方法，将一组关键字映像到一个有限的、地址连续的地址集(区间)上，并以关键字在地址集中的“象”作为相应数据元素在表中的
 * 存储位置，如此构造所得的查找表称之为“哈希表”。<br>
 * -->(1).构造“好”的哈希函数。<br>
 * -->(2).制定解决冲突的方法。<br>
 * 9.4.2.常用的哈希函数<br>
 * ->1.除留余数法<br>
 * ->2.直接地址法<br>
 * ->3.数字分析法<br>
 * ->4.平方取中法<br>
 * ->5.折叠法<br>
 * -->(1).移位叠加法<br>
 * -->(2).间界叠加法<br>
 * ->6.随机数法<br>
 * ->实际工作中需要根据不同的情况采用不同的哈希函数。通常应考虑的因素有：(1).计算哈希函数所需时间；(2).关键字的长度；(3).哈希表的大小；(4).关键字的分布情况；(5).
 * 记录的查询频率。<br>
 * 9.4.3.处理冲突的方法<br>
 * ->1.开放定址法<br>
 * -->1)线性探测法<br>
 * -->2)二次探测法<br>
 * -->3)双哈希函数探测法<br>
 * ->2.链地址法<br>
 * ->链地址法哈希表HashTable定义如下。其中，哈希函数hash()才欧勇除留余数法，在哈希表上的操作有查找、插入和删除等，单链表采用第二章定义的LinkList类。
 * ->第9章.采用链地址法的哈希表类，包括插入、删除、查找、遍历等操作。
 */
public class HashTable<E> {	// 采用链地址法的哈希表类
	private LinkList[] table;	// 哈希表的对象数组

	public HashTable(int size) {	// 构造指定大小的哈希表
		this.table = new LinkList[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkList();	// 构造空单链表
		}
	}

	public int hash(int key) {	// 除留余数法哈希函数，除数是哈希表长度
		return key % table.length;
	}

	public void insert(E element) throws Exception {	// 在哈希表中插入指定元素
		int key = element.hashCode();	// 每个对象的hashCode()方法返回整数值
		int i = hash(key);	// 计算哈希地址
		table[i].insert(0, element);
	}

	public void printHashTable() {	// 输出哈希表中各单链表的元素
		for (int i = 0; i < table.length; i++) {
			System.out.print("table[" + i + "]=");	// 遍历单链表并输出元素值
			table[i].display();
		}
	}

	public Node search(E element) throws Exception {	// 在哈希表中查找制定对象，若查找成功返回结点，否则返回null
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);	// 返回元素在单链表中的位置
		if (index >= 0) {
			return (Node) table[i].get(index);	// 返回在单链表中找到的结点
		} else {
			return null;
		}
	}

	public boolean contain(E element) throws Exception {	// 以查找结果判断哈希表是否包含指定对象，若包含返回true，否则返回false
		return this.search(element) != null;
	}

	public boolean remove(E element) throws Exception {	// 删除指定对象，若删除成功返回true，否则返回false
		int key = element.hashCode();
		int i = hash(key);
		int index = table[i].indexOf(element);
		if (index >= 0) {
			table[i].remove(index);	// 在单链表中删除对象
			return true;
		} else {
			return false;
		}
	}

}
