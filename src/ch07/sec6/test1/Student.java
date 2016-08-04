package ch07.sec6.test1;

/**
 * 7.6.基数排序<p>
 * 7.6.1.多关键字排序<br>
 * ->方法1：先对花色排序，将其分为4个组，即梅花组、方块组、红心组和黑心组；再对每个组分别按面值进行排序；最后，将4个组连接起来即可。<br>
 * ->方法2：先按13个面值给出13个编号组(2号，3号，...，A号)，将牌按面值依次放入对应的编号组，分成13堆；再按花色给出4个编号组(梅花、方块、红心、黑心)，将2号组中的牌
 * 取出分别放入对应花色组，再将3号组中的牌取出分别放入对应花色组......这样，4个花色组中均按面值有序；最后，将4个花色组依次连接起来即可。<br>
 * ->(1).最主位优先(Most Significant Digit First)法，简称MSD法：先按k1排序分组，同一组中记录，若关键字k1相等，再对各组按k2排序分成子组；之后，对后面的关键字继续
 * 这样的排序分组，直到按最次位关键字kd对各子表排序后，再将各组连接起来，便得到一个有序序列。扑克牌按花色、面值排序中介绍的方法1即是MSD法。<br>
 * ->(2).最次位优先(Least Significant Digit First)法，简称LSD法：先从kd开始排序，再对k(d-1)进行排序，依次重复，直到对k1排序后得到一个有序序列。扑克牌按花色，面
 * 值排序中介绍的方法2即是LSD法。<br>
 * ->例7.1.学生信息类<br>
 * <p>
 * ->7.6.2.链式基数排序<br>
 */
public class Student {
	int id;	// 学号
	String name;	// 姓名
	double score;	// 成绩

	public Student(int id, String name, double score) {	// 构造方法
		this.id = id;
		this.name = name;
		this.score = score;
	}

	/*
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	*/

}
