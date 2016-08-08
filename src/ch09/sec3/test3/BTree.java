package ch09.sec3.test3;

/**
 * 9.3.动态表查找<p>
 * 9.3.3.B-树和B+树<br>
 * ->1.B-树的定义<br>
 * ->B-树中的结点类<br>
 * ->第9章.B-树算法演示<br>
 */
class Node<T> {	// B-树结点
	public int keyNum;	// 关键字个数域
	public boolean isLeaf;	// 是否为树叶
	public T[] key;	// 关键字数组
	public Node[] child;	// 子树指针数组
	public Node parent;	// 双亲结点指针

	Node(int m) {	// 构造方法
		keyNum = 0;
		isLeaf = true;
		key = (T[]) (new Object[2 * m - 1]);
		child = new Node[2 * m];
		parent = null;
	}

	/*
	public int keyNum() {
		return keyNum;
	}
	public void setKeyNum(int keyNum) {
		this.keyNum = keyNum;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public T[] key() {
		return key;
	}
	public void setKey(T[] key) {
		this.key = key;
	}
	public Node[] child() {
		return child;
	}
	public void setChild(Node[] child) {
		this.child = child;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	*/

}


/**
 * 9.3.3.B-树和B+树<br>
 * ->1.B-树的定义<br>
 * ->返回的查找结果类<br>
 * ->第9章.B-树算法演示<br>
 */
class Result {	// B-树查找结果类型
	public Node resultNode;	// 指向找到的结点
	public int i;	// 在结点中的关键码序号
	public boolean found;	// true：找到；false：未找到

	/*
	public Node getResultNode() {
		return resultNode;
	}
	public void setResultNode(Node resultNode) {
		this.resultNode = resultNode;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	*/

}


/**
 * 9.3.3.B-树和B+树<br>
 * ->1.B-树的定义<br>
 * ->B树类<br>
 * ->第9章.B-树算法演示<br>
 * ->2.基于B-树的查找运算<br>
 * ->[算法9.7].B-树查找算法。<br>
 * ->3.基于B-树的插入运算<br>
 * ->4.基于B-树的删除运算<br>
 * -->(1).若被删除结点Ki是最下层的非终端结点(即叶子结点的上一层)，则应删除Ki及它右边的指针；删除后若结点中关键字个数不少于[m/2]-1，则删除完成；否则要进行“合并”结
 * 点操作。<br>
 * -->(2).假设待删除结点是最下层的非终端结点以上某个层次的结点，根据B-树的特性可知，可以用Ki右边指针Pi所指子树中最小关键字Y代替Ki，然后在相应的结点中删除Y。<br>
 * -->(1).被删关键字所在结点的关键字个数不小于[m/2]，则只需从该结点中删除关键字Ki和相应的指针Pi，树的其他部分保持不变。<br>
 * -->(2).被删关键字所在结点的关键字个数等于[m/2]-1，而在该结点相邻的右兄弟(或左兄弟)结点中的关键字个数大于[m/2]-1，则需将其右兄弟的最小关键字(或其左兄弟的最大关
 * 键字)上移到双亲结点中，而将双亲结点中小于(或大于)该上移关键字的关键字下移到被删关键字所在的双结点中。<br>
 * -->(3).被删关键字所在结点的关键字个数和其相邻的兄弟结点中的关键字个数均等于[m/2]-1，则第(2)种情况中采用的移动方法将不奏效，此时需将被删关键字的所有结点与其左或
 * 右兄弟合并。不妨假设该结点有右兄弟，但其右兄弟地址由双亲结点指针Pi所指，则在删除关键字之后，它所在结点中剩余的关键字和指针加上双亲结点中的关键字Ki一起合并到Pi所
 * 指兄弟结点中(若没有右兄弟，则合并到左兄弟结点中)。<br>
 */
public class BTree<T> {
	private Node<T> root = null;	// 根结点
	private int degree;

	public BTree(int t) {
		degree = t;
	}

	// 9.3.3.B-树和B+树<br>
	// ->2.基于B-树的查找运算<br>
	// ->[算法9.7].B-树查找算法。
	/**
	 * 在B-树t上搜索指定的关键码key
	 * @param root 要搜索的B-树根结点
	 * @param key 要搜索的关键码键值
	 * @return 返回结果(resultNode, i, found)
	 * @return 若找到，则found=true, resultNode结点中第i个关键码等于key
	 * @return 返找不到，则found=false，等于key的关键码应插入在resultNode所指结点中第i和第i+1个关键码之间
	 */
	public Result searchBTree(Node<T> root, T key) {
		int i = 0;
		Node<T> p = root, q = null;	// p指向待查结点，q指向p的双亲结点
		boolean found = false;
		Result rs = new Result();	// 存放查找结果
		Comparable<T> k = (Comparable<T>) key;
		while (p != null && !found) {
			i = 0;
			while (i < p.keyNum && k.compareTo((p.key)[i]) > 0) 
				i++;
			if (i < p.keyNum && k.compareTo((p.key)[i]) == 0) 
				found = true;	// 找到
			else {
				q = p;	// 保存双亲结点
				p = p.child[i];	// 在子树中查找
			}
		}
		if (found == false) 
			p = q;
		rs.resultNode = p;
		rs.i = i;
		rs.found = found;
		return rs;
	}

	// ->2.基于B-树的查找运算<br>
	// ->[算法9.7].B-树查找算法。
	public <T extends Object & Comparable<? super T>> Node<T> search(Node<T> x, T k) {
		int i = 1;
//		Comparable<T> k = (Comparable<T> k) k1;
		while (i <= x.keyNum && k.compareTo((x.key)[i - 1]) > 0) 
			i++;
		if (i <= x.keyNum && k.compareTo((x.key)[i - 1]) == 0) 
			return x;
		if (x.isLeaf) 
			return null;
		else if ((x.child)[i - 1] != null) 
			return search((x.child)[i - 1], k);
		else {
			return null;
		}
	}

	// ->3.基于B-树的插入运算
	private void splitChild(Node<T> x, int i, Node<T> y) {
		Node<T> z = new Node<T>(degree);
		z.isLeaf = y.isLeaf;
		z.keyNum = degree - 1;
		for (int j = 0; j < degree - 1; j++) {
			(z.key)[j] =(y.key)[degree + j];
			(y.key)[degree + j]= null;
		}
		if (!y.isLeaf) {
			for (int j = 0; j < degree - 1; j++) {
				(z.child)[j] = (y.child)[degree + j];
				(y.child)[degree + j] = null;
			}
		}
		y.keyNum = degree - 1;
		for (int j = x.keyNum; j > i; j--) 
			(x.child)[j + 1] = (x.child)[j];
		(x.child)[i + 1] = z;
		for (int j = x.keyNum; j > i; j--) 
			(x.key)[j] = (x.key)[j - 1];
		(x.key)[i] = (y.key)[degree - 1];
		(y.key)[degree - 1] = null;
		x.keyNum = x.keyNum+1;
	}

	// ->3.基于B-树的插入运算
	public void insert(T k) {
		if (root == null) 
			root = new Node<T>(degree);
		Node<T> r = root;
		if (r.keyNum == 2 * degree - 1) {
			Node<T> z = new Node<T>(degree);
			z.isLeaf = false;
			root = z;
			z.child[0] = z;
			splitChild(z, 0, r);
			insertNonFull(z, k);
		} else 
			insertNonFull(r, k);
	}

	// ->3.基于B-树的插入运算
	private void insertNonFull(Node<T> x, T k) {
		int i = x.keyNum;
		Comparable<T> key = (Comparable<T>) k;
		if (x.isLeaf) {
			while (i >= 1 && key.compareTo((x.key)[i - 1]) < 0) {
				(x.key)[i] = (x.key)[i - 1];
				i--;
			}
			(x.key)[i] = k;
			x.keyNum = x.keyNum + 1;
		} else {
			while (i >= 1 && key.compareTo((x.key)[i - 1]) < 0) 
				i--;
			if ((x.child)[i].keyNum == 2 * degree - 1) {
				splitChild(x, i, (x.child)[i]);
				if (key.compareTo((x.key)[i]) > 0) 
					i++;
			}
			insertNonFull((x.child)[i], k);	
		}
	}

	// ->4.基于B-树的删除运算
	// -->(1).若被删除结点Ki是最下层的非终端结点(即叶子结点的上一层)，则应删除Ki及它右边的指针；删除后若结点中关键字个数不少于[m/2]-1，则删除完成；否则要进行“合
	// 并”结点操作。
	// -->(2).假设待删除结点是最下层的非终端结点以上某个层次的结点，根据B-树的特性可知，可以用Ki右边指针Pi所指子树中最小关键字Y代替Ki，然后在相应的结点中删除Y。
	public void delete(Node<T> x, T k) {
		Comparable<T> key = (Comparable<T>) k;
		if (isInside(x, k)) {
			int i = x.keyNum;
			while (i >= 1 && key.compareTo((x.key)[i - 1]) < 0) 
				i--;
			if (x.isLeaf) {
				for (int j = i - 1; j < x.keyNum - 1; j++) 
					(x.key)[j] = (x.key)[j + 1];
				(x.key)[x.keyNum - 1] = null;
				x.keyNum = x.keyNum - 1;
			} else {	// 非叶结点
				if ((x.child)[i - 1].keyNum >= degree) {
					Node<T> r = (x.child)[i - 1];
					while (!r.isLeaf) {
						r = (r.child)[r.keyNum];
					}
					T predecessor = (r.key)[r.keyNum - 1];
					(x.key)[i - 1] = predecessor;
					delete(r, predecessor);
				} else {
					if ((x.child)[i].keyNum >= degree) {
						Node<T> r = (x.child)[i];
						while (!r.isLeaf) {
							r = (r.child)[0];
						}
						T predecessor = (r.key)[0];
						(x.key)[i - 1] = predecessor;
						delete(r, predecessor);
					} else {
						mergeChild(x, i - 1, (x.child)[i - 1]);
						delete((x.child)[i - 1], k);
					}
				}
			}
		} else {
			Node<T> rootK = findRootContainsK(x, k);
			Node<T> r = null;
			if (!rootK.isLeaf) {
				for (int i = 0; i <= rootK.keyNum; i++) {
					if (isInside((rootK.child)[i], k)) {
						r = (rootK.child)[i];
						break;
					}
				}
			} else 
				r = rootK;
			if (rootK == x) 
				rootK = r;
			if (rootK.keyNum >= degree) 
				delete(r, k);
			else {
				int i = r.keyNum;
				while (i >= 1 && key.compareTo((r.key)[i - 1]) < 0) 
					i--;
				Node<T> p = findParentIn(x, rootK);
				int v = degree;
				for (int j = 0; j <= p.keyNum; j++) {
					if ((p.child)[j] == rootK) {
						v = j;
						break;
					}
				}
				if (v > 0 && (p.child)[v - 1].keyNum >= degree) {
					(r.key)[v - 1] = (p.key)[v];
					(p.key)[v] = (T) ((p.child)[v]).key[(p.child)[v].keyNum - 1];
					delete((p.child)[v], (p.key)[v]);
				} else {
					if (v < p.keyNum && (p.child)[v + 1].keyNum >= degree) {
						(r.key)[i - 1] = (p.key)[v];
						(p.key)[v] = (T) (((p.child)[v + 1]).key)[0];
						delete((p.child)[v + 1], (p.key)[v]);
					} else {
						mergeChild(p, v, rootK);
						if (p.keyNum == 0) 
							root = p.child[v];
						delete(rootK, k);
					}
				}
			}
		}
	}

	// ->4.基于B-树的删除运算
	private boolean isInside(Node<T> x, T k) {
		Comparable<T> key = (Comparable<T>) k;
		for (int i = 0; i < x.keyNum; i++) {
			if (key.compareTo(x.key[i]) == 0) 
				return true;
		}
		return false;
	}

	// ->4.基于B-树的删除运算
	private void mergeChild(Node<T> x, int i, Node<T> y) {
		Node<T> z = (x.child)[i + 1];
		(y.key)[degree - 1] = (x.key)[i];
		for (int j = 0; j < degree - 1; j++) {
			(y.key)[degree + j] = (z.key)[j];
		}
		if (!z.isLeaf) {
			for (int j = 0; j < degree; j++) {
				(y.child)[degree + j] = (z.child)[j];
			}
		}
		(x.child)[i + 1] = null;
		for (int j = i + 1; j < x.keyNum; j++) 
			(x.child)[j] = (x.child)[j + 1];
		(x.child)[x.keyNum] = null;
		y.keyNum = 2 * degree - 1;
		for (int j = i; j < x.keyNum; j++) {
			(x.key)[i] = (x.key)[i + 1];
		}
		(x.key)[x.keyNum - 1] = null;
		x.keyNum = x.keyNum - 1;
	}

	// ->4.基于B-树的删除运算
	private Node<T> findRootContainsK(Node<T> x, T k) {
		for (int i = 0; i < x.keyNum; i++) {
			if (isInside(x.child[i], k)) {
				return x;
			}
			if (!x.child[i].isLeaf) 
				return findRootContainsK(x.child[i], k);
		}
		return null;
	}

	// ->4.基于B-树的删除运算
	private Node<T> findParentIn(Node<T> x, Node<T> y) {
		if (x != null && y != null) {
			for (int i = 0; i <= x.keyNum; i++) {
				if (y == (x.child)[i]) {
					return x;
				}
				return findParentIn((x.child)[i], y);
			}
		}
		return null;
	}

	// 测试B-树
	public static void main(String[] args) {
		int m = 2;	// 2*m为B-树的阶
		BTree<Integer> btree = new BTree<Integer>(m);	// 2*m-1为每个结点关键码个数
		Node s = null;
		int k1 = 40;	// 待查找的关键码
		
		Result rs = null;
		btree.insert(10);	// 插入关键码
		btree.insert(20);
		btree.insert(30);
		btree.insert(40);
		btree.insert(50);
		btree.insert(60);
		
//		btree.delete(btree.root, 40);	// 删除关键码
		
		rs = btree.searchBTree(btree.root, k1);	// 按关键码查询
		
		if (rs.found) {
			System.out.println("查询结果：" + rs.resultNode.key[rs.i]);
		} else {
			System.out.println("未找到");
		}
	}

}
