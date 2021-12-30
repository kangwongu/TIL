package thirdEdition.exercise;

public class Exercise6_7 {
	public static void main(String[] args) {
		// 객체 생ㅅ어
		MyPoint m = new MyPoint(1,1);
		
		System.out.println(m.getDistance(2, 2));
	}
}

class MyPoint {
	// 속성
	int x;
	int y;
	
	// 생성자
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 기능
	// 두점의 거리를 계산하는 공식
	double getDistance(int x1, int y1) {
		return Math.sqrt(Math.abs(((x-x1)*(x-x1))+((y-y1)*(y-y1)))); 
	}
	
}
