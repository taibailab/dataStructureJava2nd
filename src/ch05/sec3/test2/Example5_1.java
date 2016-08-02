package ch05.sec3.test2;

import ch05.sec2.test3.BiTree;
import ch05.sec2.test3.BiTreeNode;

/**
 * 5.3.2.二叉树遍历算法的应用举例
 * ->[例5.1].二叉树上的查找：编写算法完成在二叉树中查找值为x的结点的操作。
 * ->[算法5.8].二叉树上的查找算法。
 * ->编写成员函数完成在二叉树中查找数据元素值为x的结点的操作
 * ->在二叉树中查找数据元素操作的要求是：在以T为根结点的二叉树中查找数据元素值为x的结点，若找到则返回该结点，否则返回空值
 */
public class Example5_1 {
	// 采用先根遍历的方式对树进行遍历，比较结点的数据元素与给定的数据元素的值
	public BiTreeNode searchNode(BiTreeNode T, Object x) {
		if (T != null) {
			if (T.data.equals(x)) 	// 对根结点进行判断
				return T;
			else {
				BiTreeNode lresult = searchNode(T.lchild, x);	// 查找左子树
				return lresult != null ? lresult : searchNode(T.rchild, x);	// 如果在左子树中，则返回值为x结点；否则在右子树中查找并返回其结果
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BiTree biTree = new BiTreeCreator().createBiTree();	// 创建一棵树
		BiTreeNode root = biTree.getRoot();	// 取得树的根结点
		
		// 调试[例5-1].编写成员函数完成在二叉树中查找数据元素值为x的结点的操作
		Example5_1 e = new Example5_1();
		if (e.searchNode(root, 'B') != null) 
			System.out.println("树中包含数据指定元素值的结点为：" + e.searchNode(root, 'B').data);
		else
			System.out.println("树中不包含数据指定元素值的结点！");
	}

}

// 运行结果：
// 树中包含数据指定元素值的结点为： B
