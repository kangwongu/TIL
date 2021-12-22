package baekjoon;

import java.util.Scanner;

public class Ex4344 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// 몇 개를 테스트 할 지?
		int testCase = scanner.nextInt();
		int[] scores;
		
		// testCase만큼 반복
		for(int i=0; i<testCase; i++) {
			// 몇 명의 점수를 입력받을지?
			scores = new int[scanner.nextInt()];
			
			double hab = 0;	// 합
			
			// 성적 입력
			for(int j=0; j<scores.length; j++) {
				scores[j] = scanner.nextInt();
				hab += scores[j];
			}
			
			double average = hab/scores.length;	// 평균
			double count = 0;					// 평균을 넘는 학생들 수
			
			// 평균을 넘는 학생들 체크
			for(int k=0; k<scores.length; k++) {
				if(scores[k] > average) 
					count++;
			}
			
			// 평균을 넘는 인원들의 비율 산출
			System.out.printf("%.3f%%\n", (count/scores.length)*100);
		
		}
		
	}
}
