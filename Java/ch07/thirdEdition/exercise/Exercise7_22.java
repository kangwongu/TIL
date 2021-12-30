package thirdEdition.exercise;

import java.util.Arrays;

// �߻� Ŭ����
abstract class Shape {
	Point p;	// ���԰���, Point�� ���������� �����
	
	Shape(Point p) {
		this.p = p;
	}
	
	// �߻�޼ҵ�, ��ӹ޴� Ŭ�������� ������ �����ؾ� ��
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
	
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point() {
		this(0,0);
	}
	
	public String toString() {
		return "["+x+","+y+"]";
	}
}

class Circle extends Shape {
	double r;
	Point p;
	
	Circle(Point p, double r) {
		super(p);
		this.r = r;
	}
	
	Circle(double r) {
		this(new Point(0,0), r);
	}
	
	@Override
	double calcArea() {
		return Math.PI*r*r;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	Point p;
	
	Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	Rectangle(double width, double height) {
		this(new Point(0,0), width, height);
	}

	@Override
	double calcArea() {
		return width*height;
	}
	
	boolean isSquare() {
		return (width!=0 && height!=0) && (width==height);
	}
	
	
}




public class Exercise7_22 {
	public static double sumArea(Shape[] arr) {
		double total = 0.0;
		for(int i=0; i<arr.length; i++) {
			total += arr[i].calcArea();
		}
		return total;
	}
	
	public static void main(String[] args) {
		// �ϳ��� �迭�� ������ü�� ��´� -> ������ ����
		Shape[] arr = { new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println(sumArea(arr));
	}
}
