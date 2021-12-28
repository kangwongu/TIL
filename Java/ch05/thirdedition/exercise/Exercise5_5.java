package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_5 {

	public static void main(String[] args) {
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// ballArr의 요소들을 섞는다
		for(int i=0; i<ballArr.length; i++) {
			// 0~8 랜덤 수
			int idx = (int)(Math.random()*9);
			// 자리바꾸기
			int tmp = ballArr[i];
			ballArr[i] = ballArr[idx];
			ballArr[idx] = tmp;
		}
		
		// ball3에 ballArr의 요소 3개 복사
		ball3 = Arrays.copyOfRange(ballArr, 0, 3);
		System.out.println(Arrays.toString(ball3));
	}

}
