package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_8 {
	public static void main(String[] args) {
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];
		
		// 각 숫자의 갯수를 구함
		for(int i=0; i<answer.length; i++) {
			if(answer[i]==1) 
				counter[0]++;
			else if(answer[i]==2)
				counter[1]++;
			else if(answer[i]==3)
				counter[2]++;
			else
				counter[3]++;
			
//			counter[answer[i]-1]++;
		}
		
		// 배열 요소의 각 수 출력
		for(int i=0; i<counter.length; i++) {
			System.out.print(counter[i]);
			
			// 배열 각 요소의 수만큼 *출력
			for(int j=0; j<counter[i]; j++) {
				System.out.print('*');;
			}
			System.out.println();
		}
	}
}
