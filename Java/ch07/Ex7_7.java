// CarŬ����
class Car {
	// �Ӽ�
	String color;
	int door;
	
	// ���
	void drive() {
		System.out.println("�ο���");
	}
	
	void stop() {
		System.out.println("����");
	}
}

// CarŬ���� ��ӹ޴� FireEngineŬ����
class FireEngine extends Car {
	void water() {
		System.out.println("������");
	}
}


public class Ex7_7 {
	public static void main(String[] args) {
		// Car�� ��������
		Car car = null;
		// FireEngine�ν��Ͻ�
		FireEngine fe = new FireEngine();
		car = fe;	// ����ȯ, �ڼ�->����
		//car.water() // ������ �ڼ��� ����� ����� �� ����	
		
		doWork(car);
		//doWork(fe);
	}
	
	public static void doWork(Car c) {
		if(c instanceof Car) {
			FireEngine fe = (FireEngine)c;
			fe.water();
		}
	}
	
	
}
