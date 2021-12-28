import java.util.Scanner;

public class Ex4_7 {

	public static void main(String[] args) {
		int num = 0;
		
		for(int i=1; i<=5; i++) {
			num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
		}
		System.out.println();
		
		// 1~10사이의 난수 20개 출력
		// 1,2,3,4,5,6,7,8,9,10 10개
		for(int i=1; i<=20; i++) {
			num = (int)(Math.random() * 10) + 1;
			System.out.println(num);
		}
		System.out.println();
		
		// -5~5사이의 난수 20개 출력
		// -5,-4,-3,-2,-1,0,1,2,3,4,5 11개
//		for(int i=0; i<20; i++) {
//			num = (int)(Math.random() * 11) - 5;
//			System.out.println(num);
//		}
		
	}

}
