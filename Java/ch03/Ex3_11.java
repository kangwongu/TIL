
public class Ex3_11 {

	public static void main(String[] args) {
		double pi = 3.141592;
		double shortPi = Math.round(pi);
		
		System.out.println(shortPi);
		System.out.println(pi);
		System.out.println(pi*1000);
		
		// 3.142����ϱ�
		// 1. 3.141592 * 1000
		System.out.println(Math.round(pi * 1000));
		// 2. 3142 / 1000.0
		System.out.println(Math.round(pi * 1000) / 1000.0);
		
		// 3.141�� ����غ���
		// 1. 3.142 * 1000
		System.out.println(pi * 1000);
		// 2. 3141.592�� int������ ����ȯ -> �Ҽ��� Ż����Ŵ
		System.out.println((int)(pi * 1000));
	
		System.out.println(Math.round(pi*100));
		System.out.println(Math.round(pi * 100) / 100.0);
		
	}

}
