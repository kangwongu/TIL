import java.util.Scanner;

public class Ex4_6 {

	public static void main(String[] args) {
		// '월'을 입력받음
		System.out.print("월을 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		// 입력받은 월의 계절을 출력 (switch)
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println("가을입니다.");
			break;
		default:
			System.out.println("겨울입니다.");
		}
		
		// 조건식이 많으면 if문보다 switch문 사용이 적합
	}

}
