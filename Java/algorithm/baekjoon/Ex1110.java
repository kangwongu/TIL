package baekjoon;

import java.util.Scanner;

public class Ex1110 {
	public static void main(String[] args) {
		// �Է�
		Scanner scanner = new Scanner(System.in);
		int count=0;	// ����Ŭ(�ݺ�Ƚ��)
		int num = scanner.nextInt();	// �Է¹��� ����
		int copyNum = num;
		
//		System.out.println((num%10*10)+((num/10)+(num%10))%10);
		while(true) {
			copyNum = ((copyNum%10*10)+((copyNum/10)+(copyNum%10))%10);
			
			++count;
			if(num==copyNum)
				break;
			
		}
		
		System.out.println(count);
		
	}
}
