package ch05.sec2.test3;

import ch03.sec1.test4.LinkStack;
import ch03.sec2.test4.LinkQueue;

/**
 * 5.2.3.二叉树的存储结构
 * ->3.二叉链式存储结构下二叉树类的描述
 * ->二叉链式存储结构下的二叉树
 * 
 * 5.3.二叉树的遍历
 * 5.3.1.二叉树的遍历方法及其实现
 * ->3.二叉树遍历操作实现的递归算法
 * ->[算法5.1].先根遍历操作实现的递归算法。
 * ->[算法5.2].中根遍历操作实现的递归算法。
 * ->[算法5.3].后根遍历操作实现的递归算法。
 * ->4.二叉树遍历操作实现的非递归算法
 * ->[算法5.4].先根遍历操作实现的非递归算法。
 * ->[算法5.5].中根遍历操作实现的非递归算法。
 * ->[算法5.6].后根遍历操作实现的非递归算法。
 * ->[算法5.7].层次遍历操作实现的非递归算法。
 */
public class BiTree {
	private BiTreeNode root;	// 树的根节点

	public BiTree() {	// 构造一棵空树
		this.root = null;
	}

	public BiTree(BiTreeNode root) {	// 构造一棵树
		this.root = root;
	}

	// 由先根遍历的数组和中根遍历的数组建立一棵二叉树
	// 其中参数preOrder是整棵树的先根遍历，inOrder是整棵树的中根遍历，preIndex是先根遍历从preOrder字符串中的开始位置，inIndex是中根遍历从字符串inOrder中的开
	// 始位置，count表示树结点的个数
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		if (count > 0) {	// 先根和中根非空
			char r = preOrder.charAt(preIndex);	// 取先根字符串中的第一个元素作为根结点
			int i = 0;
			for (; i < count; i++) 
				// 寻找根结点在中根遍历字符串中的索引
				if (r == inOrder.charAt(i + inIndex)) 
					break;
			
			root = new BiTreeNode(r);	// 建立树的根结点
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;	// 建立树的左子树
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;	// 建立树的右子树
		}
	}

	// 由标明空子树的先根遍历序列建立一棵二叉树
	private static int index = 0;	// 用于记录preStr的索引值

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);	// 取出字符串索引为index的字符串，且index增1
		if (c != '#') {	// 字符不为#
			root = new BiTreeNode(c);	// 建立树的根结点
			root.lchild = new BiTree(preStr).root;	// 建立树的左子树
			root.rchild = new BiTree(preStr).root;	// 建立树的右子树
		} else 
			root = null;
	}

	// 5.3.1.二叉树的遍历方法及其实现
	// ->3.二叉树遍历操作实现的递归算法
	// ->[算法5.1].先根遍历操作实现的递归算法。s
	// 先根遍历二叉树基本操作的递归算法
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.data);	// 访问根结点
			preRootTraverse(T.lchild);	// 访问左子树
			preRootTraverse(T.rchild);	// 访问右子树
		}
	}

	// ->4.二叉树遍历操作实现的非递归算法
	// ->[算法5.4].先根遍历操作实现的非递归算法。
	// 先根遍历二叉树基本操作的非递归算法
	public void preRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();	// 构造栈
			S.push(T);	// 根结点入栈
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();	// 移除栈顶结点，并返回其值
				System.out.print(T.data);	// 访问结点
				while (T != null) {
					if (T.lchild != null) 	// 访问左孩子
						System.out.print(T.lchild.data);	// 访问结点
					
					if (T.rchild != null) 	// 右孩子非空入栈
						S.push(T.rchild);
					
					T = T.lchild;
				}
			}
		}
	}

	// ->3.二叉树遍历操作实现的递归算法
	// ->[算法5.2].中根遍历操作实现的递归算法。
	// 中根遍历二叉树基本操作的递归算法
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.lchild);	// 访问左子树
			System.out.print(T.data);	// 访问根结点
			inRootTraverse(T.rchild);	// 访问右子树
		}
	}

	// ->4.二叉树遍历操作实现的非递归算法
	// ->[算法5.5].中根遍历操作实现的非递归算法。
	// 中根遍历二叉树基本操作的非递归算法
	public void inRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();	// 构造栈链
			S.push(T);	// 根结点入栈
			while (!S.isEmpty()) {
				while (S.peek() != null) 
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();	//空结点退栈
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();	// 移除栈顶结点，并返回其值
					System.out.print(T.data);	// 访问结点
					S.push(T.rchild);	// 结点的右孩子入栈
				}
			}
		}
	}

	// ->3.二叉树遍历操作实现的递归算法
	// ->[算法5.3].后根遍历操作实现的递归算法。
	// 后根遍历二叉树基本操作的递归算法
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.lchild);	// 访问左子树
			postRootTraverse(T.rchild);	// 访问右子树
			System.out.print(T.data);	// 访问根结点
		}
	}

	// ->4.二叉树遍历操作实现的非递归算法
	// ->[算法5.6].后根遍历操作实现的非递归算法。
	// 后根遍历二叉树基本操作的非递归算法
	public void postRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();	// 构造链栈
			S.push(T);	// 根结点进栈
			Boolean flag;	// 访问标记
			BiTreeNode p = null;	// p指向刚被访问的结点
			while (!S.isEmpty()) {
				while (S.peek() != null) 
					// 将栈顶结点的所有左孩子结点入栈
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();	// 空结点退栈
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();	// 查看栈顶元素
					if (T.rchild == null || T.rchild == p) {
						System.out.print(T.data);	// 访问结点
						S.pop();	// 移除栈顶元素
						p = T;	// p指向刚被访问的结点
						flag = true;
					} else {
						S.push(T.rchild);	// 右孩子结点入栈
						flag = false;	// 设置未被访问
					}
					if (!flag) 
						break;
				}
			}
		}
	}

	// ->4.二叉树遍历操作实现的非递归算法
	// ->[算法5.7].层次遍历操作实现的非递归算法。
	// 层次遍历二叉树基本操作的算法(自左向右)
	public void levelTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkQueue L = new LinkQueue();	// 构造队列
			L.offer(T);	// 根结点入队列
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				System.out.print(T.data);	// 访问结点
				if (T.lchild != null) 	// 左孩子非空，入队列
					L.offer(T.lchild);
				if (T.rchild != null) 	// 右孩子非空，入队列
					L.offer(T.rchild);
			}
		}
	}

	// 统计叶结点数目
	public int countLeafNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			if (T.lchild == null && T.rchild == null) {
				++count;	// 叶结点个数加1
			} else {
				count += countLeafNode(T.lchild);	// 加上左子树上叶结点的个数
				count += countLeafNode(T.rchild);	// 加上右子树上叶节点的个数
			}
		}
		return count;
	}

	// 统计结点的数目
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;	// 结点的个数加1
			count += countNode(T.lchild);	// 加上左子树上结点的个数
			count += countNode(T.rchild);	// 加上右子树上节点的个数
			
		}
		return count;
	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

}
