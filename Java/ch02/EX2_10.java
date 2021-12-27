import java.util.Scanner;

public class EX2_10 {

	public static void main(String[] args) {
		// 사용자로부터 String입력받고, int형으로 변환
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("수를 입력해주세요.>>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		// 출력
		System.out.println("입력한 수는 " + num + "입니다.");
		
	
	}

}
