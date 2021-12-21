package baekjoon;

import java.util.Scanner;

public class Ex10951 {
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()) {
			// 두 수를 입력받음
			int a = scanner.nextInt();
			int b = scanner.nextInt();
	
			// 합을 구함
			System.out.println(a+b);
		}
	}
}
