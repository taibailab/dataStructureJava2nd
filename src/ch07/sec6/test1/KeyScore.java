package ch07.sec6.test1;

/**
 * 7.6.1.多关键字排序<br>
 * ->例7.1.顺序表记录结点关键字类<br>
 */
public class KeyScore implements Comparable<KeyScore> {
	private double score;	// 关键字

	public KeyScore(double score) {
		this.score = score;
	}

	// 覆盖Comparable接口中比较关键字大小的方法compareTo
	@Override
	public int compareTo(KeyScore another) {
		double thisVal = this.score;
		double anotherVal = another.score;
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}

	@Override
	public String toString() {	// 覆盖toString()方法
		return score + " ";
	}

}
