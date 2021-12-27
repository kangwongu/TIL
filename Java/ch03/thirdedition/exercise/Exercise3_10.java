package thirdedition.exercise;

public class Exercise3_10 {
	public static void main(String[] args) {
		char ch = 'A';
		
		char lowerCase = ( 'A' <= ch && ch <= 'Z' ) ? (char)(ch+32) : ch;
		
		System.out.println(ch);
		System.out.println(lowerCase);
	}
}
