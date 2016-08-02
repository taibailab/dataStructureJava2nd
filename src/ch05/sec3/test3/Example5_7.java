package ch05.sec3.test3;

import ch05.sec2.test3.BiTree;
import ch05.sec2.test3.BiTreeNode;
import ch05.sec3.test2.Example5_3;

/**
 * 5.3.3.建立二叉树
 * ->3.由完全二叉树的顺序存储结构建立其二叉链式存出结构
 * ->[例5.7].编写一个程序：首先根据完全二叉树的书香怒存储结构建立一棵二叉树的链式存储结构，然后输出该二叉树的中根遍历序列和该二叉树的深度。
 */
public class Example5_7 {
	// 由顺序存储的完全二叉树建立一棵二叉树，并返回其根结点，其中index标识结点在完全二叉树中的序号
	public BiTreeNode createBiTree(String sqBiTree, int index) {
		BiTreeNode root = null;	// 根结点
		if (index < sqBiTree.length()) {	// 位置不越界
			root = new BiTreeNode(sqBiTree.charAt(index));	// 建立树的根结点，存储二叉树使用了0号单元
			root.lchild = createBiTree(sqBiTree, 2 * index + 1);	// 建立树的左子树
			root.rchild = createBiTree(sqBiTree, 2 * index + 2);	// 建立树的右子树
		}
		return root;
	}

	public static void main(String[] args) {
		Example5_7 e = new Example5_7();
		String sqBiTree = "ABCDEFGH";	// 顺序存储的完全二叉树
		
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		
		System.out.println("先根遍历：");
		T.preRootTraverse();
		System.out.println();
		
		System.out.println("中根遍历：");
		T.inRootTraverse();
		System.out.println();
		
		System.out.println("后根遍历：");
		T.postRootTraverse();
		System.out.println();
		
		Example5_3 e3 = new Example5_3();
		System.out.println("树的深度为：" + e3.getDepth(root));	// 调用例3中的求深度函数，输出深度
	}

}

// 运行结果：
// 先根遍历：
// ABDHECFG
// 中根遍历：
// HDBEAFCG
// 后根遍历：
// HDEBFGCA
// 树的深度为：4
