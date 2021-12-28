import java.util.Scanner;

public class Ex4_5 {

	public static void main(String[] args) {
		// 변수
		int score = 0;		// 점수
		char grade = ' ';	// 학점
		char opt = '0';		// 세부 학점
		
		// 점수 입력
		System.out.print("점수를 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		// 점수에 따라 grade 부여
		// grade 부여 시, 점수에 따라 opt도 부여
		if(score >= 90) {
			grade = 'A';
			if(score >= 98) {
				opt = '+';
			} else if(score <= 94) {
				opt = '-';
			}
		} else if(score >= 80) {
			grade = 'B';
			if(score >= 88) {
				opt = '+';
			} else if(score <= 84) {
				opt = '-';
			}
		} else if(score >= 70) {
			grade = 'C';
			if(score >= 78) {
				opt = '+';
			} else if(score >= 74) {
				opt = '-';
			}
		} else {
			grade = 'D';
		}
		
		System.out.printf("당신의 학점은 %c%c입니다.", grade, opt);
	}

}
