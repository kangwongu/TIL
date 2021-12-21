package baekjoon;

import java.util.Scanner;

public class Ex8958 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 입력, 몇 개의 ox문제
		String[] arr = new String[scanner.nextInt()];
		
		// ox문제 입력
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.next();
		}
		
		// 각 ox문제의 점수 도출
		for(int i=0; i<arr.length; i++) {
			int score=0;
			int sum=0;
			
			for(int j=0; j<arr[i].length(); j++) {
				// O이면
				if(arr[i].charAt(j)=='O') {
					score++;
				// X면
				} else {
					score=0;
				}
				// 점수 구하기
				sum += score;	
			}
			System.out.println(sum);
		}
		
	}
}
