package ch06.sec1.test2;

/**
 * 第6章.图<p>
 * 6.1.图概述<p>
 * 6.1.1.图的基本概念<br>
 * 6.1.2.图的抽象数据类型描述<br>
 * ->图的抽象数据类型接口
 */
public interface IGraph {
	// 创建一个图
	void createGraph();

	// 返回图中的顶点数
	int getVexNum();

	// 返回图中的边数
	int getArcNum();

	// 给定顶点的位置v，返回其对应的顶点值，其中，0<=v<vexNum(vexNum为顶点数)
	Object getVex(int v);

	// 给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
	int locateVex(Object vex);

	// 返回v的第一个邻接点，若v没有邻接点，则返回-1，其中0≤v<vexNum
	int firstAdjVex(int v) throws Exception;

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v，w<vexNum
	int nextAdjVex(int v, int w);

}
