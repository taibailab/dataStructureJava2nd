package ch07.sec6.test1;

import java.util.Scanner;

import ch07.sec1.RecordNode;
import ch07.sec1.SeqList;

/**
 * 7.6.1.多关键字排序<br>
 * ->例7.1.学生成绩排序<br>
 */
public class Example7_1 {
	private Scanner scanner;
	private Student[] student;
	private int number;
	private SeqList SL;

	public Example7_1() throws Exception {
		scanner = new Scanner(System.in);
		System.out.println("输入学生的个数：");
		number = scanner.nextInt();
		input(number);	// 输入数据记录
		
		SL = new SeqList(number);	// 建立顺序表
		for (int i = 0; i < student.length; i++) {
			RecordNode r = new RecordNode(new KeyScore(student[i].score), student[i]);	// 产生记录
			SL.insert(SL.length(), r);	// 把记录r插入到表SL的末尾
		}
		System.out.println("排序前");
		output();
		SL.insertSort();	// 进行排序
		System.out.println("排序后");
		output();
	}

	public void input(int n) {	// 输入学生的信息
		student = new Student[n];
		System.out.println("学生	姓名	成绩");
		for (int i = 0; i < student.length; i++) {
			int id = scanner.nextInt();
			String name = scanner.next();
			double score = scanner.nextDouble();
			student[i] = new Student(id, name, score);
		}
	}

	public void output() {	// 输出学生的信息
		System.out.println("学生	姓名	成绩");
		for (int i = 0; i < student.length; i++) {
			Student st = (Student) SL.r[i].element;
			System.out.println(st.id + "\t" + st.name + "\t" + st.score);
		}
	}

	public static void main(String[] args) throws Exception {
		Example7_1 scoresort = new Example7_1();
	}

}
