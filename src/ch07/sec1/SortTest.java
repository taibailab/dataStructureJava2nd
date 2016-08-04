package ch07.sec1;

import java.util.Scanner;

/**
 * 第7章.内排序<p>
 * ->第7章.排序测试
 */
public class SortTest {
	public static void main(String[] args) throws Exception {
//		int[] d = {52, 39, 67, 95, 70, 8, 25, 52};
		int[] d = {52, 39, 67, 95, 70, 8, 25, 52, 
				03, 47, 43, 73, 86, 36, 96, 47, 36, 61, 
				46, 98, 63, 71, 62, 97, 74, 24, 67, 62, 
				42, 81, 14, 57, 20, 42, 53, 32, 37, 32, 
				16, 76, 02, 27, 66, 56, 50, 26, 71, 07, 
				32, 90, 79, 78, 53, 12, 56, 85, 99, 26, 
				96, 96, 68, 27, 31, 05, 03, 72, 93, 15, 
				55, 59, 56, 35, 64, 38, 54, 82, 46, 22, 
				31, 62, 43,  9, 90, 16, 22, 77, 94, 39, 
				49, 54, 43, 54, 82, 17, 37, 93, 23, 78, 
				84, 42, 17, 53, 31, 57, 24, 55, 06, 88, 
				
				77, 04, 74, 47, 67, 63, 01, 63, 78, 59, 
				16, 95, 55, 67, 19, 98, 10, 50, 71, 75, 
				33, 21, 12, 34, 29, 78, 64, 56, 07, 82, 
				52, 42, 07, 44, 28, 57, 60, 86, 32, 44, 
				 9, 47, 27, 96, 54, 49, 17, 46,  9, 62, 
				18, 18, 07, 92, 46, 44, 17, 16, 58,  9, 
				79, 83, 86, 19, 62, 26, 62, 38, 97, 75, 
				84, 16, 07, 44, 99, 83, 11, 46, 24, 23, 
				42, 40, 54, 74, 82, 97, 77, 77, 81, 07, 
				45, 32, 14,  8, 62, 36, 28, 19, 95, 50, 
				
				92, 26, 11, 97, 00, 56, 76, 31, 38, 37, 
				85, 94, 35, 12, 83, 39, 50,  8, 30, 42, 
				34, 07, 96, 88, 70, 29, 17, 12, 13, 40, 
				33, 20, 38, 26, 13, 89, 51, 03, 74, 56, 
				62, 18, 37, 35, 96, 83, 50, 87, 75, 97, 
				12, 25, 93, 47, 99, 49, 57, 22, 77, 88, 
				42, 95, 45, 72, 16, 64, 36, 16, 00, 16, 
				 8, 15, 04, 72, 33, 27, 14, 34,  9, 45, 
				59, 34, 68, 49, 31, 16, 93, 32, 43, 50, 
				27, 89, 87, 19, 20, 15, 37, 00, 49};
		
		int[] dlta = {5, 3, 1};	// 希尔排序增量数组
		
		int maxSize = 320;	// 顺序表空间大小
		SeqList L = new SeqList(maxSize);	// 建立顺序表
		
		for (int i = 0; i < d.length; i++) {
			RecordNode r = new RecordNode(d[i]);
			L.insert(L.length(), r);
		}
		
		System.out.println("排序前：");
		L.display();
		
		System.out.println("请选择排序方法：");
		System.out.println("1-直接插入排序");
		System.out.println("2-希尔排序");
		System.out.println("3-冒泡排序");
		System.out.println("4-快速排序");
		System.out.println("5-直接选择排序");
		System.out.println("6-树形选择排序");
		/*
        System.out.println("7-堆排序");
        */
		System.out.println("8-归并排序");
		System.out.println("9-带监视哨的直接插入排序");
		Scanner s = new Scanner(System.in);
		int xz = s.nextInt();
		long startTime = System.currentTimeMillis();
		switch (xz) {
		case 1:
			L.insertSort();
			break;	// 直接插入排序
		case 2:
			L.shellSort(dlta);
			break;	//  希尔排序
		case 3:
			L.bubbleSort();
			break;	// 冒泡排序
		case 4:
			L.quickSort();
			break;	// 快速排序
		case 5:
			L.selectSort();
			break;	// 直接选择排序
		case 6:
			L.tournamentSort();
			break;	// 树形选择排序
			/*
			case 7:
                L.heapSort();
                break;               //堆排序
			 */
			
			
			
			
		case 8:
			L.mergeSort();
			break;	// 归并排序
		case 9:
			L.insert(0, new RecordNode(0));	// 在0号单元插入一个元素。
			L.insertSortWithGuard();
			break;	// 带监视哨的直接插入排序，需要改insert和display
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		System.out.println("排序后：");
		L.display(xz);
	}

}
