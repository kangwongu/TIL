import java.util.Arrays;

public class Ex5_9 {

	public static void main(String[] args) {
		
		// ����, ����, ���������� 2���� �迭�� ����
		int score[][] = {
				{100, 90, 70},
				{80, 70, 90},
				{50, 30, 100},
				{100, 100, 20},
				{75, 91, 78}
		};
		
		// ��������, ��������, �������� ����
		int korTotal=0, engTotal=0, mathTotal=0;
		
		int sum=0;
		float average=0;
		// ������ ����� ����
		// 2���� �迭�� �ϳ��� ������ �� ���� ������ ����
		for(int i=0; i<score.length; i++) {
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
		
			System.out.printf("%d", i+1);
			// �� �迭�� ������ ����, ���� ���
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			// ����� ������ �������� ����� ����, ������ ��� ���
			average = sum/(float)score[i].length;
			System.out.printf("%5d, %5.1f\n", sum, average);
		}
		
		
		// �� ������ ������ ���
		System.out.printf("���� ����: %3d %3d %3d", korTotal, engTotal, mathTotal);
		
	}

}
