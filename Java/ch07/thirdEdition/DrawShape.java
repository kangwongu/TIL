package thirdEdition;

public class DrawShape {
	public static void main(String[] args) {
		Point[] p = {	new Point(100, 100),
						new Point(140, 50),
						new Point(200, 100)
					};
		
		Triangle t = new Triangle(p);
		Circle c = new Circle(new Point(150,150), 50);
		
		t.color = "red";
		t.draw();
		c.draw();
	}
}

// 도형클래스 (조상)
class Shape {
	// 공통적인 부분이 포함
	// 속성
	String color = "black";
	
	// 기능
	void draw() {
		System.out.printf("[color=%s]\n", color);
	}
}

// 점클래스 (포함)
class Point {
	// 속성
	int x;
	int y;
	
	// 생성자
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point() {
		this(0,0);
	}
	
	// 기능
	String getXY() {
		return "("+x+","+y+")";
	}
}


// 도형클래스 자손
class Circle extends Shape {
	// 도형클래스의 자손, 점클래스를 포함
	Point center;
	int r;
	
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() {
		System.out.printf("[center=(%d, %d), r=%d, color=%s]\n"
									,center.x, center.y, r, color);
	}
}

// 도형클래스 자손
class Triangle extends Shape {
	Point[] p = new Point[3];
	
	Triangle(Point[] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]\n"
							,p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
