import java.util.Scanner;

public class Ex4_14 {

	public static void main(String[] args) {
		
		// 문자열을 입력받고 숫자로 변환 (숫자를 입력받음)
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		int sum=0; 
	
		// 입력받은 숫자를 계속 10씩 나눠가면서 나머지 값들을 합한다
		while(num!=0) {
			sum += num%10;
			System.out.printf("sum:%d, num=%d\n", sum, num);
			num /= 10;
		}
		
		System.out.println(sum);
	}
}