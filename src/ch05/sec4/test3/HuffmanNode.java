package ch05.sec4.test3;

/**
 * 5.4.哈夫曼树及哈夫曼编码
 * 5.4.1.哈夫曼树的基本概念
 * ->1.结点间的路径和结点的路径长度
 * ->2.结点的权和结点的带权路径长度
 * ->3.树的带权路径长度
 * ->4.最优二叉树
 * 5.4.2.哈夫曼树和哈夫曼编码的构造方法
 * ->1.哈夫曼树的构造
 * ->2.用哈夫曼树进行编码
 * ->[例5.8].已知在一个信息通信联络中使用了8个字符：a、b、c、d、e、f、g和h，每个字符的使用频率分别为：6、30、8、9、15、24、4和12。试设计各个字符的哈夫曼编码。
 * ->3.用哈夫曼树进行译码
 * 5.4.3.构造哈夫曼树和哈夫曼编码类的描述
 * ->哈夫曼树的节点类
 */
public class HuffmanNode {
	public int weight;	// 结点的权值
	public int flag;	// 加入哈夫曼树的标志，flag=0时表示该结点未加入哈夫曼树，flag=1时则表示该结点已加入哈夫曼树
	public HuffmanNode parent, lchild, rchild;	// 父结点及左右孩子结点

	public HuffmanNode() {	// 构造一个空结点
		this(0);
	}

	public HuffmanNode(int weight) {	// 构造一个具有权值的结点
		this.weight = weight;
		flag = 0;
		parent = lchild = rchild = null;
	}

}
