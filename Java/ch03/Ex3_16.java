import java.util.Scanner;

public class Ex3_16 {

	public static void main(String[] args) {
		boolean b = true;
		char ch = 'C';
		
		System.out.printf("b=%b\n", b);
		System.out.printf("!b=%b\n", !b);
		System.out.printf("!!b=%b\n", !!b);
		System.out.printf("!!!b=%b\n", !!!b);
		System.out.println();
		
		System.out.printf("ch=%c\n", ch);

		// ch�� �ҹ��ڰ� �ƴ���?
		System.out.printf("ch=%c\n", ch);
		System.out.printf("ch < 'a' || ch > 'z'=%b\n", ch < 'a' || ch > 'z');
		System.out.printf("!('a' < ch && ch < 'z')=%b\n", !('a' < ch && ch < 'z'));
		
		char c = 'A';
		
		System.out.println(c + 1);
		System.out.println(++c);
	}

}
