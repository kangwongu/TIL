import java.util.Arrays;

public class Exercise5_5 {

	public static void main(String[] args) {
		// 배열 1~9
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		// 복사 배열
		int[] ball3 = new int[3];
		
		// 배열 섞기 (배열 길이만큼 반복), 랜덤 수 이용
		for(int i=0; i<ballArr.length; i++) {
			int idx = (int)(Math.random()*ballArr.length);
			int tmp = ballArr[i];
			ballArr[i] = ballArr[idx];
			ballArr[idx] = tmp;
		}
		
		// 배열 복사
		ball3 = Arrays.copyOf(ballArr, 3);
//		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
		// 배열 출력
		for(int i=0; i<ball3.length; i++) {
			System.out.println(ball3[i]);
		}
	}

}
