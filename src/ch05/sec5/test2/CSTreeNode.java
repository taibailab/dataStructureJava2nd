package ch05.sec5.test2;

/**
 * 5.5.树与森林
 * 5.5.1.树、森林与二叉树之间的转换
 * ->1.树转换成二叉树
 * ->2.二叉树转成树
 * ->3.森林与二叉树的转换
 * 5.5.2.树的存储结构
 * ->1.双亲链表存储结构
 * ->2.孩子链表存储结构
 * ->3.双亲孩子链表存储结构
 * ->4.孩子兄弟链表存储结构
 * ->二叉链式(孩子-兄弟)存储结构下的树结点
 */
public class CSTreeNode {
	public Object data;	// 结点的数据元素
	public CSTreeNode firstchild, nextsibling;	// 孩子兄弟结点

	public CSTreeNode() {	// 构造一个空结点
		this(null);
	}

	public CSTreeNode(Object data) {	// 构造一棵孩子及兄弟为空的结点
		this(data, null, null);
	}

	public CSTreeNode(Object data, CSTreeNode firstchild, CSTreeNode nextsibling) {	// 构造一棵数据元素和孩子及兄弟都不为空的结点
		this.data = data;
		this.firstchild = firstchild;
		this.nextsibling = nextsibling;
	}

}
