import java.util.Arrays;

public class Ex5_5 {

	public static void main(String[] args) {
		int[] ball = new int[45];
		
		// �迭 �ʱ�ȭ 1~45
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}
		System.out.println(Arrays.toString(ball));
		
		// 0~5��° ��Ҹ� ����
		for(int i=0; i<6; i++) {
			int idx = (int)(Math.random()*45);
			int tmp = ball[i];
			ball[i] = ball[idx];
			ball[idx] = tmp;
		}
		
		// ��� 0~5��°������
		for(int i=0; i<6; i++) {
			System.out.print(ball[i] + ", ");
		}
		
	}
}
