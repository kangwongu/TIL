package thirdedition.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5_8 {
	public static void main(String[] args) {
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];
		
		// answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 별 찍기
		
		// 1. answer에 담긴 요소들의 숫자를 센다
		for(int i=0; i<answer.length; i++) {
			// 2. 배열의 각 요소를 순회하면서 조건문으로 체크해 숫자를 센다, (결과는 counter에 담기)
			switch(answer[i]) {
			case 1:
				counter[0]++;
				break;
			case 2:
				counter[1]++;
				break;
			case 3:
				counter[2]++;
				break;
			case 4:
				counter[3]++;
			}
		}		
		// 별찍기
		for(int i=0; i<counter.length; i++) {
			System.out.print(counter[i]);
			for(int j=0; j<counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
