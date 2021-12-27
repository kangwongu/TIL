import java.util.Scanner;

public class Ex3_15 {

	public static void main(String[] args) {
		// 문자열을 입력받음
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		// 문자열의 1번째만 뽑아옮 (문자형)
		char ch = input.charAt(0);
		
		
		// ch가 문자 0~9사이인지 체크
		if('0' <= ch && ch <= '9')
			System.out.println(ch+"는 숫자입니다.");
		
		// ch가 a~z이거나 A~Z인지 체크
		if('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z')
			System.out.println(ch+"는 영문자입니다.");
	}

}
