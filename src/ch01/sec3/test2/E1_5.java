package ch01.sec3.test2;

/**
 * 例1.5.给出求整形数组a中最大值的算法
 */
public class E1_5 {
	public static int maxEle(int[] a) {
		int n = a.length;
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] intArray = new int[]{3, 4, 2, 22, 2, 8, 9};
		int maxEle = maxEle(intArray);
		System.out.println(maxEle);
	}

}
