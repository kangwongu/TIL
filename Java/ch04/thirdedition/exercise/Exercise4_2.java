package thirdedition.exercise;

public class Exercise4_2 {
	public static void main(String[] args) {
		int sum=0;
		// 1~20
		for(int i=1; i<=20; i++) {
			// 2, 3의 배수면 재반복
			if(i%2==0 || i%3==0) continue;
			// 2, 3의 배수가 아닌 수만 합함
			sum += i;
		}
		System.out.println(sum);
		
	
	}

}
