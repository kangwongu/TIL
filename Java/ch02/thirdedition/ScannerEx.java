package thirdedition;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 자리 정수를 하나 입력해주세요>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println(input);
		System.out.println(num);
	}

}
