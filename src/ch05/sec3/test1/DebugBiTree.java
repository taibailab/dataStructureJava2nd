package ch05.sec3.test1;

import ch05.sec2.test3.BiTree;
import ch05.sec2.test3.BiTreeNode;

/**
 * 5.3.二叉树的遍历
 * 5.3.1.二叉树的遍历方法及其实现
 * ->4.二叉树遍历操作实现的非递归算法
 * ->调试二叉链式存储结构下的二叉树的个操作
 */
public class DebugBiTree {
	public BiTree createBiTree() {
		BiTreeNode d = new BiTreeNode('D');
		BiTreeNode g = new BiTreeNode('G');
		BiTreeNode h = new BiTreeNode('H');
		BiTreeNode e = new BiTreeNode('E', g, null);
		BiTreeNode b = new BiTreeNode('B', d, e);
		BiTreeNode f = new BiTreeNode('F', null, h);
		BiTreeNode c = new BiTreeNode('C', f, null);
		BiTreeNode a = new BiTreeNode('A', b, c);
		return new BiTree(a);
		// 创建根结点为a的二叉树，其中二叉树类BitTree的定义紧接在DebugBiTree类的后面给出
	}

	public static void main(String[] args) {
		DebugBiTree debugBiTree = new DebugBiTree();
		BiTree biTree = debugBiTree.createBiTree();
		BiTreeNode root = biTree.getRoot();	// 取得树的根结点
		
		// 调试先根遍历
		System.out.print("(递归)先根遍历序列为：");
		biTree.preRootTraverse(root);
		System.out.println();	// 输出换行
		System.out.print("(非递归)先根遍历序列为：");
		biTree.preRootTraverse();
		System.out.println();
		
		// 调试中根遍历
		System.out.print("(递归)中根遍历序列为：");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.print("(非递归)中根遍历序列为：");
		biTree.inRootTraverse();
		System.out.println();
		
		// 调试后根遍历
		System.out.print("(递归)后根遍历序列为：");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.print("(非递归)后根遍历序列为：");
		biTree.postRootTraverse();
		System.out.println();
		
		// 调试层次遍历
		System.out.print("层次遍历序列为：");
		biTree.levelTraverse();
		System.out.println();
	}

}

// 运行结果：
// (递归)先根遍历序列为：ABDEGCFH
// (非递归)先根遍历序列为：ABDEGCFH
// (递归)中根遍历序列为：DBGEAFHC
// (非递归)中根遍历序列为：DBGEAFHC
// (递归)后根遍历序列为：DGEBHFCA
// (非递归)后根遍历序列为：DGEBHFCA
// 层次遍历序列为：ABCDEFGH
