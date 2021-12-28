import java.util.Arrays;

public class Exercise5_4 {

	public static void main(String[] args) {
		// 2차원 배열
		int[][] score = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		
		int total = 0;
		float average = 0;
		
		// 총합 구하기
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				total += score[i][j];
			}
		}
		
		// 평균 구하기
		average = (float)total / (score.length * score[0].length);
		
		
		System.out.println("total:"+total);
		System.out.println("average:"+average);
	}

}
