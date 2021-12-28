package thirdedition.exercise;

public class Exercise4_3 {
	
	public static void main(String[] args) {
		int sum=0;	// 합을 담을 변수
		int total=0;
		
		// 1~10
		for(int i=1; i<=10; i++) {
			sum += i;
			total += sum;
		}
		System.out.println(total);
	}

}
