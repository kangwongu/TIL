import java.util.Arrays;

public class Ex5_2 {

	public static void main(String[] args) {
		// ���� �迭
		int score[] = {100, 90, 80, 74, 65, 50};
		int sum=0;
		double average=0;
		
		// ���� ���ϱ�
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		
		// ��� ���ϱ�
		average = (double)sum/score.length;
		
		System.out.println("sum:"+sum);
		System.out.println("average:"+average);
	}

}
