import java.util.Arrays;

public class Ex5_5 {

	public static void main(String[] args) {
		int[] ball = new int[45];
		
		// 배열 초기화 1~45
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}
		System.out.println(Arrays.toString(ball));
		
		// 0~5번째 요소만 섞기
		for(int i=0; i<6; i++) {
			int idx = (int)(Math.random()*45);
			int tmp = ball[i];
			ball[i] = ball[idx];
			ball[idx] = tmp;
		}
		
		// 출력 0~5번째까지만
		for(int i=0; i<6; i++) {
			System.out.print(ball[i] + ", ");
		}
		
	}
}
