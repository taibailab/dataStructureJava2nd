package ch05.sec3.test3;

import ch05.sec2.test3.BiTree;

/**
 * 5.3.二叉树的遍历
 * 5.3.3.建立二叉树
 * ->1.由先根和中根遍历序列建立一棵二叉树<br>
 * ->[例5.5].编写程序完成：首先由先根和中根遍历序列建立一棵二叉树，然后输出该二叉树的后根遍历序列。
 */
public class Example5_5 {
	public static void main(String[] args) {
		String preOrder = "ABDEGCFH";	// 先根遍历序列
		String inOrder = "DBGEAFHC";	// 中根遍历序列
		
		BiTree T = new BiTree(preOrder, inOrder, 0, 0, preOrder.length());
		System.out.println("后根遍历：");
		T.postRootTraverse();	// 调用二叉树的后根遍历的非递归算法
	}

}

// 运行结果：
// 后根遍历：
// DGEBHFCA
