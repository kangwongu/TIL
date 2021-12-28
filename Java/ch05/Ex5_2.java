import java.util.Arrays;

public class Ex5_2 {

	public static void main(String[] args) {
		// 점수 배열
		int score[] = {100, 90, 80, 74, 65, 50};
		int sum=0;
		double average=0;
		
		// 총합 구하기
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		
		// 평균 구하기
		average = (double)sum/score.length;
		
		System.out.println("sum:"+sum);
		System.out.println("average:"+average);
	}

}
