
public class Exercise4_2 {

	public static void main(String[] args) {
		int sum=0;
		
		for(int i=1; i<=20; i++) {
			// 2의 배수이거나, 3의 배수면 합x
			if(i%2==0 || i%3==0)
				continue;
			
			sum += i;
		}
		
		System.out.println(sum);
	}

}
