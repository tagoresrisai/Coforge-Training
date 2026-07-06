package com.coforge.day4.abstraction;

public abstract class Figure {
	private int length;
	private int breadth;
	private int side;
	private long base;
	private long height;
	
	public Figure(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	public Figure(int side) {
		this.side = side;
	}
	public Figure(long base, long height) {
		this.base = base;
		this.height = height;
	}
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getSide() {
		return side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public long getBase() {
		return base;
	}
	public void setBase(long base) {
		this.base = base;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public abstract void area();

}
