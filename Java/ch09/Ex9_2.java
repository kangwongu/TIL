
public class Ex9_2 {
	public static void main(String[] args) {
		Person v1 = new Person(10434784864L);
		Person v2 = new Person(10434784864L);
		
		if(v1.equals(v2)) {
			System.out.println("v1�� v2�� ���ƿ�");
		} else {
			System.out.println("v1�� v2�� �޶��");
		}
	}

}

class Person {
	long id;
	
	Person(long id) {
		this.id = id;
	}

	// equals()�޼ҵ� �������̵�
	@Override
	public boolean equals(Object obj) {
		// instanceof�� Ÿ��üũ ��, ����ȯ
		if(obj instanceof Person) {
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	
}
