class Outer2 {
	// �ν��Ͻ� ���� Ŭ����
	class Inner {
		int iv = 100;
	}
}


public class Exercise7_6 {
	public static void main(String[] args) {
		// �ܺ� Ŭ���� �ν��Ͻ� ���� �� ���� Ŭ���� ��밡��
		Outer2 out = new Outer2();
		Outer2.Inner in = out.new Inner();
		System.out.println(in.iv);

	}

}
