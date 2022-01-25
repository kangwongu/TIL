package thirdedition.exercise;

import java.util.Arrays;

public class Exercise5_5 {

	public static void main(String[] args) {
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// 배열 ballArr를 랜덤으로 섞는다
		for(int i=0; i<ballArr.length; i++) {
			// 1. 랜덤값을 받는다 (배열의 자리값)
			int idx = (int)(Math.random()*9);
			// 2. 자리 바꿀 때 임의로 담아놓을 변수 선언
			int temp = 0;
			// 3. 자리 바꾼다.
			temp = ballArr[i];
			ballArr[i] = ballArr[idx];
			ballArr[idx] = temp;
		}
		
		// ballArr배열 앞의 3자리를 ball3에 복사
		ball3 = Arrays.copyOfRange(ballArr, 0, 3);
		
		System.out.println(Arrays.toString(ballArr));
		System.out.println(Arrays.toString(ball3));
	}

}
