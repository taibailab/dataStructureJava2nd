package ch01.sec3.test3;

/**
 * 例1.7.对于如下求两个n阶矩阵相乘的算法，求其算法的时间复杂度。
 */
public class E1_7 {
	public static void squareMult(int[][] a, int[][]b, int[][] c, int n) {
		for (int i = 0; i < n; i++) {	// n+1
			for (int j = 0; j < n; j++) {	// n(n+1)
				c[i][j] = 0;	// n^2
				for (int k = 0; k < n; k++)	// (n^2)(n+1)
					c[i][j] += a[i][k] * b[k][j];	// n^3
			}
		}
	}

}
