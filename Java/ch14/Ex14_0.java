
public class Ex14_0 {
	public static void main(String[] args) {
//		Object obj = new Object() {
//			int max(int a, int b) {
//				return a > b ? a : b;
//			}
//		};
		
		// Object�� max�޼ҵ尡 ����
		//int value = obj.max(3,5);
		
		// �Լ��� �������̽��� �ʿ伺
		
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) {
//				return a > b ? a : b;
//			}
//		};
		
		// ���ٽ� ����
		Lambda l = (a, b) -> a+b;
		
		// ���ٽ� ȣ��
		System.out.println(l.max(10, 20));
	
		Lambda2 l2 = (x, y) -> x+", "+y;
		System.out.println(l2.concat("�ȳ��ϼ���", "������"));
	}

}

// �Լ��� �������̽�
@FunctionalInterface
interface Lambda {
	int max(int a, int b);
}

interface Lambda2 {
	String concat(String a, String b);
}

