
public class Exercise4_4 {

	public static void main(String[] args) {
		// 홀수 +, 짝수-
		// 총합 100이상
		int sum = 0;
		int s = 1;
		int num = 0;
		
		
		for(int i=1; sum<100; i++, s=-s) {
			num = i * s; // 더할 수를 결정(부호)
			sum += num;
		}
		
		System.out.printf("num : %d, sum : %d", num, sum);
		

	}

}
