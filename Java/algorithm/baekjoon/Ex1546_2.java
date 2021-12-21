package baekjoon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ex1546_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 1. 시험 볼 과목 개수 입력
		// 2. 시험 점수 입력
		double[] arr = new double[scanner.nextInt()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextDouble();
		}
		
		// 3. 최대값 도출
		// 4. 시험 점수 /max*100으로 변경
		Arrays.sort(arr);
		double hab = 0;
		for(int i=0; i<arr.length; i++) {
			hab += (arr[i] / arr[arr.length-1] * 100);
		}
		
		// 5. 최종 평균 구하기
		System.out.println(hab/arr.length);
		
		
	}
}
