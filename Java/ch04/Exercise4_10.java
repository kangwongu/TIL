import java.util.Scanner;

public class Exercise4_10 {

	public static void main(String[] args) {
		int answer = (int)(Math.random()*6)+1;
		int input = 0;
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100사이를 입력하세요 : ");
			input = scanner.nextInt();
			
			// answer가 input보다 크면
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			// answer가 input보다 작으면
			} else if(answer < input) {
				System.out.println("더 작은 수를 입력하세요");
			// answer == input이면
			} else {
				System.out.println("맞혔습니다.");
				System.out.println("시도횟수는 " + count + "번입니다.");
				break;
			}
			
			
			
		} while(true);
	}

}
