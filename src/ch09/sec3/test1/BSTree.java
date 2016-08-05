package ch09.sec3.test1;

import ch05.sec2.test3.BiTreeNode;
import ch07.sec1.RecordNode;

/**
 * 9.3.动态表查找<p>
 * 9.3.1.二叉排序树<br>
 * ->1.二叉排序树的定义<br>
 * -->(1).若左子树不空，则左子树上所有结点的值均小于根结点的值。<br>
 * -->(2).若右子树不空，则右子树上所有结点的值均大于根结点的值。<br>
 * -->(3).它的左右子树也都是二叉排序树。<br>
 * ->二叉排序树类<br>
 * ->2.二叉排序树的查找过程<br>
 * -->(1).若查找树为空，则查找失败。<br>
 * -->(2).若查找树非空，则：<br>
 * --->a.若给定值k等于根结点的关键字值，则查找成功，结束查找过程，否则转b。<br>
 * --->b.若给定值k小于根结点的关键字值，则继续在根结点的左子树上进行，否则转c。<br>
 * --->c.若给定值k大于根结点的关键字值，则继续在根结点的右子树上进行。<br>
 * ->[算法9.4].二叉排序树查找算法。<br>
 * ->3.二叉排序树的插入操作<br>
 * ->[算法9.5].在二叉排序树中插入一个新结点的算法。<br>
 * ->4.二叉排序树删除操作<br>
 * -->(1).若待删除的结点是叶子结点，则直接删除该结点即可。若该结点同时也是根结点，则删除后二叉排序树将变为空树。<br>
 * -->(2).若待删除的结点只有左子树，而无右子树。根据二叉排序树的结点，可以直接将其左子树的根结点替代被删除结点的位置，即若被删除的结点为其双亲结点的左孩子，则将被
 * 删除结点的唯一左孩子收为其双亲结点的左孩子；否则收为其双亲结点的右孩子。<br>
 * -->(3).待删除的结点只有右子树，而无左子树。与情况(2)类似，可以直接将其右子树的根结点代替被删除结点的位置，即若被删除的结点为其双亲结点的左孩子，则将被删除结点
 * 的唯一右孩子收为其双亲结点的左孩子；否则收为其双亲结点的右孩子。<br>
 * -->(4).待删除结点既有左子树又有右子树。根据二叉排序树的特点，可以用被删除结点在中序遍历序列下的前驱结点(或其中序遍历序列下的后继结点)代替被删除结点，同时删除其
 * 中序遍历序列下的前驱结点(或中序遍历序列下的后继结点)。而被删除结点在中序遍历下的前驱无右子树，被删除结点在中序遍历下的后继无左子树，因而问题转换为第(2)种情况
 * 或第(3)种情况。<br>
 * ->[算法9.6].在二叉排序树中删除一个结点的算法。<br>
 */
public class BSTree {
	public BiTreeNode root;	// 根结点

	public BSTree() {	// 构造空二叉排序树
		root = null;
	}

	/*
	public BiTreeNode getRoot() {
		return root;
	}
	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
	*/

	public boolean isEmpty() {	// 判断是否空二叉树
		return this.root == null;
	}

	public void inOrderTraverse(BiTreeNode p) {	// 中根次序遍历以p结点为根的二叉树
		if (p != null) {
			inOrderTraverse(p.lchild);
			System.out.print(((RecordNode) p.data).toString() + "");
			inOrderTraverse(p.rchild);
		}
	}

	// ->2.二叉排序树的查找过程
	// -->(1).若查找树为空，则查找失败。
	// -->(2).若查找树非空，则：
	// --->a.若给定值k等于根结点的关键字值，则查找成功，结束查找过程，否则转b。
	// --->b.若给定值k小于根结点的关键字值，则继续在根结点的左子树上进行，否则转c。
	// --->c.若给定值k大于根结点的关键字值，则继续在根结点的右子树上进行。
	// ->[算法9.4].二叉排序树查找算法。
	// 查找关键字值为key的结点，若查找成功返回结点值，否则返回null
	public Object searchBST(Comparable key) {
		if (key == null || !(key instanceof Comparable)) {
			return null;
		}
		return searchBST(root, key);
	}

	// ->[算法9.4].二叉排序树查找算法。
	// 二叉排序树查找的递归算法
	// 在二叉排序树中查找关键字为key的结点。若查找成功则返回节点值，否则返回null
	private Object searchBST(BiTreeNode p, Comparable key) {
		if (p != null) {
			if (key.compareTo(((RecordNode) p.data).key) == 0) {	// 查找成功
				return p.data;
			}
//			System.out.print(((RecordNode) p.data).key + "? ");
			if (key.compareTo(((RecordNode) p.data).key) < 0) {
				return searchBST(p.lchild, key);	// 在左子树中查找
			} else {
				return searchBST(p.rchild, key);	// 在右子树中查找
			}
		}
		return null;
	}

	// ->3.二叉排序树的插入操作
	// ->[算法9.5].在二叉排序树中插入一个新结点的算法。
	// 在二叉排序树中插入关键字为key，数据项为theElement的结点，若插入成功返回true，否则返回false
	public boolean insertBST(Comparable key, Object theElement) {
		if (key == null || !(key instanceof Comparable)) {	// 不能插入空对象或不可比较大小的对象
			return false;
		}
		if (root == null) {
			root = new BiTreeNode(new RecordNode(key, theElement));	// 建立根结点
			return true;
		}
		return insertBST(root, key, theElement);
	}

	// ->3.二叉排序树的插入操作
	// ->[算法9.5].在二叉排序树中插入一个新结点的算法。
	// 将关键字为key，数据项为theElement的结点插入到以p为根的二叉排序树中的递归算法
	private boolean insertBST(BiTreeNode p, Comparable key, Object theElement) {
		if (key.compareTo(((RecordNode) p.data).key) == 0) {
			return false;	// 不插入关键字重复的结点
		}
		if (key.compareTo(((RecordNode) p.data).key) < 0) {
			if (p.lchild == null) {	// 若p的左子树为空
				p.lchild = new BiTreeNode(new RecordNode(key, theElement));	// 建立叶子结点作为p的左孩子
				return true;
			} else {	// 若p的左子树非空
				return insertBST(p.lchild, key, theElement);	//插入到p的左子树中
			}
		} else if (p.rchild == null) {	// 若p的右子树为空
			p.rchild = new BiTreeNode(new RecordNode(key, theElement));	// 建立叶子结点作为p的右孩子
			return true;
		} else {
			return insertBST(p.rchild, key, theElement);	// 插入到p的右子树中
		}
	}

	// ->4.二叉排序树删除操作
	// -->(1).若待删除的结点是叶子结点，则直接删除该结点即可。若该结点同时也是根结点，则删除后二叉排序树将变为空树。
	// -->(2).若待删除的结点只有左子树，而无右子树。根据二叉排序树的结点，可以直接将其左子树的根结点替代被删除结点的位置，即若被删除的结点为其双亲结点的左孩子，则
	// 将被删除结点的唯一左孩子收为其双亲结点的左孩子；否则收为其双亲结点的右孩子。
	// -->(3).待删除的结点只有右子树，而无左子树。与情况(2)类似，可以直接将其右子树的根结点代替被删除结点的位置，即若被删除的结点为其双亲结点的左孩子，则将被删除
	// 结点的唯一右孩子收为其双亲结点的左孩子；否则收为其双亲结点的右孩子。
	// -->(4).待删除结点既有左子树又有右子树。根据二叉排序树的特点，可以用被删除结点在中序遍历序列下的前驱结点(或其中序遍历序列下的后继结点)代替被删除结点，同时删
	// 除其中序遍历序列下的前驱结点(或中序遍历序列下的后继结点)。而被删除结点在中序遍历下的前驱无右子树，被删除结点在中序遍历下的后继无左子树，因而问题转换为第(2)
	// 种情况或第(3)种情况。
	// ->[算法9.6].在二叉排序树中删除一个结点的算法。
	// 二叉排序树中删除结点算法。若删除成功返回删除结点值，否则返回null
	public Object removeBST(Comparable key) {
		if (root == null || key == null || !(key instanceof Comparable)) {
			return null;
		}
		// 在以root为根的二叉排序树中删除关键字为elemKey的结点
		return removeBST(root, key, null);
	}

	// 在以p为根的二叉排序树中删除关键字为elemKey的结点。parent是p的父结点，递归算法
	private Object removeBST(BiTreeNode p, Comparable elemKey, BiTreeNode parent) {
		if (p != null) {
			if (elemKey.compareTo(((RecordNode) p.data).key) < 0) {	// 在左子树中删除
				return removeBST(p.lchild, elemKey, p);	// 在左子树中递归搜索
			} else if (elemKey.compareTo(((RecordNode) p.data).key) > 0) {	// 在右子树中删除
				return removeBST(p.rchild, elemKey, p);	// 在右子树中递归搜索
			} else if (p.lchild != null && p.rchild != null) {
				// 相等且该结点有左右子树
				BiTreeNode innext = p.rchild;	// 寻找p在中根次序下的后继结点innext
				while (innext.lchild != null) {	// 即寻找右子树中的最左孩子
					innext = innext.lchild;
				}
				p.data = innext.data;	// 以后继结点值替换p
				return removeBST(p.rchild, ((RecordNode) p.data).key, p);	// 递归删除结点p
			} else {	// p是1度和叶子结点
				if (parent == null) {	// 删除根结点，即p==root
					if (p.lchild != null) {
						root = p.lchild;
					} else {
						root = p.rchild;
					}
					return p.data;	// 返回删除结点p值
				}
				if (p == parent.lchild) {	// p是parent的左孩子
					if (p.lchild != null) {
						parent.lchild = p.lchild;	// 以p的左子树填补
					} else {
						parent.lchild = p.rchild;
					}
				} else if (p.lchild != null) {	// p是parent的右孩子且p的左子树非空
					parent.rchild = p.lchild;
				} else {
					parent.rchild = p.rchild;
				}
				return p.data;
			}
		}
		return null;
	}

}
