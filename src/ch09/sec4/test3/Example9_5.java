package ch09.sec4.test3;

/**
 * 9.4.3.处理冲突的方法<br>
 * ->链地址法测试程序。<br>
 * ->例9.5.哈希表查找、插入、删除查找测试<br>
 * ->3.公共溢出区法<br>
 * ->4.再哈希法<br>
 * ->9.4.4.哈希表的查找和性能分析<br>
 */
public class Example9_5 {
	public static void main(String[] args) throws Exception {
		String[] name = {"Wang", "Li", "Zhang", "Liu", "Chen", "Yang", "Huang", "Zhao", "Wu", "Zhou", "Du"};	// 数据元素
		HashTable<String> ht = new HashTable<String>(7);
		String elem1, elem2;
		System.out.print("插入元素：");
		for (int i = 0; i < name.length; i++) {
			ht.insert(name[i]);	// 哈希表中插入对象
			System.out.print(name[i] + " ");
		}
		System.out.println("\n原哈希表：");
		ht.printHashTable();
		elem1 = name[2];
		System.out.println("查找" + elem1 + ", " + (ht.contain(elem1) ? "" : "不") + "成功");
		elem2 = "san";
		System.out.println("查找" + elem2 + ", " + (ht.contain(elem2) ? "" : "不") + "成功");
		System.out.println("删除" + elem1 + ", " + (ht.remove(elem1) ? "" : "不") + "成功");
		System.out.println("删除" + elem2 + ", " + (ht.remove(elem2) ? "" : "不") + "成功");
		System.out.println("新哈希表：");
		ht.printHashTable();
	}

}
