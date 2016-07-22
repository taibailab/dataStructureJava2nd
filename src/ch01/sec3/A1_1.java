package ch01.sec3;

/**
 * 1.3.4.算法设计举例
 * ->算法1.1.
 */
public class A1_1 {
	public static int maxSub(int[] sequence) {
		int max = 0;
		int n = sequence.length;
		int sum = 0;
		// 第一重循环执行一次则计算出长度为i的所有子序列和最大值
		for (int i = 1; i <= n; i++) 
			for (int j = 0; j < n; j++) {
				sum = 0;
				for (int k = j; k < j + i && k < n; k++) 
					sum += sequence[k];
				if (sum > max) 
					max = sum;
			}
		return max;
	}
	
	public static void main(String[] args) {
		int[] sequence = new int[]{-2, 11, -4, 13, -5, 2, -5, -3, 12, -9};
		int maxSeq = maxSub(sequence);
		System.out.println(maxSeq);
	}

}
