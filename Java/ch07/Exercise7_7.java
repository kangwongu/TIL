class Outer3 {
	// ����ƽ ���� Ŭ����
	static class Inner {
		int iv = 100;
	}
}


public class Exercise7_7 {
	public static void main(String[] args) {
		// �ܺ� Ŭ���� �ν��Ͻ� �������� �ٷ� ��밡��
		Outer3.Inner in = new Outer3.Inner();
		System.out.println(in.iv);
	}

}
