package baekjoon;

import java.util.Scanner;

public class Ex1110 {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int count=0;	// 사이클(반복횟수)
		int num = scanner.nextInt();	// 입력받을 정수
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
