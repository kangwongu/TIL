import java.util.Scanner;

public class Ex4_19 {

	public static void main(String[] args) {
		Loop1 : for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				// 5�� �������ʰ� �Ǹ�
				if(j==5)
					// ��ü �ݺ��� Ż��
					//break Loop1;
					// �ش� �������� �� Ż��
					//break;
					//continue;
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}
}