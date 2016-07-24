package ch01.sec2.test3;

/**
 * 复数抽象数据类型的接口表示
 */
public interface IComplex {
	public double getReal();	// 取实部
	public void setReal(double real);	// 修改虚部
	public double getImag();	// 取虚部
	public void setImag(double imag);	// 修改虚部
	public void add(IComplex Z);	// 两个复数的求和

}
