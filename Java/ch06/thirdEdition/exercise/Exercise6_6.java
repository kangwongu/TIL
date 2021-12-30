package thirdEdition.exercise;

public class Exercise6_6 {
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
	}
	
	// 두점의 거리를 계산하는 공식
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.abs(((x-x1)*(x-x1))+((y-y1)*(y-y1)))); 
	}
}
