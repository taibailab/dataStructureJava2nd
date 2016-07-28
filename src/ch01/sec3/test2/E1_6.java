package ch01.sec3.test2;

/**
 * 例1.6.给出将整形数组a中数组元素实现就地逆置的算法
 */
public class E1_6 {
	public static void reverse(int[] a) {
		int n = a.length;
		int temp;
		for (int i = 0, j = n-1; i < j; i++, j--) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		
	}

}
