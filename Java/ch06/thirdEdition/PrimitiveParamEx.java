package thirdEdition;


class Data { int x; }

public class PrimitiveParamEx {
	public static void main(String[] args) {
		// DataŬ���� �ν��Ͻ� ����
		Data d = new Data();
		// �ν��Ͻ��� x���� change �޼ҵ忡 �Ѱ���
		System.out.println("d.x = " + d.x);
		change(d.x);
		System.out.println("after - d.x = " + d.x);
		
	}
	
	// �⺻���� �Ű������� �޴� �޼ҵ�
	// �Ű������� ���� ���� �����Ű�� �޼ҵ�
	static void change(int x) {
		x = 1000;
		System.out.println("change(int x) = "+ x);
	}

}
