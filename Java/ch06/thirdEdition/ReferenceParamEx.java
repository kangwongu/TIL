package thirdEdition;


class Things { int x; }

public class ReferenceParamEx {
	public static void main(String[] args) {
		// �ν��Ͻ� ����
		Things t = new Things();
		t.x = 10;
		System.out.println("t.x = "+t.x);
		change(t);	// ���������� �Ѱ���
		System.out.println("after - t.x = " + t.x);
		
	}
	
	// �⺻���� �Ű������� �޴� �޼ҵ�
	// �Ű������� ���� ���� �����Ű�� �޼ҵ�
	static void change(Things t) {
		t.x = 1000;
		System.out.println("change(int x) = "+ t.x);
	}

}
