
public class Ex9_1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) {
			System.out.println("v1�� v2�� ���ƿ�");
		} else {
			System.out.println("v1�� v2�� �޶��");
		}
	}

}

class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}

	// ==�� �ּ� ��, equals()�޼ҵ� �������̵����� ��ü ������ ���ϰ� ��
	@Override
	public boolean equals(Object obj) {
		// instanceof�����ڷ� Ÿ�� üũ�� ��
		if(obj instanceof Value) {
			Value v = (Value)obj;
			// ������ ��
			if(value==v.value)
				return true;
		}
		
		return false;
	}
	
	
	
		
	
}
