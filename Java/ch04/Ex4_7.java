import java.util.Scanner;

public class Ex4_7 {

	public static void main(String[] args) {
		int num = 0;
		
		for(int i=1; i<=5; i++) {
			num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
		}
		System.out.println();
		
		// 1~10������ ���� 20�� ���
		// 1,2,3,4,5,6,7,8,9,10 10��
		for(int i=1; i<=20; i++) {
			num = (int)(Math.random() * 10) + 1;
			System.out.println(num);
		}
		System.out.println();
		
		// -5~5������ ���� 20�� ���
		// -5,-4,-3,-2,-1,0,1,2,3,4,5 11��
//		for(int i=0; i<20; i++) {
//			num = (int)(Math.random() * 11) - 5;
//			System.out.println(num);
//		}
		
	}

}
