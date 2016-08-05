package ch09.sec2.test3;

import java.util.Scanner;

import ch07.sec1.KeyType;
import ch07.sec1.RecordNode;
import ch07.sec1.SeqList;

/**
 * 第9章.查找<p>
 * 9.1.查找的基本概念<p>
 * <p>
 * 9.2.静态表查找<p>
 * 9.2.1.顺序查找<br>
 * 9.2.2.二分查找<br>
 * 9.2.3.分块查找<br>
 * ->[例9.1].二分查找测试程序。
 */
public class Example9_1 {
	static SeqList ST = null;

	public static void createSearchList() throws Exception {
		int maxSize = 20;	// 查找表预分配空间的大小
		ST = new SeqList(maxSize);	// 创建查找表对象
		int curlen;	// 表的实际长度
		System.out.print("Please input table length:");
		Scanner sc = new Scanner(System.in);
		curlen = sc.nextInt();
		KeyType[] k = new KeyType[curlen];
		System.out.print("Please input keyword sequence:");
		for (int i = 0; i < curlen; i++) {	// 输入关键字序列
			k[i] = new KeyType(sc.nextInt());
		}
		for (int i = 0; i < curlen; i++) {	// 记录顺序表
			RecordNode r = new RecordNode(k[i]);
			ST.insert(ST.length(), r);
		}
	}

	public static void main(String[] args) throws Exception {
		createSearchList();	// 创建查找表
		System.out.print("please input search keyword:");	// 提示输入待查找的关键字
		Scanner sc = new Scanner(System.in);	// 输入待查找关键字
		KeyType key1 = new KeyType(sc.nextInt());
		KeyType key2 = new KeyType(sc.nextInt());
		System.out.println("binaryseqSearch(" + key1.key + ")=" + ST.binarySearch(key1));
		System.out.println("binarySearch(" + key2.key + ")=" + ST.binarySearch(key2));
	}

}
