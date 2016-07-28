package ch01.sec3.test3;

/**
 * 例1.8.对于如下计算整形数组a[0, ... n-1]各元素之和的算法，求其算法的时间复杂度。
 */
public class E1_8 {
	public static int sum(int[] a) {
		int n = a.length, s = 0;	// 1
		for (int i = 0; i < n; i++)	// n+1
			s = s + a[i];	// n
		return s;	// 1
	}

}
