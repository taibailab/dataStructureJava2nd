package ch01;

public class Complex implements IComplex {
	private double real;	// 实部
	private double imag;	// 虚部
	
	// 构造一个实数
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	// 取实部
	@Override
	public double getReal() {
		return real;
	}

	// 修改实部
	@Override
	public void setReal(double real) {
		this.real = real;
	}

	// 取虚部
	@Override
	public double getImag() {
		return imag;
	}

	// 修改虚部
	@Override
	public void setImag(double imag) {
		this.imag = imag;
	}

	// 两个复数的求和
	@Override
	public void add(IComplex Z) {
		if (Z != null) {
			real += Z.getReal();
			imag += Z.getImag();
		}
	}

}
