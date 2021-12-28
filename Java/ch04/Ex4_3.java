import java.util.Scanner;

public class Ex4_3 {

	public static void main(String[] args) {
		System.out.print("숫자를 하나 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		// 입력받은 수가 0인지 아닌지?
		if(input==0) {
			System.out.println("입력받은 수는 0입니다.");
		} else {
			System.out.println("입력받은 수는 0이 아닙니다");
		}
	}

}
