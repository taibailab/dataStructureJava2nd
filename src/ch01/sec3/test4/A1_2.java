package ch01.sec3.test4;

/**
 * 1.3.4.算法设计举例
 * ->算法1.2.
 */
public class A1_2 {
	public static int maxSub_2(int[] sequence) {
		int max = 0;
		int n = sequence.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += sequence[j];
				if (sum > max) 
					max = sum;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] sequence = new int[]{-2, 11, -4, 13, -5, 2, -5, -3, 12, -9};
		int maxSeq = maxSub_2(sequence);
		System.out.println(maxSeq);
	}

}
