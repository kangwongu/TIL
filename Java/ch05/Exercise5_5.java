import java.util.Arrays;

public class Exercise5_5 {

	public static void main(String[] args) {
		// �迭 1~9
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		// ���� �迭
		int[] ball3 = new int[3];
		
		// �迭 ���� (�迭 ���̸�ŭ �ݺ�), ���� �� �̿�
		for(int i=0; i<ballArr.length; i++) {
			int idx = (int)(Math.random()*ballArr.length);
			int tmp = ballArr[i];
			ballArr[i] = ballArr[idx];
			ballArr[idx] = tmp;
		}
		
		// �迭 ����
		ball3 = Arrays.copyOf(ballArr, 3);
//		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
		// �迭 ���
		for(int i=0; i<ball3.length; i++) {
			System.out.println(ball3[i]);
		}
	}

}
