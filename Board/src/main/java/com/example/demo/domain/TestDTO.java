package com.example.demo.domain;

public class TestDTO {

	private Long a;
	private String b;
	private String c;
	private boolean d;
	
	public Long getA() {
		return a;
	}
	public void setA(Long a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "TestDTO [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}
	
	
	
}
