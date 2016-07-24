package ch01.sec2.test2;

import java.util.GregorianCalendar;

/**
 * 1.订单记录类
 */
public class OrderRecord {
	public String orderNum;	// 生产订单号
	public int lineNum;	// 行号
	public String itemCode;	// 物料编码
	public String itemName;	// 物料名称
	public GregorianCalendar beginTime;	// 开工时间
	public GregorianCalendar endTime;	// 完工时间
	public String unit;	// 计量单位
	public Double amount;	// 生产数量
	public String cbill;	// 制单
	// ...

}
