package thirdedition.exercise;

public class Exercise4_9 {
	
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		// 1+2+3+4+5
		for(int i=0; i<str.length(); i++) {
			// 1. charAt()�� ����� �� ���ھ� �����´�.
			char s = str.charAt(i);
			// 2. �� ���� int������ ��ȯ�� ���Ѵ�.
			sum += s - '0';
		}
		
		System.out.println(sum);
	}

}
