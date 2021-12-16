
@FunctionalInterface
interface MyLambda {
	void call();
}

public class Ex14_1 {
	public static void main(String[] args) {
		// �׳� ȣ��
		MyLambda ml = () -> System.out.println("call()");
		ml.call();
		
		// �Ű������� MyLambda
		callLambda(ml);
		callLambda2(ml);
		
		MyLambda ml2 = null;
		callLambda2(ml2);
		
		// ��ȯ���� MyLambda
		MyLambda ml3 = returnLambda();
		ml3.call();
		
		
		
	}
	
	// �Ű������� �Լ����������̽�, ���ٽ��� ���ǵ� �Լ��� ���;� �������
	static void callLambda(MyLambda ml) {
		ml.call();
	}
	
	// ���ٽ��� ���� ����
	static void callLambda2(MyLambda ml) {
		ml = () -> System.out.println("call2()");
		ml.call();
	}
	
	// ��ȯ���� �Լ����������̽�
	static MyLambda returnLambda() {
		MyLambda ml3 = () -> System.out.println("call3()");
		return ml3;
	}
	
}
