import java.util.Arrays;
import java.util.Scanner;

public class Ex5_10 {

	public static void main(String[] args) {
		
		// �ܾ�, ���� ����� 2�����迭�� ����
		String[][] words = {
				{"Computer", "��ǻ��"},
				{"Desk", "å��"},
				{"Chair", "����"},
				{"Pensil", "����"},
				{"Cloth", "��"}
		};
		System.out.println(Arrays.deepToString(words));
		
		Scanner scanner = new Scanner(System.in);
		
		// �迭�� ���̸�ŭ �ݺ�(����)
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s�� ����?>>", i+1, words[i][0]);
			
			// �ܾ��� ���� ����� ��, �� �Է¹���
			String input = scanner.nextLine().trim();
			// ��� �Է°��� ������ ���� Ʋ���� ��
			// ���ڿ� �񱳴� ������  equals()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			if(input.equals(words[i][1]))
				System.out.println("�����Դϴ�.");
			else {
				System.out.println("��!");
			}
		}
		
		
			
	}

}
