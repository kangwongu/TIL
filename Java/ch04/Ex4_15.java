import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
		// 나, 컴퓨터
		int input=0, com=0;
		
		// 컴퓨터에 임의의 수 저장
		com = (int)(Math.random()*100)+1;
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("수를 입력하세요.>>");
			input = scanner.nextInt();
			
			if(input > com) {
				System.out.println("Down!!");
			} else if(input < com) {
				System.out.println("Up!!");
			}
		} while(input!=com);
		
		System.out.println("정답!");
	}
}