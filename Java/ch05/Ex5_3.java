import java.util.Arrays;

public class Ex5_3 {

	public static void main(String[] args) {
		int score[] = {50, 68, 28, 34, 19, 88, 96, 58};
		
		// 최대값, 최소값 설정
		int max = score[0];
		int min = score[0];
		
		// 배열 1번째부터 0번째와 비교해가며 최대, 최소값 도출
		for(int i=1; i<score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			} else if(score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("max:"+max);
		System.out.println("min:"+min);	
	}
}
