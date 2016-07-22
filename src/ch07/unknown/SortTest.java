package ch07.unknown;

import java.util.Scanner;

import ch07.sec1.RecordNode;
import ch07.sec1.SeqList;

/**
 * 
 * 第7章  排序测试
 */
public class SortTest {
	public static void main(String[] args) throws Exception {
		int[] d = {52, 39, 67, 95, 70, 8, 25, 52};
		
		int[] dlta = {5, 3, 1};	// 希尔排序增量数组
		
		int maxSize = 20;	// 顺序表空间大小
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
		/*
        System.out.println("6-树形选择排序");
        System.out.println("7-堆排序");
        System.out.println("8-归并排序");
        */
		System.out.println("9-带监视哨的直接插入排序");
		Scanner s = new Scanner(System.in);
		int xz = s.nextInt();
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
			
			
			
			
			
			
		case 9:
			L.insert(0, new RecordNode(0));	// 在0号单元插入一个元素。
			L.insertSortWithGuard();
			break;	// 带监视哨的直接插入排序，需要改insert和display
		}
		/*
        switch (xz) {
            case 5:
                L.selectSort();
                break;               //直接选择排序
            case 6:
                L.tournamentSort();
                break;           //树形选择排序
            case 7:
                L.heapSort();
                break;               //堆排序
            case 8:
                L.mergeSort();
                break;              //归并排序
        }
		 */
		System.out.println("排序后：");
		L.display(xz);
	}

}
