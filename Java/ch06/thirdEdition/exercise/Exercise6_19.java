package thirdEdition.exercise;

public class Exercise6_19 {
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		// �Ű������� �Ѱ��� str�� ����Ǿ ���ο� �ּ� ����
		// ������ str�� ���� ���� ����
		System.out.println("After change : "+str);
	}
	
	public static void change(String str) {
		// ���ڿ� ������ �ϸ鼭 ���ο� ���ڿ��� ������ "ABC123456" -> �ּҺ���
		str += "456";
	}
}


