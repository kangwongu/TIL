import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise8_7 {
	public static void main(String[] args) {
		// 임의의 값을 입력받고 그 값을 맞추는 게임
		
		// 임의의 값 설정
		int answer = (int)(Math.random()*100)+1;
		int input = 0;	// 사용자 입력을 저장할 변수
		int count = 0;	// 시도횟수를 저장할 변수
		
		do {
			count++;
			System.out.print("1~100사이의 값을 입력하세요.>>");
			
			// 사용자 입력
			try {
				input = new Scanner(System.in).nextInt();
			} catch (InputMismatchException e) {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요.");
				continue;
			}
			
			if(answer > input) {
				System.out.println("Up!");
			} else if(answer < input) {
				System.out.println("Down!");
			} else {
				System.out.println("정답!");
				System.out.println("시도횟수는 "+count+"번입니다.");
				break;
			}
		} while(true);
	}
}
