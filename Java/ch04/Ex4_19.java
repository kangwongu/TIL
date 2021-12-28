import java.util.Scanner;

public class Ex4_19 {

	public static void main(String[] args) {
		Loop1 : for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				// 5를 곱할차례가 되면
				if(j==5)
					// 전체 반복문 탈출
					//break Loop1;
					// 해당 구구단의 단 탈출
					//break;
					//continue;
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}