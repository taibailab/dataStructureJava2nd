package ch01.sec3;

/**
 * 1.3.4.算法设计举例
 * ->算法1.3.
 */
public class A1_3 {
	public static int maxSum_3(int[] sequence, int left, int right) {
		if (left == right) 
			if (sequence[left] > 0) 
				return sequence[left];
			else 
				return 0;
		int mid = (left + right) / 2;
		int maxLeftSum = maxSum_3(sequence, left, mid);
		int maxRightSum = maxSum_3(sequence, mid + 1, right);
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = mid; i >= left; i--) {
			leftBorderSum += sequence[i];
			if (leftBorderSum > maxLeftBorderSum) 
				maxLeftBorderSum = leftBorderSum;
		}
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = mid + 1; i <= right; i++) {
			rightBorderSum += sequence[i];
			if (rightBorderSum > maxRightBorderSum) 
				maxRightBorderSum = rightBorderSum;
		}
		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}
	
	public static int max3(int a, int b, int c) {
		int max = a > b ? a:b;
		max = max > c ? max:c;
		return max;
	}
	
	public static int maxSub_3(int[] sequence) {
		return maxSum_3(sequence, 0, sequence.length - 1);
	}
	
	
	public static void main(String[] args) {
		int[] sequence = new int[]{-2, 11, -4, 13, -5, 2, -5, -3, 12, -9};
		int maxSeq = maxSub_3(sequence);
		System.out.println(maxSeq);
	}

}
