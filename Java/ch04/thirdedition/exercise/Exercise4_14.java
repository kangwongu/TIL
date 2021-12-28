package thirdedition.exercise;

import java.util.Scanner;

public class Exercise4_14 {
	public static void main(String[] args) {
		int answer = (int)(Math.random()*100)+1;
		System.out.println(answer);
		int input = 0;	// 사용자가 입력한 수
		int count = 0;	// 몇번시도했는지
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1~100사이의 수를 입력하세요>>");
			input = scanner.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("정답!");
				System.out.println("시도횟수는 "+count+"번 입니다.");
				break;
			}
			
		} while(true);
	}
}
