package ch07.sec1;

/**
 * 7.1.排序的基本概念
 * ->待排序的顺序表类描述
 * ->顺序表类
 * 
 * 7.2.插入排序
 * 7.2.1.直接插入排序
 * ->[算法7.1].不带监视哨的直接插入排序算法。
 * ->[算法7.2].带监视哨的直接插入排序算法
 * 7.2.2.希尔排序
 * ->[算法7.3].希尔排序算法。
 * 
 * 7.3.交换排序
 * 7.3.1.冒泡排序
 * ->[算法7.4].冒泡排序算法
 * 7.3.2.快速排序
 * ->[算法7.5].一趟快速排序算法
 * ->[算法7.6].递归形式的快速排序算法
 * ->[算法7.7].顺序表快速排序算法
 * 
 * 7.4.选择排序
 * 7.4.1.直接选择排序
 * ->[算法7.8].直接选择排序
 * 
 * 
 * 
 * 
 */
public class SeqList {
	public RecordNode[] r;	// 顺序表记录结点数组
	public int curlen;	// 顺序表长度，即记录个数
	
	public SeqList() {
	}
	
	// 顺序表的构造方法，构造一个存储空间容量为maxSize的顺序表
	public SeqList(int maxSize) {
		this.r = new RecordNode[maxSize];	// 为顺序表分配maxSize个存储单元
		this.curlen = 0;	// 置顺序表的当前长度为0
	}
	
	/*
	public RecordNode[] getRecordNode() {
		return r;
	}
	public void setRecordNode(RecordNode[] r) {
		this.r = r;
	}
	*/
	
	// 求顺序表中的数据元素个数并由函数返回其值
	public int length() {
		return curlen;	// 返回顺序表的当前长度
	}
	
	// 在当前顺序表的第i个结点之前插入一个RecordNode类型的结点x，其中i取值范围为：0≤i≤length()。
	// 如果i值不在此范围则抛出异常，当i=0时表示在表头插入一个数据元素x，当i=length()时表示在表尾插入一个数据元素x
	public void insert(int i, RecordNode x) throws Exception {
		if (curlen == r.length) {	// 判断顺序表是否已满
			throw new Exception("顺序表已满");
		}
		if (i < 0 || i > curlen) {	// i小于0或者大于表长
			throw new Exception("插入位置不合理");
		}
		for (int j = curlen; j > i; j--) {
			r[j] = r[j - 1];	// 插入位置及之后的元素后移
		}
		r[i] = x;	// 插入x
		this.curlen++;	// 表长度增1
	}
	
	public void display() {	// 输出数组元素
		for (int i = 0; i < this.curlen; i++) {
			System.out.print(" " + r[i].key.toString());
		}
		System.out.println();
	}
	
	public void display(int sortMode) {	// 输出数组元素
		int i;
		if (sortMode == 9) 	// 带监视哨的直接插入排序方法，0号单元用于存放监视哨
			i = 1;
		else 
			i = 0;
		for (; i < curlen; i++) {
			System.out.print(" " + r[i].key.toString());
		}
		System.out.println();
	}
	
	// 7.2.插入排序
	// 7.2.1.直接插入排序
	// [算法7.1].不带监视哨的直接插入排序算法
	public void insertSort() {
		RecordNode temp;
		int i, j;
//		System.out.println("直接插入排序");	// 注释掉
		for (i = 1; i < this.curlen; i++) {	// n-1趟扫描
			temp = r[i];	// 将待插入的第i条记录暂存在temp中
			for (j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--) {	// 将前面比r[i]大的记录向后移动
				r[j + 1] = r[j];
			}
			r[j + 1] = temp;	// r[i]插入到第j+1个位置
//			System.out.println("第" + i + "趟：");	// 注释掉
//			display();	// 注释掉
		}
	}
	
	// 7.2.1.直接插入排序
	// [算法7.2].带监视哨的直接插入排序算法
	public void insertSortWithGuard() {
		int i, j;
		System.out.println("带监视哨的直接插入排序");
		for (i = 2; i < this.curlen; i++) {	// n-1趟扫描
			r[0] = r[i];	// 将待插入的第i条记录暂存在r[0]中，同时r[0]为监视哨
			for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--) {	// 将前面较大元素向后移动
				r[j + 1] = r[j];
			}
			r[j + 1] = r[0];	// r[i]插入到第j+1个位置
			System.out.println("第" + i + "趟：");	// 注释掉
			display();	// 注释掉
		}
	}
	
	// 7.2.2.希尔排序
	// [算法7.3].希尔排序算法
	public void shellSort(int[] d) {	// d[]为增量数组
		RecordNode temp;
		int i, j;
		System.out.println("希尔排序");
		// 控制数量，增量减半，若干趟扫描
		for (int k = 0; k < d.length; k++) {
			// 一趟中若干字表，每个记录在自己所属字表内进行直接插入排序
			int dk = d[k];
			for (i = dk; i < this.curlen; i++) {
				temp = r[i];
				for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
					r[j + dk] = r[j];
				}
				r[j + dk] = temp;
			}
			System.out.print("增量dk=" + dk + " ");
			display();
		}
	}

	// 7.3.交换排序
	// 7.3.1.冒泡排序
	// [算法7.4].冒泡排序算法
	public void bubbleSort() {
//		System.out.println("冒泡排序");
		RecordNode temp;	// 辅助结点
		boolean flag = true;	// 是否交换的标记
		for (int i = 1; i < this.curlen && flag; i++) {	// 有交换时再进行下一趟，最多n-1趟
			flag = false;	// 假定元素未交换
			for (int j = 0; j < this.curlen - i; j++) {	// 一次比较、交换
				if (r[j].key.compareTo(r[j + 1].key) > 0) {	// 逆序时，交换
					temp = r[j];
					r[j] = r[j + 1];
					r[j + 1] = temp;
					flag = true;
				}
			}
//			System.out.print("第" + i + "趟: ");
//			display();
		}
	}

	// 7.3.2.快速排序
	// ->[算法7.5].一趟快速排序算法
	// 交换排序表r[i..j]的记录，使支点记录到位，并返回其所在位置
	// 此时，在支点之前(后)的记录关键字均不大于(小于)它
	public int Partition(int i, int j) {
		RecordNode pivot = r[i];	// 第一个记录作为支点记录
//		System.out.print(i + ".." + j + ", pivot=" + pivot.key + " ");
		while (i < j) {	// 从表的两端交替地向中间扫描
			while (i < j && pivot.key.compareTo(r[j].key) <= 0) {
				j--;
			}
			if (i < j) {
				r[i] = r[j];	// 将比支点记录关键字小的记录向前移动
				i++;
			}
			while (i < j && pivot.key.compareTo(r[i].key) > 0) {
				i++;
			}
			if (i < j) {
				r[j] = r[i];	// 将比支点记录关键字大的记录向后移动
				j--;
			}
		}
		r[i] = pivot;	// 支点记录到位
//		display();
		return i;	// 返回支点位置
	}

	// 7.3.2.快速排序
	// [算法7.6].递归形式的快速排序算法
	// 对子表r[low..high]快速排序
	public void qSort(int low, int high) {
		if (low < high) {
			int pivotloc = Partition(low, high);	// 一趟排序，将排序表分成两部分
			qSort(low, pivotloc - 1);	// 低子表递归排序
			qSort(pivotloc + 1, high);	// 高子表递归排序
		}
	}

	// 7.3.2.快速排序
	// [算法7.7].顺序表快速排序算法
	public void quickSort() {
		qSort(0, this.curlen - 1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	// 7.4.选择排序
	// 7.4.1.直接选择排序
	// [算法7.8].直接选择排序
	public void selectSort() {
		
		
		
		/*
		 //   System.out.println("直接选择排序");
        RecordNode temp; //辅助结点
        for (int i = 0; i < this.curlen - 1; i++) {//n-1趟排序
            //每趟在从r[i]开始的子序列中寻找最小元素
            int min = i;               //设第i条记录的关键字最小
            for (int j = i + 1; j < this.curlen; j++) {//在子序列中选择关键字最小的记录
                if (r[j].key.compareTo(r[min].key) < 0) {
                    min = j;             //记住关键字最小记录的下标
                }
            }
            if (min != i) {    //将本趟关键字最小的记录与第i条记录交换
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        //    System.out.print("第" + (i + 1) + "趟: ");
        //    display();
        }
		 */
	}

	
	
	
	
	
	


	/*
    //【算法7.9】 树形选择排序(锦标赛排序)
    //建立树的顺序存储数组tree,并对其排序，并将结果返回到r中
    void tournamentSort() {
        TreeNode[] tree;   //胜者树结点数组
        int leafSize = 1;  //胜者树的叶子结点数
        //得到胜者树叶子结点(外结点)的个数，该个数必须是2的幂
        while (leafSize < this.curlen) {
            leafSize *= 2;
        }
        int TreeSize = 2 * leafSize - 1;   //胜者树的所有节点数
        int loadindex = leafSize - 1;      //叶子结点(外结点)存放的起始位置
        tree = new TreeNode[TreeSize];
        int j = 0;
        //把待排序结点复制到胜者树的叶子结点中
        for (int i = loadindex; i < TreeSize; i++) {
            tree[i] = new TreeNode();
            tree[i].index=i;
            if (j < this.curlen) {      //复制结点
                tree[i].active=1;
                tree[i].data=r[j++];
            } else {
                tree[i].active=0 ;   //空的外结点
            }
        }
        int i = loadindex;    //进行初始比较查找关键码最小结点
        while (i > 0) {      //产生胜者树
            j = i;
            while (j < 2 * i) {   //处理各对比赛者
                if (tree[j + 1].active == 0 || ((tree[j].data).key.compareTo((tree[j + 1].data).key)) <= 0) {
                    tree[(j - 1) / 2] = tree[j];      //左孩子(胜者)赋值给父结点
                } else {
                    tree[(j - 1) / 2] = tree[j + 1];  //右孩子(胜者)赋值给父结点
                }
                j += 2;     //下一对比赛者
            }
            i = (i - 1) / 2;    //处理上层结点
        }
        for (i = 0; i < this.curlen - 1; i++) {  //处理剩余的n-1个记录
            r[i] = tree[0].data;               //将胜者树的根(最小者)存入数组r
            tree[tree[0].index].active=0;  //该元素相应外结点不再比赛
            updateTree(tree, tree[0].index);   //调整胜者树
        }
        r[this.curlen - 1] = tree[0].data;
    }

    //【算法7.10】树形选择排序的调整算法，i是当前最小关键字记录的下标
    void updateTree(TreeNode[] tree, int i) {
        int j;
        if (i % 2 == 0) { //i为偶数，对手为左结点
            tree[(i - 1) / 2] = tree[i - 1];
        } else { //i为奇数，对手为右结点
            tree[(i - 1) / 2] = tree[i + 1];
        }
        i = (i - 1) / 2;   //最小元素输出后，其对手上升到父结点
        while (i > 0) {          //直到i==0
            if (i % 2 == 0) {   //i为偶数，对手为左结点
                j = i - 1;
            } else {            //i为奇数，对手为右结点
                j = i + 1;
            }
            //比赛对手中有一个为空
            if (tree[i].active == 0 || tree[j].active == 0) {
                if (tree[i].active == 1) {
                    tree[(i - 1) / 2] = tree[i];  //i可参选，i上升到父结点
                } else {
                    tree[(i - 1) / 2] = tree[j];  //否则，j上升到父结点
                }
            } else //双方都可参选
            //关键码小者上升到父结点
            if ((tree[i].data).key.compareTo((tree[j].data).key) <= 0) {
                tree[(i - 1) / 2] = tree[i];
            } else {
                tree[(i - 1) / 2] = tree[j];
            }
            i = (i - 1) / 2;     //i上升到父结点
        }
    }

    //【算法7.11】将以筛选法调整堆算法
    //将以low为根的子树调整成小顶堆，low、high是序列下界和上界
    public void sift(int low, int high) {
        int i = low;                                //子树的根
        int j = 2 * i + 1;                         //j为i结点的左孩子
        RecordNode temp = r[i];
        while (j < high) {  //沿较小值孩子结点向下筛选
            if (j < high - 1 && r[j].key.compareTo(r[j + 1].key) > 0) {
                j++; //数组元素比较,j为左右孩子的较小者
            }
            if (temp.key.compareTo(r[j].key) > 0) { //若父母结点值较大
                r[i] = r[j];           //孩子结点中的较小值上移
                i = j;
                j = 2 * i + 1;
            } else {
                j = high + 1;          //退出循环
            }
        }
        r[i] = temp;                   //当前子树的原根值调整后的位置
    //    System.out.print("sift  " + low + ".." + high + "  ");
    //    display();
    }

    //【算法7.12】 堆排序算法
    public void heapSort() {
       // System.out.println("堆排序");
        int n = this.curlen;
        RecordNode temp;
        for (int i = n / 2 - 1; i >= 0; i--) {//创建堆
            sift(i, n);
        }
        for (int i = n - 1; i > 0; i--) {//每趟将最小值交换到后面，再调整成堆
            temp = r[0];
            r[0] = r[i];
            r[i] = temp;
            sift(0, i);
        }
    }

    //【算法7.13】两个有序序列的归并算法
    //把r数组中两个相邻的有序表r[h]-r[m]和r[m+1]-r[t]归并为一个有序表order[h]-order[t]
    public void merge(RecordNode[] r, RecordNode[] order, int h, int m, int t) {
        int i = h, j = m + 1, k = h;
        while (i <= m && j <= t) {//将r中两个相邻子序列归并到order中
            if (r[i].key.compareTo(r[j].key) <= 0) {//较小值复制到order中
                order[k++] = r[i++];
            } else {
                order[k++] = r[j++];
            }
        }
        while (i <= m) {//将前一个子序列剩余元素复制到order中
            order[k++] = r[i++];
        }
        while (j <= t) {//将后一个子序列剩余元素复制到order中
            order[k++] = r[j++];
        }
    }

    //【算法7.14】一趟归并算法
    //把数组r[n]中每个长度为s的有序表两两归并到数组order[n]中
    //s 为子序列的长度，n为排序序列的长度
    public void mergepass(RecordNode[] r, RecordNode[] order, int s, int n) {
        System.out.print("子序列长度s=" + s + "  ");
        int p = 0;  //p为每一对待合并表的第一个元素的下标，初值为0
        while (p + 2 * s - 1 <= n - 1) {  //两两归并长度均为s的有序表
            merge(r, order, p, p + s - 1, p + 2 * s - 1);
            p += 2 * s;
        }
        if (p + s - 1 < n - 1) {  //归并最后两个长度不等的有序表
            merge(r, order, p, p + s - 1, n - 1);
        } else {
            for (int i = p; i <= n - 1; i++) //将剩余的有序表复制到order中
            {
                order[i] = r[i];
            }
        }
    }

    //【算法7.15】2-路归并排序算法
    public void mergeSort() {
        System.out.println("归并排序");
        int s = 1;                      //s为已排序的子序列长度，初值为1
        int n = this.curlen;
        RecordNode[] temp = new RecordNode[n];  //定义长度为n的辅助数组temp
        while (s < n) {
            mergepass(r, temp, s, n);  //一趟归并，将r数组中各子序列归并到temp中
            display();
            s *= 2;                     //子序列长度加倍
            mergepass(temp, r, s, n);  //将temp数组中各子序列再归并到r中
            display();
            s *= 2;
        }
    }

    // 【算法8.1】顺序查找算法
    // 从顺序表r[0]到r[n-1]的n个元素中顺序查找出关键字为key的记录
    // 若查找成功返回其下标，否则返回-1
    public int seqSearch(Comparable key) {
        int i = 0, n = length();
        while (i < n && r[i].key.compareTo(key) != 0) {
            i++;
        }
        if (i < n) {   //查找成功则返回该元素的下标i，否则返回-1
            return i;
        } else {
            return -1;
        }
    }

    // 【算法8.2】带监视哨的顺序查找算法
    // 从顺序表r[1]到r[n]的n个元素中顺序查找出关键字为key的元素
    // 若查找成功返回其下标，否则返回-1
    public int seqSearchWithGuard(Comparable key) {
        int i = length()-1 ;
        r[0].key=key;    //哨兵
        while ((r[i].key).compareTo(key) != 0) {
            i--;
        }
        if (i > 0) {
            return i;
        } else {
            return -1;
        }
    }

    //【算法8.3】二分查找算法，
    //数组元素已按升序排列，若查找成功返回元素下标，否则返回-1
    public int binarySearch(Comparable key) {
        if (length() > 0) {
            int low = 0, high = length() - 1; //查找范围的下界和上界
            while (low <= high) {
                int mid = (low + high) / 2;   //中间位置，当前比较元素位置
                //    System.out.print(r[mid].key + "? ");
                if (r[mid].key.compareTo(key) == 0) {
                    return mid;                                //查找成功
                } else if (r[mid].key.compareTo(key) > 0) { //给定值更小
                    high = mid - 1;     //查找范围缩小到前半段
                } else {
                    low = mid + 1;      //查找范围缩小到后半段
                }
            }
        }
        return -1;  //查找不成功
    }

}

class TreeNode {      //胜者树的结点类

    public RecordNode data;  //排序记录结点数据值
    public int index;        //结点在满二叉树中的序号
    public int active;       //参加选择标志，1表示参选，0表示不参选
/ *
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public RecordNode getData() {
        return data;
    }

    public void setData(RecordNode data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
* /
	 */

}
