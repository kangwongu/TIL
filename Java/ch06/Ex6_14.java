
public class Ex6_14 {
	// ����� �ʱ�ȭ
	static int[] arr = new int[10];
	
	// ���� �ʱ�ȭ
	// Ŭ���� �ʱ�ȭ ��
	static {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}
	}
	public static void main(String[] args) {
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] : " + arr[i]);
		}
	}
}

