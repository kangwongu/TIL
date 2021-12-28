import java.util.Arrays;

public class Ex5_9 {

	public static void main(String[] args) {
		
		// 국어, 영어, 수학점수를 2차원 배열로 저장
		int score[][] = {
				{100, 90, 70},
				{80, 70, 90},
				{50, 30, 100},
				{100, 100, 20},
				{75, 91, 78}
		};
		
		// 국어총점, 영어총점, 수학총점 변수
		int korTotal=0, engTotal=0, mathTotal=0;
		
		int sum=0;
		float average=0;
		// 총점과 평균을 구함
		// 2차원 배열을 하나씩 꺼내서 각 과목별 총점에 합함
		for(int i=0; i<score.length; i++) {
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
		
			System.out.printf("%d", i+1);
			// 각 배열의 총점을 합함, 점수 출력
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			// 계산한 총점을 바탕으로 평균을 구함, 총점과 평균 출력
			average = sum/(float)score[i].length;
			System.out.printf("%5d, %5.1f\n", sum, average);
		}
		
		
		// 각 과몰별 총점을 출력
		System.out.printf("과목별 총점: %3d %3d %3d", korTotal, engTotal, mathTotal);
		
	}

}
