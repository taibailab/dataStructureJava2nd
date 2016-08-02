package ch05.sec3.test2;

import ch03.sec2.test4.LinkQueue;
import ch05.sec2.test3.BiTree;
import ch05.sec2.test3.BiTreeNode;

/**
 * 5.3.2.二叉树遍历算法的应用举例
 * ->[例5.2].计算二叉树中结点的个数：编写算法实现统计二叉树中结点的个数的操作
 * ->[算法5.9].统计二叉树中结点个数的算法。
 * ->[算法5.10].统计二叉树中结点个数的算法。
 * ->[算法5.13].统计二叉树中结点个数的算法(采用递归模型方法)。
 * ->编写成员函数计算二叉树中结点的个数
 */
public class Example5_2 {
	// [算法5.9].统计二叉树中结点个数的算法。
	// 采用先根遍历的方式对树进行遍历，计算树中的结点数
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;	// 结点数增1
			count += countNode(T.lchild);	// 加上左子树上结点数
			count += countNode(T.rchild);	// 加上右子树上的结点数
		}
		return count;
	}

	// [算法5.10].统计二叉树中结点个数的算法。
	public int countNode1_10(BiTreeNode T) {
		// 采用层次遍历的方式在对二叉树进行遍历，并计算结点的个数
		int count = 0;
		if (T != null) {
			LinkQueue L = new LinkQueue();	// 构造队列
			L.offer(T);
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				++count;	// 结点数目增加1
				if (T.lchild != null) 	// 左孩子非空，入队列
					L.offer(T.lchild);
				if (T.rchild != null) 	// 右孩子非空，入队列
					L.offer(T.rchild);
			}
		}
		return count;
	}

	// 采用递归模型方法，计算树中的结点数
	public int countNode1(BiTreeNode T) {
		if (T == null) 
			return 0;
		else 
			return countNode1(T.lchild) + countNode1(T.rchild) + 1;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();	// 创建一棵树
		BiTreeNode root = biTree.getRoot();	// 取得树的根结点
		
		Example5_2 e = new Example5_2();
		
		System.out.println("树中的结点个数为：" + e.countNode(root));
		System.out.println("树中的结点个数为：" + e.countNode1(root));
	}

}

// 运行结果：
// 树中的结点个数为：13
// 树中的结点个数为：13
